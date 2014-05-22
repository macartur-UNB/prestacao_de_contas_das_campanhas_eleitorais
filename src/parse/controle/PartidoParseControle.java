package parse.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.BasicoDAO;
import modelo.dao.PartidoDAO;
import parse.indices.IndicesParse;
import parse.indices.PartidoIndicesParse;

public class PartidoParseControle extends ParseControle<Partido> {

	public PartidoParseControle(IndicesParse<Partido> indicesParse) {
		super(indicesParse, new PartidoDAO());
	}

	@Override
	public Partido novaInstancia() {
		Partido partido = new Partido();
		return partido;
	}
	
}
