package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.candidatura.CadastroCandidatoParse;

public class ParseResultado extends Parse {

	public ParseResultado(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {

		listaCadastrosParse.add(new CadastroCandidatoParse(null, null));

	}

}
