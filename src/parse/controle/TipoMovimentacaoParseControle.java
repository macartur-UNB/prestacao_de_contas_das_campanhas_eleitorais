package parse.controle;

import modelo.beans.TipoMovimentacao;
import modelo.dao.TipoMovimentacaoDAO;
import parse.indices.IndicesParse;

public class TipoMovimentacaoParseControle extends ParseControle<TipoMovimentacao> {

	public TipoMovimentacaoParseControle(IndicesParse<TipoMovimentacao> indicesParse) {
		super(indicesParse, new TipoMovimentacaoDAO());
	}

	@Override
	public TipoMovimentacao novaInstancia() {
		TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
		return tipoMovimentacao;
	}

	@Override
	public boolean iguais(TipoMovimentacao objetoUm, TipoMovimentacao objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
