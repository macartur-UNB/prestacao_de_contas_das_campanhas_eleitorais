package modelo.beans;

public class Fornecedor extends Pessoa {

	public static final String STRING_VAZIO = "";
	
	private String cadastroNacional;
	
	public Fornecedor() {
		this.setNome(STRING_VAZIO);
		this.cadastroNacional = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Fornecedor) || object == null )
			return false;
		
		Fornecedor outroFornecedor = (Fornecedor) object;
		return this.getNome().equalsIgnoreCase(outroFornecedor.getNome());
	}

	public String getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(String cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
	
}
