package modelo.beans;

import java.util.Calendar;

public class MovimentacaoFinanceira {
	
	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Float FLOAT_VAZIO = (float) 0;
	public static final Boolean BOOLEAN_VAZIO = false;
	public static final Pessoa PESSOA_VAZIO = null;
	public static final Calendar CALENDAR_VAZIO = null;

	private Pessoa emNomeDe;
	private String horaRegistro;
	private Boolean entregaEmConjunto;
	private String numeroDocumento;
	private Calendar data;
	private Float valor;
	private String fonte;
	private String tipo;
	private String especie;
	private String descricao;

	public MovimentacaoFinanceira(){
		this.emNomeDe = PESSOA_VAZIO;
		this.horaRegistro = STRING_VAZIO;
		this.entregaEmConjunto = BOOLEAN_VAZIO;
		this.numeroDocumento = STRING_VAZIO;
		this.data = CALENDAR_VAZIO;
		this.valor = FLOAT_VAZIO;
		this.fonte = STRING_VAZIO;
		this.tipo = STRING_VAZIO;
		this.especie = STRING_VAZIO;
		this.descricao = STRING_VAZIO;
	}

	public Pessoa getEmNomeDe() {
		return emNomeDe;
	}

	public void setEmNomeDe(Pessoa emNomeDe) {
		this.emNomeDe = emNomeDe;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public Boolean isEntregaEmConjunto() {
		return entregaEmConjunto;
	}

	public void setEntregaEmConjunto(Boolean entregaEmConjunto) {
		this.entregaEmConjunto = entregaEmConjunto;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}