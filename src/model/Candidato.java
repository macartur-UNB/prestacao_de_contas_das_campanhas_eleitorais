package model;

public class Candidato {

	private String nome;
	private String cpf;
	private String partido;
	private String numero;
	private Integer ano;
	private String cargoPleiteado;
	private String resultadoEleicao;
	private String dominio;
	private Integer arrecadacao;
	private Integer despesa;
	
	public Candidato() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Candidato) || object == null )
			return false;
		
		Candidato outroCandidato = (Candidato) object;
		
		return ( this.nome.equals(outroCandidato.getNome()) &&
				 this.ano.equals(outroCandidato.getAno()) );
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
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

	public String getCargoPleiteado() {
		return cargoPleiteado;
	}

	public void setCargoPleiteado(String cargoPleiteado) {
		this.cargoPleiteado = cargoPleiteado;
	}

	public String getResultadoEleicao() {
		return resultadoEleicao;
	}

	public void setResultadoEleicao(String resultadoEleicao) {
		this.resultadoEleicao = resultadoEleicao;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Integer getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(Integer arrecadacao) {
		this.arrecadacao = arrecadacao;
	}

	public Integer getDespesa() {
		return despesa;
	}

	public void setDespesa(Integer despesa) {
		this.despesa = despesa;
	}	
	
}
