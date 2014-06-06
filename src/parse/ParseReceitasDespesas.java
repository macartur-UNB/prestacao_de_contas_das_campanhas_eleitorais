package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.receita_despesa.CandidatoCadastroParse;
import parse.cadastro.receita_despesa.DespesaCadastroParse;
import parse.cadastro.receita_despesa.DoadorCadastroParse;
import parse.cadastro.receita_despesa.FornecedorCadastroParse;
import parse.cadastro.receita_despesa.PartidoCadastroParseDespesaReceita;

public class ParseReceitasDespesas extends Parse {

	public ParseReceitasDespesas(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {
		
		listaCadastrosParse.add(new PartidoCadastroParseDespesaReceita(tipoArquivo, ano));
		listaCadastrosParse.add(new CandidatoCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new FornecedorCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new DoadorCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new DespesaCadastroParse(tipoArquivo, ano));
	}

}
