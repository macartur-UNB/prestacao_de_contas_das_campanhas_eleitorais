package parse.cadastro.receita_despesa;

import modelo.beans.Fornecedor;
import parse.ParseException;
import parse.controle.FornecedorParseControle;
import parse.controle.ParseControle;
import parse.indices.FornecedorIndicesParse;
import parse.indices.IndicesParse;

public class FornecedorCadastroParse extends CadastroParseReceitasDespesas<Fornecedor> {

	public FornecedorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<Fornecedor> novaInstancia(IndicesParse<Fornecedor> indicesParse) {
		FornecedorParseControle fornecedorParseControle = new FornecedorParseControle(indicesParse);
		return fornecedorParseControle;
	}
	
	public FornecedorIndicesParse getIndicesParseDespesa2002() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(6);
		fornecedorIndicesParse.setIndiceNome(8);
		fornecedorIndicesParse.setIndiceUf(7);
		
		return fornecedorIndicesParse;
	}
	
	public FornecedorIndicesParse getIndicesParseDespesa2006() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(19);
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceUf(20);
		fornecedorIndicesParse.setIndiceSituacaoCadastral(21);
		
		return fornecedorIndicesParse;
	}
	
	public FornecedorIndicesParse getIndicesParseDespesa2010() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(10);
		fornecedorIndicesParse.setIndiceNome(11);
		
		return fornecedorIndicesParse;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2002() {
		return new FornecedorIndicesParse();
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2006() {
		return new FornecedorIndicesParse();
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParseReceita2010() {
		return new FornecedorIndicesParse();

	}

}
