/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requisitarMovimentacoes")
public class RequisitarMovimentacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override
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
}