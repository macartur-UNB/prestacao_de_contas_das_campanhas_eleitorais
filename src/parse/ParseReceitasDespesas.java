package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.CandidatoCadastroParse;
import parse.cadastro.DespesaCadastroParse;
import parse.cadastro.DoadorCadastroParse;
import parse.cadastro.FornecedorCadastroParse;
import parse.cadastro.PartidoCadastroParse;

public class ParseReceitasDespesas extends Parse {

	public ParseReceitasDespesas(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {
		
		listaCadastrosParse.add(new PartidoCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new CandidatoCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new FornecedorCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new DoadorCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new DespesaCadastroParse(tipoArquivo, ano));
	}

}
