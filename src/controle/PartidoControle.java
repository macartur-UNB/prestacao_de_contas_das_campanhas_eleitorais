package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;
import modelo.dao.PartidoDAO.Comparacao;

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
