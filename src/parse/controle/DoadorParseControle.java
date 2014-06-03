package parse.controle;

import modelo.beans.Doador;
import parse.indices.IndicesParse;

public class DoadorParseControle extends ParseControle<Doador> {

	public DoadorParseControle(IndicesParse<Doador> indicesParse) {
		super(indicesParse, null);
	}

	@Override
	public Doador novaInstancia() {
		Doador doador = new Doador();
		return doador;
	}

	@Override
	public boolean iguais(Doador objetoUm, Doador objetoDois) {
		return objetoUm.equals(objetoDois);
	}	
	
}
