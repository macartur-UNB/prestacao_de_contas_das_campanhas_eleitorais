package modelo.beans;

public class Fornecedor {

	public static final String STRING_VAZIO = "";
	
	private String cadastroNacional;
	
	public Fornecedor() {
		this.cadastroNacional = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Fornecedor) || object == null )
			return false;
		
		Fornecedor outroFornecedor = (Fornecedor) object;
		return this.getCadastroNacional().equalsIgnoreCase(outroFornecedor.getCadastroNacional());
	}

	public String getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(String cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
	
}
