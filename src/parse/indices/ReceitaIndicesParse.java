package parse.indices;

import modelo.beans.Doador;
import modelo.beans.Receita;

public class ReceitaIndicesParse extends MovimentacaoFinanceiraIndicesParse<Receita>{

	private int indiceReciboEleitoral;
	private int indiceDoadorNome;
	private int indiceDoadorCpfCnpj;
	
	public ReceitaIndicesParse(String ano) {
		super(ano);
		this.indiceReciboEleitoral = INDICE_INVALIDO;
		this.indiceDoadorNome = INDICE_INVALIDO;
		this.indiceDoadorCpfCnpj = INDICE_INVALIDO;

	}
	
	@Override
	protected void setIndicesValidos(Receita receita, String[] campo) {
		super.setIndicesValidos(receita, campo);
		
		Doador doador = new Doador();
		if(indiceValido(this.indiceReciboEleitoral)) {
			receita.setReciboEleitoral(campo[this.indiceReciboEleitoral]);
		}
		if(indiceValido(this.indiceDoadorNome)) {
			doador.setNome(campo[this.indiceDoadorNome]);
		}
		if(indiceValido(this.indiceDoadorCpfCnpj)) {
			doador.setCpf_cnpj(campo[this.indiceDoadorCpfCnpj]);
		}
		receita.setDoador(doador);

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

	public void setIndiceDoadorNome(int indiceDoadorNome) {
		this.indiceDoadorNome = indiceDoadorNome;
	}
	
	public void setIndiceDoadorCpfCnpj(int indiceDoadorCpfCnpj) {
		this.indiceDoadorCpfCnpj = indiceDoadorCpfCnpj;
	}
}
