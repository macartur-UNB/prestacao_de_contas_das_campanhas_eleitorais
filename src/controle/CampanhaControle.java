package controle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public Campanha getPeloAnoNumeroCodCargoEUf(Campanha campanha) throws SQLException {
		return this.campanhaDAO.getPeloAnoNumeroCodCargoEUf(campanha);
	}
	
	public int geraIndiceDaLista(List<Campanha> lista, int divisor) {
		int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
		return indice;
	}
	
	public int geraIndiceDePaginacao(List<Campanha> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
