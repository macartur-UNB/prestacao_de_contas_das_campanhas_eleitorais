package model;

import java.util.Calendar;

public class MovimentacaoFinanceira {

	private Pessoa emNomeDe; //Classe ainda não criada
	private String horaRegistro;
	private boolean entregaEmConjunto;
	private String numeroDocumento;
	private Calendar data;
	private float valor;
	private String fonte;
	private String tipo;
	private String especie;
	private String descricao;

	public MovimentacaoFinanceira(){

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

	public boolean isEntregaEmConjunto() {
		return entregaEmConjunto;
	}

	public void setEntregaEmConjunto(boolean entregaEmConjunto) {
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
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