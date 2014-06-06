package parse.controle;

import modelo.beans.Cargo;
import modelo.dao.CargoDAO;
import parse.indices.IndicesParse;

public class CargoParseControle extends ParseControle<Cargo> {

	public CargoParseControle(IndicesParse<Cargo> indicesParse) {
		super(indicesParse, new CargoDAO());
	}

	@Override
	public Cargo novaInstancia() {
		Cargo cargo = new Cargo();
		return cargo;
	}

	@Override
	public boolean iguais(Cargo objetoUm, Cargo objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
