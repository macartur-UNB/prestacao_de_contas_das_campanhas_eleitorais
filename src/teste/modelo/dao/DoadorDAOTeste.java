package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Doador;
import modelo.dao.DespesaDAO;
import modelo.dao.DoadorDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class DoadorDAOTeste extends TemplateTeste {

	private DoadorDAO doadorDAO;
	
	@Override
	public void beforeTest() throws Exception {
		this.doadorDAO = new DoadorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void valoresComparacao() throws Exception {
		DoadorDAO.Comparacao.valueOf(DoadorDAO.Comparacao.NOME.toString());
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmDoadorInexistente() throws Exception {
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		doador.setPessoaJuridica(true);
		doador.setCadastroNacional("123");
		listaDoadores.add(doador);
		
		this.doadorDAO.cadastrarLista(listaDoadores);
	}
	
	@Test
	public void naoDeveCadastrarUmDoadorJaExistente() throws Exception {
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		doador.setPessoaJuridica(true);
		doador.setCadastroNacional("123");
		listaDoadores.add(doador);

		this.doadorDAO.cadastrarLista(listaDoadores);
		this.doadorDAO.cadastrarLista(listaDoadores);
		
		Assert.assertEquals(1, this.doadorDAO.getLista().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsDoadoresCadastrados() throws Exception {
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		doador.setPessoaJuridica(true);
		doador.setCadastroNacional("123");
		listaDoadores.add(doador);
		
		doador = new Doador();
		doador.setNome("Nome");
		doador.setPessoaJuridica(true);
		doador.setCadastroNacional("123");
		listaDoadores.add(doador);

		this.doadorDAO.cadastrarLista(listaDoadores);
		Assert.assertEquals(listaDoadores, this.doadorDAO.getLista());
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoTentarPegarAListaDeDoadoresSeAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.doadorDAO.getLista().size();
	}

}
