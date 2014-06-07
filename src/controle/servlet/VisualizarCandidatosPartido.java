package controle.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import controle.CampanhaControle;

@WebServlet("/VisualizarCandidatosPartido")
public class VisualizarCandidatosPartido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public VisualizarCandidatosPartido() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			CampanhaControle campanhaControle = new CampanhaControle();
			ArrayList<Campanha> listaCampanhas = new ArrayList<>();
			String sigla = request.getParameter("sigla");
			String ano =  request.getParameter("ano");
			listaCampanhas = campanhaControle.getListaCampanhasPorSiglaPartidoEAno(sigla,ano);
			int anos[] = { 2010, 2006, 2002 };
			request.setAttribute("anos", anos);
			request.setAttribute("listaCampanhas", listaCampanhas);
			RequestDispatcher requestDispatcher = request.
					getRequestDispatcher("/visualizar_candidato_partido.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
