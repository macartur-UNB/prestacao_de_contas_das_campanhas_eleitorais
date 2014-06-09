package parse.indices;

import modelo.beans.Despesa;
import modelo.beans.Fornecedor;

public class DespesaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Despesa> {

	private int indiceFornecedor;
	private int indiceTipoDocumento;
	
	public DespesaIndicesParse(String ano) {
		super(ano);
		this.indiceFornecedor = INDICE_INVALIDO;
		this.indiceTipoDocumento = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Despesa despesa, String[] campo) {
		super.setIndicesValidos(despesa, campo);
		
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
	protected void setVazioEmTodosOsSetters(Despesa despesa) {
		super.setVazioEmTodosOsSetters(despesa);

		despesa.setFornecedor((Fornecedor)Despesa.OBJETO_VAZIO);
		despesa.setTipoDocumento(Despesa.STRING_VAZIO);
	}
	
	public void setIndiceFornecedor(int indiceFornecedor) {
		this.indiceFornecedor = indiceFornecedor;
	}

	public void setIndiceTipoDocumento(int indiceTipoDocumento) {
		this.indiceTipoDocumento = indiceTipoDocumento;
	}
	
}
