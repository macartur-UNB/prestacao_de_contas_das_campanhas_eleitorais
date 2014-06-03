package controle.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import controle.CandidatoControle;


@WebServlet("/VisualizarResultadoListaBuscaCandidato")
public class VisualizarResultadoListaBuscaCandidato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");

		RequestDispatcher requestDispatcher;

		CandidatoControle control = new CandidatoControle();
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();

		if (listaCandidatos.isEmpty()) {
			requestDispatcher = request
					.getRequestDispatcher("/erro_candidato_inexistente.jsp");
			requestDispatcher.forward(request, response);
		} else {

			String cpf = listaCandidatos.get(0).getNome();
			request.setAttribute("cpf", cpf);
			request.setAttribute("listaCandidatos", listaCandidatos);

			requestDispatcher = request
					.getRequestDispatcher("/visualizar_lista_candidatos.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
