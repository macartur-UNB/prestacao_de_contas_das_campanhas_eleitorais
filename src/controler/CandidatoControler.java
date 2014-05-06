package controler;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import dao.CandidatoDAO;

public class CandidatoControler {

	private CandidatoDAO candidatoDAO;
	
	public CandidatoControler() {
		this.candidatoDAO = new CandidatoDAO();
	}
	
	public ArrayList<Candidato> getListaCandidatos() throws SQLException {
		return this.candidatoDAO.getListaCandidatos();
	}
	
	
	
}