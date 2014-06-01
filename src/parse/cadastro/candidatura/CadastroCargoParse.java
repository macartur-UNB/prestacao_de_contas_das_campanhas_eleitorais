package parse.cadastro.candidatura;

import modelo.beans.Cargo;
import parse.ParseException;
import parse.cadastro.CadastroParse;
import parse.controle.CargoParseControle;
import parse.controle.ParseControle;
import parse.indices.CargoIndicesParse;
import parse.indices.IndicesParse;

public class CadastroCargoParse extends CadastroParse<Cargo> {
	
	public CadastroCargoParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Cargo> novaInstancia(
			IndicesParse<Cargo> indicesParse) {
		CargoParseControle cargoParseControle = new CargoParseControle(indicesParse);
		return cargoParseControle;
	}

	@Override
	protected IndicesParse<Cargo> getIndicesParse(String tipoArquivo,
			String ano) throws ParseException {
		
		CargoIndicesParse cargoIndicesParse;
		cargoIndicesParse = new CargoIndicesParse();
		
		cargoIndicesParse.setIndiceCodigo(8);
		cargoIndicesParse.setIndiceDescricao(9);
		
		return cargoIndicesParse;
	}

}
