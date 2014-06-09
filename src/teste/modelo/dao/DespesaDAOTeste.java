package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Despesa;
import modelo.beans.Fornecedor;
import modelo.dao.DespesaDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class DespesaDAOTeste extends TemplateTeste {
	
	private DespesaDAO despesaDAO;

	private Campanha campanhaCadastrada;
	private Fornecedor fornecedorCadastrado;
	
	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void valoresComparacaoParteI() throws Exception {
		//DespesaDAO.Comparacao.valueOf(DespesaDAO.Comparacao.NOME.toString());
		
		Despesa D1 = new Despesa();
		Despesa D2 = new Despesa();
		//D1.setAno(2010);
		//D2.setAno(2006);
		int resultado;

		resultado = DespesaDAO.Comparacao.ANO_E_NUMERO.compare(D1, D2);
		
		Assert.assertEquals(1,resultado);
	}
	
	@Test
	public void valoresComparacaoParteII() throws Exception {
		//DespesaDAO.Comparacao.valueOf(DespesaDAO.Comparacao.NOME.toString());
		
		Despesa D1 = new Despesa();
		Despesa D2 = new Despesa();
		D1.setAno(2010);
		D2.setAno(2010);
		D1.setNumeroDocumento("000");
		D2.setNumeroDocumento("000");
		int resultado;

		resultado = DespesaDAO.Comparacao.ANO_E_NUMERO.compare(D1, D2);
		
		Assert.assertEquals(0,resultado);
	}	

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmaDespesaInexistente() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setFornecedor(this.fornecedorCadastrado);
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}
	
	@Test
	public void naoDeveCadastrarUmaDespesaJaExistente() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setCampanha(this.campanhaCadastrada);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.campanhaCadastrada.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		Assert.assertEquals(1, this.despesaDAO.getLista().size());
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmaDespesaSemPessoa() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.campanhaCadastrada.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}
	
	@Test
	public void deveRecuperarUmaListaComAsDespesasCadastradas() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setCampanha(this.campanhaCadastrada);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.campanhaCadastrada.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		despesa = new Despesa();
		despesa.setCampanha(this.campanhaCadastrada);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.campanhaCadastrada.getAno());
		despesa.setNumeroDocumento("123454123");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		Assert.assertEquals(listaDespesas, this.despesaDAO.getLista());
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmaDespesaSemFornecedor() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setCampanha(this.campanhaCadastrada);
		despesa.setAno(this.campanhaCadastrada.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}

	@Override
	public void beforeTest() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
