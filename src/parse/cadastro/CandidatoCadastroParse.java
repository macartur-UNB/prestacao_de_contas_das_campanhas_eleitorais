package parse.cadastro;

<<<<<<< HEAD
<<<<<<< HEAD
import parse.CandidatoParse;
=======
>>>>>>> Implementando Parse do Candidato
=======
import parse.CandidatoParse;
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
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
	
<<<<<<< HEAD
<<<<<<< HEAD
	private CandidatoIndicesParse candidatoIndicesParse;
	private CandidatoParse candidatoParse;
		
	public CandidatoCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.candidatoIndicesParse = getCandidatoIndicesParse(tipoArquivo, Integer.valueOf(ano));
		this.candidatoParse = new CandidatoParse(candidatoIndicesParse);
=======
	public CandidatoCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
>>>>>>> Implementando Parse do Candidato
=======
	private CandidatoIndicesParse candidatoIndicesParse;
	private CandidatoParse candidatoParse;
		
	public CandidatoCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.candidatoIndicesParse = getCandidatoIndicesParse(tipoArquivo, Integer.valueOf(ano));
		this.candidatoParse = new CandidatoParse(candidatoIndicesParse);
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
	}
	
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
		try {
			this.candidatoParse.addCandidato(campo);
			this.linhasLidas++;
			
			if(this.linhasLidas >= 40000) {
				this.candidatoParse.cadastrarCandidatos();
				this.candidatoParse.resetar();
				this.linhasLidas = 0;
			}
			
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try {
			this.candidatoParse.cadastrarCandidatos();
			this.candidatoParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
<<<<<<< HEAD
=======
		
>>>>>>> Implementando Parse do Candidato
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParse(String tipoArquivo, Integer ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return getCandidatoIndicesParseDespesa2002();
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008

			case ANO_2004:
				return getCandidatoIndicesParseDespesa2004();

			case ANO_2006:
				return getCandidatoIndicesParseDespesa2006();

			case ANO_2008:
				return getCandidatoIndicesParseDespesa2008();
<<<<<<< HEAD
=======
>>>>>>> Implementando Parse do Candidato
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
	
			default:
				return null;
			}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
		} else {
			switch (ano) {
			case ANO_2002:
				return getCandidatoIndicesParseReceita2002();

			case ANO_2004:
				return getCandidatoIndicesParseReceita2004();

			case ANO_2006:
				return getCandidatoIndicesParseReceita2006();

			case ANO_2008:
				return getCandidatoIndicesParseReceita2008();

			default:
				break;
			}
<<<<<<< HEAD
=======
>>>>>>> Implementando Parse do Candidato
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
	
	private CandidatoIndicesParse getCandidatoIndicesParseReceita2002() {
		return getCandidatoIndicesParseDespesa2002();
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseDespesa2004() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2004);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(4);
		candidatoIndicesParse.setIndiceCargo(1);
		candidatoIndicesParse.setIndicePartidoSigla(8);
		candidatoIndicesParse.setIndiceNumero(3);
		
		return candidatoIndicesParse;
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseReceita2004() {
		return getCandidatoIndicesParseDespesa2004();
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseDespesa2006() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2006);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(4);
		candidatoIndicesParse.setIndiceCargo(1);
		candidatoIndicesParse.setIndicePartidoSigla(8);
		candidatoIndicesParse.setIndiceNumero(3);
		
		return candidatoIndicesParse;
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseReceita2006() {
		return getCandidatoIndicesParseDespesa2006();
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseDespesa2008() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2008);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(5);
		candidatoIndicesParse.setIndiceCargo(2);
		candidatoIndicesParse.setIndicePartidoSigla(12);
		candidatoIndicesParse.setIndiceNumero(4);
		
		return candidatoIndicesParse;
	}
	
	private CandidatoIndicesParse getCandidatoIndicesParseReceita2008() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2008);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(4);
		candidatoIndicesParse.setIndiceCargo(1);
		candidatoIndicesParse.setIndicePartidoSigla(9);
		candidatoIndicesParse.setIndiceNumero(3);
		
		return candidatoIndicesParse;
	}
<<<<<<< HEAD
=======
>>>>>>> Implementando Parse do Candidato
=======
>>>>>>> Parse funcionando para o Candidato, 2002 a 2008
}
