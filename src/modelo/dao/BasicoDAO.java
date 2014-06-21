package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import parse.ParseDAO;
import parse.ParseException;

public abstract class BasicoDAO<O> implements ParseDAO<O>{

	protected Connection conexao;
	protected PreparedStatement instrucaoSQL;
	
	private Comparator<O> comparador;
	private String nomeTabela;
	
	public BasicoDAO(String nomeTabela, Comparator<O> comparador) {
		this.nomeTabela = nomeTabela;
		this.comparador = comparador;
	}
	
	@Override
	public void cadastrarListaParse(ArrayList<O> lista) throws ParseException {
		try {
			cadastrarLista(lista);
		} catch(Exception e) {
			throw new ParseException(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<O> getListaParse() throws ParseException {
		ArrayList<O> lista = new ArrayList<>();
		try {
			lista = getLista();
		} catch(Exception e) {
			throw new ParseException(e.getMessage());
		}
		return lista;
	}
	
	public void cadastrarLista(ArrayList<O> lista) throws SQLException {
		try {
			ArrayList<O> listaNaoCadastrados = getListaNaoCadastrados(lista);

			this.conexao = new ConexaoBancoDados().getConexao();
			this.instrucaoSQL = getInstrucaoSQL(getSqlInsert());
			this.conexao.setAutoCommit(false);
	
			adicionarListaNoBatch(listaNaoCadastrados, instrucaoSQL);
	
			this.instrucaoSQL.executeBatch();
			this.conexao.commit();
						
		} catch(Exception e) {
			throw new SQLException(nomeTabela + " - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<O> getLista() throws SQLException {
		ArrayList<O> lista = new ArrayList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = getSqlSelect();
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
			
			adicionarResultSetNaLista(lista, resultadoSQL);
		} catch(Exception e) {
			throw new SQLException(nomeTabela + " - " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
		
	protected ArrayList<O> getListaNaoCadastrados(ArrayList<O> lista) throws SQLException {
		ArrayList<O> listaNaoCadastrados = new ArrayList<>();
		ArrayList<O> listaCadastrados = getLista();
		
		if(this.comparador != null) {
			Collections.sort(listaCadastrados, this.comparador);
			for(O objeto : lista) {
				if(Collections.binarySearch(listaCadastrados, objeto, this.comparador) < 0) {
					listaNaoCadastrados.add(objeto);
				}
			}
		} else {
			for(O objeto : lista) {
				if(!listaCadastrados.contains(objeto)) {
					listaNaoCadastrados.add(objeto);
				}
			}
		}
		
		return listaNaoCadastrados;
	}
	
	protected abstract String getSqlInsert();
	protected abstract String getSqlSelect();
	protected abstract void adicionarListaNoBatch(ArrayList<O> lista, PreparedStatement instrucaoSQL) throws SQLException ;
	protected abstract void adicionarResultSetNaLista(ArrayList<O> lista, ResultSet resultadoSQL) throws SQLException ;
	
	protected void fecharConexao() throws SQLException {
		if(this.instrucaoSQL != null) {
			this.instrucaoSQL.close();
		}
		if(this.conexao != null) {
			this.conexao.close();
		}
	}
	
	protected PreparedStatement getInstrucaoSQL(String comandoSQL) throws SQLException {		
		return this.conexao.prepareStatement(comandoSQL);
	}
	
}
