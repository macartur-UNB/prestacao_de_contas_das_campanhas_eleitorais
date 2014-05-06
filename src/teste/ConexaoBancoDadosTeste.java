package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dao.ConexaoBancoDados;

public class ConexaoBancoDadosTeste {

	private Connection conexao;
	
	@Test
	public void NaoDeveLancarExcecaoAoIniciarAConexao() throws SQLException {
		this.conexao = new ConexaoBancoDados().getConexao();
		PreparedStatement preparedStatement = null;
		
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
