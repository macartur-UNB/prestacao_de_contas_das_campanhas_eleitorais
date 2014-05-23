package parse.cadastro;

import modelo.beans.Fornecedor;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.indices.FornecedorIndicesParse;
import parse.indices.IndicesParse;

public class FornecedorCadastroParse extends CadastroParse<Fornecedor> {
	
	public FornecedorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}
	

	@Override
	public ParseControle<Fornecedor> novaInstancia(
			IndicesParse<Fornecedor> indicesParse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseDespesa2002() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(8);
		fornecedorIndicesParse.setIndiceCadastroNacional(6);
		
		return fornecedorIndicesParse;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseDespesa2004() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceCadastroNacional(19);
		return fornecedorIndicesParse;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseDespesa2006() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceCadastroNacional(19);
		
		return fornecedorIndicesParse;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseDespesa2008() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(22);
		fornecedorIndicesParse.setIndiceCadastroNacional(23);
		
		return fornecedorIndicesParse;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2002() {
		return new FornecedorIndicesParse();
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2004() {
		return new FornecedorIndicesParse();
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2006() {
		return new FornecedorIndicesParse();
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2008() {
		return new FornecedorIndicesParse();
	}
	
}
