package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.candidatura.CadastroCandidatoParse;
import parse.cadastro.candidatura.CadastroResultadoParse;

public class ParseCandidato extends Parse {

	public ParseCandidato(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {

		listaCadastrosParse.add(new CadastroCandidatoParse(null, null));
		listaCadastrosParse.add(new CadastroResultadoParse(null, null));


	}

	
	
}
