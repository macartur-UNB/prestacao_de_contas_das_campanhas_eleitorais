package controle;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.dao.CampanhaDAO;

public class CampanhaControle {
	
	private CampanhaDAO campanhaDAO;

	public CampanhaControle() {
		this.campanhaDAO = new CampanhaDAO();
	}
	
	public ArrayList<Campanha> getListaCampanhas(Candidato candidato) throws SQLException {
		return this.campanhaDAO.getCampanhasPeloTituloEleitoral(candidato);
	}
	
	public ArrayList<Campanha> getListaCampanhasPorSiglaPartidoEAno(String sigla, String ano) throws SQLException{
		return this.campanhaDAO.getCampanhasPorSiglaEAno(sigla,ano);
	}
	
	public ArrayList<Campanha> topFivePorCargoEAno(String cargo, Integer ano) throws SQLException{
		return this.campanhaDAO.TopFive(cargo, ano);
	}

	public Campanha getPeloAnoNumeroCodCargoEUf(Campanha campanha) throws SQLException {
		return this.campanhaDAO.getPeloAnoNumeroCodCargoEUf(campanha);
	}
	

}
