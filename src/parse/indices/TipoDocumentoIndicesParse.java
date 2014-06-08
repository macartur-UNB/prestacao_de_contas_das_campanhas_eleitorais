package parse.indices;

import modelo.beans.TipoDocumento;

public class TipoDocumentoIndicesParse extends IndicesParse<TipoDocumento> {
	
	private int indiceId;
	private int indiceCodigo;
	private int indiceDescricao;
	
	public TipoDocumentoIndicesParse() {
		super();
		this.indiceId = INDICE_INVALIDO;
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}

	@Override
	protected void setIndicesValidos(TipoDocumento tipoDocumento, String[] campo) {
		if(indiceValido(this.indiceId)) {
			tipoDocumento.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCodigo)) {
			tipoDocumento.setCodigo(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if(indiceValido(this.indiceDescricao)) {
			tipoDocumento.setDescricao(campo[this.indiceDescricao]);
		}
		
	}

	@Override
	protected void setVazioEmTodosOsSetters(TipoDocumento tipoDocumento) {
		
		tipoDocumento.setId(TipoDocumento.INTEGER_VAZIO);
		tipoDocumento.setCodigo(TipoDocumento.INTEGER_VAZIO);
		tipoDocumento.setDescricao(TipoDocumento.STRING_VAZIO);
		
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
