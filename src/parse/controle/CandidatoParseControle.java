package parse.controle;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;
import parse.indices.IndicesParse;

public class CandidatoParseControle extends ParseControle<Candidato> {

	public CandidatoParseControle(IndicesParse<Candidato> indicesParse) {
		super(indicesParse, new CandidatoDAO());
	}
	
	@Override
	public Candidato novaInstancia() {
		Candidato candidato = new Candidato();
		return candidato;
	}

}