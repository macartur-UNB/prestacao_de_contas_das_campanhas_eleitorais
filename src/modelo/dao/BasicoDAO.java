package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public abstract class BasicoDAO<O> {

	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	private Comparator<O> comparador;
	private String nomeTabela;
	
	public BasicoDAO(String nomeTabela, Comparator<O> comparador) {
		this.nomeTabela = nomeTabela;
		this.comparador = comparador;
	}
	
	public void cadastrarLista(ArrayList<O> lista) throws SQLException {
		try {
			ArrayList<O> listaNaoCadastrados = getListaNaoCadastrados(lista);
			
			this.conexao = new ConexaoBancoDados().getConexao();
			String comandoSQL = getSqlInsert();
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
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
			throw new SQLException(nomeTabela + e.getMessage());
		}
		
		return lista;
	}
	
	protected ArrayList<O> getListaNaoCadastrados(ArrayList<O> lista) throws SQLException {
		ArrayList<O> listaNaoCadastrados = new ArrayList<>();
		ArrayList<O> listaCadastrados = getLista();
		Collections.sort(listaCadastrados, this.comparador);
		for(O objeto : lista) {
			if(Collections.binarySearch(listaCadastrados, objeto, this.comparador) < 0) {
				listaNaoCadastrados.add(objeto);
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
	
	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public PreparedStatement getInstrucaoSQL() {
		return instrucaoSQL;
	}

	public void setInstrucaoSQL(PreparedStatement instrucaoSQL) {
		this.instrucaoSQL = instrucaoSQL;
	}
	
}
