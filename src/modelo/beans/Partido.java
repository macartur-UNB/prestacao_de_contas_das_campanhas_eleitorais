package modelo.beans;

public class Partido {
	
	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;

	
	private Integer numero;
	private String sigla;
	private String deferimento;
	private String nome;
	
	public Partido() {
		this.nome = STRING_VAZIO;
		this.sigla = STRING_VAZIO;
		this.numero = INTEGER_VAZIO;
		this.deferimento = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido))
			return false;
		
		Partido outroPartido = (Partido) object;
		return this.numero.equals(outroPartido.getNumero());
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDeferimento() {
		return deferimento;
	}

	public void setDeferimento(String deferimento) {
		this.deferimento = deferimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
