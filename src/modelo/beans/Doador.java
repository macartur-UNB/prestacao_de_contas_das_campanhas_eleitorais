package modelo.beans;

public class Doador {
	
	public static final String STRING_VAZIO = "";
	
	private String cadastroNacional;
	
	public Doador() {
		this.cadastroNacional = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Doador) || object == null )
			return false;
		
		Doador outroDoador = (Doador) object;
		return this.getCadastroNacional().equalsIgnoreCase(outroDoador.getCadastroNacional());
	}

	public String getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(String cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
}
