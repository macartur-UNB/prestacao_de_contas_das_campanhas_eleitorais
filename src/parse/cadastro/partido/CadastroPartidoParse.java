package parse.cadastro.partido;

import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.ParseControle;
import parse.controle.PartidoParseControle;
import parse.indices.IndicesParse;
import parse.indices.PartidoIndicesParse;
import modelo.beans.Partido;

public class CadastroPartidoParse extends CadastroParse<Partido>{

	public CadastroPartidoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Partido> novaInstancia(
			IndicesParse<Partido> indicesParse) {
		PartidoParseControle partidoParseControle;
		partidoParseControle = new PartidoParseControle(indicesParse);
		return partidoParseControle;
	}

	@Override
	protected IndicesParse<Partido> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		PartidoIndicesParse partidoIndicesParse;
		partidoIndicesParse = new PartidoIndicesParse();
		
		partidoIndicesParse.setIndiceNome(2);
		partidoIndicesParse.setIndiceSigla(1);
		partidoIndicesParse.setIndiceNumero(5);
		partidoIndicesParse.setIndiceDeferimento(3);
		
		return partidoIndicesParse;
	}

	
}
