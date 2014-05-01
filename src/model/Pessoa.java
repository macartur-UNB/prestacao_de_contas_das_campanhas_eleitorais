package model;

public abstract class Pessoa {
	
	private String nome;
	protected Boolean pessoaJuridica;

	public Pessoa() {}

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
	
	
}
