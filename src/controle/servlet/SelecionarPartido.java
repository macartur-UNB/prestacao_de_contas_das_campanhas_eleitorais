package controle.servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

@WebServlet("/SelecionarPartido")
public class SelecionarPartido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PartidoDAO partidoDAO = new PartidoDAO();
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public SelecionarPartido() {
		
	}
       
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/visualizar_partido.jsp");
		requestDispatcher.forward(request, response);
	}*/
	
	public void exibirInformacaoPartido(LinkedList<Partido> listaPartidos) {
		
		this.partidoDAO = partidoDAO;
		this.request = request;
		this.response = response;
		
		
	}
	
	

}
