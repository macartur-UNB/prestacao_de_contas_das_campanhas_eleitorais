package parse;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import model.Candidato;

public class CandidatoParse {
	
	public static final int INDICE_INVALIDO = -1;
	
	private LeitorCSV leitorCSV;
	
	private int ano;
	
	private int indiceNome;
	private int indiceCPF;
	private int indicePartido;
	private int indiceNumero;
	private int indiceCargoPleiteado;
	private int indiceDominio;
	private int indiceArrecadacao;
	private int indiceDespesa;	
	
	public CandidatoParse() {
		this.leitorCSV = new LeitorCSV();
		
		this.ano = 0;
		
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCPF = INDICE_INVALIDO;
		this.indicePartido = INDICE_INVALIDO;
		this.indiceNumero = INDICE_INVALIDO;
		this.indiceCargoPleiteado = INDICE_INVALIDO;
		this.indiceDominio = INDICE_INVALIDO;
		this.indiceArrecadacao = INDICE_INVALIDO;
		this.indiceDespesa = INDICE_INVALIDO;
	}
	
	
	
	public LinkedList<Candidato> getListaCandidatosUnicos(String arquivo, String divisao, int linhaInicial) throws IOException
	{
		LinkedList<Candidato> listaCandidatos = getListaCandidatos(arquivo, divisao, linhaInicial);
		
		if(listaCandidatos.size() <= 1)
			return listaCandidatos;
		
		LinkedList<Candidato> candidatosRemovidos = new LinkedList<>();
		
		Iterator<Candidato> iterador = listaCandidatos.iterator();
		Candidato candidatoAnterior = iterador.next();
		Candidato candidatoAtual;
		while(iterador.hasNext()) {
			candidatoAtual = iterador.next();
			
			if(candidatoAtual.equals(candidatoAnterior)) {
				candidatosRemovidos.add(candidatoAtual);
			}
			
			candidatoAnterior = candidatoAtual;
		}
		
		for(Candidato candidatoRemovido : candidatosRemovidos) {
			listaCandidatos.remove(candidatoRemovido);
		}
		
		return listaCandidatos;
	}
	
	public LinkedList<Candidato> getListaCandidatos(String arquivo, String divisao, int linhaInicial) throws IOException {
		LinkedList<Candidato> listaCandidatos = new LinkedList<>();
		LinkedList<String[]> listaCampos = (LinkedList<String[]>) this.leitorCSV.getCamposCSV(arquivo, divisao, linhaInicial);
		
		for(String campo[] : listaCampos) {
			Candidato candidato = new Candidato();
			
			if(this.indiceNome > INDICE_INVALIDO)
				candidato.setNome(campo[this.indiceNome]);
			
			if(this.indiceCPF > INDICE_INVALIDO)
				candidato.setCpf(campo[this.indiceCPF]);
				
			if(this.indicePartido > INDICE_INVALIDO)
				candidato.setPartido(campo[this.indicePartido]);
				
			if(this.indiceNumero > INDICE_INVALIDO)
				candidato.setNumero(campo[this.indiceNumero]);
				
			if(this.ano > INDICE_INVALIDO)
				candidato.setAno(this.ano);
				
			if(this.indiceCargoPleiteado > INDICE_INVALIDO)
				candidato.setCargoPleiteado(campo[this.indiceCargoPleiteado]);
				
			if(this.indiceDominio > INDICE_INVALIDO)
				candidato.setDominio(campo[this.indiceDominio]);
				
			if(this.indiceArrecadacao > INDICE_INVALIDO)
				candidato.setArrecadacao(Integer.getInteger(campo[this.indiceArrecadacao]));
				
			if(this.indiceDespesa > INDICE_INVALIDO)
				candidato.setDespesa(Integer.getInteger(campo[this.indiceDespesa]));
			
			listaCandidatos.add(candidato);
		}
		
		return listaCandidatos;
	}

	public LeitorCSV getLeitorCSV() {
		return leitorCSV;
	}

	public void setLeitorCSV(LeitorCSV leitorCSV) {
		this.leitorCSV = leitorCSV;
	}

	public int getIndiceNome() {
		return indiceNome;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public int getIndiceCPF() {
		return indiceCPF;
	}

	public void setIndiceCPF(int indiceCPF) {
		this.indiceCPF = indiceCPF;
	}

	public int getIndicePartido() {
		return indicePartido;
	}

	public void setIndicePartido(int indicePartido) {
		this.indicePartido = indicePartido;
	}

	public int getIndiceNumero() {
		return indiceNumero;
	}

	public void setIndiceNumero(int indiceNumero) {
		this.indiceNumero = indiceNumero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIndiceCargoPleiteado() {
		return indiceCargoPleiteado;
	}

	public void setIndiceCargoPleiteado(int indiceCargoPleiteado) {
		this.indiceCargoPleiteado = indiceCargoPleiteado;
	}

	public int getIndiceDominio() {
		return indiceDominio;
	}

	public void setIndiceDominio(int indiceDominio) {
		this.indiceDominio = indiceDominio;
	}

	public int getIndiceArrecadacao() {
		return indiceArrecadacao;
	}

	public void setIndiceArrecadacao(int indiceArrecadacao) {
		this.indiceArrecadacao = indiceArrecadacao;
	}

	public int getIndiceDespesa() {
		return indiceDespesa;
	}

	public void setIndiceDespesa(int indiceDespesa) {
		this.indiceDespesa = indiceDespesa;
	}

	public static int getIndiceInvalido() {
		return INDICE_INVALIDO;
	}
	
}
