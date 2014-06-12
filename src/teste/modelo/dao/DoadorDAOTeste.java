package teste.modelo.dao;

import java.util.ArrayList;

import modelo.beans.Doador;
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
	public void valoresComparacaoParteI() throws Exception {
		
		Doador D1 = new Doador();
		Doador D2 = new Doador();
		D1.setCpf_cnpj("1234567");
		D2.setCpf_cnpj("1234567");
		int resultado;

		resultado = DoadorDAO.Comparacao.NOME.compare(D1, D2);
		
		Assert.assertEquals(0,resultado);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmDoadorInexistente() throws Exception {
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
		listaDoadores.add(doador);
		
		this.doadorDAO.cadastrarLista(listaDoadores);
	}
	
	@Test
	public void naoDeveCadastrarUmDoadorJaExistente() throws Exception {
		ArrayList<Doador> listaDoadores = new ArrayList<>();
		
		Doador doador = new Doador();
		doador.setNome("Nome");
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
		doador.setCpf_cnpj("123");
		doador.setSituacaoCadastral("Cadastrado");
		doador.setUf("DF");
		listaDoadores.add(doador);
		
		doador = new Doador();
		doador.setNome("Nome2");
		doador.setCpf_cnpj("1234");
		doador.setSituacaoCadastral("Cadastrado");
		doador.setUf("DF");
		listaDoadores.add(doador);

		this.doadorDAO.cadastrarLista(listaDoadores);
		Assert.assertEquals(listaDoadores, this.doadorDAO.getLista());
	}
	

}
