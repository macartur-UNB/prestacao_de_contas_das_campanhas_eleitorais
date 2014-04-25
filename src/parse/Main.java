package parse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dao.CandidatoDAO;
import model.Candidato;

public class Main {
	
	public static void main(String[] args) {		
		try {
			String diretorioCSV = new File("./src/teste/").getCanonicalPath();
			String arquivoCSV = diretorioCSV + "/csv_testes.csv";
			String divisao = "\";\"";
			
			int linhaInicial = 2;
			int linhaFinal = 1000;

			System.out.println("cadastrando candidatos");
			
			CadastrarCandidato cadastrarCandidato;
			cadastrarCandidato = new CadastrarCandidatos2004(arquivoCSV, divisao, linhaInicial, linhaFinal);
			cadastrarCandidato.cadastrar();
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
		System.out.println("\nOk!");
	}
	
	public interface CadastrarCandidato {
		public void cadastrar();
	}
	
	public static class CadastrarCandidatos2004 implements CadastrarCandidato {
		
		private CandidatoParse candidatoParse;
		private String arquivoCSV;
		private String divisao;
		private int linhaInicial;
		private int linhaFinal;
		
		public CadastrarCandidatos2004(String arquivoCSV, String divisao, int linhaInicial, int linhaFinal) {
			this.candidatoParse = new CandidatoParse();
			
			this.arquivoCSV = arquivoCSV;
			this.divisao = divisao;
			this.linhaInicial = linhaInicial;
			this.linhaFinal = linhaFinal;
			
			iniciarCandidato(candidatoParse);
		}
		
		@Override
		public void cadastrar() {
			try {
				this.candidatoParse.cadastrarCandidatos(this.arquivoCSV, this.divisao,
						this.linhaInicial, this.linhaFinal);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void iniciarCandidato(CandidatoParse candidatoParse) {
			candidatoParse.setIndiceNome(0);
			candidatoParse.setIndiceCargoPleiteado(1);
			candidatoParse.setIndicePartido(8);
			candidatoParse.setIndiceNumero(3);
			candidatoParse.setAno(2004);
		}
		
	}

}
