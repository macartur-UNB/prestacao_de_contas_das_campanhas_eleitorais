package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.campanha.CadastroCampanhaParse;
import parse.cadastro.campanha.CadastroCandidatoParse;
import parse.cadastro.campanha.CadastroCargoParse;
import parse.cadastro.campanha.CadastroResultadoParse;

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
		listaCadastrosParse.add(new CadastroCargoParse(null, null));
		listaCadastrosParse.add(new CadastroCampanhaParse(null, null));
	}
	
}
