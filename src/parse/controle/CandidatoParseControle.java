package parse.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;
import parse.indices.CandidatoIndicesParse;

public class CandidatoParseControle {

	private CandidatoIndicesParse candidatoIndicesParse;
	private ArrayList<Candidato> listaCandidatos;
	private CandidatoDAO candidatoDAO;

	public CandidatoParseControle(CandidatoIndicesParse candidatoIndicesParse) {
		this.candidatoDAO = new CandidatoDAO();
		this.listaCandidatos = new ArrayList<>();
		this.candidatoIndicesParse = candidatoIndicesParse;
	}

	public void addCandidato(String campo[]) {
		Candidato candidato = new Candidato();
		candidato.setNome(campo[this.candidatoIndicesParse.getIndiceNome()]);
		candidato.setAno(this.candidatoIndicesParse.getAno());
		

		if(!this.listaCandidatos.contains(candidato)) {
			this.candidatoIndicesParse.iniciarCandidato(candidato, campo);
			this.listaCandidatos.add(candidato);
		}
	}

	public void cadastrarCandidatos() throws SQLException {		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
	}

	public void resetar() {
		this.listaCandidatos.clear();
	}

}