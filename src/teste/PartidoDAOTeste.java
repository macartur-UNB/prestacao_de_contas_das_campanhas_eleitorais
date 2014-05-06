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

}
