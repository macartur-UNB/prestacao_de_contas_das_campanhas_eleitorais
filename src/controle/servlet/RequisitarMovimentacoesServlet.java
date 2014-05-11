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


@WebServlet("/requisitarMovimentacoesCandidato")

public class RequisitarMovimentacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override

	protected void service(HttpServletRequest request, 
						   HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request
			.getRequestDispatcher("/visualizar_movimentacoes_candidato.jsp");
		requestDispatcher.forward(request, response);

		
	}
}