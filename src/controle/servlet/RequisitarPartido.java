package controle.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

public class RequisitarPartido implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		PartidoControle control = new PartidoControle();
		try {
			List<Partido> listaPartidos = control.getListaPartidos();
			req.setAttribute("listaPartidos", listaPartidos);
			
			return "/listar_partidos.jsp";
		
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}		
	}
}
