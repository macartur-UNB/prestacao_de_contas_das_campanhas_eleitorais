package parse.cadastro;

import parse.CandidatoParse;
import parse.cadastro.CadastrarCandidatos.IndiceCadastroCandidato;

public class CadastrarCandidatos2008 implements IndiceCadastroCandidato {

	private static final int NOME = 0;
	private static final int CARGO = 2;
	private static final int PARTIDO = 12;
	private static final int NUMERO = 4;
	private static final int ANO = 2008;

	@Override
	public void prepararIndicesDoParse(CandidatoParse candidatoParse) {
		candidatoParse.setIndiceNome(NOME);
		candidatoParse.setIndiceCargoPleiteado(CARGO);
		candidatoParse.setIndicePartido(PARTIDO);
		candidatoParse.setIndiceNumero(NUMERO);
		candidatoParse.setAno(ANO);
	}
	
}
