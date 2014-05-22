package parse.indices;

import modelo.beans.Despesa;
import modelo.beans.Fornecedor;
import modelo.beans.MovimentacaoFinanceira;

public class DespesaIndicesParse extends MovimentacaoFinanceiraIndicesParse {

	private int indiceFornecedor;
	private int indiceTipoDocumento;
	
	public DespesaIndicesParse(String ano) {
		super(ano);
		this.indiceFornecedor = INDICE_INVALIDO;
		this.indiceTipoDocumento = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(
			MovimentacaoFinanceira movimentacaoFinanceira, String[] campo) {
		super.setIndicesValidos(movimentacaoFinanceira, campo);
		
		Despesa despesa = (Despesa) movimentacaoFinanceira;
		if(indiceValido(this.indiceFornecedor)) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(campo[this.indiceFornecedor]);
			despesa.setFornecedor(fornecedor);
		}
		if(indiceValido(this.indiceTipoDocumento)) {
			despesa.setTipoDocumento(campo[this.indiceTipoDocumento]);
		}
	}
	
	@Override
	protected void setVazioEmTodosOsSetters(
			MovimentacaoFinanceira movimentacaoFinanceira) {
		super.setVazioEmTodosOsSetters(movimentacaoFinanceira);

		Despesa despesa = (Despesa) movimentacaoFinanceira;
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
