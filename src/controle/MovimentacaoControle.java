package controle;

import java.sql.SQLException;
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

	public List<Receita> getListaReceitas(Campanha campanha) throws SQLException {
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO))
			return null;
		else
			return this.receitaDAO.getPorAnoNumeroCargo(campanha);
	}

	public List<Despesa> getListaDespesas(Campanha campanha) throws SQLException {
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO))
			return null;
		else
			return this.despesaDAO.getPorAnoNumeroCargo(campanha);
	}

	public Receita getReceitaPeloId(int id) throws SQLException {
		return this.receitaDAO.getPeloId(id);
	}

	public Despesa getDespesaPeloId(int id) throws SQLException {
		return this.despesaDAO.getPeloId(id);
	}

}
