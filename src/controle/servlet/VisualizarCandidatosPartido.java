package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import controle.CandidatoControle;

@WebServlet("/VisualizarCandidatosPartido")
public class VisualizarCandidatosPartido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		CandidatoControle candidatoControle = new CandidatoControle();
		
		String nome = request.getParameter("nome");
		
		try {
			ArrayList<Candidato> listaCandidatos = new ArrayList<>();
			listaCandidatos = candidatoControle.getListaCandidatos();
			ArrayList<Candidato> listaCandidatosDF = new ArrayList<>();
			for(Candidato candidato : listaCandidatos) {
				if(candidato.getUf().equals("DF")) {
					listaCandidatosDF.add(candidato);
				}
			}
			int anos[] = { 2010, 2006, 2002 };
			request.setAttribute("anos", anos);
			request.setAttribute("listaCandidatosDF", listaCandidatosDF);
			RequestDispatcher requestDispatcher = request.
					getRequestDispatcher("/visualizar_candidato_partido.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
