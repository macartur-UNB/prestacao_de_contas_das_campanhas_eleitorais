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
	public void deveRecuperarUmaListaDePartidos() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido1 = new Partido();
		partido1.setNome("Partido da Social Democracia Brasileira");
		partido1.setSigla("PSDB");
		partido1.setDeferimento("24.8.1989");
		partido1.setNumero("45");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("Partido dos Trabalhadores");
		partido2.setSigla("PT");
		partido2.setDeferimento("11.2.1982");
		partido2.setNumero("13");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		this.partidoDAO.getLista();
		this.partidoControle.getListaPartidos();
		
		Assert.assertEquals(listaPartidos, this.partidoControle.getListaPartidos());
		
	}
}
