package controle;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

public class PartidoControler {
	
	private PartidoDAO partidoDAO;
	
	public PartidoControler() {
		this.partidoDAO = new PartidoDAO();
	}
	
	public LinkedList<Partido> getListaPartidos() throws SQLException {
		return this.partidoDAO.getListaPartidos();
	}

}
