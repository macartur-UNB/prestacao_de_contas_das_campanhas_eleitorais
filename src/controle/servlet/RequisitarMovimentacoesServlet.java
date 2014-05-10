/** CRIADO POR:          Rafael Valenca
 * 
 *  COMENTARIOS: 10/05/2014
**/

package controle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
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

@WebServlet("/requisitarMovimentacoes")

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
			
			//Tabela Receitas 
			out.println("<h2> Receitas: </h2>");

			out.println("<table border=\"2\">");
			
			out.println("<tr>");
				out.println("<th>Hora Registro</th>");
				//out.println("<th>Entraga em Conjunto</th>");
				out.println("<th>Número do Documento</th>");
				out.println("<th>Data</th>");
				out.println("<th>Valor</th>");
				out.println("<th>Fonte</th>");
				out.println("<th>Tipo</th>");
				out.println("<th>Espécie</th>");
				out.println("<th>Descrição</th>");
				out.println("<th>Recibo Eleitoral</th>");
				out.println("<th>Nome do Doador</th>");
				out.println("<th>Cadastro do Doador</th>");	
			out.println("</tr>");
			for(Receita receita:listaReceitas)
			{
			out.println("<tr>");
				out.println("<td>"+receita.getHoraRegistro()+"</td>");
				//out.println("<td>"+receita.isEntregaEmConjunto()+"</td>");
				out.println("<td>"+receita.getNumeroDocumento()+"</td>");
				out.println("<td>"+receita.getData()+"</td>");
				out.println("<td>"+receita.getValor()+"</td>");
				out.println("<td>"+receita.getFonte()+"</td>");
				out.println("<td>"+receita.getTipo()+"</td>");
				out.println("<td>"+receita.getEspecie()+"</td>");
				out.println("<td>"+receita.getDescricao()+"</td>");
				out.println("<td>"+receita.getReciboEleitoral()+"</td>");
				out.println("<td>"+receita.getDoador().getNome()+"</td>");
				out.println("<td>"+receita.getDoador().getCadastroNacional()
						+"</td>");

			out.println("</tr>");	
			}
			out.println("</table>");
			
			//Tabela Despesas
			out.println("<h2> Despesas: </h2>");
			
			out.println("<table border=\"2\">");
			out.println("<tr>");
				out.println("<th>Hora Registro</th>");
				//out.println("<th>Entraga em Conjunto</th>");
				out.println("<th>Número do Documento</th>");
				out.println("<th>Data</th>");
				out.println("<th>Valor</th>");
				out.println("<th>Fonte</th>");
				out.println("<th>Tipo</th>");
				out.println("<th>Espécie</th>");
				out.println("<th>Descrição</th>");
				out.println("<th>Recibo Eleitoral</th>");
				out.println("<th>Nome do Doador</th>");
				out.println("<th>Cadastro do Doador</th>");	
			out.println("</tr>");
			for(Despesa despesa:listaDespesas)
			{
			out.println("<tr>");
				out.println("<td>"+despesa.getHoraRegistro()+"</td>");
				//out.println("<td>"+despesa.isEntregaEmConjunto()+"</td>");
				out.println("<td>"+despesa.getNumeroDocumento()+"</td>");
				out.println("<td>"+despesa.getData()+"</td>");
				out.println("<td>"+despesa.getValor()+"</td>");
				out.println("<td>"+despesa.getFonte()+"</td>");
				out.println("<td>"+despesa.getTipo()+"</td>");
				out.println("<td>"+despesa.getEspecie()+"</td>");
				out.println("<td>"+despesa.getDescricao()+"</td>");
				out.println("<td>"+despesa.getTipoDocumento()+"</td>");
				out.println("<td>"+despesa.getFornecedor().getNome()+"</td>");
				out.println("<td>"+despesa.getFornecedor().getCadastroNacional()
						+"</td>");

			out.println("</tr>");	
			}
			out.println("</table>");
			
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			System.out.println("Erro no acesso ao BD");
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

	protected void service(HttpServletRequest request, HttpServletResponse response)
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

		out.println("</body>");
		out.println("</html>");
	
	}
}