/** CRIADO POR:          
 *  ULTIMA MODIFICACAO:  08/05/2014 (Rafael)
 * 
 *  COMENTARIOS: 
 *  - Removi codigo em duplicidade.
**/

package modelo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancoDados {
	
	private static String localBanco = "jdbc:mysql://";	
	private static String nomeSevidor = "localhost";
	private static String nomeBanco = "c_on";
	private static String usuario = "root";
	private static String senha = "root";
	
	private Connection conexao;
	private Statement afirmacao;
	
	public ConexaoBancoDados() {
		
	}
	
	public Connection getConexao() throws SQLException {
		Connection conexao = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(localBanco + nomeSevidor + "/" + nomeBanco, usuario, senha);
			return conexao;
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	
	public void criarBanco(String nomeNovoBanco) throws SQLException {
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			this.afirmacao = this.conexao.createStatement();

			String comandoSQL = "create database if not exists " + nomeNovoBanco;
			
			this.afirmacao.executeUpdate(comandoSQL);
		} catch(Exception e) {
			throw new SQLException("ConexaoBancoDados - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}
	
	public void alterarBanco(String nomeBancoAtual) {
		nomeBanco = nomeBancoAtual;
	}
	
	public void importarSQL(String arquivoSQL) throws SQLException {
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			this.afirmacao = this.conexao.createStatement();
			
			String comando[] = getLinhasArquivo(arquivoSQL);
			for(String linha : comando) {
				this.afirmacao.execute(linha);
			}
						
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
			
			String comandoSQL = "drop database if exists " + nomeBanco;
			
			this.afirmacao.executeUpdate(comandoSQL);
		} catch(Exception e) {
			throw new SQLException("ConexaoBancoDados - " + e.getMessage());
		} finally {
			fecharConexao();
		}
	}

	public void setLocalBanco(String novoLocalBanco) {
		localBanco = novoLocalBanco;
	}
	
	public String getLocalBanco() {
		return localBanco;
	}
	
	private void fecharConexao() throws SQLException {
		if(this.conexao != null) {
			this.conexao.close();
		}
	}
	
	private String[] getLinhasArquivo(String arquivo) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(arquivo)));
		String linhaComando = "";
		String comando[];
		String linhaLida;
		while( (linhaLida = bufferedReader.readLine()) != null ) {
			if(!linhaLida.isEmpty()) {
				linhaComando += linhaLida;
			}
		}
		comando = linhaComando.split(";");
		bufferedReader.close();
		return comando;
	}
	
}
