package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Fornecedor;
import modelo.beans.Partido;
import modelo.dao.FornecedorDAO;
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
		//PartidoDAO.Comparacao.valueOf(PartidoDAO.Comparacao.SIGLA.toString());
		
		Partido P1 = new Partido();
		Partido P2 = new Partido();
		P1.setNumero(123);
		P2.setNumero(123);
		int resultado;

		resultado = PartidoDAO.Comparacao.NUMERO.compare(P1, P2);
		
		Assert.assertEquals(0,resultado);
		
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmPartidoInexistente() throws Exception {
		
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setNumero("1");
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
		partido.setNumero("1");
		partido.setSigla("A");
		partido.setDeferimento("11.2.1982");
		partido.setNome("AEIOU");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		int numeroDePartidosNaLista = this.partidoDAO.getLista().size();
		
		this.partidoDAO.cadastrarLista(listaPartidos);
		
		Assert.assertEquals(numeroDePartidosNaLista, this.partidoDAO.getLista().size());
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoSeTiverDoisPartidosIguaisNaListaDeCadastro() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setSigla("A");
		partido.setNumero("2");
		listaPartidos.add(partido);
		
		partido = new Partido();
		partido.setSigla("A");
		partido.setNumero("2");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarLista(listaPartidos);
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoTentarPegarAListaDePartidosSeAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.partidoDAO.getLista().size();
	}

	@Test
	public void testeGetPelaSigla(){
		partidoDAO.getPelaSigla(null);
		//Necessita testar o loop while
	}
	
	@Test
	public void testeGetPelaNumero(){
		partidoDAO.getPeloNumero(null);
		//Necessita testar o loop while
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoGetarPelaSiglaOuNumero() throws Exception {
		this.conexaoBancoDados.setLocalBanco(null);
		partidoDAO.getPelaSigla(null);
		partidoDAO.getPeloNumero(null);
	}
	
}
