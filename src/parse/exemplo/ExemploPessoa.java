package parse.exemplo;

public class ExemploPessoa {

	private String nome;
	private Integer idade;
	
	public ExemploPessoa() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof ExemploPessoa))
			return false;
		
		ExemploPessoa pessoa = (ExemploPessoa) object;
		
		return this.nome.equals(pessoa.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
}
