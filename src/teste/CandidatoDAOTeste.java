package teste;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import model.Candidato;

import org.junit.Before;
import org.junit.Test;

import dao.CandidatoDAO;

public class CandidatoDAOTeste {
	
	private CandidatoDAO mockCandidatoDAO;
	
	@Before
	public void setUp() {
		this.mockCandidatoDAO = mock(CandidatoDAO.class);
	}

	
	
}
