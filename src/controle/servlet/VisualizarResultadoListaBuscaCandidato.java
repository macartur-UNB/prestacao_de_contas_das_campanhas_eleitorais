package controle.servlet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import controle.CandidatoControle;

public class VisualizarResultadoListaBuscaCandidato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		String nome = req.getParameter("nome");

		int inicio = Integer.parseInt(req.getParameter("inicio"));
		int qtdPorPagina = Integer.parseInt(req.getParameter("qtdPorPagina"));
		boolean verTodos = Boolean.parseBoolean(req.getParameter("verTodos"));

		try {
			CandidatoControle control = new CandidatoControle();

			List<Candidato> listaCandidatos = control.getListaCandidatos(nome);

			if (listaCandidatos.isEmpty()) {
				return "/erro_candidato_inexistente.jsp";
			} else {

				int indice = geraIndiceDaLista(listaCandidatos,qtdPorPagina);
				int qtdDePP = geraIndiceDePaginacao(listaCandidatos);

				req.setAttribute("listaCandidatos", listaCandidatos);

				req.setAttribute("nome", nome);
				req.setAttribute("inicio", inicio);
				if(verTodos)
					qtdPorPagina = listaCandidatos.size();
				req.setAttribute("qtdPorPagina", qtdPorPagina);
				req.setAttribute("indice", indice);
				req.setAttribute("qtdDePP", qtdDePP);								

				return "/visualizar_lista_candidatos.jsp";
			}			
		}
		catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}
	}
	
	private int geraIndiceDaLista(List<Candidato> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}
	
	private int geraIndiceDePaginacao(List<Candidato> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
