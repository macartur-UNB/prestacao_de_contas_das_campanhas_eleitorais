package teste;

import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import modelo.dao.ConexaoBancoDados;
import modelo.dao.PartidoDAO;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class PartidoDAOTeste {
	
	private PartidoDAO mockPartidoDAO;
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	@Before
	public void setUp() throws Exception {
		this.mockPartidoDAO = mock(PartidoDAO.class);
	}
	
	@Test (expected  = NullPointerException.class)
	public void deveLancarExcecaoAoFecharUmaConexaoNaoIniciada() throws SQLException {
		this.instrucaoSQL.close();
		this.conexao.close();
	}
	
	@Test
	public void naoDeveLancarExcecaoAoFecharUmaConexaoIniciada() throws SQLException {
		this.conexao = (Connection) new ConexaoBancoDados().getConexao();
		this.conexao.close();
	}

}
