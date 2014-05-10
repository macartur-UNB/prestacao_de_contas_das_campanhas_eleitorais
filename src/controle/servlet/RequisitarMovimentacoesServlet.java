/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import modelo.dao.MovimentacaoDAO;

@WebServlet("/requisitarMovimentacoesCandidato")

public class RequisitarMovimentacoesServlet extends HttpServlet {

	private MovimentacaoDAO dao;
	private LinkedList<Receita> listaReceitas;
	private LinkedList<Despesa> listaDespesas;
	
	private static final long serialVersionUID = 2421786756015460808L;

	@Override

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
		
		try {
			dao = new MovimentacaoDAO();
			System.out.println("Conexao BD foi estabelecida");
			listaReceitas = dao.getListaReceitas(candidato);
			listaDespesas = dao.getListaDespesas(candidato);
			
			//Mostrar na tela o resultado
			
			out.println("<html>");
			out.println("<body>");
			
			out.println("<h1>Resultado da busca:</h1>");
			out.println("<p> Candidato: "+ candidato.getNome() + 
						", " + candidato.getAno() + "</p>");
			out.println("<br />");
			
			out.println("<h2> Receitas: </h2>");
			out.println(listaReceitas);
			
			out.println("<h2> Despesas: </h2>");
			out.println(listaDespesas);
			
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
			throw new ServletException(e);
		}
		
		
	}
}