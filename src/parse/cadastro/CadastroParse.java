package parse.cadastro;

import parse.ParseException;
import parse.controle.ParseControle;
import parse.indices.IndicesParse;

public abstract class CadastroParse<O> {

	protected int linhasLidas;
	protected int linhasParaFazerCadastro;
	
	protected IndicesParse<O> indicesParse;
	protected ParseControle<O> parseControle;
	
	public CadastroParse(String tipoArquivo, String ano) throws ParseException {
		this.linhasLidas = 0;
		this.linhasParaFazerCadastro = 1500;
		
		this.indicesParse = getIndicesParse(tipoArquivo, ano);
		this.parseControle = novaInstancia(this.indicesParse);
	}
	
	public void executarLinhaDoArquivo(String campo[]) throws ParseException {
		this.parseControle.addInstancia(campo);
		this.linhasLidas++;
		if(this.linhasLidas >= this.linhasParaFazerCadastro) {
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

	public int getLinhasParaFazerCadastro() {
		return linhasParaFazerCadastro;
	}

	public void setLinhasParaFazerCadastro(int linhasParaFazerCadastro) {
		this.linhasParaFazerCadastro = linhasParaFazerCadastro;
	}
	
}
















