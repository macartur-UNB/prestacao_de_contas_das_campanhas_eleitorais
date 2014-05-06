package parse;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;
import parse.indices.CandidatoIndicesParse;

public class CandidatoParse {

	private CandidatoIndicesParse candidatoIndicesParse;
	private ArrayList<Candidato> listaCandidatos;
	private CandidatoDAO candidatoDAO;

	public CandidatoParse(CandidatoIndicesParse candidatoIndicesParse) {
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
<<<<<<< HEAD
	
	public void cadastrarCandidatos() throws SQLException {		
		this.candidatoDAO.cadastrarLista(listaCandidatos);

=======

	public void cadastrarCandidatos() throws SQLException {		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
>>>>>>> Renomeando os nomes dos pacotes para adequar ao doc de arquitetura
	}

	public void resetar() {
		this.listaCandidatos.clear();
	}

}
