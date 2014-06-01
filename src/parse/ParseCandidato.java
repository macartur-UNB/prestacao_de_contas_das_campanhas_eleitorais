package parse;

import java.util.ArrayList;

import parse.Parse;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.cadastro.candidatura.CadastroCandidatoParse;

public class ParseCandidato extends Parse {

	public ParseCandidato(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {

		listaCadastrosParse.add(new CadastroCandidatoParse(null, null));

	}

	
	
}
