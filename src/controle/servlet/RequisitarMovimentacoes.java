package controle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Resultado;
import modelo.dao.CampanhaDAO;

@WebServlet("/requisitarMovimentacoes")
public class RequisitarMovimentacoes extends HttpServlet {

	private static final long serialVersionUID = 2421786756015460808L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int ano = Integer.parseInt(request.getParameter("ano"));
		int numero = Integer.parseInt(request.getParameter("numero_cand"));
		int cargo_cod = Integer.parseInt(request.getParameter("cargo_cod"));
		int result_cod = Integer.parseInt(request.getParameter("resultado_cod"));
		String nomeDeUrna = request.getParameter("nome_urna");
		
		Cargo cargo = new Cargo();
		cargo.setCodigo(cargo_cod);
		// Buscar descricao para exibir na pagina
		
		Resultado resultado = new Resultado();
		resultado.setCodigo(result_cod);
		// Buscar descricao para exbir na pagina

		RequestDispatcher requestDispatcher;
		//MovimentacaoControle control = new MovimentacaoControle();

		Campanha campanha = new Campanha();
		campanha.setNumeroCandidato(numero);
		campanha.setAno(ano);
		campanha.setCargo(cargo);
		campanha.setResultado(resultado);
		campanha.setNomeDeUrna(nomeDeUrna);
		
		CampanhaDAO dao = new CampanhaDAO();
		
		campanha = dao.getPeloAnoNumeroECodCargo(campanha);
		
		if (campanha == null) {
			requestDispatcher = request
					.getRequestDispatcher("/erro_candidato_inexistente.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("campanha", campanha);
			
			//List<Receita> listaReceita = control.getListaReceitas(campanha);
			//List<Despesa> listaDespesa = control.getListaDespesas(campanha);
			
			//request.setAttribute("listaReceitas", listaReceita);
			//request.setAttribute("listaDespesas", listaDespesa);
		
			requestDispatcher = request
					.getRequestDispatcher("/visualizar_movimentacoes.jsp");
			requestDispatcher.forward(request, response);
		}
	
	}

}
