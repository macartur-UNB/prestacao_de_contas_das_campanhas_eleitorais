package teste.modelo.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.beans.Partido;
import modelo.dao.CandidatoDAO;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class CandidatoDAOTeste extends TemplateTeste {

	private CandidatoDAO candidatoDAO;
	private Partido partidoCadastrado;
	private PartidoDAO partidoDAO;
	
	@Override
	public void beforeTest() throws Exception {
		this.candidatoDAO = new CandidatoDAO();
		this.partidoDAO = new PartidoDAO();
		cadastrarPartido();		
	}

	@Override
	public void afterTest() {
		
	}
	
	@Test
	public void valoresComparacao() throws Exception {
		CandidatoDAO.Comparacao.valueOf(CandidatoDAO.Comparacao.NOME.toString());
	}
	
	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmCandidatoInexistente() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("candidato inexistente");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
	}
	
	@Test
	public void deveRecuperarUmCandidatoPeloNomeEAno() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("candidato existente");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
		
		Assert.assertEquals(candidato, this.candidatoDAO.getUmCandidato("candidato existente", 1990));
	}
	
	@Test
	public void naoDeveCadastrarUmCandidatoJaExistente() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("candidato inexistente");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		this.candidatoDAO.cadastrarLista(listaCandidatos);
		
		Assert.assertEquals(1, this.candidatoDAO.getLista().size());
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmCandidatoSemPartido() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("candidato inexistente");
		candidato.setAno(1990);
		listaCandidatos.add(candidato);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
	}
	
	@Test
	public void deveRecuperarUmaListaComOsCandidatosCadastrados() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		Candidato candidato = new Candidato();
		candidato.setNome("candidato inexistente");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);
		
		candidato = new Candidato();
		candidato.setNome("candidato inexistente dois");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		Assert.assertEquals(listaCandidatos, candidatoDAO.getLista());
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoTentarPegarAListaDeCandidatosSeAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.candidatoDAO.getLista().size();
	}
	
	@Test
	public void verificarSeUmCandidatoExiste() throws SQLException{
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		Candidato candidato = new Candidato();
		candidato.setNome("Fulano");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		listaCandidatos.add(candidato);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		assertTrue(candidato.existe());

	}

	@Test
	public void verificarQueUmCandidatoNaoExiste() throws SQLException{
		Candidato candidato = new Candidato();
		candidato.setNome("Fulano");
		candidato.setAno(1990);
		candidato.setPartido(this.partidoCadastrado);
		assertFalse(candidato.existe());
	}
	
	private void cadastrarPartido() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		this.partidoCadastrado = new Partido();
		this.partidoCadastrado.setSigla("A");
		this.partidoCadastrado.setNumero("1");
		listaPartidos.add(this.partidoCadastrado);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
	}

}
