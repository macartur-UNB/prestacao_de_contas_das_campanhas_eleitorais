package parse.indices;

import modelo.beans.Partido;

public class PartidoIndicesParse {

	public static final int INDICE_INVALIDO = -1;

	private int indiceSigla;
	private int indiceNumeroPartido;
	
	public PartidoIndicesParse() {
		this.indiceSigla = INDICE_INVALIDO;
		this.indiceNumeroPartido = INDICE_INVALIDO;
	}
	
	public void iniciarPartido(Partido partido, String campo[]) {
		reiniciarPartido(partido);
				
		if(indiceValido(this.indiceSigla)) {
			partido.setSigla(campo[this.indiceSigla]);
		}
		if(indiceValido(this.indiceNumeroPartido)) {
			partido.setNumeroPartido(campo[this.indiceNumeroPartido]);
		}
	}
	
	public Partido iniciarPartido(String campo[]) {
		Partido partido = new Partido();
		iniciarPartido(partido, campo);
		return partido;
	}
	
	private void reiniciarPartido(Partido partido) {
		partido.setSigla(Partido.CAMPO_VAZIO);
		partido.setNumeroPartido(Partido.CAMPO_VAZIO);
	}
	
	private boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
	}

	public void setIndiceSigla(int indiceSigla) {
		this.indiceSigla = indiceSigla;
	}

	public void setIndiceNumeroPartido(int indiceNumeroPartido) {
		this.indiceNumeroPartido = indiceNumeroPartido;
	}
	
}
