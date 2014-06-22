package controle.servlet;

import java.util.ArrayList;
import java.util.List;

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
		
		int inicio = Integer.parseInt(req.getParameter("inicio"));
		int qtdPorPagina = Integer.parseInt(req.getParameter("qtdPorPagina"));
		boolean verTodos = Boolean.parseBoolean(req.getParameter("verTodos"));
		
		try {
			CampanhaControle campanhaControle = new CampanhaControle();
			PartidoControle controle = new PartidoControle();
			
			Partido partido = controle.getPelaSigla(sigla);

			ArrayList<Campanha> listaCampanhas = new ArrayList<>();

			listaCampanhas = campanhaControle
					.getListaCampanhasPorSiglaPartidoEAno(sigla,ano);
			
			int indice = geraIndiceDaLista(listaCampanhas,qtdPorPagina);
			int qtdDePP = geraIndiceDePaginacao(listaCampanhas);
						
			req.setAttribute("ano", ano);
			req.setAttribute("listaCampanhas", listaCampanhas);
			req.setAttribute("partido",partido);
			
			req.setAttribute("sigla", sigla);
			
			req.setAttribute("inicio", inicio);
			if(verTodos)
				qtdPorPagina = listaCampanhas.size();
			req.setAttribute("qtdPorPagina", qtdPorPagina);
			req.setAttribute("indice", indice);
			req.setAttribute("qtdDePP", qtdDePP);
			
			return "/visualizar_candidato_partido.jsp";
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);		
		}
	}
	
	private int geraIndiceDaLista(List<Campanha> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}
	
	private int geraIndiceDePaginacao(List<Campanha> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
