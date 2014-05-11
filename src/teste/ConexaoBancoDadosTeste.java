package teste;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.dao.ConexaoBancoDados;

import org.junit.Test;

public class ConexaoBancoDadosTeste {

	private Connection conexao;
	
	@Test
	public void NaoDeveLancarExcecaoAoIniciarAConexao() throws SQLException {
		this.conexao = new ConexaoBancoDados().getConexao();
		
	}
	
	@Test (expected = NullPointerException.class)
	public void DeveLancarExcecaoAoEncerrarUmaConexaoQueNaoFoiIniciada() throws SQLException {
		this.conexao.close();
	}

	@Test
	public void NaoDeveLancarExcecaoAoEncerrarUmaConexaoQueFoiIniciada() throws SQLException {
		this.conexao = new ConexaoBancoDados().getConexao();
		this.conexao.close();
	}
	
}
