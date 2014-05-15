package parse.indices;

import modelo.beans.Fornecedor;

public class FornecedorIndicesParse {

	public static final int INDICE_INVALIDO = -1;

	private int indiceNome;
	private int indiceCadastroNacional;
	
	public FornecedorIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCadastroNacional = INDICE_INVALIDO;
	}
	
	public void iniciarFornecedor(Fornecedor fornecedor, String campo[]) {
		reiniciarFornecedor(fornecedor);
		
		if(indiceValido(this.indiceNome)) {
			fornecedor.setNome(campo[this.indiceNome]);
		}
		
		if(indiceValido(this.indiceCadastroNacional) && !campo[this.indiceCadastroNacional].isEmpty()) {
			fornecedor.setCadastroNacional(campo[this.indiceCadastroNacional]);
		}
	}
	
	public Fornecedor iniciarFornecedor(String campo[]) {
		Fornecedor fornecedor = new Fornecedor();
		iniciarFornecedor(fornecedor, campo);
		return fornecedor;
	}
	
	private void reiniciarFornecedor(Fornecedor fornecedor) {
		fornecedor.setNome(Fornecedor.STRING_VAZIO);
		fornecedor.setCadastroNacional(Fornecedor.STRING_VAZIO);
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
