package parse.controle;

import modelo.beans.Fornecedor;
import modelo.dao.FornecedorDAO;
import parse.indices.IndicesParse;

public class FornecedorParseControle extends ParseControle<Fornecedor> {

	public FornecedorParseControle(IndicesParse<Fornecedor> indicesParse) {
		super(indicesParse, new FornecedorDAO());
	}

	@Override
	public Fornecedor novaInstancia() {
		Fornecedor fornecedor = new Fornecedor();
		return fornecedor;
	}
	
}
