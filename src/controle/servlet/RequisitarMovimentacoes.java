/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
 **/

package controle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.PartidoControle;
import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Partido;
import modelo.beans.Receita;

@WebServlet("/requisitarMovimentacoes")
public class RequisitarMovimentacoes extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int ano = Integer.parseInt(request.getParameter("ano"));
		String nome = request.getParameter("nome");

		RequestDispatcher requestDispatcher;
		
		if (request.getParameter("tabela").equals("candidato")) {
			Candidato candidato = new Candidato();
			candidato.setNome(nome);
			candidato.setAno(ano);

			if (!candidato.existe()) {
				requestDispatcher = request
						.getRequestDispatcher("/erro_candidato_inexistente.jsp");
				requestDispatcher.forward(request, response);
			} else {
				request.setAttribute("candidato", candidato);
				request.setAttribute("entidade", "Candidato");
				
				List<Receita> listaReceita = candidato.getListaReceitas();
				List<Despesa> listaDespesa = candidato.getListaDespesas();
				
				request.setAttribute("listaReceitas", listaReceita);
				request.setAttribute("listaDespesas", listaDespesa);
				
				requestDispatcher = request
						.getRequestDispatcher("/visualizar_movimentacoes.jsp");
				requestDispatcher.forward(request, response);
			}
		} else if (request.getParameter("tabela").equals("partido")) {
			PartidoControle partidoControle = new PartidoControle();

			String sigla = request.getParameter("nome");

			Partido partido = new Partido();
			partido.setSigla(sigla);
			
			try{
				List<Receita> listaReceita = partido.getListaReceitas(ano);
				List<Despesa> listaDespesa = partido.getListaDespesas(ano);
				request.setAttribute("listaReceitas", listaReceita);
				request.setAttribute("listaDespesas", listaDespesa);
				
				partido = partidoControle.getPartido(sigla);
				if (partido.getSigla().equals("0")) {
					requestDispatcher = request
							.getRequestDispatcher("/erro_partido_inexistente.jsp");
					requestDispatcher.forward(request, response);
				} else {
					request.setAttribute("partido", partido);
					request.setAttribute("entidade","Partido");

					requestDispatcher = request
							.getRequestDispatcher("/visualizar_movimentacoes.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch(Exception e){
				System.out.println("Erro no acesso ao BD");
				throw new ServletException(e);
			}
			
		}

	}
}