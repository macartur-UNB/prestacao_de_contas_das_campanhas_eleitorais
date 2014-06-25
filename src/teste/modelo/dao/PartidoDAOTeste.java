package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class PartidoDAOTeste extends TemplateTeste {

	private PartidoDAO partidoDAO;

	@Override
	public void beforeTest() throws Exception {
		
		this.partidoDAO = new PartidoDAO();
	}

	@Override
	public void afterTest() throws Exception {

	}

	@Test
	public void valoresComparacao() throws Exception {

		Partido P1 = new Partido();
		Partido P2 = new Partido();
		P1.setSigla("AEIOU");
		P2.setSigla("AEIOU");
		int resultado;

		resultado = PartidoDAO.Comparacao.SIGLA.compare(P1, P2);

		Assert.assertEquals(0, resultado);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmPartidoInexistente() throws Exception {

		ArrayList<Partido> listaPartidos = new ArrayList<>();

		Partido partido = new Partido();
		partido.setNumero(1);
		partido.setSigla("A");
		partido.setDeferimento("11.2.1982");
		partido.setNome("AEIOU");
		listaPartidos.add(partido);

		this.partidoDAO.cadastrarLista(listaPartidos);
	}

	@Test
	public void naoDeveCadastrarUmPartidoJaCadastrado() throws Exception {

		ArrayList<Partido> listaPartidos = new ArrayList<>();

		Partido partido = new Partido();
		partido.setNumero(1);
		partido.setSigla("A");
		partido.setDeferimento("11.2.1982");
		partido.setNome("AEIOU");
		listaPartidos.add(partido);

		this.partidoDAO.cadastrarLista(listaPartidos);
		int numeroDePartidosNaLista = this.partidoDAO.getLista().size();

		this.partidoDAO.cadastrarLista(listaPartidos);

		Assert.assertEquals(numeroDePartidosNaLista, this.partidoDAO.getLista()
				.size());
	}

	@Test
	public void deveRecuperarUmPartidoPelaSigla() throws SQLException {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		Partido partidoRecuperado = new Partido();
		
		Partido p1 = new Partido();
		p1.setNumero(45);
		p1.setSigla("PI1");
		p1.setNome("PARTIDO INEXISTENTE 1");
		p1.setDeferimento("11.8.1996");
		listaPartidos.add(p1);
		
		Partido p2 = new Partido();
		p2.setNumero(23);
		p2.setSigla("PI2");
		p2.setNome("PARTIDO INEXISTENTE 2");
		p2.setDeferimento("11.8.1994");
		listaPartidos.add(p2);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		partidoRecuperado = this.partidoDAO.getPelaSigla("PI1");
		
		Assert.assertEquals(p1, partidoRecuperado);
	}

	@Test
	public void deveRecuperarUmPartidoPeloNumero() throws SQLException {
		
		partidoDAO.getPeloNumero(null);
	}
	
}
