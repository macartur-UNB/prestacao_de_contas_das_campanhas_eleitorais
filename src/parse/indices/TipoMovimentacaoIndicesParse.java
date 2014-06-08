package parse.indices;

import modelo.beans.TipoMovimentacao;

public class TipoMovimentacaoIndicesParse extends IndicesParse<TipoMovimentacao> {
	
	private int indiceId;
	private int indiceCodigo;
	private int indiceDescricao;
	
	public TipoMovimentacaoIndicesParse() {
		super();
		this.indiceId = INDICE_INVALIDO;
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}

	@Override
	protected void setIndicesValidos(TipoMovimentacao tipoMovimentacao, String[] campo) {
		if(indiceValido(this.indiceId)) {
			tipoMovimentacao.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCodigo)) {
			tipoMovimentacao.setCodigo(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if(indiceValido(this.indiceDescricao)) {
			tipoMovimentacao.setDescricao(campo[this.indiceDescricao]);
		}
		
	}

	@Override
	protected void setVazioEmTodosOsSetters(TipoMovimentacao tipoMovimentacao) {
		
		tipoMovimentacao.setId(TipoMovimentacao.INTEGER_VAZIO);
		tipoMovimentacao.setCodigo(TipoMovimentacao.INTEGER_VAZIO);
		tipoMovimentacao.setDescricao(TipoMovimentacao.STRING_VAZIO);
		
	}

	public void setIndiceId(int indiceId) {
		this.indiceId = indiceId;
	}


	public void setIndiceCodigo(int indiceCodigo) {
		this.indiceCodigo = indiceCodigo;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}

}
