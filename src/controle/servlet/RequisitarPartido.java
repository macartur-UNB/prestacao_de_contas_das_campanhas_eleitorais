package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

@WebServlet("/RequisitarPartido")
public class RequisitarPartido extends HttpServlet {

	private static final long serialVersionUID = 207920781158789423L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("select");
		String valor = request.getParameter("valor");
		
		PartidoControle control = new PartidoControle();
		try {
			List<Partido> listaPartidos = control.getListaPartidos(tipo, valor);
			
			request.setAttribute("listaPartidos", listaPartidos);
			
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/listar_partidos.jsp");
			requestDispatcher.forward(request, response);
		
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}

	}
}
