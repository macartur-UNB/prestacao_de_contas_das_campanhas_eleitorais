package parse.cadastro.candidatura;

import modelo.beans.Resultado;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.ParseControle;
import parse.controle.ResultadoParseControle;
import parse.indices.IndicesParse;
import parse.indices.ResultadoIndicesParse;

public class CadastroResultadoParse extends CadastroParse<Resultado>{

	public CadastroResultadoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Resultado> novaInstancia(
			IndicesParse<Resultado> indicesParse) {
		ResultadoParseControle resultadoParseControle = new ResultadoParseControle(indicesParse);
		return resultadoParseControle;
	}

	@Override
	protected IndicesParse<Resultado> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		ResultadoIndicesParse resultadoIndicesParse;
		resultadoIndicesParse = new ResultadoIndicesParse();
		
		resultadoIndicesParse.setIndiceCodigo(40);
		resultadoIndicesParse.setIndiceDescricao(41);
		
		return resultadoIndicesParse;
	}

}
