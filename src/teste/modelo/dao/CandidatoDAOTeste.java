package teste.modelo.dao;

import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class CandidatoDAOTeste extends TemplateTeste {

	private CandidatoDAO candidatoDAO;
	
	@Override
	public void beforeTest() throws Exception {
		this.candidatoDAO = new CandidatoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void valoresComparacao() throws Exception {
		
		CandidatoDAO.Comparacao.valueOf(CandidatoDAO.Comparacao.TITULO_ELEITORAL.toString());
	}
	
	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmCandidatoInexistente() throws Exception {
		
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("CANDIDATO INEXISTENTE");
		candidato.setTituloEleitoral("000000");
		listaCandidatos.add(candidato);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
	}
	
	@Test
	public void naoDeveCadastrarUmCandidatoJaExistente() throws Exception {
		
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("CANDIDATO INEXISTENTE");
		candidato.setTituloEleitoral("000000");
		listaCandidatos.add(candidato);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		this.candidatoDAO.cadastrarLista(listaCandidatos);
		
		Assert.assertEquals(1, this.candidatoDAO.getLista().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsCandidatosCadastrados() throws Exception {
		
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("CANDIDATO INEXISTENTE");
		candidato.setTituloEleitoral("000000");
		listaCandidatos.add(candidato);
		
		Candidato candidatoDois = new Candidato();
		candidatoDois.setNome("CANDIDATO INEXISTENTE DOIS");
		candidatoDois.setTituloEleitoral("000001");
		listaCandidatos.add(candidatoDois);
		
		candidatoDAO.cadastrarLista(listaCandidatos);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		Assert.assertEquals(listaCandidatos, candidatoDAO.getLista());
	}

	@Test
	public void deveLancarFalsoSeUmCandidatoNaoExiste() throws Exception{
		
		Candidato candidato = new Candidato();
		candidato.setNome("FULANO");
		candidato.setTituloEleitoral("000000");
		
		Candidato candidatoDois = new Candidato();
		candidatoDois.setNome("FULANO");
		candidatoDois.setTituloEleitoral("000001");

		Assert.assertFalse(candidato.equals(candidatoDois));
	}
	
}
