package parse.indices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import modelo.beans.Candidato;
import modelo.beans.MovimentacaoFinanceira;


public class MovimentacaoFinanceiraIndicesParse {

	public static final int INDICE_INVALIDO = -1;

	private String ano;
	
	private int indiceEmNomeDe;
	private int indiceHoraRegistro;
	private int indiceEntregaEmConjunto;
	private int indiceNumeroDocumento;
	private int indiceValor;
	private int indiceFonte;
	private int indiceTipo;
	private int indiceEspecie;
	private int indiceDescricao;

	public MovimentacaoFinanceiraIndicesParse(String ano) {
		this.ano = ano;
		
		this.indiceEmNomeDe = INDICE_INVALIDO;
		this.indiceHoraRegistro = INDICE_INVALIDO;
		this.indiceEntregaEmConjunto = INDICE_INVALIDO;
		this.indiceNumeroDocumento = INDICE_INVALIDO;
		this.indiceValor = INDICE_INVALIDO;
		this.indiceFonte = INDICE_INVALIDO;
		this.indiceFonte = INDICE_INVALIDO;
		this.indiceEspecie = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}
	
	public void iniciarMovimentacaoFinanceira(MovimentacaoFinanceira movimentacaoFinanceira, String campo[]) throws ParseException {
		reiniciarMovimentacaoFinanceira(movimentacaoFinanceira);
		
		movimentacaoFinanceira.setAno(ano);
		
		if(indiceValido(this.indiceEmNomeDe)) {
			Candidato candidato = new Candidato();
			candidato.setNome(campo[this.indiceEmNomeDe]);
			movimentacaoFinanceira.setEmNomeDe(candidato);
		}
		if(indiceValido(this.indiceHoraRegistro)) {
			movimentacaoFinanceira.setHoraRegistro(campo[this.indiceHoraRegistro]);
		}
		if(indiceValido(this.indiceEntregaEmConjunto)) {
			boolean entregaEmConjunto = Boolean.getBoolean(campo[this.indiceEntregaEmConjunto]);
			movimentacaoFinanceira.setEntregaEmConjunto(entregaEmConjunto);
		}
		if(indiceValido(this.indiceNumeroDocumento)) {
			movimentacaoFinanceira.setNumeroDocumento(campo[this.indiceNumeroDocumento]);
		}
		if(indiceValido(this.indiceValor)) {
			float valor = Float.parseFloat(campo[this.indiceValor].replace(',', '.'));
			movimentacaoFinanceira.setValor(valor);
		}
		if(indiceValido(this.indiceFonte)) {
			movimentacaoFinanceira.setFonte(campo[this.indiceFonte]);
		}
		if(indiceValido(this.indiceTipo)) {
			movimentacaoFinanceira.setTipo(campo[this.indiceTipo]);
		}
		if(indiceValido(this.indiceEspecie)) {
			movimentacaoFinanceira.setEspecie(campo[this.indiceEspecie]);
		}
		if(indiceValido(this.indiceDescricao)) {
			movimentacaoFinanceira.setDescricao(campo[this.indiceDescricao]);
		}
		
	}
	
	private void reiniciarMovimentacaoFinanceira(MovimentacaoFinanceira movimentacaoFinanceira) {
		movimentacaoFinanceira.setEmNomeDe(MovimentacaoFinanceira.PESSOA_VAZIO);
		movimentacaoFinanceira.setHoraRegistro(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setEntregaEmConjunto(MovimentacaoFinanceira.BOOLEAN_VAZIO);
		movimentacaoFinanceira.setNumeroDocumento(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setAno(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setValor(MovimentacaoFinanceira.FLOAT_VAZIO);
		movimentacaoFinanceira.setFonte(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setTipo(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setEspecie(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setDescricao(MovimentacaoFinanceira.STRING_VAZIO);
	}
	
	protected boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
	}

	public void setIndiceEmNomeDe(int indicEmNomeDe) {
		this.indiceEmNomeDe = indicEmNomeDe;
	}

	public void setIndiceHoraRegistro(int indiceHoraRegistro) {
		this.indiceHoraRegistro = indiceHoraRegistro;
	}

	public void setIndiceEntregaEmConjunto(int indiceEntregaEmConjunto) {
		this.indiceEntregaEmConjunto = indiceEntregaEmConjunto;
	}

	public void setIndiceNumeroDocumento(int indiceNumeroDocumento) {
		this.indiceNumeroDocumento = indiceNumeroDocumento;
	}

	public void setAno(String indiceAno) {
		this.ano = indiceAno;
	}

	public void setIndiceValor(int indiceValor) {
		this.indiceValor = indiceValor;
	}

	public void setIndiceFonte(int indiceFonte) {
		this.indiceFonte = indiceFonte;
	}

	public void setIndiceTipo(int indiceTipo) {
		this.indiceTipo = indiceTipo;
	}

	public void setIndiceEspecie(int indiceEspecie) {
		this.indiceEspecie = indiceEspecie;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}
	
	
	
}
