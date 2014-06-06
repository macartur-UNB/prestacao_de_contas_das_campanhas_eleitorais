package controle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;


@WebServlet("/visualizarPartido")
public class VisualizarPartido extends HttpServlet{

	private static final long serialVersionUID = 2421786756015460808L;
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sigla = request.getParameter("sigla");
		
		RequestDispatcher requestDispatcher;
		
		Partido partido = new Partido();
		
		partido.setNome(nome);
		partido.setSigla(sigla);
		
		request.setAttribute("partido", partido);
	
		requestDispatcher = request.getRequestDispatcher("/visualizar_partido.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	
}
