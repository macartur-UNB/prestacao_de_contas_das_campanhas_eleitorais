package parse.controle;

import modelo.beans.Fornecedor;
import parse.indices.IndicesParse;

public class FornecedorParseControle extends ParseControle<Fornecedor> {

	public FornecedorParseControle(IndicesParse<Fornecedor> indicesParse) {
		super(indicesParse, null);
	}

	@Override
	public Fornecedor novaInstancia() {
		Fornecedor fornecedor = new Fornecedor();
		return fornecedor;
	}

	@Override
	public boolean iguais(Fornecedor objetoUm, Fornecedor objetoDois) {
		return objetoUm.equals(objetoDois);
	}
	
}
