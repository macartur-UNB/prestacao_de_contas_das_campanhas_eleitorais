package controle;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

public class PartidoControle {
	
	private PartidoDAO partidoDAO;
	
	public PartidoControle() {
		this.partidoDAO = new PartidoDAO();
	}
	
	public LinkedList<Partido> getListaPartidos() throws SQLException {
		return this.partidoDAO.getListaPartidos();
	}
	
	public Partido getPartido(String sigla) throws SQLException {
		return this.partidoDAO.getPartido(sigla);
	}

}
