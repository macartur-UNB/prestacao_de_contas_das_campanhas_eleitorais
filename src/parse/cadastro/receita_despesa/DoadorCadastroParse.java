package parse.cadastro.receita_despesa;

import modelo.beans.Doador;
import parse.ParseException;
import parse.controle.DoadorParseControle;
import parse.controle.ParseControle;
import parse.indices.DoadorIndicesParse;
import parse.indices.IndicesParse;

public class DoadorCadastroParse extends CadastroParseReceitasDespesas<Doador> {

	public DoadorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);

	}

	@Override
	public ParseControle<Doador> novaInstancia(IndicesParse<Doador> indicesParse) {
		DoadorParseControle doadorParseControle = new DoadorParseControle(indicesParse);
		return doadorParseControle;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2002() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(6);
		doadorIndicesParse.setIndiceNome(8);
		doadorIndicesParse.setIndiceUf(7);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2006() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(16);
		doadorIndicesParse.setIndiceNome(15);
		doadorIndicesParse.setIndiceUf(17);
		doadorIndicesParse.setIndiceSituacaoCadastral(18);
		
		return doadorIndicesParse;
	}
	
	public DoadorIndicesParse getIndicesParseReceita2010() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceCpf_Cnpj(10);
		doadorIndicesParse.setIndiceNome(11);
		
		return doadorIndicesParse;
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2002() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2006() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2010() {
		return new DoadorIndicesParse();
	}

}
