package teste;

import java.sql.SQLException;

import modelo.dao.CandidatoDAO;

import org.junit.Test;

import controle.CandidatoControle;

public class CandidatoControleTeste extends TemplateTeste {

	private CandidatoDAO candidatoDAO;
	private CandidatoControle candidatoControle;
	
	@Override
	public void beforeTest() throws Exception {
		this.candidatoDAO = new CandidatoDAO();
		this.candidatoControle = new CandidatoControle();
		
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmCandidatoPeloNome() throws SQLException {
		
	}
	
	@Test
	public void deveRecuperarUmaListaDeCandidatos() throws SQLException {
		
	}

}
