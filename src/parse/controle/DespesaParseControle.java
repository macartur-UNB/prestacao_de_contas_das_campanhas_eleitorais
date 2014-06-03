package parse.controle;

import modelo.beans.Despesa;
import parse.indices.IndicesParse;

public class DespesaParseControle extends ParseControle<Despesa> {

	public DespesaParseControle(IndicesParse<Despesa> indicesParse) {
		super(indicesParse, null);
	}

	@Override
	public Despesa novaInstancia() {
		Despesa despesa = new Despesa();
		return despesa;
	}

	@Override
	public boolean iguais(Despesa objetoUm, Despesa objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
