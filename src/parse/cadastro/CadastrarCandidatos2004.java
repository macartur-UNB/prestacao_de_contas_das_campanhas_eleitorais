package parse.cadastro;

import parse.CandidatoParse;
import parse.cadastro.CadastrarCandidatos.IndiceCadastroCandidato;


public class CadastrarCandidatos2004 implements IndiceCadastroCandidato {

	private static final int NOME = 0;
	private static final int CARGO = 1;
	private static final int PARTIDO = 8;
	private static final int NUMERO = 3;
	private static final int ANO = 2004;

	@Override
	public void prepararIndicesDoParse(CandidatoParse candidatoParse) {
		candidatoParse.setIndiceNome(NOME);
		candidatoParse.setIndiceCargoPleiteado(CARGO);
		candidatoParse.setIndicePartido(PARTIDO);
		candidatoParse.setIndiceNumero(NUMERO);
		candidatoParse.setAno(ANO);
	}
	
}
