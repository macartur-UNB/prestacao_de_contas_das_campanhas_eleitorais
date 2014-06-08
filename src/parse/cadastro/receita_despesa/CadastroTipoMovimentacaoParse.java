package parse.cadastro.receita_despesa;

import modelo.beans.TipoMovimentacao;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.TipoMovimentacaoParseControle;
import parse.indices.IndicesParse;
import parse.indices.TipoMovimentacaoIndicesParse;

public class CadastroTipoMovimentacaoParse extends CadastroParseReceitasDespesas<TipoMovimentacao> {

	public CadastroTipoMovimentacaoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<TipoMovimentacao> novaInstancia(IndicesParse<TipoMovimentacao> indicesParse) {
		TipoMovimentacaoParseControle tipoMovimentacaoParseControle = new TipoMovimentacaoParseControle(indicesParse);
		return tipoMovimentacaoParseControle;
	}
	
	public TipoMovimentacaoIndicesParse getIndicesParseDespesa2002() {
		TipoMovimentacaoIndicesParse tipoMovimentacaoIndicesParse = new TipoMovimentacaoIndicesParse();
		tipoMovimentacaoIndicesParse.setIndiceDescricao(10);
		return tipoMovimentacaoIndicesParse;
	}
	
	public TipoMovimentacaoIndicesParse getIndicesParseDespesa2006() {
		TipoMovimentacaoIndicesParse tipoMovimentacaoIndicesParse = new TipoMovimentacaoIndicesParse();
		tipoMovimentacaoIndicesParse.setIndiceCodigo(12);
		tipoMovimentacaoIndicesParse.setIndiceDescricao(11);
		return tipoMovimentacaoIndicesParse;
	}
	
	public TipoMovimentacaoIndicesParse getIndicesParseDespesa2010() {
		TipoMovimentacaoIndicesParse tipoMovimentacaoIndicesParse = new TipoMovimentacaoIndicesParse();
		tipoMovimentacaoIndicesParse.setIndiceDescricao(14);
		return tipoMovimentacaoIndicesParse;
	}

	@Override
	protected IndicesParse<TipoMovimentacao> getIndicesParseReceita2002() {
		return new TipoMovimentacaoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoMovimentacao> getIndicesParseReceita2006() {
		TipoMovimentacaoIndicesParse tipoMovimentacaoIndicesParse = new TipoMovimentacaoIndicesParse();
		tipoMovimentacaoIndicesParse.setIndiceCodigo(12);
		tipoMovimentacaoIndicesParse.setIndiceDescricao(11);
		return tipoMovimentacaoIndicesParse;
	}

	@Override
	protected IndicesParse<TipoMovimentacao> getIndicesParseReceita2010() {
		TipoMovimentacaoIndicesParse tipoMovimentacaoIndicesParse = new TipoMovimentacaoIndicesParse();
		tipoMovimentacaoIndicesParse.setIndiceDescricao(14);
		return tipoMovimentacaoIndicesParse;
	}

}
