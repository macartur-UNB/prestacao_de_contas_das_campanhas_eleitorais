package parse.cadastro.receita_despesa;

import modelo.beans.Partido;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.PartidoParseControle;
import parse.indices.IndicesParse;
import parse.indices.PartidoIndicesParse;

public class PartidoCadastroParseDespesaReceita extends CadastroParseReceitasDespesas<Partido> {
	
	public PartidoCadastroParseDespesaReceita(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}
	
	@Override
	public ParseControle<Partido> novaInstancia(
			IndicesParse<Partido> indicesParse) {
		return new PartidoParseControle(indicesParse);
	}	

	@Override
	protected IndicesParse<Partido> getIndicesParseDespesa2002() {
		return getIndicesParseReceita2002();
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseDespesa2004() {
		return getIndicesParseReceita2004();
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseDespesa2006() {
		return getIndicesParseReceita2006();
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseDespesa2008() {
		return getIndicesParseReceita2008();
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseReceita2002() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(1);
		
		return partidoIndicesParse;
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseReceita2004() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(8);
		partidoIndicesParse.setIndiceNumero(7);
		
		return partidoIndicesParse;
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseReceita2006() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(8);
		partidoIndicesParse.setIndiceNumero(7);
		
		return partidoIndicesParse;
	}

	@Override
	protected IndicesParse<Partido> getIndicesParseReceita2008() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(12);
		partidoIndicesParse.setIndiceNumero(11);
		
		return partidoIndicesParse;
	}
	
}
