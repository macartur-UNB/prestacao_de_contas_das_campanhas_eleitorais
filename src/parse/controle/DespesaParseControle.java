package parse.controle;

import modelo.beans.Despesa;
import modelo.dao.DespesaDAO;
import parse.indices.IndicesParse;

public class DespesaParseControle extends ParseControle<Despesa> {

	public DespesaParseControle(IndicesParse<Despesa> indicesParse) {
		super(indicesParse, new DespesaDAO());
	}

	@Override
	public Despesa novaInstancia() {
		Despesa despesa = new Despesa();
		return despesa;
	}

	
}
