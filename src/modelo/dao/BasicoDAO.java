package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public abstract class BasicoDAO<E> {

	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	private Comparator<E> comparador;
	private String nomeTabela;
	
	public BasicoDAO(String nomeTabela, Comparator<E> comparador) {
		this.nomeTabela = nomeTabela;
		this.comparador = comparador;
	}
	
	public void cadastrarLista(ArrayList<E> lista) throws SQLException {
		try {
			ArrayList<E> listaNaoCadastrados = getListaNaoCadastrados(lista);
			
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
	
	public ArrayList<E> getLista() throws SQLException {
		ArrayList<E> lista = new ArrayList<>();
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
	
	protected ArrayList<E> getListaNaoCadastrados(ArrayList<E> lista) throws SQLException {
		ArrayList<E> listaNaoCadastrados = new ArrayList<>();
		ArrayList<E> listaCadastrados = getLista();
		Collections.sort(listaCadastrados, this.comparador);
		for(E objeto : lista) {
			if(Collections.binarySearch(listaCadastrados, objeto, this.comparador) < 0) {
				listaNaoCadastrados.add(objeto);
			}
		}
		
		return listaNaoCadastrados;
	}
	
	protected abstract String getSqlInsert();
	protected abstract String getSqlSelect();
	protected abstract void adicionarListaNoBatch(ArrayList<E> lista, PreparedStatement instrucaoSQL) throws SQLException ;
	protected abstract void adicionarResultSetNaLista(ArrayList<E> lista, ResultSet resultadoSQL) throws SQLException ;
	
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