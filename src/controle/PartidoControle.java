package controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

public class PartidoControle {
	
	private PartidoDAO partidoDAO;
	
	public PartidoControle() {
		this.partidoDAO = new PartidoDAO();
	}
	
	public ArrayList<Partido> getListaPartidos() throws SQLException {
		return this.partidoDAO.getLista();
	}
	
	public Partido getPartido(String sigla) throws SQLException {
		return null;
	}

}
