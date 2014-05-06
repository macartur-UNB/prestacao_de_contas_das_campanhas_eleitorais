/** CRIADO POR:          
 *  ULTIMA MODIFICACAO:  01/05/2014 (Rafael)
 * 
 *  COMENTARIOS:
 *  (Rafael): Adequei os atributos a modelagem UML.
**/

package model;

public class Candidato extends Pessoa{

	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Boolean BOOLEAN_VAZIO = false;
	public static final Partido PARTIDO_VAZIO = new Partido();
	
	private Integer ano;
	private String cpf;
	private String cargo;
	private Partido partido;
	private String numero;
	private String uf;
	private Boolean foiEleito;
	
	public Candidato() {
		this.ano = INTEGER_VAZIO;
		this.cpf = STRING_VAZIO;
		this.cargo = STRING_VAZIO;
		this.partido = PARTIDO_VAZIO;
		this.numero = STRING_VAZIO;
		this.uf = STRING_VAZIO;
		this.foiEleito = BOOLEAN_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Candidato) || object == null )
			return false;
		
		Candidato outroCandidato = (Candidato) object;
		
		return ( this.getNome().equals(outroCandidato.getNome()) &&
				 this.ano.equals(outroCandidato.getAno()) );
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public Boolean getFoiEleito() {
		return foiEleito;
	}

	public void setFoiEleito(Boolean foiEleito) {
		this.foiEleito = foiEleito;
	}
	
}
