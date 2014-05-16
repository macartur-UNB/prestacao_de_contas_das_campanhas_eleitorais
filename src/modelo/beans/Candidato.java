/** CRIADO POR:          
 * 
 *  COMENTARIOS:
 *  Rafael: (01/05/14) Adequei os atributos a modelagem UML.
 *  Rafael: (10/05/14) Transferi os metodos de MovimentacaoDAO pra ca. Com
 *  isso, esses metodos se tornam metodos sem parametros e podem mais 
 *  facilmente serem usados atraves de tags na view.
**/

package modelo.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.dao.CandidatoDAO;


public class Candidato extends Pessoa{

	public static final String  STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Boolean BOOLEAN_VAZIO = false;
	public static final Partido PARTIDO_VAZIO = new Partido();
	
	/**** Atributos de Classe *******************************************/
	
	private Integer ano;
	private String cpf;
	private String cargo;
	private Partido partido;
	private String numero;
	private String uf;
	private Boolean foiEleito;
	private Integer resultadoUltimaEleicao;
	
	public Candidato() {
		this.ano = INTEGER_VAZIO;
		this.cpf = STRING_VAZIO;
		this.cargo = STRING_VAZIO;
		this.partido = PARTIDO_VAZIO;
		this.numero = STRING_VAZIO;
		this.uf = STRING_VAZIO;
		this.foiEleito = BOOLEAN_VAZIO;
		this.resultadoUltimaEleicao = INTEGER_VAZIO;
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

	public Integer getResultadoUltimaEleicao() {
		return resultadoUltimaEleicao;
	}

	public void setResultadoUltimaEleicao(Integer resultadoUltimaEleicao) {
		this.resultadoUltimaEleicao = resultadoUltimaEleicao;
	}

	public boolean existe() {

		CandidatoDAO dao = new CandidatoDAO();
		ResultSet result = dao.selectSQL(this,"t_candidato");
		try{
			if(result.next()) return true;
			else return false;

		}catch(SQLException e){
			return false;
		}

	}
}
