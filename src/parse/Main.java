package parse;

import java.io.File;
import java.util.List;

import dao.CandidatoDAO;
import model.Candidato;

public class Main {
	
	public static void main(String[] args) {		
		try {
			String diretorioCSV = new File("./src/teste/").getCanonicalPath();
			String arquivoCSV = diretorioCSV + "/csv_testes.csv";
			String csvSplit = "\";\"";
			
			List<Candidato> listaCandidatos;
			CandidatoParse candidatoParse = new CandidatoParse();
			candidatoParse.setIndiceNome(0);
			candidatoParse.setIndiceCargoPleiteado(1);
			candidatoParse.setIndicePartido(8);
			candidatoParse.setIndiceNumero(3);
			candidatoParse.setAno(2004);
			
			CandidatoDAO candidatoDAO = CandidatoDAO.getInstancia();
			
			System.out.println("getListaCandidatosUnicos");
			listaCandidatos = candidatoParse.getListaCandidatosUnicos(arquivoCSV, csvSplit, 2);
//			listaCandidatos = candidatoDAO.getListaCandidatos();
			

			System.out.println("cadastrarCandidato");
			
			for(Candidato candidato : listaCandidatos) {
				candidatoDAO.cadastrarCandidato(candidato);
//				System.out.println("Nome: " + candidato.getNome() +
//						 		 "; Cargo: " + candidato.getCargoPleiteado() +
//								 "; Partido: " + candidato.getPartido() +
//								 "; Numero: " + candidato.getNumero() +
//								 "; Ano: " + candidato.getAno());
			}
			
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
		
		System.out.println("\nOk!");
	}

}
