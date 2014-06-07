package parse.cadastro.receita_despesa;

import modelo.beans.TipoDocumento;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.TipoDocumentoParseControle;
import parse.indices.IndicesParse;
import parse.indices.TipoDocumentoIndicesParse;

public class TipoDocumentoCadastroParse extends CadastroParseReceitasDespesas<TipoDocumento> {

	public TipoDocumentoCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<TipoDocumento> novaInstancia(IndicesParse<TipoDocumento> indicesParse) {
		TipoDocumentoParseControle tipoDocumentoParseControle = new TipoDocumentoParseControle(indicesParse);
		return tipoDocumentoParseControle;
	}
	
	public TipoDocumentoIndicesParse getIndicesParseTipoDocumento2002() {
		TipoDocumentoIndicesParse tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		tipoDocumentoIndicesParse.setIndiceCodigo(0);
		
		return tipoDocumentoIndicesParse;
	}
	
	public TipoDocumentoIndicesParse getIndicesParseTipoDocumento2006() {
		TipoDocumentoIndicesParse tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		tipoDocumentoIndicesParse.setIndiceCodigo(0);
		tipoDocumentoIndicesParse.setIndiceCodigo(17);
		tipoDocumentoIndicesParse.setIndiceDescricao(16);
		
		return tipoDocumentoIndicesParse;
	}
	
	public TipoDocumentoIndicesParse getIndicesParseTipoDocumento2010() {
		TipoDocumentoIndicesParse tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		tipoDocumentoIndicesParse.setIndiceCodigo(0);
		tipoDocumentoIndicesParse.setIndiceDescricao(8);
		
		return tipoDocumentoIndicesParse;
	}


	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2006() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2010() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseDespesa2002() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseDespesa2006() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseDespesa2010() {
		return new TipoDocumentoIndicesParse();
	}

	@Override
	protected IndicesParse<TipoDocumento> getIndicesParseReceita2002() {
		return new TipoDocumentoIndicesParse();
	}

}
