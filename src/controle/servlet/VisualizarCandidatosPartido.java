package controle.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import controle.CampanhaControle;

public class VisualizarCandidatosPartido implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		try {
			CampanhaControle campanhaControle = new CampanhaControle();
			ArrayList<Campanha> listaCampanhas = new ArrayList<>();
			String sigla = req.getParameter("sigla");
			String ano =  req.getParameter("ano");
			listaCampanhas = campanhaControle.getListaCampanhasPorSiglaPartidoEAno(sigla,ano);
			int anos[] = { 2010, 2006, 2002 };
			req.setAttribute("anos", anos);
			req.setAttribute("listaCampanhas", listaCampanhas);
			return "/visualizar_candidato_partido.jsp";
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);		
		}
	}
}
