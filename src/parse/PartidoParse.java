package parse;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.PartidoDAO;
import model.Partido;

public class PartidoParse {

	private PartidoIndicesParse partidoIndicesParse;
	private ArrayList<Partido> listaPartidos;
	private PartidoDAO partidoDAO;
	
	public PartidoParse(PartidoIndicesParse partidoIndicesParse) {
		this.partidoDAO = new PartidoDAO();
		this.listaPartidos = new ArrayList<>();
		this.partidoIndicesParse = partidoIndicesParse;
	}
	
	public void addPartido(String campo[]) {
		Partido partido = this.partidoIndicesParse.iniciarPartido(campo);
		if(!this.listaPartidos.contains(partido)) {
			this.listaPartidos.add(partido);
		}
	}
	
	public void cadastrarPartidos() throws SQLException {
		this.partidoDAO.cadastrarPartidos(this.listaPartidos);
	}
	
	public void resetar() {
		this.listaPartidos.clear();
	}
}
