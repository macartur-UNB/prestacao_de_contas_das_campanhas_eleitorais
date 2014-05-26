package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

public class CandidatoControle {

	private CandidatoDAO candidatoDAO;

	public CandidatoControle() {
		this.candidatoDAO = new CandidatoDAO();
	}
	
	public ArrayList<Candidato> getListaCandidatos() throws SQLException {
		return this.candidatoDAO.getLista();
	}

	public LinkedList<Candidato> getListaCandidatos(String nome) {
		return this.candidatoDAO.getLista(nome);
	}

	public LinkedList<Candidato> getUmCandidato(String nome) {
		return this.candidatoDAO.getCandidato(nome);
	}

}