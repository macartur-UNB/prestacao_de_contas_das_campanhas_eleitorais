package model;

public class Doador /* extends Pessoa */ {
	
	private String nome; /*P = Pessoa*/
	private Boolean pessoaJuridica; /*P*/
	private Integer cadastroNacional;

	public Doador() {
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Doador) || object == null )
			return false;
		
		Doador outroDoador = (Doador) object;
		
		return (/*P*/this.nome.equals(outroDoador.getNome()) &&
				/*P*/this.pessoaJuridica.equals(outroDoador.getPessoaJuridica()) &&
				this.cadastroNacional.equals(outroDoador.getCadastroNacional()));
	}

	// INICIO P
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(Boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	// FIM P
	
	public Integer getCadastroNacional() {
		return cadastroNacional;
	}

	public void setCadastroNacional(Integer cadastroNacional) {
		this.cadastroNacional = cadastroNacional;
	}
	
}
