package parse.indices;

import modelo.beans.Fornecedor;

public class FornecedorIndicesParse extends IndicesParse<Fornecedor> {

	public static final int INDICE_INVALIDO = -1;
	public static final int INTEGER_VAZIO = 0;

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
			fornecedor.setCpf_cnpj(Integer.parseInt(campo[this.indiceCpf_Cnpj]));
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
		fornecedor.setCpf_cnpj(INTEGER_VAZIO);
		fornecedor.setNome(Fornecedor.STRING_VAZIO);
		fornecedor.setUf(Fornecedor.STRING_VAZIO);
		fornecedor.setSituacaoCadastral(Fornecedor.STRING_VAZIO);
	}

	public int getIndiceCpf_Cnpj() {
		return indiceCpf_Cnpj;
	}

	public void setIndiceCpf_Cnpj(int indiceCpf_Cnpj) {
		this.indiceCpf_Cnpj = indiceCpf_Cnpj;
	}

	public int getIndiceNome() {
		return indiceNome;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public int getIndiceUf() {
		return indiceUf;
	}

	public void setIndiceUf(int indiceUf) {
		this.indiceUf = indiceUf;
	}

	public int getIndiceSituacaoCadastral() {
		return indiceSituacaoCadastral;
	}

	public void setIndiceSituacaoCadastral(int indiceSituacaoCadastral) {
		this.indiceSituacaoCadastral = indiceSituacaoCadastral;
	}
	
}
