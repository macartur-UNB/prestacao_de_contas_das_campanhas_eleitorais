package parse.cadastro.receita_despesa;

import modelo.beans.Fornecedor;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.FornecedorParseControle;
import parse.controle.ParseControle;
import parse.indices.FornecedorIndicesParse;
import parse.indices.IndicesParse;

public class FornecedorCadastroParse extends CadastroParse<Fornecedor> {
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2010 = "2010";
	public static final String DESPESA = "despesa";

	public FornecedorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<Fornecedor> novaInstancia(IndicesParse<Fornecedor> indicesParse) {
		FornecedorParseControle fornecedorParseControle = new FornecedorParseControle(indicesParse);
		return fornecedorParseControle;
	}

	@Override
	protected IndicesParse<Fornecedor> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		switch(ano) {
		case ANO_2002:
			return getFornecedorIndicesParse2002();
			
		case ANO_2006:
			return getFornecedorIndicesParse2006();
			
		case ANO_2010:
			return getFornecedorIndicesParse2010();
			
		default:
			return null;
		}
		
	}
	
	public FornecedorIndicesParse getFornecedorIndicesParse2002() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(6);
		fornecedorIndicesParse.setIndiceNome(8);
		fornecedorIndicesParse.setIndiceUf(7);
		
		return fornecedorIndicesParse;
	}
	
	public FornecedorIndicesParse getFornecedorIndicesParse2006() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(19);
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceUf(20);
		fornecedorIndicesParse.setIndiceSituacaoCadastral(21);
		
		return fornecedorIndicesParse;
	}
	
	public FornecedorIndicesParse getFornecedorIndicesParse2010() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceCpf_Cnpj(10);
		fornecedorIndicesParse.setIndiceNome(11);
		
		return fornecedorIndicesParse;
	}

}
