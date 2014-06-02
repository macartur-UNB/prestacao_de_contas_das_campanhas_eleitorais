package modelo.beans;

public class Candidato {

	public static final String  STRING_VAZIO = "";
	public static final Integer  INTEGER_VAZIO = 0;
	
	/**** Atributos de Classe *******************************************/
	
	private String nome;
	private String tituloEleitoral;
	
	public Candidato() {
		this.nome = STRING_VAZIO;
		this.tituloEleitoral = STRING_VAZIO;
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Candidato) || object == null )
			return false;

		Candidato outroCandidato = (Candidato) object;

		return this.tituloEleitoral.equals(outroCandidato.getTituloEleitoral());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}
	
	

}
