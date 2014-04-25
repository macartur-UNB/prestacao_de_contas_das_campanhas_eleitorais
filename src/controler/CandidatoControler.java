package controler;

import java.sql.SQLException;
import java.util.LinkedList;

import model.Candidato;
import dao.CandidatoDAO;

public class CandidatoControler {

	private CandidatoDAO candidatoDAO;
	
	public CandidatoControler() {
		this.candidatoDAO = new CandidatoDAO();
	}
	
	public LinkedList<Candidato> getListaCandidatos() throws SQLException {
		return this.candidatoDAO.getListaCandidatos();
	}
	
	
	
}
