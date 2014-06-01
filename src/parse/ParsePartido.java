package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.partido.CadastroPartidoParse;

public class ParsePartido extends Parse {

	public ParsePartido(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {

		listaCadastrosParse.add(new CadastroPartidoParse(tipoArquivo, ano));
	}

}
