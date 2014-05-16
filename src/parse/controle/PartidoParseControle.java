package parse.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;
import parse.indices.PartidoIndicesParse;

public class PartidoParseControle {

	private PartidoIndicesParse partidoIndicesParse;
	private ArrayList<Partido> listaPartidos;
	private PartidoDAO partidoDAO;
	
	public PartidoParseControle(PartidoIndicesParse partidoIndicesParse) {
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
