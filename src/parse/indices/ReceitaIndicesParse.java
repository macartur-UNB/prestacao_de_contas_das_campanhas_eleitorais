package parse.indices;

import modelo.beans.Receita;

public class ReceitaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Receita>{

	private int indiceReciboEleitoral;
	private int indiceDoador;
	
	public ReceitaIndicesParse(String ano) {
		super(ano);
		this.indiceReciboEleitoral = INDICE_INVALIDO;
		this.indiceDoador = INDICE_INVALIDO;
	}
	
	protected void setIndicesValidos(Receita receita, String[] campo) {
		super.setIndicesValidos(receita, campo);
	}

}
