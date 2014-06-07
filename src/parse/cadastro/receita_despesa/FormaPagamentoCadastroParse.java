package parse.cadastro.receita_despesa;

import modelo.beans.FormaPagamento;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.FormaPagamentoParseControle;
import parse.indices.IndicesParse;
import parse.indices.FormaPagamentoIndicesParse;

public class FormaPagamentoCadastroParse extends CadastroParseReceitasDespesas<FormaPagamento> {

	public FormaPagamentoCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<FormaPagamento> novaInstancia(IndicesParse<FormaPagamento> indicesParse) {
		FormaPagamentoParseControle formaPagamentoParseControle = new FormaPagamentoParseControle(indicesParse);
		return formaPagamentoParseControle;
	}
	
	public FormaPagamentoIndicesParse getIndicesParseDespesa2002() {
		return new FormaPagamentoIndicesParse();
	}
	
	public FormaPagamentoIndicesParse getIndicesParseDespesa2006() {
		FormaPagamentoIndicesParse formaPagamentoIndicesParse = new FormaPagamentoIndicesParse();
		formaPagamentoIndicesParse.setIndiceCodigo(14);
		formaPagamentoIndicesParse.setIndiceDescricao(13);
		
		return formaPagamentoIndicesParse;
	}
	
	public FormaPagamentoIndicesParse getIndicesParseDespesa2010() {
		FormaPagamentoIndicesParse formaPagamentoIndicesParse = new FormaPagamentoIndicesParse();
		formaPagamentoIndicesParse.setIndiceDescricao(16);
		return formaPagamentoIndicesParse;
	}

	@Override
	protected IndicesParse<FormaPagamento> getIndicesParseReceita2002() {
		FormaPagamentoIndicesParse formaPagamentoIndicesParse = new FormaPagamentoIndicesParse();
		formaPagamentoIndicesParse.setIndiceDescricao(10);
		return formaPagamentoIndicesParse;	}

	@Override
	protected IndicesParse<FormaPagamento> getIndicesParseReceita2006() {
		FormaPagamentoIndicesParse formaPagamentoIndicesParse = new FormaPagamentoIndicesParse();
		formaPagamentoIndicesParse.setIndiceCodigo(14);
		formaPagamentoIndicesParse.setIndiceDescricao(13);
		return formaPagamentoIndicesParse;
	}

	@Override
	protected IndicesParse<FormaPagamento> getIndicesParseReceita2010() {
		FormaPagamentoIndicesParse formaPagamentoIndicesParse = new FormaPagamentoIndicesParse();
		formaPagamentoIndicesParse.setIndiceDescricao(16);
		return formaPagamentoIndicesParse;
	}

}
