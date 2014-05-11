package teste;

import java.sql.SQLException;

import modelo.dao.ConexaoBancoDados;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConexaoBancoDadosTeste {
	
	private static final String NOME_BANCO = "banco_de_testes";
	
	private ConexaoBancoDados conexaoBancoDados;

	@Test
	public void naoDeveLancarExcecaoAoCriarEDeletarOBancoDeTestes() throws SQLException {
		this.conexaoBancoDados = new ConexaoBancoDados();
		this.conexaoBancoDados.setNomeBanco(NOME_BANCO);
		
		this.conexaoBancoDados.criarBanco();
		this.conexaoBancoDados.deletarBanco();
	}

}
