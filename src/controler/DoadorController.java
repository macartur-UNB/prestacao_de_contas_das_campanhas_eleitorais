package controler;

import java.sql.SQLException;
import java.util.LinkedList;

import model.Doador;
import dao.DoadorDAO;


public class DoadorController {
	
	private DoadorDAO doadorDAO;

	public DoadorController() {
		this.doadorDAO = new DoadorDAO();
	}

	public LinkedList<Doador> getListaDoadores() throws SQLException {
		return this.doadorDAO.getListaDoadores();
	}
}
