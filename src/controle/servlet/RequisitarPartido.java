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
			
			int inicio = Integer.parseInt(req.getParameter("inicio"));
			int qtdPorPagina = Integer.parseInt(req.getParameter("qtdPorPagina"));
			boolean verTodos = Boolean.parseBoolean(req.getParameter("verTodos"));
			
			int indice = control.geraIndiceDaLista(listaPartidos,qtdPorPagina);
			int qtdDePP = control.geraIndiceDePaginacao(listaPartidos);
			
			//System.out.println(qtdDePP);
			
			req.setAttribute("listaPartidos", listaPartidos);
			req.setAttribute("inicio", inicio);
			if(verTodos)
				qtdPorPagina = listaPartidos.size();
			req.setAttribute("qtdPorPagina", qtdPorPagina);
			req.setAttribute("indice", indice);
			req.setAttribute("qtdDePP", qtdDePP);
			
			return "/listar_partidos.jsp";
		
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}		
	}
}
