package modelo.beans;

public class Fornecedor {
	
	public static final String STRING_VAZIO = "";
	public static final int INTEGER_VAZIO = 0;
	
	private Integer cpf_cnpj;
	private String nome;
	private String uf;
	private String situacao_cadastral;
	
	
	public Fornecedor() {
		this.cpf_cnpj = INTEGER_VAZIO;
		this.nome = STRING_VAZIO;
		this.uf = STRING_VAZIO;
		this.situacao_cadastral = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Fornecedor) || object == null )
			return false;
		
		Fornecedor outroFornecedor = (Fornecedor) object;
		return this.getCpf_cnpj().equals(outroFornecedor.getCpf_cnpj());
	}
	
	public Integer getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(Integer cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getSituacao_cadastral() {
		return situacao_cadastral;
	}
	
	public void setSituacao_cadastral(String situacao_cadastral) {
		this.situacao_cadastral = situacao_cadastral;
	}

}
