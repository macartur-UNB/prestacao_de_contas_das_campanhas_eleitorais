package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import controle.PartidoControle;

public class PartidoControleTeste extends TemplateTeste {
	
	private PartidoDAO partidoDAO;
	private PartidoControle partidoControle;
	
	@Override
	public void beforeTest() throws Exception {
		this.partidoControle = new PartidoControle();
		this.partidoDAO = new PartidoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void deveRecuperarUmPartidoPelaSigla() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setNumero("13");
		partido.setSigla("PT");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		this.partidoDAO.getPartido("PT");
		this.partidoControle.getPartido("PT");
		
		Assert.assertEquals(partido, this.partidoControle.getPartido("PT"));
	}
	
	@Test
	public void deveRecuperarUmaListaDePartidos() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido1 = new Partido();
		partido1.setSigla("PSDB");
		partido1.setNumero("45");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setSigla("PT");
		partido2.setNumero("13");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		this.partidoDAO.getListaPartidos();
		this.partidoControle.getListaPartidos();
		
		Assert.assertEquals(listaPartidos, this.partidoControle.getListaPartidos());
		
	}
}
