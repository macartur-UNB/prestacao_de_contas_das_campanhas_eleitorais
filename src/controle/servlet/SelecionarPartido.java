package controle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

public class SelecionarPartido implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Partido partido = new Partido();
		PartidoControle partidoControle = new PartidoControle();
		
		String sigla = req.getParameter("sigla");

		try {
			int anos[] = { 2010, 2006, 2002 };
			if (partido.getSigla().equals("0")) {
				return "/erro_partido_inexistente.jsp";
			} else {
				partido = partidoControle.getPartido(sigla);
				req.setAttribute("partido", partido);
				req.setAttribute("anos", anos);
				
				return "/visualizar_partido.jsp";
			}
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);		
		}
	}

}