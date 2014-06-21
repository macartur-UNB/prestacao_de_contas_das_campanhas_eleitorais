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
			String inicio = req.getParameter("inicio");
			int indice = geraIndiceDaLista(listaPartidos);
			req.setAttribute("listaPartidos", listaPartidos);
			req.setAttribute("indice", indice);
			req.setAttribute("inicio", inicio);
			return "/listar_partidos.jsp";
		
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}		
	}
	
	public int geraIndiceDaLista(List<Partido> lista) {
		int indice = 1;
		for (int i = 0; i < lista.size(); i++) {
			indice++;
		}
		indice = (int) Math.ceil(indice/10);
		return indice;
	}
}
