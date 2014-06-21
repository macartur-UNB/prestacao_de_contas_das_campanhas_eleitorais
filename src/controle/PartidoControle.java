package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

public class PartidoControle {
	
	private PartidoDAO partidoDAO;
	
	public PartidoControle() {
		this.partidoDAO = new PartidoDAO();
	}
	
	public ArrayList<Partido> getListaTodosPartidos() throws SQLException {
		return this.partidoDAO.getLista();
	}
	
	public Partido getPelaSigla(String sigla) throws SQLException {
		return this.partidoDAO.getPelaSigla(sigla);
	}
	
	public Partido getPeloNumero(String numero) throws SQLException {
		return this.partidoDAO.getPeloNumero(numero);

	}

	public int geraIndiceDaLista(List<Partido> lista, int divisor) {
		int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
		return indice;
	}
	
	public int geraIndiceDePaginacao(List<Partido> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
	
}
