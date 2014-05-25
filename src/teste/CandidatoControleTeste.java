package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Partido;
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
		
		
		ArrayList<Candidato>   listaCandidatos = new ArrayList <Candidato> ();
			
		Candidato candidato = new Candidato();
		candidato.setNome("Nome_Candidato");
		listaCandidatos.add(candidato);
				
		/*this.candidatoDAO.adicionarResultSetNaLista(listaCandidatos);*/
		this.candidatoDAO.getCandidato("Nome_Candidato");
		this.candidatoControle.getCandidato("Nome_Candidato");
			
	}
	
	@Test
	public void deveRecuperarUmaListaDeCandidatos() throws SQLException {
		
	}

}
