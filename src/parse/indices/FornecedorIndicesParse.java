package parse.indices;

import modelo.beans.Fornecedor;

public class FornecedorIndicesParse extends IndicesParse<Fornecedor> {

	public static final int INDICE_INVALIDO = -1;

	private int indiceNome;
	private int indiceCadastroNacional;
	
	public FornecedorIndicesParse() {
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCadastroNacional = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(Fornecedor fornecedor, String[] campo) {
		if(indiceValido(this.indiceNome)) {
			fornecedor.setNome(campo[this.indiceNome]);
		}
		
		if(indiceValido(this.indiceCadastroNacional) && !campo[this.indiceCadastroNacional].isEmpty()) {
			fornecedor.setCadastroNacional(campo[this.indiceCadastroNacional]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(Fornecedor fornecedor) {
		fornecedor.setNome(Fornecedor.STRING_VAZIO);
		fornecedor.setCadastroNacional(Fornecedor.STRING_VAZIO);
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
