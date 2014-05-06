package teste;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

import org.junit.Before;
import org.junit.Test;

public class CandidatoDAOTeste {
	
	private CandidatoDAO mockCandidatoDAO;
	
	@Before
	public void setUp() {
		this.mockCandidatoDAO = mock(CandidatoDAO.class);
	}

	
	
}
