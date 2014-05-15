package parse.indices;

import java.text.ParseException;

import modelo.beans.Despesa;
import modelo.beans.Fornecedor;

public class DespesaIndicesParse extends MovimentacaoFinanceiraIndicesParse {

	private int indiceFornecedor;
	private int indiceTipoDocumento;
	
	public DespesaIndicesParse() {
		super();
		this.indiceFornecedor = INDICE_INVALIDO;
		this.indiceTipoDocumento = INDICE_INVALIDO;
	}
	
	public void iniciarDespesa(Despesa despesa, String campo[]) throws ParseException {
		reiniciarDespesa(despesa);
		iniciarMovimentacaoFinanceira(despesa, campo);
		
		if(indiceValido(this.indiceFornecedor)) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(campo[this.indiceFornecedor]);
			despesa.setFornecedor(fornecedor);
		}
		if(indiceValido(this.indiceTipoDocumento)) {
			despesa.setTipoDocumento(campo[this.indiceTipoDocumento]);
		}
	}
	
	private void reiniciarDespesa(Despesa despesa) {
		despesa.setFornecedor(Despesa.FORNECEDOR_VAZIO);
		despesa.setTipoDocumento(Despesa.STRING_VAZIO);
	}

	public void setIndiceFornecedor(int indiceFornecedor) {
		this.indiceFornecedor = indiceFornecedor;
	}

	public void setIndiceTipoDocumento(int indiceTipoDocumento) {
		this.indiceTipoDocumento = indiceTipoDocumento;
	}
	
}
