package parse.indices;

import modelo.beans.Candidato;

public class CandidatoIndicesParse extends IndicesParse<Candidato> {

	private int indiceNome;
	private int indiceTituloEleitoral;

	public CandidatoIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceTituloEleitoral = INDICE_INVALIDO;
	}

	@Override
	protected void setIndicesValidos(Candidato candidato, String[] campo) {
		if (indiceValido(this.indiceNome)) {
			candidato.setNome(campo[this.indiceNome]);
		}
		if (indiceValido(this.indiceTituloEleitoral)) {
			candidato.setTituloEleitoral(campo[this.indiceTituloEleitoral]);

		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Candidato candidato) {
		candidato.setNome(Candidato.STRING_VAZIO);
		candidato.setTituloEleitoral(Candidato.STRING_VAZIO);
	}

	
	public void setIndiceTituloEleitoral(int indiceTituloEleitoral) {
		this.indiceTituloEleitoral = indiceTituloEleitoral;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}


}