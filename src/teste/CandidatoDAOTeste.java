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

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmCandidatoNaoExistente() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("Jose");
		candidato.setAno(2002);
		
		this.mockCandidatoDAO.cadastrarCandidato(candidato);
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmCandidatoExistente() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("Jose");
		candidato.setAno(2002);
		
		doThrow(new SQLException()).when(this.mockCandidatoDAO).cadastrarCandidato(candidato);
		
		this.mockCandidatoDAO.cadastrarCandidato(candidato);
	}
	
}
