package controle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import controle.CampanhaControle;
import controle.CandidatoControle;

@WebServlet("/SelecionarCandidato")
public class SelecionarCandidato extends HttpServlet {

	private static final long serialVersionUID = -4024368294265814535L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String tituloEleitoral = request.getParameter("tituloEleitoral");

		RequestDispatcher requestDispatcher;

		CandidatoControle candidatoControl = new CandidatoControle();
		CampanhaControle campanhaControl = new CampanhaControle();
		Candidato candidato = candidatoControl.getUmCandidato(tituloEleitoral);

		if (candidato.getTituloEleitoral().equals("-1")) {
			requestDispatcher = request
					.getRequestDispatcher("/erro_candidato_inexistente.jsp");
			requestDispatcher.forward(request, response);
		} else {
			List<Campanha> campanhas = campanhaControl.getListaCampanhas(candidato);
			request.setAttribute("candidato", candidato);
			request.setAttribute("campanhas", campanhas);

			requestDispatcher = request
					.getRequestDispatcher("/visualizar_candidato.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
