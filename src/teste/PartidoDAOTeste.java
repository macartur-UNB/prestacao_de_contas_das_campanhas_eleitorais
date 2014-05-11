package teste;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Partido;
import modelo.dao.ConexaoBancoDados;
import modelo.dao.PartidoDAO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidoDAOTeste {
	
	private static final String NOME_BANCO_OFICIAL = "gpp";
	private static final String LOCAL_BANCO_OFICIAL = "jdbc:mysql://";
	
	private static final String NOME_BANCO_TESTES = "banco_de_testes";
	private static final String LOCAL_BANCO_ERROR = "Erro na Conexao";
	
	private ConexaoBancoDados conexaoBancoDados;
	private PartidoDAO partidoDAO;

	@Before
	public void setUp() throws Exception {
		String diretorioSQL = new File("./lib/").getCanonicalPath();
		String arquivoSQL = diretorioSQL + "/MER_Parse_SQL.sql";		
		this.conexaoBancoDados = new ConexaoBancoDados();
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_OFICIAL);
		this.conexaoBancoDados.criarBanco(NOME_BANCO_TESTES);
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
		this.conexaoBancoDados.importarSQL(arquivoSQL);
		this.partidoDAO = new PartidoDAO();
	}

	@After
	public void tearDown() throws Exception {
		if(!this.conexaoBancoDados.getLocalBanco().equals(LOCAL_BANCO_ERROR)) {
			this.conexaoBancoDados.deletarBanco();
		}
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



















