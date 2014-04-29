package model;

public class Doador /* extends Pessoa */ {
	
	private Integer cadastroNacional;

	public Doador() {
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Doador) || object == null )
			return false;
		
		Doador outroDoador = (Doador) object;
		
		return (this.cadastroNacional.equals(outroDoador.getCadastroNacional()));
	}

	public Integer getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(Integer cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
	
}
