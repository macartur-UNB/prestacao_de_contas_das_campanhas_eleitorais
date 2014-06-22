package controle.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import controle.CampanhaControle;
import controle.CandidatoControle;

public class SelecionarCandidato implements Logica {

	private CandidatoControle candidatoControle;
	private Candidato candidato;
	private CampanhaControle campanhaControle;
	private List<Campanha> listaCampanha;

	private String tituloEleitoral;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		
		this.tituloEleitoral = req.getParameter("tituloEleitoral");

		this.candidatoControle = new CandidatoControle();
		this.campanhaControle = new CampanhaControle();
		
		this.candidato = this.candidatoControle.getUmCandidato(this.tituloEleitoral);

		this.listaCampanha = this.campanhaControle.getListaCampanhas(this.candidato);
		req.setAttribute("candidato", this.candidato);
		req.setAttribute("campanhas", this.listaCampanha);

		return "/visualizar_candidato.jsp";
	}

}
