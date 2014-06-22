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
		return this.candidatoDAO.getListaPeloNome(nome);
	}

	public Candidato getUmCandidato(String tituloEleitoral) {
		return this.candidatoDAO.getCandidatoPeloTitulo(tituloEleitoral);
	}
	
	public int geraIndiceDaLista(List<Candidato> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}
	
	public int geraIndiceDePaginacao(List<Candidato> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}