package controle;

import java.util.LinkedList;
import java.util.List;

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
	
	public int geraIndiceDaLista(List<Candidato> lista, int divisor) {
		int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
		return indice;
	}
	
	public int geraIndiceDePaginacao(List<Candidato> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}