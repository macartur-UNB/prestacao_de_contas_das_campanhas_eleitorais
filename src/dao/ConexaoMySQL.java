package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexaoMySQL {
	
	private static final String MY_SQL = "jdbc:mysql://";	
	private static final String NOME_SERVIDOR = "localhost";
	private static final String NOME_BANCO = "gpp";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	
	/** Estou usando como padrao: 
	 *     NOME_BANCO = "gpp";
	 *     USUARIO = "root";
	 *     SENHA = "root";
	 *  Para a conexao mySQL funcionar, usei no prompt do mysql:
	 *     $ SET PASSWORD FOR 'root'@'localhost' = PASSWORD('root'); 
	 *    
	 *  No caso de mudar o password e nao conseguir acessar o mysql,
	 *  buscar usuario e senha em 
	 *     $ vi /etc/mysql/debian.cnf 
	 *  e acessar com os parametros
	 *     $ mysql --user=debian-sys-maint --password=GPCzJs63iCz3w3Y8
	 *     (de acordo com o que constar no arquivo.
	 *  (RAFAEL, 1/5/14) 
	 */
	
	private static ConexaoMySQL instancia;
	
	private Connection conexao;
	
	private ConexaoMySQL() {
		this.conexao = null;
	}
	
	public static synchronized ConexaoMySQL getInstancia() {
		if(instancia == null) {
			instancia = new ConexaoMySQL();
		}
		
		return instancia;
	}
	
	public synchronized void iniciarConexao() throws SQLException {
		if(this.conexao == null) {
			this.conexao = DriverManager.getConnection(MY_SQL + NOME_SERVIDOR + "/" + NOME_BANCO, USUARIO, SENHA);
		}
	}
	
	public synchronized void encerrarConexao() throws SQLException {
		this.conexao.close();
		this.conexao = null;
	}
	
	public synchronized PreparedStatement prepararInstrucao(String comandoSQL) throws SQLException {
		return this.conexao.prepareStatement(comandoSQL);
	}
}
