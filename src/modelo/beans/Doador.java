package modelo.beans;

public class Doador extends Pessoa {
	
	public static final String STRING_VAZIO = "";
	
	private String cadastroNacional;
	
	public Doador() {
		this.setNome(STRING_VAZIO);
		this.cadastroNacional = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Doador) || object == null )
			return false;
		
		Doador outroDoador = (Doador) object;
		return this.getNome().equalsIgnoreCase(outroDoador.getNome());
	}

	public String getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(String cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
}
