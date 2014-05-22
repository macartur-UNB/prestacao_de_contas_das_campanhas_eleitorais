package parse.indices;

import modelo.beans.Doador;

public class DoadorIndicesParse extends IndicesParse<Doador> {

	public static final int INDICE_INVALIDO = -1;

	private int indiceNome;
	private int indiceCadastroNacional;
	
	public DoadorIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCadastroNacional = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Doador doador, String[] campo) {
		if(indiceValido(this.indiceNome)) {
			doador.setNome(campo[this.indiceNome]);
		}
		
		if(indiceValido(this.indiceCadastroNacional)) {
			doador.setCadastroNacional(campo[this.indiceCadastroNacional]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Doador doador) {
		doador.setNome(Doador.STRING_VAZIO);
		doador.setCadastroNacional(Doador.STRING_VAZIO);
	}

	public int getIndiceNome() {
		return indiceNome;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public int getIndiceCadastroNacional() {
		return indiceCadastroNacional;
	}

	public void setIndiceCadastroNacional(int indiceCadastroNacional) {
		this.indiceCadastroNacional = indiceCadastroNacional;
	}
	
}
