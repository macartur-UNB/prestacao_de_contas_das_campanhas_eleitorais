package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

public class CandidatoControle {

	private CandidatoDAO candidatoDAO;
	
	public CandidatoControle() {
		this.candidatoDAO = new CandidatoDAO();
	}
	
	public ArrayList<Candidato> getListaCandidatos() throws SQLException {
		return this.candidatoDAO.getLista();
	}
	
	
	
}
