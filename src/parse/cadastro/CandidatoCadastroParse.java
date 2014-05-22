package parse.cadastro;

import modelo.beans.Candidato;
import parse.ParseException;
import parse.controle.CandidatoParseControle;
import parse.controle.ParseControle;
import parse.indices.CandidatoIndicesParse;
import parse.indices.IndicesParse;

public class CandidatoCadastroParse extends CadastroParse<Candidato> {

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
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2002);
		candidatoIndicesParse.setIndiceNome(3);
		candidatoIndicesParse.setIndiceUf(0);
		candidatoIndicesParse.setIndiceCargo(2);
		candidatoIndicesParse.setIndicePartidoSigla(1);
		candidatoIndicesParse.setIndiceNumero(4);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2004() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2004);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(4);
		candidatoIndicesParse.setIndiceCargo(1);
		candidatoIndicesParse.setIndicePartidoSigla(8);
		candidatoIndicesParse.setIndiceNumero(3);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2006() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2006);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(4);
		candidatoIndicesParse.setIndiceCargo(1);
		candidatoIndicesParse.setIndicePartidoSigla(8);
		candidatoIndicesParse.setIndiceNumero(3);

		return candidatoIndicesParse;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParseDespesa2008() {
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2008);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(5);
		candidatoIndicesParse.setIndiceCargo(2);
		candidatoIndicesParse.setIndicePartidoSigla(12);
		candidatoIndicesParse.setIndiceNumero(4);

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
		CandidatoIndicesParse candidatoIndicesParse = new CandidatoIndicesParse(ANO_2008);
		candidatoIndicesParse.setIndiceNome(0);
		candidatoIndicesParse.setIndiceUf(5);
		candidatoIndicesParse.setIndiceCargo(2);
		candidatoIndicesParse.setIndicePartidoSigla(12);
		candidatoIndicesParse.setIndiceNumero(11);

		return candidatoIndicesParse;
	}
	
}
