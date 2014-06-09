package parse.indices;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.beans.Resultado;

public class CampanhaIndicesParse extends IndicesParse<Campanha> {

	private int indiceResultadoCod;
	private int indiceCargoCod;
	private int indicePartidoNumero;
	private int indiceCandidatoTitulo;
	private int indiceAno;
	private int indiceNumeroCandidato;
	private int indiceNomeDeUrna;
	private int indiceUf;
	private int indiceDespesaMaxDeclarada;
	private int indiceDespesaTotalCalculada;
	private int indiceReceitaTotalCalculada;

	public CampanhaIndicesParse() {
		this.indiceResultadoCod = INDICE_INVALIDO;	
		this.indiceCargoCod = INDICE_INVALIDO;	
		this.indicePartidoNumero = INDICE_INVALIDO;	
		this.indiceCandidatoTitulo = INDICE_INVALIDO;	
		this.indiceAno = INDICE_INVALIDO;	
		this.indiceNumeroCandidato = INDICE_INVALIDO;	
		this.indiceNomeDeUrna = INDICE_INVALIDO;	
		this.indiceUf = INDICE_INVALIDO;	
		this.indiceDespesaMaxDeclarada = INDICE_INVALIDO;	
		this.indiceDespesaTotalCalculada = INDICE_INVALIDO;	
		this.indiceReceitaTotalCalculada = INDICE_INVALIDO;	
	}
	
	@Override
	protected void setIndicesValidos(Campanha campanha, String[] campo) {
		if (indiceValido(this.indiceResultadoCod)) {
			Resultado resultado = new Resultado();
			resultado.setCodigo(Integer.parseInt(campo[this.indiceResultadoCod]));
			campanha.setResultado(resultado);
		}
		if (indiceValido(this.indiceCargoCod)) {
			Cargo cargo = new Cargo();
			cargo.setCodigo(Integer.parseInt(campo[this.indiceCargoCod]));
			campanha.setCargo(cargo);
		}	
		if (indiceValido(this.indicePartidoNumero)) {
			Partido partido = new Partido();
			partido.setNumero(Integer.parseInt(campo[this.indicePartidoNumero]));
			campanha.setPartido(partido);
		}	
		if (indiceValido(this.indiceCandidatoTitulo)) {
			Candidato candidato = new Candidato();
			candidato.setTituloEleitoral(campo[this.indiceCandidatoTitulo]);
			campanha.setCandidato(candidato);
		}	
		if (indiceValido(this.indiceAno)) {
			campanha.setAno(Integer.parseInt(campo[this.indiceAno]));
		}	
		if (indiceValido(this.indiceNumeroCandidato)) {
			campanha.setNumeroCandidato(Integer.parseInt(campo[this.indiceNumeroCandidato]));
		}	
		if (indiceValido(this.indiceNomeDeUrna)) {
			campanha.setNomeDeUrna(campo[this.indiceNomeDeUrna]);
		}	
		if (indiceValido(this.indiceUf)) {
			campanha.setUf(campo[this.indiceUf]);
		}	
		if (indiceValido(this.indiceDespesaMaxDeclarada)) {
			campanha.setDespesaMaxDeclarada(
					Float.parseFloat(campo[this.indiceDespesaMaxDeclarada]));
		}	
		if (indiceValido(this.indiceDespesaTotalCalculada)) {
			campanha.setDespesaTotalCalculada(
					Float.parseFloat(campo[this.indiceDespesaTotalCalculada]));
		}	
		if (indiceValido(this.indiceReceitaTotalCalculada)) {
			campanha.setReceitaTotalCalculada(
					Float.parseFloat(campo[this.indiceReceitaTotalCalculada]));
		}
		
	}

	@Override
	protected void setVazioEmTodosOsSetters(Campanha campanha) {
		campanha.setId(Campanha.INTEGER_VAZIO);
		campanha.setResultado(Campanha.RESULTADO_VAZIO);	
		campanha.setCargo(Campanha.CARGO_VAZIO);	
		campanha.setPartido(Campanha.PARTIDO_VAZIO);	
		campanha.setCandidato(Campanha.CANDIDATO_VAZIO);	
		campanha.setAno(Campanha.INTEGER_VAZIO);	
		campanha.setNumeroCandidato(Campanha.INTEGER_VAZIO);	
		campanha.setNomeDeUrna(Campanha.STRING_VAZIO);	
		campanha.setUf(Campanha.STRING_VAZIO);	
		campanha.setDespesaMaxDeclarada(Campanha.FLOAT_VAZIO);	
		campanha.setDespesaTotalCalculada(Campanha.FLOAT_VAZIO);	
		campanha.setReceitaTotalCalculada(Campanha.FLOAT_VAZIO);	
	}

	public void setIndiceResultadoCod(int indiceResultadoId) {
		this.indiceResultadoCod = indiceResultadoId;
	}

	public void setIndiceCargoCod(int indiceCargoId) {
		this.indiceCargoCod = indiceCargoId;
	}

	public void setIndicePartidoNumero(int indicePartidoNumero) {
		this.indicePartidoNumero = indicePartidoNumero;
	}

	public void setIndiceCandidatoTitulo(int indiceCandidatoTitulo) {
		this.indiceCandidatoTitulo = indiceCandidatoTitulo;
	}

	public void setIndiceAno(int indiceAno) {
		this.indiceAno = indiceAno;
	}

	public void setIndiceNumeroCandidato(int indiceNumeroCandidato) {
		this.indiceNumeroCandidato = indiceNumeroCandidato;
	}

	public void setIndiceNomeDeUrna(int indiceNomeDeUrna) {
		this.indiceNomeDeUrna = indiceNomeDeUrna;
	}

	public void setIndiceUf(int indiceUf) {
		this.indiceUf = indiceUf;
	}

	public void setIndiceDespesaMaxDeclarada(int indiceDespesaMaxDeclarada) {
		this.indiceDespesaMaxDeclarada = indiceDespesaMaxDeclarada;
	}

	public void setIndiceDespesaTotalCalculada(int indiceDespesaTotalCalculada) {
		this.indiceDespesaTotalCalculada = indiceDespesaTotalCalculada;
	}

	public void setIndiceReceitaTotalCalculada(int indiceReceitaTotalCalculada) {
		this.indiceReceitaTotalCalculada = indiceReceitaTotalCalculada;
	}
	
	

}
