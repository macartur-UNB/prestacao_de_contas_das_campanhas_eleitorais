package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.MovimentacaoControle;
import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Receita;
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
		
		RequestDispatcher requestDispatcher;

		Cargo cargo = new Cargo();
		cargo.setCodigo(cargo_cod);
		
		Campanha campanha = new Campanha();
		campanha.setNumeroCandidato(numero);
		campanha.setAno(ano);
		campanha.setCargo(cargo);
		
		CampanhaDAO dao = new CampanhaDAO();
		
		try {
			campanha = dao.getPeloAnoNumeroECodCargo(campanha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (campanha == null) {
			requestDispatcher = request
					.getRequestDispatcher("/erro_candidato_inexistente.jsp");
			requestDispatcher.forward(request, response);
		} else {	
			DecimalFormatSymbols padraoBrasileiro = new DecimalFormatSymbols(Locale.GERMAN);
			
			DecimalFormat df  = new DecimalFormat("###,###,##0.00",padraoBrasileiro);  
			String despesaTot = df.format(campanha.getDespesaMaxDeclarada());  
			despesaTot = "R$ " + despesaTot;
			
			request.setAttribute("campanha", campanha);
			request.setAttribute("depesaTot", despesaTot);
			
			MovimentacaoControle control = new MovimentacaoControle();
			
			List<Receita> listaReceita = null;
			try {
				listaReceita = control.getListaReceitas(campanha);
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Despesa> listaDespesa = null;
			try {
				listaDespesa = control.getListaDespesas(campanha);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("listaReceitas", listaReceita);
			request.setAttribute("listaDespesas", listaDespesa);
		
			requestDispatcher = request
					.getRequestDispatcher("/visualizar_movimentacoes.jsp");
			requestDispatcher.forward(request, response);
		}
	
	}

}
