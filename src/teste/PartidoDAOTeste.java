package teste;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import model.Partido;

import org.junit.Before;
import org.junit.Test;

import dao.PartidoDAO;

public class PartidoDAOTeste {
	
	private PartidoDAO mockPartidoDAO;
	
	@Before
	public void setUp() throws Exception {
		this.mockPartidoDAO = mock(PartidoDAO.class);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmPartidoNaoExistente() throws SQLException {
		Partido partido = new Partido();
		partido.setSigla("PT");
		partido.setNumeroPartido("13");
		
		this.mockPartidoDAO.cadastrarPartido(partido);
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmPartidoExistente() throws SQLException {
		Partido partido = new Partido();
		partido.setSigla("PT");
		partido.setNumeroPartido("13");
		
		doThrow(new SQLException()).when(this.mockPartidoDAO).cadastrarPartido(partido);
		
		this.mockPartidoDAO.cadastrarPartido(partido);
	}

}