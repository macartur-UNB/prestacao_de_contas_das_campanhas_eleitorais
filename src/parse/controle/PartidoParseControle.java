package parse.controle;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;
import parse.indices.IndicesParse;

public class PartidoParseControle extends ParseControle<Partido> {

	public PartidoParseControle(IndicesParse<Partido> indicesParse) {
		super(indicesParse, new PartidoDAO());
	}

	@Override
	public Partido novaInstancia() {
		Partido partido = new Partido();
		return partido;
	}

	@Override
	public boolean iguais(Partido objetoUm, Partido objetoDois) {
		return objetoUm.equals(objetoDois);
	}
	
}
