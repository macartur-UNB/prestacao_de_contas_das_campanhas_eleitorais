package parse.controle;

import modelo.beans.Receita;
import modelo.dao.ReceitaDAO;
import parse.indices.IndicesParse;

public class ReceitaParseControle extends ParseControle<Receita> {

	public ReceitaParseControle(IndicesParse<Receita> indicesParse) {
		super(indicesParse, new ReceitaDAO());
	}

	@Override
	public Receita novaInstancia() {
		Receita receita = new Receita();
		return receita;
	}

	@Override
	public boolean iguais(Receita objetoUm, Receita objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
