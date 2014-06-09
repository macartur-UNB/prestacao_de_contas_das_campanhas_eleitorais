package controle.servlet;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import controle.CandidatoControle;

public class VisualizarResultadoListaBuscaCandidato implements Logica {
       
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String nome = req.getParameter("nome");

		RequestDispatcher requestDispatcher;

		CandidatoControle control = new CandidatoControle();
		List<Candidato> listaCandidatos = control.getListaCandidatos(nome);

		if (listaCandidatos.isEmpty()) {
			return "/erro_candidato_inexistente.jsp";
		} else {

			req.setAttribute("listaCandidatos", listaCandidatos);

			return "/visualizar_lista_candidatos.jsp";
		}
	}
}
