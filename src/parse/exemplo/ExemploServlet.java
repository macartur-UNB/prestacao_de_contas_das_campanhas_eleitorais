package parse.exemplo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selecionarPessoa")
public class ExemploServlet extends HttpServlet {

	private static final long serialVersionUID = -5034505257122185902L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/exemplo_visualizar_pessoa.jsp");
		requestDispatcher.forward(request, response);
	}
}
