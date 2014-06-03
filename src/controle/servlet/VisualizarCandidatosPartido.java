package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import modelo.beans.Partido;
import controle.CandidatoControle;

@WebServlet("/VisualizarCandidatosPartido")
public class VisualizarCandidatosPartido extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public VisualizarCandidatosPartido() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			CandidatoControle candidatoControle = new CandidatoControle();
			ArrayList<Candidato> listaCandidatos = new ArrayList<>();
			listaCandidatos = candidatoControle.getListaCandidatos();
			listaCandidatos =
					filtrarListaDeCandidatosPorUfPartidoAnoCadastroUnico
					(listaCandidatos,request);
			int anos[] = { 2010, 2006, 2002 };
			request.setAttribute("anos", anos);
			request.setAttribute("listaCandidatos", listaCandidatos);
			RequestDispatcher requestDispatcher = request.
					getRequestDispatcher("/visualizar_candidato_partido.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Candidato> filtrarListaDeCandidatosPorUfPartidoAnoCadastroUnico
		(ArrayList<Candidato> lCandidatos, HttpServletRequest request) {	
		
		String sigla = request.getParameter("sigla");
		int ano = Integer.parseInt(request.getParameter("ano"));
		Partido partido = new Partido();
		partido.setSigla(sigla);
		
		ArrayList<Candidato> lCandidatosFiltrados = new ArrayList<>();
		
		for(Candidato candidato : lCandidatos) {
			if((candidato.getNome().equals("DF"))
//					&& (candidato.getPartido().equals(partido))
//					&& (candidato.getAno().equals(ano))
					&& !(lCandidatosFiltrados.contains(candidato))) {
				lCandidatosFiltrados.add(candidato);
			}
		}		
		return lCandidatosFiltrados;
	}
}
