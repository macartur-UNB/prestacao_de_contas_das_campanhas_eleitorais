package teste.modelo.dao;

import java.util.ArrayList;

import modelo.beans.Fornecedor;
import modelo.dao.FornecedorDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class FornecedorDAOTeste extends TemplateTeste {

	private FornecedorDAO fornecedorDAO;
	
	@Override
	public void beforeTest() throws Exception {
		this.fornecedorDAO = new FornecedorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void valoresComparacao() throws Exception {
		
		Fornecedor F1 = new Fornecedor();
		Fornecedor F2 = new Fornecedor();
		F1.setNome("FORNECEDOR UM");
		F2.setNome("FORNECEDOR UM");
		int resultado;

		resultado = FornecedorDAO.Comparacao.NOME.compare(F1, F2);
		
		Assert.assertEquals(0,resultado);
	}
	
	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmFornecedorInexistente() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		listaFornecedores.add(fornecedor);
		
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
	}
	
	@Test
	public void naoDeveCadastrarUmFornecedorJaExistente() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		listaFornecedores.add(fornecedor);

		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		
		Assert.assertEquals(1, this.fornecedorDAO.getLista().size());
	}
	
	@Test
	public void deveRecuperarUmaListaComOsFornecedoresCadastrados() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Nome");
		fornecedor.setCpf_cnpj("123");
		fornecedor.setSituacaoCadastral("Cadastrado");
		fornecedor.setUf("DF");
		listaFornecedores.add(fornecedor);
		
		fornecedor = new Fornecedor();
		fornecedor.setNome("Nome2");
		fornecedor.setCpf_cnpj("1234");
		fornecedor.setSituacaoCadastral("Cadastrado");
		fornecedor.setUf("DF");
		listaFornecedores.add(fornecedor);

		this.fornecedorDAO.cadastrarLista(listaFornecedores);
		Assert.assertEquals(listaFornecedores, this.fornecedorDAO.getLista());
	}
	
	@Test
	public void deveRecuperarUmFornecedorPeloNomeOuCpfCnpj() throws Exception {
		
		ArrayList<Fornecedor> listaFornecedoresACadastrar = new ArrayList<>();
		Fornecedor fornecedorRecuperado;
		
		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setNome("nome");
		fornecedor1.setCpf_cnpj("123456");
		fornecedor1.setSituacaoCadastral("REGULAR");
		fornecedor1.setUf("DF");
		listaFornecedoresACadastrar.add(fornecedor1);
		
		Fornecedor fornecedor2 = new Fornecedor();
		fornecedor2.setNome("nome2");
		fornecedor2.setCpf_cnpj("12345678");
		fornecedor2.setSituacaoCadastral("IRREGULAR");
		fornecedor2.setUf("DF");
		listaFornecedoresACadastrar.add(fornecedor2);
		
		this.fornecedorDAO.cadastrarLista(listaFornecedoresACadastrar);
		fornecedorRecuperado = this.fornecedorDAO.getPeloNomeOuCpfCnpj(fornecedor1);
		
		Assert.assertEquals(fornecedor1, fornecedorRecuperado);
		
	}
}
