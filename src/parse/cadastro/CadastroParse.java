package parse.cadastro;

import parse.ParseException;
import parse.controle.ParseControle;
import parse.indices.IndicesParse;

public abstract class CadastroParse<O> {

	public static final Integer LINHAS_PARA_FAZER_CADASTRO = 10000;
	
	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";

	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;
	
	private IndicesParse<O> indicesParse;
	private ParseControle<O> parseControle;
	
	public CadastroParse(String tipoArquivo, String ano) throws ParseException {
		this.linhasLidas = 0;
		
		this.indicesParse = getIndicesParse(tipoArquivo, ano);
		this.parseControle = novaInstancia(this.indicesParse);
	}
	
	public void executarLinhaDoArquivo(String campo[]) throws ParseException {
		this.parseControle.addInstancia(campo);
		this.linhasLidas++;
		if(this.linhasLidas >= LINHAS_PARA_FAZER_CADASTRO) {
			cadastrarInstancias();
		}
	}
	
	public void cadastrarInstancias() throws ParseException {
		this.parseControle.cadastrarInstancias();
		this.parseControle.resetar();
		this.linhasLidas = 0;
	}
	
	public abstract ParseControle<O> novaInstancia(IndicesParse<O> indicesParse);
	
	protected abstract IndicesParse<O> getIndicesParseDespesa2002();
	protected abstract IndicesParse<O> getIndicesParseDespesa2004();
	protected abstract IndicesParse<O> getIndicesParseDespesa2006();
	protected abstract IndicesParse<O> getIndicesParseDespesa2008();

	protected abstract IndicesParse<O> getIndicesParseReceita2002();
	protected abstract IndicesParse<O> getIndicesParseReceita2004();
	protected abstract IndicesParse<O> getIndicesParseReceita2006();
	protected abstract IndicesParse<O> getIndicesParseReceita2008();
	
	private IndicesParse<O> getIndicesParse(String tipoArquivo, String ano) throws ParseException {
		if(tipoArquivo.equals(DESPESA)) {
			return getIndicesParseDespesa(ano);
		} else if (tipoArquivo.equals(RECEITA)) {
			return getIndicesParseReceita(ano);
		}
		
		throw new ParseException("Tipo do Arquivo, esta invalido!");
	}
	
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
















