package parse.cadastro.campanha;

import modelo.beans.Campanha;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.CampanhaParseControle;
import parse.controle.ParseControle;
import parse.indices.CampanhaIndicesParse;
import parse.indices.IndicesParse;

public class CadastroCampanhaParse extends CadastroParse<Campanha> {

	public CadastroCampanhaParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
		
		setLinhasParaFazerCadastro(100000);
	}

	@Override
	public ParseControle<Campanha> novaInstancia(
			IndicesParse<Campanha> indicesParse) {
		CampanhaParseControle campanhaParseControle = new CampanhaParseControle(indicesParse);	
		return campanhaParseControle;
	}

	@Override
	protected IndicesParse<Campanha> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		CampanhaIndicesParse campanhaIndicesParse;
		campanhaIndicesParse = new CampanhaIndicesParse();
		
		campanhaIndicesParse.setIndiceAno(2);
		campanhaIndicesParse.setIndiceNumeroCandidato(12);
		campanhaIndicesParse.setIndiceNomeDeUrna(13);
		campanhaIndicesParse.setIndiceUf(5);
		campanhaIndicesParse.setIndiceCargoCod(8);
		campanhaIndicesParse.setIndiceCandidatoTitulo(26);
		campanhaIndicesParse.setIndicePartidoNumero(16);
		campanhaIndicesParse.setIndiceResultadoCod(40);
		campanhaIndicesParse.setIndiceDespesaMaxDeclarada(39);
	
		return campanhaIndicesParse;
	}
	
	@Override
	public void executarLinhaDoArquivo(String[] campo) throws ParseException {
		this.parseControle.addInstanciaIgual(campo);
		this.linhasLidas++;
		if(this.linhasLidas >= this.linhasParaFazerCadastro) {
			cadastrarInstancias();
		}
	}

}
