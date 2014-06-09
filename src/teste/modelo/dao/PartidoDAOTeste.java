package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.beans.Resultado;
import modelo.dao.PartidoDAO;
import modelo.dao.ResultadoDAO;

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
		// PartidoDAO.Comparacao.valueOf(PartidoDAO.Comparacao.SIGLA.toString());

		Partido P1 = new Partido();
		Partido P2 = new Partido();
		P1.setNumero(123);
		P2.setNumero(123);
		int resultado;

		resultado = PartidoDAO.Comparacao.NUMERO.compare(P1, P2);

		Assert.assertEquals(0, resultado);

	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmPartidoInexistente()
			throws Exception {

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

	@Test(expected = SQLException.class)
	//Consertar teste! OBS.: NAO replicar este teste para outras classes de teste
	public void deveLancarExcecaoAoTentarPegarAListaDePartidosSeAConexaoComOBancoNaoForSucedida()
			throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.partidoDAO.getLista().size();
	}

	@Test
	public void testeGetPelaSigla() throws SQLException {
		partidoDAO.getPelaSigla(null);
		// Necessita testar o loop while
	}

	@Test
	public void testeGetPelaNumero() throws SQLException {
		partidoDAO.getPeloNumero(null);
		// Necessita testar o loop while
	}

	@Test
	public void naoDeveAcharPartidoPeloNumero() throws SQLException {

		ArrayList<Partido> lista = new ArrayList<>();

		Partido p1 = new Partido();
		p1.setNumero(1);
		p1.setNome("Resultado 1");
		lista.add(p1);

		Partido p2 = new Partido();
		p2.setNumero(2);
		p2.setNome("Resultado 2");
		lista.add(p2);

		this.partidoDAO.cadastrarLista(lista);

		Partido p3 = new Partido();
		p3 = this.partidoDAO.getPeloNumero("5");
		Assert.assertNotEquals(p1, p3);

	}

	@Test
	public void deveRecuperarUmPartidoPeloNumero() throws SQLException {

		ArrayList<Partido> lista = new ArrayList<>();

		Partido p1 = new Partido();
		p1.setNumero(1);
		p1.setNome("Resultado 1");
		lista.add(p1);

		Partido p2 = new Partido();
		p2.setNumero(2);
		p2.setNome("Resultado 2");
		lista.add(p2);

		this.partidoDAO.cadastrarLista(lista);

		Partido p3 = new Partido();
		p3 = this.partidoDAO.getPeloNumero("1");
		Assert.assertEquals(p1, p3);

	}
	
	@Test
	public void naoDeveAcharPartidoPeloSigla() throws SQLException {

		ArrayList<Partido> lista = new ArrayList<>();

		Partido p1 = new Partido();
		p1.setNumero(1);
		p1.setNome("Resultado 1");
		p1.setSigla("PT");
		lista.add(p1);

		Partido p2 = new Partido();
		p2.setNumero(2);
		p2.setNome("Resultado 2");
		p1.setSigla("PT do B");
		lista.add(p2);

		this.partidoDAO.cadastrarLista(lista);

		Partido p3 = new Partido();
		p3 = this.partidoDAO.getPelaSigla("PSDB");
		Assert.assertNotEquals(p1, p3);

	}

	@Test
	public void deveRecuperarUmPartidoPeloSigla() throws SQLException {

		ArrayList<Partido> lista = new ArrayList<>();

		Partido p1 = new Partido();
		p1.setNumero(1);
		p1.setNome("Resultado 1");
		p1.setSigla("PT");
		lista.add(p1);

		Partido p2 = new Partido();
		p2.setNumero(2);
		p2.setNome("Resultado 2");
		p1.setSigla("PT do B");
		lista.add(p2);

		this.partidoDAO.cadastrarLista(lista);

		Partido p3 = new Partido();
		p3 = this.partidoDAO.getPelaSigla("PT do B");
		Assert.assertEquals(p1, p3);

	}
	

}
