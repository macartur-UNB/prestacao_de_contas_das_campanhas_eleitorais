package parse.indices;

import modelo.beans.Doador;
import modelo.beans.Receita;

public class ReceitaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Receita>{

	private int indiceReciboEleitoral;
	private int indiceDoador;
	
	public ReceitaIndicesParse(String ano) {
		super(ano);
		this.indiceReciboEleitoral = INDICE_INVALIDO;
		this.indiceDoador = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Receita receita, String[] campo) {
		super.setIndicesValidos(receita, campo);
		
		if(indiceValido(this.indiceReciboEleitoral)) {
			receita.setReciboEleitoral(campo[this.indiceReciboEleitoral]);
		}
		if(indiceValido(this.indiceDoador)) {
			Doador doador = new Doador();
			doador.setCpf_cnpj(campo[this.indiceDoador]);
			receita.setDoador(doador);
		}
	}
	
	@Override
	protected void setVazioEmTodosOsSetters(Receita receita) {
		super.setVazioEmTodosOsSetters(receita);

		receita.setReciboEleitoral(Receita.STRING_VAZIO);
		receita.setDoador((Doador)Receita.OBJETO_VAZIO);
		
	}

	public void setIndiceReciboEleitoral(int indiceReciboEleitoral) {
		this.indiceReciboEleitoral = indiceReciboEleitoral;
	}

	public void setIndiceDoador(int indiceDoador) {
		this.indiceDoador = indiceDoador;
	}
	
}
