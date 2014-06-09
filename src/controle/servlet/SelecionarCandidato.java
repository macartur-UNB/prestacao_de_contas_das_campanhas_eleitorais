package controle.servlet;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import controle.CampanhaControle;
import controle.CandidatoControle;

public class SelecionarCandidato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String tituloEleitoral = req.getParameter("tituloEleitoral");

		RequestDispatcher requestDispatcher;

		CandidatoControle candidatoControl = new CandidatoControle();
		CampanhaControle campanhaControl = new CampanhaControle();
		Candidato candidato = candidatoControl.getUmCandidato(tituloEleitoral);

		if (candidato.getTituloEleitoral().equals("-1")) {
			return "/erro_candidato_inexistente.jsp";
		} else {
			List<Campanha> campanhas = campanhaControl.getListaCampanhas(candidato);
			req.setAttribute("candidato", candidato);
			req.setAttribute("campanhas", campanhas);

			return "/visualizar_candidato.jsp";
		}
	}

}
