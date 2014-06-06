package parse.indices;

import modelo.beans.Resultado;

public class ResultadoIndicesParse extends IndicesParse<Resultado>{

	private int indiceCodigo;
	private int indiceDescricao;
	
	public ResultadoIndicesParse() {
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
		
	}
	@Override
	protected void setIndicesValidos(Resultado resultado, String[] campo) {
		if (indiceValido(this.indiceCodigo)) {
			resultado.setCodigo(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if (indiceValido(this.indiceDescricao)) {
			resultado.setDescricao(campo[this.indiceDescricao]);
		}	
	}

	@Override
	protected void setVazioEmTodosOsSetters(Resultado resultado) {
		resultado.setCodigo(Resultado.INTEGER_VAZIO);
		resultado.setDescricao(Resultado.STRING_VAZIO);
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
