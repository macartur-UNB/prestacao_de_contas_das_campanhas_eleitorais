package parse.indices;

import modelo.beans.Partido;

public class PartidoIndicesParse extends IndicesParse<Partido>{

	public static final int INDICE_INVALIDO = -1;

	private int indiceSigla;
	private int indiceNumeroPartido;
	
	public PartidoIndicesParse() {
		super();
		this.indiceSigla = INDICE_INVALIDO;
		this.indiceNumeroPartido = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Partido partido, String campo[]) {
		if(indiceValido(this.indiceSigla)) {
			partido.setSigla(campo[this.indiceSigla]);
		}
		if(indiceValido(this.indiceNumeroPartido)) {
			partido.setNumeroPartido(campo[this.indiceNumeroPartido]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Partido partido) {
		partido.setSigla(Partido.STRING_VAZIO);
		partido.setNumeroPartido(Partido.STRING_VAZIO);
	}
	
	public void setIndiceSigla(int indiceSigla) {
		this.indiceSigla = indiceSigla;
	}

	public void setIndiceNumeroPartido(int indiceNumeroPartido) {
		this.indiceNumeroPartido = indiceNumeroPartido;
	}
	
}
