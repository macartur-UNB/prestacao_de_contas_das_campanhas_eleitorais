package parse.indices;

import modelo.beans.Doador;

public class DoadorIndicesParse extends IndicesParse<Doador> {

	public static final int INDICE_INVALIDO = -1;

	private int indiceCpf_Cnpj;
	private int indiceNome;
	private int indiceUf;
	private int indiceSituacaoCadastral;
	
	public DoadorIndicesParse() {
		super();
		this.indiceCpf_Cnpj = INDICE_INVALIDO;
		this.indiceNome = INDICE_INVALIDO;
		this.indiceUf = INDICE_INVALIDO;
		this.indiceSituacaoCadastral = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Doador doador, String[] campo) {
		if(indiceValido(this.indiceCpf_Cnpj)) {
			doador.setCpf_cnpj(campo[this.indiceCpf_Cnpj]);
		}
		if(indiceValido(this.indiceNome)) {
			doador.setNome(campo[this.indiceNome]);
		}
		if(indiceValido(this.indiceUf)) {
			doador.setUf(campo[this.indiceUf]);
		}
		if(indiceValido(this.indiceSituacaoCadastral)) {
			doador.setSituacaoCadastral(campo[this.indiceSituacaoCadastral]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Doador doador) {
		doador.setCpf_cnpj(Doador.STRING_VAZIO);
		doador.setNome(Doador.STRING_VAZIO);
		doador.setUf(Doador.STRING_VAZIO);
		doador.setSituacaoCadastral(Doador.STRING_VAZIO);
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
