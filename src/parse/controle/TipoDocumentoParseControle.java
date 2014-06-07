package parse.controle;

import modelo.beans.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;
import parse.indices.IndicesParse;

public class TipoDocumentoParseControle extends ParseControle<TipoDocumento> {

	public TipoDocumentoParseControle(IndicesParse<TipoDocumento> indicesParse) {
		super(indicesParse, new TipoDocumentoDAO());
	}

	@Override
	public TipoDocumento novaInstancia() {
		TipoDocumento tipoDocumento = new TipoDocumento();
		return tipoDocumento;
	}

	@Override
	public boolean iguais(TipoDocumento objetoUm, TipoDocumento objetoDois) {
		return objetoUm.equals(objetoDois);
	}

}
