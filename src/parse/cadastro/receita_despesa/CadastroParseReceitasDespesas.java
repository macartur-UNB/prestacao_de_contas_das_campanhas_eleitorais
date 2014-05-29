package parse.cadastro.receita_despesa;

import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.indices.IndicesParse;

public abstract class CadastroParseReceitasDespesas<O> extends CadastroParse<O> {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";

	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	public CadastroParseReceitasDespesas(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	protected IndicesParse<O> getIndicesParse(String tipoArquivo, String ano)
			throws ParseException {
		if(tipoArquivo.equals(DESPESA)) {
			return getIndicesParseDespesa(ano);
		} else if (tipoArquivo.equals(RECEITA)) {
			return getIndicesParseReceita(ano);
		}
		
		throw new ParseException("Tipo do Arquivo, esta invalido!");
	}
	
	protected abstract IndicesParse<O> getIndicesParseDespesa2002();
	protected abstract IndicesParse<O> getIndicesParseDespesa2004();
	protected abstract IndicesParse<O> getIndicesParseDespesa2006();
	protected abstract IndicesParse<O> getIndicesParseDespesa2008();

	protected abstract IndicesParse<O> getIndicesParseReceita2002();
	protected abstract IndicesParse<O> getIndicesParseReceita2004();
	protected abstract IndicesParse<O> getIndicesParseReceita2006();
	protected abstract IndicesParse<O> getIndicesParseReceita2008();

	private IndicesParse<O> getIndicesParseDespesa(String ano) throws ParseException {
		switch (ano) {
		case ANO_2002:
			return getIndicesParseDespesa2002();
		case ANO_2004:
			return getIndicesParseDespesa2004();
		case ANO_2006:
			return getIndicesParseDespesa2006();
		case ANO_2008:
			return getIndicesParseDespesa2008();
		}
		throw new ParseException("Ano do arquivo, esta invalido!");
	}
	
	private IndicesParse<O> getIndicesParseReceita(String ano) throws ParseException {
		switch (ano) {
		case ANO_2002:
			return getIndicesParseReceita2002();
		case ANO_2004:
			return getIndicesParseReceita2004();
		case ANO_2006:
			return getIndicesParseReceita2006();
		case ANO_2008:
			return getIndicesParseReceita2008();
		}
		throw new ParseException("Ano do arquivo, esta invalido!");
	}
	
}
