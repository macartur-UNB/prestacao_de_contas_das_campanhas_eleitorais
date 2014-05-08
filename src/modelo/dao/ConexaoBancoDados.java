/** CRIADO POR:          
 *  ULTIMA MODIFICACAO:  08/05/2014 (Rafael)
 * 
 *  COMENTARIOS: 
 *  - Removi codigo em duplicidade.
**/

package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
	
	private static final String MY_SQL = "jdbc:mysql://";	
	private static final String NOME_SERVIDOR = "localhost";
	private static final String NOME_BANCO = "gpp";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	
	public ConexaoBancoDados() {
		
	}
	
	public Connection getConexao() throws SQLException {
		Connection conexao = null;

		try {
			conexao = DriverManager.getConnection(MY_SQL + NOME_SERVIDOR + "/" + NOME_BANCO, USUARIO, SENHA);
			return conexao;
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}
	
}
