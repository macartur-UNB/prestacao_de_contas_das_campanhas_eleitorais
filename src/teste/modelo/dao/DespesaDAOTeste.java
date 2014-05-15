package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Fornecedor;
import modelo.beans.Partido;
import modelo.dao.CandidatoDAO;
import modelo.dao.DespesaDAO;
import modelo.dao.FornecedorDAO;
import modelo.dao.PartidoDAO;
import teste.TemplateTeste;

public class DespesaDAOTeste extends TemplateTeste {
	
	private DespesaDAO despesaDAO;
	private PartidoDAO partidoDAO;
	private CandidatoDAO candidatoDAO;
	private FornecedorDAO fornecedorDAO;
	
	private Partido partidoCadastrado;
	private Candidato candidatoCadastrado;
	private Fornecedor fornecedorCadastrado;
	
	@Override
	public void beforeTest() throws Exception {
		this.despesaDAO = new DespesaDAO();
		this.partidoDAO = new PartidoDAO();
		this.candidatoDAO = new CandidatoDAO();
		this.fornecedorDAO = new FornecedorDAO();
		
		cadastrarPartido();
		cadastrarCandidato();
		cadastrarFornecedor();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmaDespesaInexistente() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}

	@Test
	public void deveRecuperarUmaListaDeDespesasPeloEmNomeDeEAno() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		ArrayList<Despesa> listaResultado = this.despesaDAO.getDespesasPorSelecao(DespesaDAO.EM_NOME_DE,
				this.candidatoCadastrado.getNome(), "2002");
		
		Assert.assertEquals(listaDespesas, listaResultado);
	}
	
	@Test
	public void deveRecuperarUmaListaDeDespesasPeloFornecedorDeEAno() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		ArrayList<Despesa> listaResultado = this.despesaDAO.getDespesasPorSelecao(DespesaDAO.FORNECEDOR,
				this.fornecedorCadastrado.getNome(), "2002");
		
		Assert.assertEquals(listaDespesas, listaResultado);
	}
	
	@Test
	public void naoDeveCadastrarUmaDespesaJaExistente() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
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
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}
	
	@Test
	public void deveRecuperarUmaListaComAsDespesasCadastradas() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454123");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		Assert.assertEquals(listaDespesas, this.despesaDAO.getLista());
	}
	
	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmaDespesaSemFornecedor() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
	}

	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoTentarRecuperarUmaListaDeDespesasPorUmCampoInvalido() throws Exception {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		
		Despesa despesa = new Despesa();
		despesa.setEmNomeDe(this.candidatoCadastrado);
		despesa.setFornecedor(this.fornecedorCadastrado);
		despesa.setAno(this.candidatoCadastrado.getAno());
		despesa.setNumeroDocumento("123454");
		listaDespesas.add(despesa);
		
		this.despesaDAO.cadastrarLista(listaDespesas);
		
		ArrayList<Despesa> listaResultado = this.despesaDAO.getDespesasPorSelecao("Campo Invalido",
				this.fornecedorCadastrado.getNome(), "2002");
	}
	
	@Test(expected = SQLException.class)
	public void deveLancarExcecaoAoTentarPegarAListaDeDespesasSeAConexaoComOBancoNaoForSucedida() throws Exception {
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_ERROR);
		this.despesaDAO.getLista();
	}
	
	private void cadastrarPartido() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();
		
		this.partidoCadastrado = new Partido();
		this.partidoCadastrado.setSigla("A");
		this.partidoCadastrado.setNumeroPartido("1");
		listaPartidos.add(this.partidoCadastrado);
		
		this.partidoDAO.cadastrarPartidos(listaPartidos);
	}
	
	private void cadastrarCandidato() throws Exception {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		
		this.candidatoCadastrado = new Candidato();
		this.candidatoCadastrado.setNome("Candidato");
		this.candidatoCadastrado.setAno(2002);
		this.candidatoCadastrado.setPartido(this.partidoCadastrado);
		listaCandidatos.add(this.candidatoCadastrado);
		
		this.candidatoDAO.cadastrarLista(listaCandidatos);
	}
	
	private void cadastrarFornecedor() throws Exception {
		ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
		
		this.fornecedorCadastrado = new Fornecedor();
		this.fornecedorCadastrado.setNome("Fornecedor");
		this.fornecedorCadastrado.setCadastroNacional("123456");
		this.fornecedorCadastrado.setPessoaJuridica(true);
		listaFornecedores.add(this.fornecedorCadastrado);
		
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
	}

}
