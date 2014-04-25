package parse;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import dao.CandidatoDAO;
import parse.LeitorCSV.ExecutorLeitorCSV;
import model.Candidato;

public class CandidatoParse {
	
	public static final int INDICE_INVALIDO = -1;
	
	private LeitorCSV leitorCSV;
	private CandidatoDAO candidatoDAO;
	
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
		this.candidatoDAO = new CandidatoDAO();
		
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
	
	public void cadastrarCandidatos(String arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, new CadastrarCandidatos(), linhaInicial, linhaFinal);
	}
	
	public void cadastrarCandidatos(String arquivo, String divisao, int linhaInicial) throws IOException {
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, new CadastrarCandidatos(), linhaInicial);
	}
	
	public LinkedList<Candidato> getListaCandidatosUnicos(String arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		LinkedList<Candidato> listaCandidatos = getListaCandidatos(arquivo, divisao, linhaInicial, linhaFinal);
		
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
	
	public LinkedList<Candidato> getListaCandidatosUnicos(String arquivo, String divisao, int linhaInicial) throws IOException {
		int numeroLinhas = this.leitorCSV.getNumeroLinhas(arquivo);
		return getListaCandidatosUnicos(arquivo, divisao, linhaInicial, numeroLinhas);
	}
	
	public LinkedList<Candidato> getListaCandidatos(String arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		LinkedList<Candidato> listaCandidatos = new LinkedList<>();
		LinkedList<String[]> listaCampos = (LinkedList<String[]>) this.leitorCSV.getCamposCSV(arquivo, divisao, linhaInicial, linhaFinal);
		
		Candidato candidato;
		for(String campo[] : listaCampos) {
			candidato = criarCandidato(campo);
			listaCandidatos.add(candidato);
		}
		
		return listaCandidatos;
	}
	
	public LinkedList<Candidato> getListaCandidatos(String arquivo, String divisao, int linhaInicial) throws IOException {
		int numeroLinhas = this.leitorCSV.getNumeroLinhas(arquivo);
		return getListaCandidatos(arquivo, divisao, linhaInicial, numeroLinhas);
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
	
	private void criarCandidato(String campo[], Candidato candidato) {		
		if(this.indiceNome > INDICE_INVALIDO)
			candidato.setNome(campo[this.indiceNome]);
		else
			candidato.setNome(null);
		
		if(this.indiceCPF > INDICE_INVALIDO)
			candidato.setCpf(campo[this.indiceCPF]);
		else
			candidato.setCpf(null);
			
		if(this.indicePartido > INDICE_INVALIDO)
			candidato.setPartido(campo[this.indicePartido]);
		else
			candidato.setPartido(null);
			
		if(this.indiceNumero > INDICE_INVALIDO)
			candidato.setNumero(campo[this.indiceNumero]);
		else
			candidato.setNumero(null);
			
		if(this.ano > INDICE_INVALIDO)
			candidato.setAno(this.ano);
		else
			candidato.setAno(null);
			
		if(this.indiceCargoPleiteado > INDICE_INVALIDO)
			candidato.setCargoPleiteado(campo[this.indiceCargoPleiteado]);
		else
			candidato.setCargoPleiteado(null);
			
		if(this.indiceDominio > INDICE_INVALIDO)
			candidato.setDominio(campo[this.indiceDominio]);
		else
			candidato.setDominio(null);
			
		if(this.indiceArrecadacao > INDICE_INVALIDO)
			candidato.setArrecadacao(Integer.getInteger(campo[this.indiceArrecadacao]));
		else
			candidato.setArrecadacao(null);
			
		if(this.indiceDespesa > INDICE_INVALIDO)
			candidato.setDespesa(Integer.getInteger(campo[this.indiceDespesa]));
		else
			candidato.setDespesa(null);
	}
	
	private Candidato criarCandidato(String campo[]) {
		Candidato candidato = new Candidato();
		criarCandidato(campo, candidato);
		return candidato;
	}
	
	private class CadastrarCandidatos implements ExecutorLeitorCSV{

		private Candidato candidato;
		private Candidato candidatoAnterior;
		
		public CadastrarCandidatos() {
			this.candidato = new Candidato();
			this.candidatoAnterior = new Candidato();
		}
		
		@Override
		public void executarMetodoPorLinhaDoArquivo(String[] campo) {
			try{
				criarCandidato(campo, this.candidato);
				
				if(!this.candidato.equals(this.candidatoAnterior)) {
					candidatoDAO.cadastrarCandidato(this.candidato);
				}
				
			} catch(Exception e) {
				
			}
			
			this.candidatoAnterior.setNome(this.candidato.getNome());
			this.candidatoAnterior.setAno(this.candidato.getAno());
		}
		
	}
	
}
