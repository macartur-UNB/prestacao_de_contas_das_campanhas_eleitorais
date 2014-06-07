package controle;

import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

public class CandidatoControle {

	private CandidatoDAO candidatoDAO;

	public CandidatoControle() {
		this.candidatoDAO = new CandidatoDAO();
	}
	
	public LinkedList<Candidato> getListaCandidatos(String nome) {
		return this.candidatoDAO.getLista(nome);
	}

	public Candidato getUmCandidato(String tituloEleitoral) {
		return this.candidatoDAO.getCandidato(tituloEleitoral);
	}
}