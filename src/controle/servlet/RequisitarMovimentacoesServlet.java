/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.PartidoControle;
import modelo.beans.Candidato;
import modelo.beans.Partido;


@WebServlet("/requisitarMovimentacoes")
public class RequisitarMovimentacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override

	protected void service(HttpServletRequest request, 
						   HttpServletResponse response)
			throws ServletException, IOException {

		int ano  = Integer.parseInt(request.getParameter("ano"));
		String nome = request.getParameter("nome");

		RequestDispatcher requestDispatcher;
		if(request.getParameter("tabela").equals("candidato"))
		{
			// Pegando os parametros de candidato
			Candidato candidato = new Candidato();
			candidato.setNome(nome);
			candidato.setAno(ano);

			// Verifica se candidato existe
			if(!candidato.existe()){
				requestDispatcher = request
					    .getRequestDispatcher("/erro_candidato_inexistente.jsp");
				requestDispatcher.forward(request,response);
			}else{
				// Busca receitas e despesas do candidato
				
				request.setAttribute("candidato", candidato);
				requestDispatcher = request
					    .getRequestDispatcher("/visualizar_movimentacoes_candidato.jsp");
				requestDispatcher.forward(request,response);
			}
		} else if(request.getParameter("tabela").equals("partido"))
		{
			// Pegando os parametros de partido
			PartidoControle partidoControle = new PartidoControle();

			String sigla = request.getParameter("sigla");
			
			Partido partido = new Partido();
			
			try {
				partido = partidoControle.getPartido(sigla);
				
				// Verifica se o partido existe
				if(partido.getSigla().equals("0"))
				{
					requestDispatcher = request
						    .getRequestDispatcher("/erro_partido_inexistente.jsp");
					requestDispatcher.forward(request,response);
				} else {
					request.setAttribute("partido", partido);
					
					requestDispatcher = request
							.getRequestDispatcher("/visualizar_movimentacoes_partido.jsp");
					requestDispatcher.forward(request,response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}	
}