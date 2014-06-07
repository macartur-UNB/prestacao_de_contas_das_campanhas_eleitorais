package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.receita_despesa.DoadorCadastroParse;
import parse.cadastro.receita_despesa.FornecedorCadastroParse;

public class ParseMovimentacoes extends Parse {
	
	public ParseMovimentacoes(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {

		listaCadastrosParse.add(new DoadorCadastroParse(tipoArquivo, ano));
		listaCadastrosParse.add(new FornecedorCadastroParse(tipoArquivo, ano));

	}

}
