package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Despesa;
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
	public void valoresComparacaoParteI() throws Exception {
		//DoadorDAO.Comparacao.valueOf(DoadorDAO.Comparacao.NOME.toString());
		
		Doador D1 = new Doador();
		Doador D2 = new Doador();
		D1.setCpf_cnpj("123");
		D2.setCpf_cnpj("123");
		int resultado;

		resultado = DoadorDAO.Comparacao.CPF_E_NOME.compare(D1, D2);
		
		Assert.assertEquals(0,resultado);
		
	}
	
	@Test
	public void valoresComparacaoParteII() throws Exception {
		//DoadorDAO.Comparacao.valueOf(DoadorDAO.Comparacao.NOME.toString());
		
		Doador D1 = new Doador();
		Doador D2 = new Doador();
		D1.setCpf_cnpj("124");
		D2.setCpf_cnpj("125");
		int resultado;

		resultado = DoadorDAO.Comparacao.CPF_E_NOME.compare(D1, D2);
		
		Assert.assertEquals(-1,resultado);
		
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
	

}
