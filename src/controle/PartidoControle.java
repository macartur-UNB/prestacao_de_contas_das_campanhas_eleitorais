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
	
	public LinkedList<Partido> getListaPartidos(String sigla,String valor) throws SQLException {
		return this.partidoDAO.getListaPartidos(sigla,valor);
	}
	
	
	public LinkedList<Partido> getTodosPartidos() throws SQLException{
		return this.partidoDAO.getTodosPartidos();
	}
	
	
}
