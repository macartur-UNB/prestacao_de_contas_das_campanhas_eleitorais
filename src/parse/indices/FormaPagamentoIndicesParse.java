package parse.indices;

import modelo.beans.FormaPagamento;

public class FormaPagamentoIndicesParse extends IndicesParse<FormaPagamento> {
	
	private int indiceId;
	private int indiceCodigo;
	private int indiceDescricao;
	
	public FormaPagamentoIndicesParse() {
		super();
		this.indiceId = INDICE_INVALIDO;
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}

	@Override
	protected void setIndicesValidos(FormaPagamento formaPagamento, String[] campo) {
		if(indiceValido(this.indiceId)) {
			formaPagamento.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCodigo)) {
			formaPagamento.setCodigo(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if(indiceValido(this.indiceDescricao)) {
			formaPagamento.setDescricao(campo[this.indiceDescricao]);
		}
		
	}

	@Override
	protected void setVazioEmTodosOsSetters(FormaPagamento formaPagamento) {
		
		formaPagamento.setId(FormaPagamento.INTEGER_VAZIO);
		formaPagamento.setCodigo(FormaPagamento.INTEGER_VAZIO);
		formaPagamento.setDescricao(FormaPagamento.STRING_VAZIO);
		
	}

	public int getIndiceId() {
		return indiceId;
	}

	public void setIndiceId(int indiceId) {
		this.indiceId = indiceId;
	}

	public int getIndiceCodigo() {
		return indiceCodigo;
	}

	public void setIndiceCodigo(int indiceCodigo) {
		this.indiceCodigo = indiceCodigo;
	}

	public int getIndiceDescricao() {
		return indiceDescricao;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}

}
