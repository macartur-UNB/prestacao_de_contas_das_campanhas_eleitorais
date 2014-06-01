package parse.controle;

import modelo.beans.Resultado;
import modelo.dao.ResultadoDAO;
import parse.indices.IndicesParse;

public class ResultadoParseControle extends ParseControle<Resultado> {

	public ResultadoParseControle(IndicesParse<Resultado> indicesParse) {
		super(indicesParse, new ResultadoDAO());
	}

	@Override
	public Resultado novaInstancia() {
		Resultado resultado = new Resultado();
		return resultado;
	}

	@Override
	public boolean iguais(Resultado objetoUm, Resultado objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
