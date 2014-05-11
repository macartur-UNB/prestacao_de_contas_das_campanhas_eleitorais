package modelo.beans;

public class Doador extends Pessoa {
	
	private String cadastroNacional;

	public String getCadastroNacional() {
		return cadastroNacional;
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Doador) || object == null )
			return false;
		
		Doador outroFornecedor = (Doador) object;
		return this.cadastroNacional.equals(outroFornecedor.getCadastroNacional());
	}
	
	public void setCadastroNacional(String cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
	
}
