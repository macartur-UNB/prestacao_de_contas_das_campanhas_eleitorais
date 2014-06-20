package controle;

import java.util.List;

import modelo.beans.Campanha;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import modelo.dao.DespesaDAO;
import modelo.dao.ReceitaDAO;

public class MovimentacaoControle {
	
	DespesaDAO despesaDAO;
	ReceitaDAO receitaDAO;
	
	public MovimentacaoControle(){
		this.despesaDAO = new DespesaDAO();
		this.receitaDAO = new ReceitaDAO();
	}

	public List<Receita> getListaReceitas(Campanha campanha) throws Exception {
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO))
			return null;
		else
			return this.receitaDAO.getPorAnoNumeroCargoUf(campanha);
	}

	public List<Despesa> getListaDespesas(Campanha campanha) throws Exception {
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO))
			return null;
		else
			return this.despesaDAO.getPorAnoNumeroCargoUf(campanha);
	}

	public Receita getReceitaPeloId(int id) throws Exception {
		return this.receitaDAO.getPeloId(id);
	}

	public Despesa getDespesaPeloId(int id) throws Exception {
		return this.despesaDAO.getPeloId(id);
	}

}
