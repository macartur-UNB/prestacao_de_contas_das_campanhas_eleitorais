package teste;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.ConexaoMySQL;

public class ConexaoMySQLTeste {

	private ConexaoMySQL conexaoMySQL;
	
	@Before
	public void setUp() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	@Test
	public void NaoDeveLancarExcecaoAoIniciarAConexao() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
	}
	
	@Test (expected = NullPointerException.class)
	public void DeveLancarExecaoAoEncerrarUmaConexaoQueNaoFoiIniciada() throws SQLException {
		this.conexaoMySQL.encerrarConexao();
	}

	@Test
	public void NaoDeveLancarExcecaoAoEncerrarUmaConexaoQueFoiIniciada() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		this.conexaoMySQL.encerrarConexao();
	}
	
}
