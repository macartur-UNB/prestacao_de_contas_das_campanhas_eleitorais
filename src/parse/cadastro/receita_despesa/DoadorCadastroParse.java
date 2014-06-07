package parse.cadastro.receita_despesa;

import modelo.beans.Doador;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.DoadorParseControle;
import parse.controle.ParseControle;
import parse.indices.DoadorIndicesParse;
import parse.indices.IndicesParse;

public class DoadorCadastroParse extends CadastroParse<Doador> {
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2010 = "2010";
	public static final String RECEITA = "receita";


	public DoadorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<Doador> novaInstancia(IndicesParse<Doador> indicesParse) {
		DoadorParseControle doadorParseControle = new DoadorParseControle(indicesParse);
		return doadorParseControle;
	}

	@Override
	protected IndicesParse<Doador> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		switch(ano) {
		case ANO_2002:
			return getDoadorIndicesParse2002();
			
		case ANO_2006:
			return getDoadorIndicesParse2006();
			
		case ANO_2010:
			return getDoadorIndicesParse2010();
			
		default:
			return null;
		}
		
	}
	
	public DoadorIndicesParse getDoadorIndicesParse2002() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(6);
		doadorIndicesParse.setIndiceNome(8);
		doadorIndicesParse.setIndiceUf(7);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getDoadorIndicesParse2006() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(16);
		doadorIndicesParse.setIndiceNome(15);
		doadorIndicesParse.setIndiceUf(17);
		doadorIndicesParse.setIndiceSituacaoCadastral(18);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getDoadorIndicesParse2010() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(10);
		doadorIndicesParse.setIndiceNome(11);
		
		return doadorIndicesParse;
	}

}
