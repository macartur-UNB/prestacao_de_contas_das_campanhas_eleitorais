package parse.controle;

import modelo.beans.Doador;
import modelo.dao.DoadorDAO;
import parse.indices.IndicesParse;

public class DoadorParseControle extends ParseControle<Doador> {

	public DoadorParseControle(IndicesParse<Doador> indicesParse) {
		super(indicesParse, new DoadorDAO());
	}

	@Override
	public Doador novaInstancia() {
		Doador doador = new Doador();
		return doador;
	}	
	
}
