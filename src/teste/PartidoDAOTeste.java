package teste;

import static org.mockito.Mockito.mock;
import modelo.dao.PartidoDAO;

import org.junit.Before;

public class PartidoDAOTeste {
	
	private PartidoDAO mockPartidoDAO;
	
	@Before
	public void setUp() throws Exception {
		this.mockPartidoDAO = mock(PartidoDAO.class);
	}

}
