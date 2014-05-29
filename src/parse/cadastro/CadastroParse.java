package parse.cadastro;

import parse.ParseException;
import parse.controle.ParseControle;
import parse.indices.IndicesParse;

public abstract class CadastroParse<O> {

	public static final Integer LINHAS_PARA_FAZER_CADASTRO = 10000;
	
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
	
	protected abstract IndicesParse<O> getIndicesParse(String tipoArquivo, String ano) throws ParseException;
	
}
















