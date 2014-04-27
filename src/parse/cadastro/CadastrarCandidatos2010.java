package parse.cadastro;

import parse.CandidatoParse;
import parse.cadastro.CadastrarCandidatos.IndiceCadastroCandidato;

public class CadastrarCandidatos2010 implements IndiceCadastroCandidato {

	private static final int NOME = 5;
	private static final int CARGO = 4;
	private static final int PARTIDO = 2;
	private static final int NUMERO = 3;
	private static final int ANO = 2010;

	@Override
	public void prepararIndicesDoParse(CandidatoParse candidatoParse) {
		System.out.println("NOME: " + NOME);
		candidatoParse.setIndiceNome(NOME);
		candidatoParse.setIndiceCargoPleiteado(CARGO);
		candidatoParse.setIndicePartido(PARTIDO);
		candidatoParse.setIndiceNumero(NUMERO);
		candidatoParse.setAno(ANO);
	}

}
