package parse.indices;

import modelo.beans.Despesa;
import modelo.beans.Fornecedor;

public class DespesaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Despesa> {

	private int indiceFornecedorNome;
	private int indiceFornecedorCpfCnpj;
	private int indiceTipoDocumento;
	
	public DespesaIndicesParse(String ano) {
		super(ano);
		this.indiceFornecedorNome = INDICE_INVALIDO;
		this.indiceFornecedorCpfCnpj = INDICE_INVALIDO;
		this.indiceTipoDocumento = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Despesa despesa, String[] campo) {
		super.setIndicesValidos(despesa, campo);
		Fornecedor fornecedor = new Fornecedor();

		if(indiceValido(this.indiceFornecedorNome)) {
			fornecedor.setNome(campo[this.indiceFornecedorNome]);
		}
		if(indiceValido(this.indiceFornecedorCpfCnpj)) {
			fornecedor.setCpf_cnpj(campo[this.indiceFornecedorCpfCnpj]);
		}
		if(indiceValido(this.indiceTipoDocumento)) {
			despesa.setTipoDocumento(campo[this.indiceTipoDocumento]);
		}
		despesa.setFornecedor(fornecedor);

	}
	
	@Override
	protected void setVazioEmTodosOsSetters(Despesa despesa) {
		super.setVazioEmTodosOsSetters(despesa);

		despesa.setFornecedor((Fornecedor)Despesa.OBJETO_VAZIO);
		despesa.setTipoDocumento(Despesa.STRING_VAZIO);
	}
	
	public void setIndiceFornecedorNome(int indiceFornecedorNome) {
		this.indiceFornecedorNome = indiceFornecedorNome;
	}
	
	public void setIndiceFornecedorCpfCnpj(int indiceFornecedorCpfCnpj) {
		this.indiceFornecedorCpfCnpj = indiceFornecedorCpfCnpj;
	}

	public void setIndiceTipoDocumento(int indiceTipoDocumento) {
		this.indiceTipoDocumento = indiceTipoDocumento;
	}
	
}
