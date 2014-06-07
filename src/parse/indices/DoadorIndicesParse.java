package parse.indices;

import modelo.beans.Doador;

public class DoadorIndicesParse extends IndicesParse<Doador> {

	public static final int INDICE_INVALIDO = -1;
	public static final int INTEGER_VAZIO = 0;

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
			doador.setCpf_cnpj(Integer.parseInt(campo[this.indiceCpf_Cnpj]));
		}
		if(indiceValido(this.indiceNome)) {
			doador.setNome(campo[this.indiceNome]);
		}
		if(indiceValido(this.indiceUf)) {
			doador.setUf(campo[this.indiceUf]);
		}
		if(indiceValido(this.indiceSituacaoCadastral)) {
			doador.setSituacao_cadastral(campo[this.indiceSituacaoCadastral]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Doador doador) {
		doador.setCpf_cnpj(INTEGER_VAZIO);
		doador.setNome(Doador.STRING_VAZIO);
		doador.setUf(Doador.STRING_VAZIO);
		doador.setSituacao_cadastral(Doador.STRING_VAZIO);
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
