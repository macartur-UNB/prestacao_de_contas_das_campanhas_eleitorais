package parse;

import java.io.IOException;

import dao.CandidatoDAO;
import model.Candidato;
import parse.LeitorCSV.ExecutorLeitorCSV;

public class CandidatoParse {
	
	public static final int FIM_DO_ARQUIVO = -1;
	
	private LeitorCSV leitorCSV;
	private CandidatoDAO candidatoDAO;
	private CandidatoIndicesParse candidatoParse;
	
	private String arquivoCSV;
	private String divisao;
	private int linhaInicial;
	private int linhaFinal;
	
	
	public CandidatoParse(String arquivoCSV, CandidatoIndicesParse candidatoParse, int linhaInicial, int linhaFinal) throws Exception {
		this.leitorCSV = new LeitorCSV();
		this.candidatoDAO = new CandidatoDAO();
		this.candidatoParse = candidatoParse;
		
		this.arquivoCSV = arquivoCSV;
		this.divisao = "\";\"";
		this.linhaInicial = linhaInicial;
		this.linhaFinal = linhaFinal;
	}
	
	public CandidatoParse(String arquivoCSV, CandidatoIndicesParse candidatoParse, int linhaInicial) throws Exception {
		this(arquivoCSV, candidatoParse, linhaInicial, FIM_DO_ARQUIVO);
	}
	
	public void cadastrar() {
		try {
			if(this.linhaFinal == FIM_DO_ARQUIVO) {
				cadastrarCandidatos(this.arquivoCSV, this.divisao,
						this.linhaInicial);
			} else {
				cadastrarCandidatos(this.arquivoCSV, this.divisao,
						this.linhaInicial, this.linhaFinal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cadastrarCandidatos(String arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, new CadastrarCandidatos(), linhaInicial, linhaFinal);
	}
	
	private void cadastrarCandidatos(String arquivo, String divisao, int linhaInicial) throws IOException {
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, new CadastrarCandidatos(), linhaInicial);
	}
	
	private void criarCandidato(String campo[], Candidato candidato) {		
		if(this.candidatoParse.getIndiceNome() > CandidatoIndicesParse.INDICE_INVALIDO)
			candidato.setNome(campo[this.candidatoParse.getIndiceNome()]);
		else
			candidato.setNome(null);
		
		if(this.candidatoParse.getIndiceCPF() > CandidatoIndicesParse.INDICE_INVALIDO)
			candidato.setCpf(campo[this.candidatoParse.getIndiceCPF()]);
		else
			candidato.setCpf(null);
			
		if(this.candidatoParse.getIndiceNumero() > CandidatoIndicesParse.INDICE_INVALIDO)
			candidato.setNumero(campo[this.candidatoParse.getIndiceNumero()]);
		else
			candidato.setNumero(null);
			
		if(this.candidatoParse.getAno() > CandidatoIndicesParse.INDICE_INVALIDO)
			candidato.setAno(this.candidatoParse.getAno());
		else
			candidato.setAno(null);
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
