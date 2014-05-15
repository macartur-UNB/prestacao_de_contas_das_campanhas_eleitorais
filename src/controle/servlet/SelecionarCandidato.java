package controle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.CandidatoControle;
import modelo.beans.Candidato;

@WebServlet("/SelecionarCandidato")
public class SelecionarCandidato extends HttpServlet {

	private static final long serialVersionUID = -4024368294265814535L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		Candidato candidato = new Candidato();
		candidato.setNome(nome);

		RequestDispatcher requestDispatcher;

		CandidatoControle control = new CandidatoControle();
		List<Candidato> listaCandidato = (List<Candidato>) control
				.getCandidato(nome);

		if (listaCandidato.isEmpty()) {
			requestDispatcher = request
					.getRequestDispatcher("/erro_candidato_inexistente.jsp");
			requestDispatcher.forward(request, response);
		} else {

			String cpf = listaCandidato.get(0).getCpf();
			request.setAttribute("cpf", cpf);
			request.setAttribute("listaCandidato", listaCandidato);

			requestDispatcher = request
					.getRequestDispatcher("/visualizar_candidato.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
