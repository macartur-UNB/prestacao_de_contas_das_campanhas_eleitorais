package parse.controle;

import modelo.beans.FormaPagamento;
import modelo.dao.FormaPagamentoDAO;
import parse.indices.IndicesParse;

public class FormaPagamentoParseControle extends ParseControle<FormaPagamento> {

	public FormaPagamentoParseControle(IndicesParse<FormaPagamento> indicesParse) {
		super(indicesParse, new FormaPagamentoDAO());
	}

	@Override
	public FormaPagamento novaInstancia() {
		FormaPagamento formaPagamento = new FormaPagamento();
		return formaPagamento;
	}

	@Override
	public boolean iguais(FormaPagamento objetoUm, FormaPagamento objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
