package controle.servlet;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import controle.CampanhaControle;
import controle.MovimentacaoControle;

public class RequisitarMovimentacoesDeCandidato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Campanha campanhaBusca = constroiCampanha(req);
				
		try {
			
			CampanhaControle campanhaControle = new CampanhaControle();
			Campanha campanha = campanhaControle
					.getPeloAnoNumeroCodCargoEUf(campanhaBusca);
			MovimentacaoControle movimentacaoControle = new MovimentacaoControle();
			
			if (campanha == null) {
				return "/erro_candidato_inexistente.jsp";
			} else {
				
				String despesaTot = 
						formataDespesa(campanha.getDespesaMaxDeclarada());
				
				List<Receita> listaReceita = 
						movimentacaoControle.getListaReceitas(campanha);
				List<Despesa> listaDespesa = 
						movimentacaoControle.getListaDespesas(campanha);
				
				req.setAttribute("listaReceitas", listaReceita);
				req.setAttribute("listaDespesas", listaDespesa);
				
				req.setAttribute("campanha", campanha);
				req.setAttribute("depesaTot", despesaTot);

				return "/visualizar_movimentacoes.jsp";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);

		}
		
	}

	private String formataDespesa(Float despesa) {
		DecimalFormatSymbols padraoBrasileiro = new DecimalFormatSymbols(Locale.GERMAN);
		
		DecimalFormat df  = new DecimalFormat("###,###,##0.00",padraoBrasileiro);  
		String despesaTot = df.format(despesa); 
	
		despesaTot = "R$ " + despesaTot;
		
		return despesaTot;
	}

	private Campanha constroiCampanha(HttpServletRequest req) {

		int ano = Integer.parseInt(req.getParameter("ano"));
		int numero = Integer.parseInt(req.getParameter("numero_cand"));
		int cargo_cod = Integer.parseInt(req.getParameter("cargo_cod"));
		String uf = req.getParameter("uf");
		
		Cargo cargo = new Cargo();
		cargo.setCodigo(cargo_cod);
		
		Campanha campanha = new Campanha();
		campanha.setNumeroCandidato(numero);
		campanha.setAno(ano);
		campanha.setCargo(cargo);
		campanha.setUf(uf);
		
		return campanha;
	}

}
