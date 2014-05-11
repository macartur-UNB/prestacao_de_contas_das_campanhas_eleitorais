package parse.indices;

import modelo.beans.Doador;

public class DoadorIndicesParse {

	public static final int INDICE_INVALIDO = -1;

	private int indiceNome;
	private int indiceCadastroNacional;
	
	public DoadorIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCadastroNacional = INDICE_INVALIDO;
	}
	
	public void iniciarDoador(Doador doador, String campo[]) {
		reiniciarDoador(doador);
		
		if(indiceValido(this.indiceNome)) {
			doador.setNome(campo[this.indiceNome]);
		}
		
		if(indiceValido(this.indiceCadastroNacional)) {
			doador.setCadastroNacional(campo[this.indiceCadastroNacional]);
		}
	}
	
	public Doador iniciarDoador(String campo[]) {
		Doador doador = new Doador();
		iniciarDoador(doador, campo);
		return doador;
	}
	
	private void reiniciarDoador(Doador doador) {
		doador.setNome(Doador.STRING_VAZIO);
		doador.setCadastroNacional(Doador.STRING_VAZIO);
	}
	
	private boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
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
