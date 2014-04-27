package parse.cadastro;

import java.io.IOException;

import parse.CandidatoParse;

public class CadastrarCandidatos {
	
	public interface IndiceCadastroCandidato {
		public void prepararIndicesDoParse(CandidatoParse parse);
	}
	
	private CandidatoParse candidatoParse;
	private IndiceCadastroCandidato indiceCadastroCandidato;
	private String arquivoCSV;
	private String divisao;
	private int linhaInicial;
	private int linhaFinal;
	
	public CadastrarCandidatos(String arquivoCSV, String ano, int linhaInicial, int linhaFinal) throws Exception {
		this.candidatoParse = new CandidatoParse();
		
		this.arquivoCSV = arquivoCSV;
		this.divisao = "\";\"";
		this.linhaInicial = linhaInicial;
		this.linhaFinal = linhaFinal;
		Class<?> classe = Class.forName(this.getClass().getName() + ano);
		this.indiceCadastroCandidato = (IndiceCadastroCandidato) classe.newInstance();
		this.indiceCadastroCandidato.prepararIndicesDoParse(this.candidatoParse);
	}
	
	public void cadastrar() {
		try {
			this.candidatoParse.cadastrarCandidatos(this.arquivoCSV, this.divisao,
					this.linhaInicial, this.linhaFinal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
