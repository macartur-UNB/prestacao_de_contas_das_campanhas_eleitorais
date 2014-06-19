package controle.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Despesa;
import modelo.beans.Receita;
import controle.MovimentacaoControle;

public class VisualizarMovimentacao implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		int id = Integer.parseInt(req.getParameter("movimentacao_id"));
		String tipo = req.getParameter("movimentacao_tipo");
		
		MovimentacaoControle controle = new MovimentacaoControle();
		
		if(tipo.equals("despesa")){
			Despesa despesa = controle.getDespesaPeloId(id);
			req.setAttribute("movimentacao", despesa);
		}	
		else if(tipo.equals("receita")){
			Receita receita = controle.getReceitaPeloId(id);
			req.setAttribute("movimentacao", receita);
		}
		else{
			throw new ServletException();
		}
		
		return "/visualizar_movimentacao.jsp";
	}

}
