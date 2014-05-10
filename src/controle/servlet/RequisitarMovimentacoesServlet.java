/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.LinkedList;
=======
>>>>>>> Criada pagina de requisicao de Relatorio de Movimetacoes Financeiras; Uni ReceitaDAO e DespesaDAO em uma unica classe MovimentacaoDAO

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import modelo.dao.MovimentacaoDAO;

@WebServlet("/requisitarMovimentacoesCandidato")
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
		
		//buscando o Writer
		PrintWriter out = response.getWriter();
		
		//pegando os parametros do request
		Candidato candidato = new Candidato();
		candidato.setNome(request.getParameter("nome"));
		
		try{
			int ano = Integer.parseInt(request.getParameter("ano"));
			candidato.setAno(ano);
		} catch (NumberFormatException e)
		{
			out.println("Erro na obtenção do ano.");
			return;
		}
		
		//Buscar dados no BD
		MovimentacaoDAO dao = new MovimentacaoDAO();

		LinkedList<Receita> listaReceitas;
		LinkedList<Despesa> listaDespesas;
		
		try{
			listaReceitas = dao.getListaReceitas(candidato);
			listaDespesas = dao.getListaDespesas(candidato);
		} catch (SQLException e){
			throw new ServletException(e);
		}
		
		//Mostrar na tela o resultado
		
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1>Resultado da busca:</h1>");
		out.println("<p> Candidato: "+ candidato.getNome() + 
					", " + candidato.getAno() + "</p>");
		out.println("<br />");
		//out.println(listaReceitas);
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
>>>>>>> Criada pagina de requisicao de Relatorio de Movimetacoes Financeiras; Uni ReceitaDAO e DespesaDAO em uma unica classe MovimentacaoDAO
		out.println("</body>");
		out.println("</html>");
		
	}
}