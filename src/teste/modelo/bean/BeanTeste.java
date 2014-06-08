package teste.modelo.bean;

import static org.junit.Assert.assertEquals;
import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Doador;
import modelo.beans.FormaPagamento;
import modelo.beans.Fornecedor;
import modelo.beans.MovimentacaoFinanceira;
import modelo.beans.Partido;
import modelo.beans.Receita;
import modelo.beans.Resultado;
import modelo.beans.TipoDocumento;
import modelo.beans.TipoMovimentacao;

import org.junit.Test;

public class BeanTeste {
	
	@Test
	public void equalsDeveRetornarVerdadeiroSeForemIguais() {
		Campanha campanha = instanciarCampanha();
		Campanha campanha2 = instanciarCampanha();
		assertEquals(true, campanha.equals(campanha2));
		
		Candidato candidato = instanciarCandidato();
		Candidato candidato2 = instanciarCandidato();
		assertEquals(true, candidato.equals(candidato2));
		
		Cargo cargo = instanciarCargo();
		Cargo cargo2 = instanciarCargo();
		assertEquals(true, cargo.equals(cargo2));
		
		Despesa despesa = instanciarDespesa();
		Despesa despesa2 = instanciarDespesa();
		assertEquals(true, despesa.equals(despesa2));
		
		Doador doador = instanciarDoador();
		Doador doador2 = instanciarDoador();
		assertEquals(true, doador.equals(doador2));
		
		FormaPagamento formaPagamento = instanciarFormaPagamento();
		FormaPagamento formaPagamento2 = instanciarFormaPagamento();
		assertEquals(true, formaPagamento.equals(formaPagamento2));
		
		Fornecedor fornecedor = instanciarFornecedor();
		Fornecedor fornecedor2 = instanciarFornecedor();
		assertEquals(true, fornecedor.equals(fornecedor2));
		
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		MovimentacaoFinanceira movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		assertEquals(true, movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		
		Partido partido = instanciarPartido();
		Partido partido2 = instanciarPartido();
		assertEquals(true, partido.equals(partido2));
		
		Receita receita = instanciarReceita();
		Receita receita2 = instanciarReceita();
		assertEquals(true, receita.equals(receita2));
		
		Resultado resultado = instanciarResultado();
		Resultado resultado2 = instanciarResultado();
		assertEquals(true, resultado.equals(resultado2));
		
		TipoDocumento tipoDocumento = instanciarTipoDocumento();
		TipoDocumento tipoDocumento2 = instanciarTipoDocumento();
		assertEquals (true, tipoDocumento.equals(tipoDocumento2));
		
		TipoMovimentacao tipoMovimentacao = instanciarTipoMovimentacao();
		TipoMovimentacao tipoMovimentacao2 = instanciarTipoMovimentacao();
		assertEquals (true, tipoMovimentacao.equals(tipoMovimentacao2));
		
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemDiferentes() {
		
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemDeClassesDistintas() {
		
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeCompararComNull() {
		
	}

	public TipoDocumento instanciarTipoDocumento() {
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setCodigo(10);
		tipoDocumento.setDescricao("Descricao Tipo Documento Teste");
		tipoDocumento.setId(10);
		
		return tipoDocumento;
	}
	
	public Fornecedor instanciarFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCpf_cnpj("CPF CNPJ Teste");
		fornecedor.setNome("Nome do Fornecedor Teste");
		fornecedor.setSituacaoCadastral("Situacao Cadastral Teste");
		fornecedor.setUf("UF Teste");
		
		return fornecedor;
	}
	
	public Candidato instanciarCandidato() {
		Candidato candidato = new Candidato();
		candidato.setNome("Nome do Candidato Teste");
		candidato.setTituloEleitoral("Titulo Eleitoral Teste");
		
		return candidato;
	}
	
	public Partido instanciarPartido() {
		Partido partido = new Partido();
		partido.setDeferimento("Deferimento Teste");
		partido.setNome("Nome do Partido Teste");
		partido.setNumero(50);
		partido.setSigla("Sigla Teste");
		
		return partido;
	}
	
	public Cargo instanciarCargo() {
		Cargo cargo = new Cargo();
		cargo.setCodigo(50);
		cargo.setDescricao("Descricao Cargo Teste");
		
		return cargo;
	}
	
	public Resultado instanciarResultado() {
		Resultado resultado = new Resultado();
		resultado.setCodigo(50);
		resultado.setDescricao("Descricao Resultado Teste");
		
		return resultado;
	}
	
	public Campanha instanciarCampanha() {
		Campanha campanha = new Campanha();
		campanha.setAno(50);
		campanha.setCandidato(instanciarCandidato());
		campanha.setCargo(instanciarCargo());
		campanha.setDespesaMaxDeclarada((float) 1000);
		campanha.setDespesaTotalCalculada((float) 1000);
		campanha.setId(50);
		campanha.setNomeDeUrna("Nome de Urna Teste");
		campanha.setNumeroCandidato(50);
		campanha.setPartido(instanciarPartido());
		campanha.setReceitaTotalCalculada((float) 1000);
		campanha.setResultado(instanciarResultado());
		campanha.setUf("UF Teste");
		
		return campanha;
	}
	
	public FormaPagamento instanciarFormaPagamento() {
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setCodigo(50);
		formaPagamento.setDescricao("Descricao Pagamento Teste");
		formaPagamento.setId(50);
		
		return formaPagamento;
	}
	
	public TipoMovimentacao instanciarTipoMovimentacao() {
		TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
		tipoMovimentacao.setCodigo(50);
		tipoMovimentacao.setDescricao("Descricao Movimentacao Teste");
		tipoMovimentacao.setId(50);
		
		return tipoMovimentacao;
	}
	
	public Despesa instanciarDespesa() {		
		Despesa despesa = new Despesa();
		despesa.setAno(50);
		despesa.setCampanha(instanciarCampanha());
		despesa.setData("Data Teste");
		despesa.setDescricao("Descricao Despesa Teste");
		despesa.setFormaPagamento(instanciarFormaPagamento());
		despesa.setFornecedor(instanciarFornecedor());
		despesa.setId(50);
		despesa.setNumeroDocumento("Numero Documento Teste");
		despesa.setTipoDocumento(instanciarTipoDocumento());
		despesa.setTipoMovimentacao(instanciarTipoMovimentacao());
		despesa.setValor((float) 1000);
		
		return despesa;
	}
	
	public Doador instanciarDoador() {
		Doador doador = new Doador();
		doador.setCpf_cnpj("CPF CNPJ Teste");
		doador.setNome("Nome do Doador Teste");
		doador.setSituacaoCadastral("Situacao Cadastral Teste");
		doador.setUf("UF Teste");
		
		return doador;
	}
	
	public MovimentacaoFinanceira instanciarMovimentacaoFinanceira() {
		MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
		movimentacaoFinanceira.setAno(50);
		movimentacaoFinanceira.setCampanha(instanciarCampanha());
		movimentacaoFinanceira.setData("Data Teste");
		movimentacaoFinanceira.setDescricao("Descricao Movimentacao Financeira Teste");
		movimentacaoFinanceira.setFormaPagamento(instanciarFormaPagamento());
		movimentacaoFinanceira.setId(50);
		movimentacaoFinanceira.setNumeroDocumento("Numero Documento Teste");
		movimentacaoFinanceira.setTipoMovimentacao(instanciarTipoMovimentacao());
		movimentacaoFinanceira.setValor((float) 1000);
		
		return movimentacaoFinanceira;
	}
	
	public Receita instanciarReceita() {
		Receita receita = new Receita();
		receita.setAno(50);
		receita.setCampanha(instanciarCampanha());
		receita.setData("Data Teste");
		receita.setDescricao("Descricao Receita Teste");
		receita.setDoador(instanciarDoador());
		receita.setFormaPagamento(instanciarFormaPagamento());
		receita.setId(50);
		receita.setNumeroDocumento("Numero Documento Teste");
		receita.setReciboEleitoral("Recibo Eleitoral Teste");
		receita.setTipoMovimentacao(instanciarTipoMovimentacao());
		receita.setValor((float)1000);
		
		return receita;
	}
	
}
