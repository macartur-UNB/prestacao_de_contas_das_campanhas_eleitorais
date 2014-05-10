/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;
>>>>>>> Criada pagina de requisicao de Relatorio de Movimetacoes Financeiras; Uni ReceitaDAO e DespesaDAO em uma unica classe MovimentacaoDAO

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

@WebServlet("/requisitarMovimentacoes")

=======
@WebServlet("/requisitarMovimentacoes")
>>>>>>> Criada pagina de requisicao de Relatorio de Movimetacoes Financeiras; Uni ReceitaDAO e DespesaDAO em uma unica classe MovimentacaoDAO
public class RequisitarMovimentacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override
<<<<<<< HEAD
	protected void service(HttpServletRequest request, 
						   HttpServletResponse response)
			throws ServletException, IOException {
		
<<<<<<< HEAD
		RequestDispatcher requestDispatcher = request
			.getRequestDispatcher("/visualizar_movimentacoes_candidato.jsp");
		requestDispatcher.forward(request, response);

	}
=======
		RequestDispatcher requestDispatcher;
		if(request.getParameter("tabela").equals("candidato"))
		{
			requestDispatcher = request
				.getRequestDispatcher("/visualizar_movimentacoes_candidato.jsp");
			requestDispatcher.forward(request,response);
		} else if(request.getParameter("tabela").equals("partido"))
		{
			requestDispatcher = request
			    .getRequestDispatcher("/visualizar_movimentacoes_partido.jsp");
			requestDispatcher.forward(request,response);
		} else {
			return;
		}
		
	}	
>>>>>>> Pagina de visualizacao de receitas e despesas agora também para partidos.Falta filtrar por ano, devido a ausencia desse filtro no BD
=======
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//pegando os parametros do request
		String nome = request.getParameter("nome");
		String ano = request.getParameter("ano");
		String tabela = request.getParameter("tabela");
		
		//USAR clausula SQL SELECT
		
		//Mostrar na tela o resultado
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Resultado da busca:</h1>");
		out.println("<p>"+ nome + ", " + ano + "</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
>>>>>>> Criada pagina de requisicao de Relatorio de Movimetacoes Financeiras; Uni ReceitaDAO e DespesaDAO em uma unica classe MovimentacaoDAO
}