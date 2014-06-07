package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.ParseException;
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
	public void deveRecuperarUmaListaDePartidos() throws SQLException, ParseException {
		
		/*ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido1 = new Partido();
		partido1.setNome("PARTIDO EXISTENTE 1");
		partido1.setSigla("PE1");
		partido1.setNumero("46");
		partido1.setDeferimento("15.8.1996");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("PARTIDO EXISTENTE 2");
		partido2.setSigla("PE2");
		partido1.setNumero("78");
		partido1.setDeferimento("15.4.1995");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		this.partidoDAO.getLista();
		this.partidoControle.getListaPartidos();
		
		Assert.assertEquals(listaPartidos, this.partidoControle.getListaPartidos());*/
		
	}
	
	@Test
	public void deveRecuperarUmPartidoPelaSigla() throws SQLException {
		
		/*ArrayList<Partido> listaPartidos = new ArrayList<>();
		Partido partidoRecuperado = new Partido();
		
		Partido partido1 = new Partido();
		partido1.setNome("PARTIDO EXISTENTE 1");
		partido1.setSigla("PE1");
		partido1.setNumero("46");
		partido1.setDeferimento("15.8.1996");
		listaPartidos.add(partido1);
		
		Partido partido2 = new Partido();
		partido2.setNome("PARTIDO EXISTENTE 2");
		partido2.setSigla("PE2");
		partido1.setNumero("78");
		partido1.setDeferimento("15.4.1995");
		listaPartidos.add(partido2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		partidoRecuperado = this.partidoDAO.getPelaSigla("PE1");
		this.partidoControle.getPartido("PE1");
		
		Assert.assertEquals(partidoRecuperado, this.partidoControle.getPartido("PE1"));*/
	}
}
