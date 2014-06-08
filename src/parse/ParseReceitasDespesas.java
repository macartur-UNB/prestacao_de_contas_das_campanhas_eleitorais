package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.receita_despesa.CadastroCandidatoParseReceitasDespesas;
import parse.cadastro.receita_despesa.CadastroDespesaParse;
import parse.cadastro.receita_despesa.CadastroDoadorParse;
import parse.cadastro.receita_despesa.CadastroFornecedorParse;
import parse.cadastro.receita_despesa.CadastroPartidoParseDespesaReceita;

public class ParseReceitasDespesas extends Parse {

	public ParseReceitasDespesas(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {
		
		listaCadastrosParse.add(new CadastroPartidoParseDespesaReceita(tipoArquivo, ano));
		listaCadastrosParse.add(new CadastroCandidatoParseReceitasDespesas(tipoArquivo, ano));
		listaCadastrosParse.add(new CadastroFornecedorParse(tipoArquivo, ano));
		listaCadastrosParse.add(new CadastroDoadorParse(tipoArquivo, ano));
		listaCadastrosParse.add(new CadastroDespesaParse(tipoArquivo, ano));
	}

}
