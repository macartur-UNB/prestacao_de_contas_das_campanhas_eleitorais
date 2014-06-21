package controle.servlet;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

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
		
		CampanhaControle controle = new CampanhaControle();
		
		try {
			campanha = controle.getPeloAnoNumeroCodCargoEUf(campanha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (campanha == null) {
			return "/erro_candidato_inexistente.jsp";
		} else {	
			DecimalFormatSymbols padraoBrasileiro = new DecimalFormatSymbols(Locale.GERMAN);
			
			DecimalFormat df  = new DecimalFormat("###,###,##0.00",padraoBrasileiro);  
			String despesaTot = df.format(campanha.getDespesaMaxDeclarada());  
			despesaTot = "R$ " + despesaTot;
			
			req.setAttribute("campanha", campanha);
			req.setAttribute("depesaTot", despesaTot);
			
			MovimentacaoControle control = new MovimentacaoControle();
			
			List<Receita> listaReceita = null;
			List<Despesa> listaDespesa = null;

			try {
				listaReceita = control.getListaReceitas(campanha);
				listaDespesa = control.getListaDespesas(campanha);
				
				if(ano == 2002){
					for(Receita receita : listaReceita)
						receita.setTipoMovimentacao("Doação");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			req.setAttribute("listaReceitas", listaReceita);
			req.setAttribute("listaDespesas", listaDespesa);

		
			return "/visualizar_movimentacoes.jsp";
		}
	
	}

}
