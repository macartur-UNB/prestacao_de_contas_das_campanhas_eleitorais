package parse;

import java.util.ArrayList;

import parse.cadastro.CadastroParse;
import parse.cadastro.receita_despesa.CadastroDespesaParse;
import parse.cadastro.receita_despesa.CadastroDoadorParse;
import parse.cadastro.receita_despesa.CadastroFornecedorParse;
import parse.cadastro.receita_despesa.CadastroParseReceitasDespesas;
import parse.cadastro.receita_despesa.CadastroReceitaParse;

public class ParseMovimentacoes extends Parse {
	
	public ParseMovimentacoes(String tipoArquivo, String ano) throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	protected void adicionarCadastrosParseNaLista(
			ArrayList<CadastroParse<?>> listaCadastrosParse,
			String tipoArquivo, String ano) throws ParseException {
		
		if(tipoArquivo.equals(CadastroParseReceitasDespesas.DESPESA))
		{
			listaCadastrosParse.add(new CadastroFornecedorParse(tipoArquivo, ano));
			listaCadastrosParse.add(new CadastroDespesaParse(tipoArquivo, ano));
		}
		else
		{
			listaCadastrosParse.add(new CadastroDoadorParse(tipoArquivo, ano));
			listaCadastrosParse.add(new CadastroReceitaParse(tipoArquivo, ano));
		}



	}

}
