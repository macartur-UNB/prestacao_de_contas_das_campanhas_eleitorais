/** CRIADO POR:          
 *  ULTIMA MODIFICACAO:  08/05/2014 (Rafael)
 * 
 *  COMENTARIOS: 
 *  - Removi codigo em duplicidade.
**/

package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancoDados {
	
	private String localBanco;	
	private String nomeSevidor;
	private String nomeBanco;
	private String usuario;
	private String senha;
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	private Statement afirmacao;
	
	public ConexaoBancoDados() {
		this.localBanco = "jdbc:mysql://";	
		this.nomeSevidor = "localhost";
		this.nomeBanco = "gpp";
		this.usuario = "root";
		this.senha = "root";
	}
	
	public Connection getConexao() throws SQLException {
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(localBanco + nomeSevidor + "/" + nomeBanco, usuario, senha);
			return conexao;
		} catch(Exception e) {
			
		}
		try {
			conexao = DriverManager.getConnection(localBanco + nomeSevidor + "/" + nomeBanco, usuario, senha);
			return conexao;
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	public void criarBanco() throws SQLException {
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			this.afirmacao = this.conexao.createStatement();
			
			String comandoSQL = "create database " + nomeBanco;
			
			this.afirmacao.executeUpdate(comandoSQL);
		} catch(Exception e) {
			throw new SQLException("ConexaoBancoDados - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}
	
	public void deletarBanco() throws SQLException {
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			this.afirmacao = this.conexao.createStatement();
			
			String comandoSQL = "drop database " + nomeBanco;
			
			this.afirmacao.executeUpdate(comandoSQL);
		} catch(Exception e) {
			throw new SQLException("ConexaoBancoDados - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}

	private void fecharConexao() throws SQLException {
		if(this.instrucaoSQL != null) {
			this.instrucaoSQL.close();
		}
		if(this.conexao != null) {
			this.conexao.close();
		}
	}
	

	public String getLocalBanco() {
		return localBanco;
	}

	public void setLocalBanco(String localBanco) {
		this.localBanco = localBanco;
	}

	public String getNomeSevidor() {
		return nomeSevidor;
	}

	public void setNomeSevidor(String nomeSevidor) {
		this.nomeSevidor = nomeSevidor;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
