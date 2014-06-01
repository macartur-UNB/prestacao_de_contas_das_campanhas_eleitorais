package parse.indices;

import modelo.beans.Partido;

public class PartidoIndicesParse extends IndicesParse<Partido>{

	private int indiceSigla;
	private int indiceNumero;
	private int indiceDeferimento;
	private int indiceNome;
	
	public PartidoIndicesParse() {
		super();
		this.indiceSigla = INDICE_INVALIDO;
		this.indiceNumero = INDICE_INVALIDO;
		this.indiceDeferimento = INDICE_INVALIDO;
		this.indiceNome = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Partido partido, String campo[]) {
		if(indiceValido(this.indiceSigla)) {
			partido.setSigla(campo[this.indiceSigla]);
		}
		if(indiceValido(this.indiceNumero)) {
			partido.setNumero(campo[this.indiceNumero]);
		}
		if(indiceValido(this.indiceDeferimento)){
			partido.setDeferimento(campo[this.indiceDeferimento]);
		}
		if(indiceValido(this.indiceNome)){
			partido.setNome(campo[this.indiceNome]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Partido partido) {
		partido.setSigla(Partido.STRING_VAZIO);
		partido.setNumero(Partido.STRING_VAZIO);
		partido.setNome(Partido.STRING_VAZIO);
		partido.setDeferimento(Partido.STRING_VAZIO);
	}
	
	public void setIndiceSigla(int indiceSigla) {
		this.indiceSigla = indiceSigla;
	}

	public int getIndiceNumero() {
		return indiceNumero;
	}

	public void setIndiceNumero(int indiceNumero) {
		this.indiceNumero = indiceNumero;
	}

	public int getIndiceDeferimento() {
		return indiceDeferimento;
	}

	public void setIndiceDeferimento(int indiceDeferimento) {
		this.indiceDeferimento = indiceDeferimento;
	}

	public int getIndiceNome() {
		return indiceNome;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public int getIndiceSigla() {
		return indiceSigla;
	}
	
}
