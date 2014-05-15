package parse;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.beans.Despesa;
import modelo.dao.DespesaDAO;
import parse.indices.DespesaIndicesParse;

public class DespesaParse {

	private DespesaDAO despesaDAO;
	private ArrayList<Despesa> listaDespesas;
	private DespesaIndicesParse despesaIndicesParse;
	
	public DespesaParse(DespesaIndicesParse despesaIndicesParse) {
		this.despesaDAO = new DespesaDAO();
		this.listaDespesas = new ArrayList<>();
		
		this.despesaIndicesParse = despesaIndicesParse;
	}
	
	public void addDespesa(String campo[]) throws ParseException {
		Despesa despesa = this.despesaIndicesParse.iniciarDespesa(campo);
		
		this.listaDespesas.add(despesa);
	}
	
	public void cadastrarDespesas() throws SQLException {
		this.despesaDAO.cadastrarLista(this.listaDespesas);
	}
	
	public void resetar() {
		this.listaDespesas.clear();
	}
}
