package parse.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carregarParse")
public class CarregarParse extends HttpServlet {

	private static final long serialVersionUID = 5625867877274809499L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter saida = response.getWriter();
		
		String arquivo = request.getParameter("arquivo");
		String tipoArquivo;
		
		if(request.getParameter("tipo_arquivo").equals("despesa")) {
			tipoArquivo = "despesa";
		} else {
			tipoArquivo = "receita";
		}
		
		saida.println(arquivo);
		saida.println("Tipo do Arquivo: " + tipoArquivo);
		saida.println("Arquivo Carregado!");
	}
}
