package parse;

import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {		
		try {
			String diretorioCSV = new File("./src/teste/").getCanonicalPath();
			String arquivoCSV = diretorioCSV + "/csv_testes.csv";
			String ano = "2004";		
			int linhaInicial = 2;
			int linhaFinal = 10;

			System.out.println("cadastrando candidatos");
			
			CandidatoIndicesParse candidatoIndicesParse;
			candidatoIndicesParse = getCandidatoIndicesParse2004();
			
			CandidatoParse cadastrarCandidatos;
			cadastrarCandidatos = new CandidatoParse(arquivoCSV, candidatoIndicesParse, linhaInicial, linhaFinal);
			cadastrarCandidatos.cadastrar();
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
		System.out.println("\nOk!");
	}
	
	public static CandidatoIndicesParse getCandidatoIndicesParse2004() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceCargoPleiteado(1);
		candidatoIndicesParse.setIndicePartido(8);
		candidatoIndicesParse.setIndiceNumero(3);
		candidatoIndicesParse.setAno(2004);
		
		return candidatoIndicesParse;
	}

}
