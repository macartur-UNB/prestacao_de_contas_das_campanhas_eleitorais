package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import modelo.beans.Fornecedor;

public class FornecedorDAO {

	private enum Comparacao implements Comparator<Fornecedor> {
		NOME {
			@Override
			public int compare(Fornecedor f1, Fornecedor f2) {
				return f1.getNome().compareToIgnoreCase(f2.getNome());
			}
		};
	}
	
	private static final String NOME = "nome";
	private static final String CADASTRO_NACIONAL = "cadastro_nacional";
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	public FornecedorDAO() {
		
	}
	
	public void cadastrarFornecedores(ArrayList<Fornecedor> listaFornecedores) throws SQLException {
//		System.out.println("cadastrarFornecedores");
		try {
			ArrayList<Fornecedor> listaFornecedoresNaoCadastrados = new ArrayList<>();
			LinkedList<Fornecedor> listaFornecedoresCadastrados = getListaFornecedores();
			Collections.sort(listaFornecedoresCadastrados, Comparacao.NOME);
			for(Fornecedor fornecedor : listaFornecedores) {
				if(Collections.binarySearch(listaFornecedoresCadastrados, fornecedor, Comparacao.NOME) < 0) {
					
//					if(fornecedor.getNome().equalsIgnoreCase("JAIRO DA SILVA CARVALHO")) {
//						System.out.println("+-------------------------------+");
//						System.out.println("fornecedor.getNome(): " + fornecedor.getNome());
//						System.out.println("resultado da busca: " + Collections.binarySearch(listaFornecedoresCadastrados, fornecedor, Comparacao.NOME));
//						
//						System.out.println("resultado do contem: " + listaFornecedoresCadastrados.contains(fornecedor));
//						System.out.println("listaFornecedoresCadastrados.size(): " + listaFornecedoresCadastrados.size());
//						
//						System.out.println("+-------------------------------+");
//					}
					
					listaFornecedoresNaoCadastrados.add(fornecedor);
				}
			}
			
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "INSERT INTO t_fornecedor (nome, cadastro_nacional)"
			          + "VALUES(?,?)";
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			this.conexao.setAutoCommit(false);
			
			for(Fornecedor fornecedor : listaFornecedoresNaoCadastrados) {
				instrucaoSQL.setString(1, fornecedor.getNome());
				instrucaoSQL.setString(2, fornecedor.getCadastroNacional());
				instrucaoSQL.addBatch();
			}
			
			this.instrucaoSQL.executeBatch();
			this.conexao.commit();
		} catch(Exception e) {
			throw new SQLException("Fornecedor - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}
	
	public LinkedList<Fornecedor> getListaFornecedores() throws SQLException {
		LinkedList<Fornecedor> listaFornecedores = new LinkedList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_fornecedor";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
			while(resultadoSQL.next()) {
				Fornecedor fornecedor = new Fornecedor();				
				fornecedor.setNome(resultadoSQL.getString(NOME));
				fornecedor.setCadastroNacional(resultadoSQL.getString(CADASTRO_NACIONAL));
				
				listaFornecedores.add(fornecedor);
			}
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			throw new SQLException(e.getMessage());
		} finally {
			fecharConexao();
		}
				
		return listaFornecedores;
	}
	
	private void fecharConexao() throws SQLException {
		if(this.instrucaoSQL != null) {
			this.instrucaoSQL.close();
		}
		if(this.conexao != null) {
			this.conexao.close();
		}
	}
}
