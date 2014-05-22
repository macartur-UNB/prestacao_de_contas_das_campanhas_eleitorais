package parse.indices;

public abstract class IndicesParse<O> {

	public static final int INDICE_INVALIDO = -1;
	
	public IndicesParse() {
		
	}
	
	public void iniciarInstancia(O objeto, String campo[]) {
		reiniciarInstancia(objeto);
		setIndicesValidos(objeto, campo);
	}
	
	private void reiniciarInstancia(O objeto) {
		setVazioEmTodosOsSetters(objeto);
	}	
	
	protected abstract void setIndicesValidos(O objeto, String campo[]);
	protected abstract void setVazioEmTodosOsSetters(O objeto);
	
	protected boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
	}
	
}
