package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

import org.junit.Assert;
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
	public void deveRecuperarUmaListaDeCandidatos() throws SQLException {

		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		Candidato candidato = new Candidato();
		candidato.setNome("CANDIDATO INEXISTENTE");
		candidato.setTituloEleitoral("000000");
		listaCandidatos.add(candidato);
		/*this.candidatoDAO.adicionarResultSetNaLista(listaCandidatos);*/
		this.candidatoDAO.getCandidato("Nome_Candidato");
		this.candidatoControle.getUmCandidato("Nome_Candidato");
			
	}
	
	@Test
	public void deveRecuperarUmaListaDeCandidatos() throws SQLException {		
		Assert.assertEquals(listaCandidatos, this.candidatoControle.getListaCandidatos());
	}

}
