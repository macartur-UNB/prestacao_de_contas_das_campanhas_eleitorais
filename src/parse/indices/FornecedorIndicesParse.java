package parse.indices;

import modelo.beans.Fornecedor;

public class FornecedorIndicesParse extends IndicesParse<Fornecedor> {

	public static final int INDICE_INVALIDO = -1;

	private int indiceCpf_Cnpj;
	private int indiceNome;
	private int indiceUf;
	private int indiceSituacaoCadastral;
	
	public FornecedorIndicesParse() {
		this.indiceCpf_Cnpj = INDICE_INVALIDO;
		this.indiceNome = INDICE_INVALIDO;
		this.indiceUf = INDICE_INVALIDO;
		this.indiceSituacaoCadastral = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Fornecedor fornecedor, String[] campo) {
		if(indiceValido(this.indiceCpf_Cnpj)) {
			fornecedor.setCpf_cnpj(campo[this.indiceCpf_Cnpj]);
		}
		if(indiceValido(this.indiceNome)) {
			fornecedor.setNome(campo[this.indiceNome]);
		}
		if(indiceValido(this.indiceUf)) {
			fornecedor.setUf(campo[this.indiceUf]);
		}
		if(indiceValido(this.indiceSituacaoCadastral)) {
			fornecedor.setSituacaoCadastral(campo[this.indiceSituacaoCadastral]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Fornecedor fornecedor) {
		fornecedor.setCpf_cnpj(Fornecedor.STRING_VAZIO);
		fornecedor.setNome(Fornecedor.STRING_VAZIO);
		fornecedor.setUf(Fornecedor.STRING_VAZIO);
		fornecedor.setSituacaoCadastral(Fornecedor.STRING_VAZIO);
	}

	public void setIndiceCpf_Cnpj(int indiceCpf_Cnpj) {
		this.indiceCpf_Cnpj = indiceCpf_Cnpj;
	}


	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public void setIndiceUf(int indiceUf) {
		this.indiceUf = indiceUf;
	}

	public void setIndiceSituacaoCadastral(int indiceSituacaoCadastral) {
		this.indiceSituacaoCadastral = indiceSituacaoCadastral;
	}
	
}
