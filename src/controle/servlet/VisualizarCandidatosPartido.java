package controle.servlet;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Partido;
import controle.CampanhaControle;
import controle.PartidoControle;

public class VisualizarCandidatosPartido implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String sigla = req.getParameter("sigla");
		String ano =  req.getParameter("ano");
		//int anos[] = { 2010, 2006, 2002 };
		
		try {

			CampanhaControle campanhaControle = new CampanhaControle();
			PartidoControle controle = new PartidoControle();

			ArrayList<Campanha> listaCampanhas = new ArrayList<>();
			listaCampanhas = campanhaControle.getListaCampanhasPorSiglaPartidoEAno(sigla,ano);
			
			Partido partido = controle.getPartido(sigla);
			
			req.setAttribute("ano", ano);
			req.setAttribute("listaCampanhas", listaCampanhas);
			req.setAttribute("partido",partido);
			return "/visualizar_candidato_partido.jsp";
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);		
		}
	}
}
