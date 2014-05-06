package parse.cadastro;

import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.indices.CandidatoIndicesParse;

public class CandidatoCadastroParse implements ExecutorLeitorCSV {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final int ANO_2002 = 2002;
	public static final int ANO_2004 = 2004;
	public static final int ANO_2006 = 2006;
	public static final int ANO_2008 = 2008;
	
	private int linhasLidas;
	
	public CandidatoCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
	}
	
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParse(String tipoArquivo, Integer ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return getCandidatoIndicesParseDespesa2002();
	
			default:
				return null;
			}
		}
		return null;
	}

	private CandidatoIndicesParse getCandidatoIndicesParseDespesa2002() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2002);
		candidatoIndicesParse.setIndiceNome(3);
		candidatoIndicesParse.setIndiceUf(0);
		candidatoIndicesParse.setIndiceCargo(2);
		candidatoIndicesParse.setIndicePartidoSigla(1);
		candidatoIndicesParse.setIndiceNumero(4);
		
		return candidatoIndicesParse;
	}
}
