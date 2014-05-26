package parse.cadastro;

import modelo.beans.Doador;
import parse.ParseException;
import parse.controle.DoadorParseControle;
import parse.controle.ParseControle;
import parse.indices.DoadorIndicesParse;
import parse.indices.IndicesParse;

public class DoadorCadastroParse extends CadastroParse<Doador> {

	
	public DoadorCadastroParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
		
	}

	@Override
	public ParseControle<Doador> novaInstancia(IndicesParse<Doador> indicesParse) {
		return new DoadorParseControle(indicesParse);
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2002() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2004() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2006() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseDespesa2008() {
		return new DoadorIndicesParse();
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseReceita2002() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(8);
		doadorIndicesParse.setIndiceCadastroNacional(6);
		
		return doadorIndicesParse;
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseReceita2004() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(15);
		doadorIndicesParse.setIndiceCadastroNacional(16);
		return doadorIndicesParse;
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseReceita2006() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(15);
		doadorIndicesParse.setIndiceCadastroNacional(16);
		
		return doadorIndicesParse;
	}

	@Override
	protected IndicesParse<Doador> getIndicesParseReceita2008() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(19);
		doadorIndicesParse.setIndiceCadastroNacional(20);
		
		return doadorIndicesParse;
	}
	
}
