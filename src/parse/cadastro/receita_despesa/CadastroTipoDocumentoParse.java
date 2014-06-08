package parse.cadastro.receita_despesa;

import modelo.beans.TipoDocumento;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.TipoDocumentoParseControle;
import parse.indices.IndicesParse;
import parse.indices.TipoDocumentoIndicesParse;

public class CadastroTipoDocumentoParse extends CadastroParseReceitasDespesas<TipoDocumento> {

	public CadastroTipoDocumentoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<TipoDocumento> novaInstancia(IndicesParse<TipoDocumento> indicesParse) {
		TipoDocumentoParseControle tipoDocumentoParseControle = new TipoDocumentoParseControle(indicesParse);
		return tipoDocumentoParseControle;
	}
	
	public TipoDocumentoIndicesParse getIndicesParseDespesa2002() {
		return new TipoDocumentoIndicesParse();
	}
	
	public TipoDocumentoIndicesParse getIndicesParseDespesa2006() {
		TipoDocumentoIndicesParse tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		tipoDocumentoIndicesParse.setIndiceCodigo(17);
		tipoDocumentoIndicesParse.setIndiceDescricao(16);
		return tipoDocumentoIndicesParse;
	}
	
	public TipoDocumentoIndicesParse getIndicesParseDespesa2010() {
		TipoDocumentoIndicesParse tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		tipoDocumentoIndicesParse.setIndiceDescricao(8);
		return tipoDocumentoIndicesParse;
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2002() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2006() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2010() {
		return new TipoDocumentoIndicesParse();
	}

}
