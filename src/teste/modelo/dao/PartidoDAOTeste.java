package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

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
		PartidoDAO.Comparacao.valueOf(PartidoDAO.Comparacao.NOME.toString());
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmPartidoInexistente() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setNumeroPartido("1");
		partido.setSigla("A");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
	}

	@Test
	public void naoDeveCadastrarUmPartidoJaCadastrado() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setNumeroPartido("1");
		partido.setSigla("A");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		int numeroDePartidosCadastrados = this.partidoDAO.getListaPartidos().size();
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		
		Assert.assertEquals(numeroDePartidosCadastrados, this.partidoDAO.getListaPartidos().size());
	}
	
	@Test
	public void deveAtualizarUmPartidoComMesmaSiglaMasSemNumero() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setSigla("A");
		listaPartidos.add(partido);
		
		partido = new Partido();
		partido.setSigla("B");
		partido.setNumeroPartido("2");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		
		partido = new Partido();
		partido.setSigla("A");
		partido.setNumeroPartido("1");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		
		Assert.assertEquals(partido.getNumeroPartido(), this.partidoDAO.getListaPartidos().get(0).getNumeroPartido());
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoSeTiverDoisPartidosIguaisNaListaDeCadastro() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setSigla("A");
		partido.setNumeroPartido("2");
		listaPartidos.add(partido);
		
		partido = new Partido();
		partido.setSigla("A");
		partido.setNumeroPartido("2");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoTentarPegarAListaDePartidosSeAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.partidoDAO.getListaPartidos().size();
	}
	
	@Test
	public void deveRecuperarUmPartidoPelaSigla() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		Partido partido = new Partido();
		partido.setNumeroPartido("1");
		partido.setSigla("A");
		listaPartidos.add(partido);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
		
		Assert.assertEquals(partido, this.partidoDAO.getPartido("A"));
	}
	
	@Test
	public void deveRecuperarUmPartidoPelaSiglaComNomeESiglaVazio() throws Exception {
		Partido partido = new Partido();		
		Assert.assertEquals(partido, this.partidoDAO.getPartido("Sigla"));
	}

	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoRecuperarUmPartidoEAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.partidoDAO.getPartido("Sigla");
	}

}
