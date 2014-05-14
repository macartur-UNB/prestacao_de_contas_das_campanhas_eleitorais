/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.CandidatoControle;
import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Receita;

@WebServlet("/requisitarMovimentacoes")
public class RequisitarMovimentacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	int ano;
	String nome;

	@Override

	protected void service(HttpServletRequest request, 
						   HttpServletResponse response)
			throws ServletException, IOException {

		this.ano  = Integer.parseInt(request.getParameter("ano"));
		this.nome = request.getParameter("nome");

		RequestDispatcher requestDispatcher;
		if(request.getParameter("tabela").equals("candidato"))
		{
			// Pegando os parametros de candidato
			Candidato candidato = new Candidato();
			candidato.setNome(this.nome);
			candidato.setAno(this.ano);

			// Verifica se candidato existe
			if(!candidato.existe()){
				requestDispatcher = request
					    .getRequestDispatcher("/candidato_inexistente.html");
				requestDispatcher.forward(request,response);
			}else{
				// Busca receitas e despesas do candidato

				requestDispatcher = request
					    .getRequestDispatcher("/visualizar_movimentacoes_candidato.jsp");
				requestDispatcher.forward(request,response);
			}
		} else if(request.getParameter("tabela").equals("partido"))
		{
			requestDispatcher = request
			    .getRequestDispatcher("/visualizar_movimentacoes_partido.jsp");
			requestDispatcher.forward(request,response);
		} else {
			requestDispatcher = request
				    .getRequestDispatcher("/erro.html");
				requestDispatcher.forward(request,response);
		}

	}	
}