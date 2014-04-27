package parse;

import java.io.File;

import parse.cadastro.CadastrarCandidatos;

public class Main {
	
	public static void main(String[] args) {		
		try {
			String diretorioCSV = new File("./src/teste/").getCanonicalPath();
			String arquivoCSV = diretorioCSV + "/csv_testes.csv";
			
			String ano = "2004";		
			int linhaInicial = 2;
			int linhaFinal = 10;

			System.out.println("cadastrando candidatos");
			
			CadastrarCandidatos cadastrarCandidatos;
			cadastrarCandidatos = new CadastrarCandidatos(arquivoCSV, ano, linhaInicial, linhaFinal);
			cadastrarCandidatos.cadastrar();
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
		System.out.println("\nOk!");
	}

}
