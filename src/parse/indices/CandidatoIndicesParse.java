package parse.indices;

import model.Candidato;
import model.Partido;

public class CandidatoIndicesParse {

	public static final int INDICE_INVALIDO = -1;
	
	private int ano;
	private int indiceNome;
	private int indiceCpf;
	private int indiceCargo;
	private int indicePartidoSigla;
	private int indiceNumero;
	private int indiceUf;
	private int indiceFoiEleito;
	private int indiceResultadoUltimaEleicao;
	
	public CandidatoIndicesParse(int ano) {
		this.ano = ano;
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCpf = INDICE_INVALIDO;
		this.indiceCargo = INDICE_INVALIDO;
		this.indicePartidoSigla = INDICE_INVALIDO;
		this.indiceNumero = INDICE_INVALIDO;
		this.indiceUf = INDICE_INVALIDO;
		this.indiceFoiEleito = INDICE_INVALIDO;
		this.indiceResultadoUltimaEleicao = INDICE_INVALIDO;
	}
	
	public void iniciarCandidato(Candidato candidato, String campo[]) {
		reiniciarCandidato(candidato);
		
		candidato.setAno(ano);
		if(indiceValido(this.indiceNome)) {
			candidato.setNome(campo[this.indiceNome]);
		}
		if(indiceValido(this.indiceCpf)) {
			candidato.setCpf(campo[this.indiceCpf]);
		}
		if(indiceValido(this.indiceCargo)) {
			candidato.setCargo(campo[this.indiceCargo]);
		}
		if(indiceValido(this.indicePartidoSigla)) {
			Partido partido = new Partido();
			partido.setSigla(campo[this.indicePartidoSigla]);
			candidato.setPartido(partido);
		}
		if(indiceValido(this.indiceNumero)) {
			candidato.setNumero(campo[this.indiceNumero]);
		}
		if(indiceValido(this.indiceUf)) {
			candidato.setUf(campo[this.indiceUf]);
		}
		if(indiceValido(this.indiceFoiEleito)) {
			boolean foiEleito = campo[this.indiceFoiEleito].equals("1") || campo[this.indiceFoiEleito].equals("true");
			candidato.setFoiEleito(foiEleito);
		}
		if(indiceValido(this.indiceResultadoUltimaEleicao)) {
			Integer resultadoUltimaEleicao = Integer.valueOf(campo[this.indiceResultadoUltimaEleicao]);
			candidato.setResultadoUltimaEleicao(resultadoUltimaEleicao);
		}
		candidato.setPessoaJuridica(false);
	}
	
	public Candidato iniciarCandidato(String campo[]) {
		Candidato candidato = new Candidato();
		iniciarCandidato(candidato, campo);
		return candidato;
	}
	
	private void reiniciarCandidato(Candidato candidato) {
		candidato.setNome(Candidato.STRING_VAZIO);
		candidato.setAno(Candidato.INTEGER_VAZIO);
		candidato.setCpf(Candidato.STRING_VAZIO);
		candidato.setCargo(Candidato.STRING_VAZIO);
		candidato.setPartido(Candidato.PARTIDO_VAZIO);
		candidato.setNumero(Candidato.STRING_VAZIO);
		candidato.setUf(Candidato.STRING_VAZIO);
		candidato.setFoiEleito(Candidato.BOOLEAN_VAZIO);
		candidato.setPessoaJuridica(Candidato.BOOLEAN_VAZIO);
		candidato.setResultadoUltimaEleicao(Candidato.INTEGER_VAZIO);
	}

	private boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setIndiceCpf(int indiceCpf) {
		this.indiceCpf = indiceCpf;
	}

	public void setIndiceCargo(int indiceCargo) {
		this.indiceCargo = indiceCargo;
	}

	public void setIndicePartidoSigla(int indicePartidoSigla) {
		this.indicePartidoSigla = indicePartidoSigla;
	}

	public void setIndiceNumero(int indiceNumero) {
		this.indiceNumero = indiceNumero;
	}

	public void setIndiceUf(int indiceUf) {
		this.indiceUf = indiceUf;
	}

	public void setIndiceFoiEleito(int indiceFoiEleito) {
		this.indiceFoiEleito = indiceFoiEleito;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public static int getIndiceInvalido() {
		return INDICE_INVALIDO;
	}

	public int getAno() {
		return ano;
	}

	public int getIndiceNome() {
		return indiceNome;
	}

	public int getIndiceCpf() {
		return indiceCpf;
	}

	public int getIndiceCargo() {
		return indiceCargo;
	}

	public int getIndicePartidoSigla() {
		return indicePartidoSigla;
	}

	public int getIndiceNumero() {
		return indiceNumero;
	}

	public int getIndiceUf() {
		return indiceUf;
	}

	public int getIndiceFoiEleito() {
		return indiceFoiEleito;
	}
	
	public int getIndiceResultadoUltimaEleicao() {
		return indiceResultadoUltimaEleicao;
	}

	public void setIndiceResultadoUltimaEleicao(int indiceResultadoUltimaEleicao) {
		this.indiceResultadoUltimaEleicao = indiceResultadoUltimaEleicao;
	}
	
}
