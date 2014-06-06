package parse.controle;

import modelo.beans.Campanha;
import modelo.dao.CampanhaDAO;
import parse.indices.IndicesParse;

public class CampanhaParseControle extends ParseControle<Campanha>{

	public CampanhaParseControle(IndicesParse<Campanha> indicesParse) {
		super(indicesParse, new CampanhaDAO());
	}

	@Override
	public Campanha novaInstancia() {
		Campanha campanha = new Campanha();
		return campanha;
	}

	@Override
	public boolean iguais(Campanha objetoUm, Campanha objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
