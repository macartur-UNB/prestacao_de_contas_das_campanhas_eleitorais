package controle;

import java.util.ArrayList;
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

		ArrayList<Receita> listaReceita = new ArrayList<>();
		
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO)
				|| (campanha.getUf()).equals(Campanha.STRING_VAZIO)){
			listaReceita =  null;
			
		}else{
			listaReceita = this.receitaDAO.getPorAnoNumeroCargoUf(campanha);
			
			if(campanha.getAno() == 2002){
				for(Receita receita : listaReceita)
					receita.setTipoMovimentacao("Receita");
			}
			
		}
		
		return listaReceita;
	}

	public List<Despesa> getListaDespesas(Campanha campanha) throws Exception {
		
		ArrayList<Despesa> listaDespesa = new ArrayList<>();
		
		if((campanha.getCargo().getDescricao().equals(Campanha.STRING_VAZIO)) 
				|| (campanha.getAno().equals(Campanha.INTEGER_VAZIO)) 
				|| (campanha.getNumeroCandidato()).equals(Campanha.INTEGER_VAZIO)
				|| (campanha.getUf()).equals(Campanha.STRING_VAZIO))
			listaDespesa =  null;
		else
			listaDespesa =  this.despesaDAO.getPorAnoNumeroCargoUf(campanha);
		
		return listaDespesa;
	}

	public Receita getReceitaPeloId(int id) throws Exception {
		return this.receitaDAO.getPeloId(id);
	}

	public Despesa getDespesaPeloId(int id) throws Exception {
		return this.despesaDAO.getPeloId(id);
	}
	
	public int geraIndiceDaListaR(List<Receita> lista, int divisor) {
		int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
		return indice;
	}
	
	public int geraIndiceDePaginacaoR(List<Receita> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
	
	public int geraIndiceDaListaD(List<Despesa> lista, int divisor) {
		int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
		return indice;
	}
	
	public int geraIndiceDePaginacaoD(List<Despesa> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}

}
