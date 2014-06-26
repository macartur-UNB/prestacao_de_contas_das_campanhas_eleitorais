package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

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
	public void deveRecuperarUmaListaDeCandidatosPorUmNomeComum() throws SQLException {

		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		LinkedList<Candidato> listaCandidatosNomeComum = new LinkedList<>();
		
		Candidato candidato1 = new Candidato();
		candidato1.setNome("CANDIDATO INEXISTENTE 1");
		candidato1.setTituloEleitoral("000000");
		listaCandidatos.add(candidato1);

		Candidato candidato2 = new Candidato();
		candidato2.setNome("CANDIDATO INEXISTENTE 2");
		candidato2.setTituloEleitoral("000001");
		listaCandidatos.add(candidato2);
		
		Candidato candidato3 = new Candidato();
		candidato3.setNome("CANDIDATO EXISTENTE 1");
		candidato3.setTituloEleitoral("000002");
		listaCandidatos.add(candidato3);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		listaCandidatosNomeComum = this.candidatoDAO.getListaPeloNome("INEXISTENTE");
		this.candidatoControle.getListaCandidatos("INEXISTENTE");
		
		Assert.assertEquals(listaCandidatosNomeComum, this.candidatoControle.getListaCandidatos("INEXISTENTE"));
	}
	
	@Test
	public void deveRecuperarUmCandidatoPeloTituloEleitoral() throws SQLException {
		
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		Candidato candidatoRecuperado = new Candidato();
		
		Candidato candidato1 = new Candidato();
		candidato1.setNome("CANDIDATO EXISTENTE 1");
		candidato1.setTituloEleitoral("000000");
		listaCandidatos.add(candidato1);

		Candidato candidato2 = new Candidato();
		candidato2.setNome("CANDIDATO EXISTENTE 2");
		candidato2.setTituloEleitoral("000001");
		listaCandidatos.add(candidato2);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
		candidatoRecuperado = this.candidatoDAO.getCandidatoPeloTitulo("000000");
		this.candidatoControle.getUmCandidato("000000");
		
		Assert.assertEquals(candidatoRecuperado, this.candidatoControle.getUmCandidato("000000"));
	}
	
}
