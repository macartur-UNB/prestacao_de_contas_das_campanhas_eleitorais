package parse.indices;

import modelo.beans.Cargo;

public class CargoIndicesParse extends IndicesParse<Cargo>{
	
	private int indiceId;
	private int indiceCodigo;
	private int indiceDescricao;

	public CargoIndicesParse() {
		super();
		this.indiceId = INDICE_INVALIDO;
		this.indiceCodigo = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Cargo cargo, String campo[]) {
		if(indiceValido(this.indiceId)) {
			cargo.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCodigo)) {
			cargo.setCodigo(Integer.parseInt(campo[this.indiceCodigo]));
		}
		if(indiceValido(this.indiceDescricao)){
			cargo.setDescricao(campo[this.indiceDescricao]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Cargo cargo) {
		cargo.setId(Cargo.INTEGER_VAZIO);
		cargo.setCodigo(Cargo.INTEGER_VAZIO);
		cargo.setDescricao(Cargo.STRING_VAZIO);
	}
	
	public void setIndiceId(int indiceId) {
		this.indiceId = indiceId;
	}

	public int getIndiceId() {
		return indiceId;
	}

	public void setIndiceCodigo(int indiceCodigo) {
		this.indiceCodigo = indiceCodigo;
	}

	public int getIndiceCodigo() {
		return indiceCodigo;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}
	
	public int getIndicesDescricao (){
		return indiceDescricao;
	}
}
