package parse.cadastro.receita_despesa;

import modelo.beans.Candidato;
import parse.ParseException;
import parse.controle.CandidatoParseControle;
import parse.controle.ParseControle;
import parse.indices.CandidatoIndicesParse;
import parse.indices.IndicesParse;

public class CandidatoCadastroParse extends CadastroParseReceitasDespesas<Candidato> {

	public CandidatoCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Candidato> novaInstancia(
			IndicesParse<Candidato> indicesParse) {
		return new CandidatoParseControle(indicesParse);
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2002() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(3);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2004() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2006() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2008() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseReceita2002() {
		return getIndicesParseDespesa2002();
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseReceita2004() {
		return getIndicesParseDespesa2004();
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseReceita2006() {
		return getIndicesParseDespesa2006();
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseReceita2008() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse();
		candidatoIndicesParse.setIndiceNome(0);

		return candidatoIndicesParse;
	}
	
}
