package parse.cadastro.campanha;

import modelo.beans.Candidato;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.CandidatoParseControle;
import parse.controle.ParseControle;
import parse.indices.CandidatoIndicesParse;
import parse.indices.IndicesParse;

public class CadastroCandidatoParse extends CadastroParse<Candidato> {

	public CadastroCandidatoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Candidato> novaInstancia(
			IndicesParse<Candidato> indicesParse) {
		CandidatoParseControle candidatoParseControle = new CandidatoParseControle(indicesParse);
		return candidatoParseControle;
	}

	@Override
	protected IndicesParse<Candidato> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		CandidatoIndicesParse candidatoIndicesParse;
		candidatoIndicesParse = new CandidatoIndicesParse();
		
		candidatoIndicesParse.setIndiceNome(10);
		candidatoIndicesParse.setIndiceTituloEleitoral(26);
		
		return candidatoIndicesParse;
	}
	

}
