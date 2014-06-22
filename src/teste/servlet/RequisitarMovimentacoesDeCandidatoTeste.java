package teste.servlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import teste.TemplateTeste;
import controle.servlet.RequisitarMovimentacoesDeCandidato;

public class RequisitarMovimentacoesDeCandidatoTeste extends TemplateTeste {
	
	RequisitarMovimentacoesDeCandidato requisitarMovimentacoesDeCandidato;
	HttpServletRequest req;
	HttpServletResponse res;

	@Test
	public void simulaServletComVerTodosFalsoEQtdPorPaginaDiferenteDeZero() throws Exception {
		when(req.getParameter("ano")).thenReturn("2006");
		when(req.getParameter("numero_cand")).thenReturn("14789");
		when(req.getParameter("cargo_cod")).thenReturn("8");
		when(req.getParameter("uf")).thenReturn("DF");
		when(req.getParameter("inicioR")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaR")).thenReturn("10");
		when(req.getParameter("verTodosR")).thenReturn("false");
		when(req.getParameter("inicioD")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaD")).thenReturn("10");
		when(req.getParameter("verTodosD")).thenReturn("false");
		
		this.requisitarMovimentacoesDeCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComVerTodosVerdadeiroEQtdPorPaginaIgualAZero() throws Exception {
		when(req.getParameter("ano")).thenReturn("2006");
		when(req.getParameter("numero_cand")).thenReturn("14789");
		when(req.getParameter("cargo_cod")).thenReturn("8");
		when(req.getParameter("uf")).thenReturn("DF");
		when(req.getParameter("inicioR")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaR")).thenReturn("0");
		when(req.getParameter("verTodosR")).thenReturn("true");
		when(req.getParameter("inicioD")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaD")).thenReturn("0");
		when(req.getParameter("verTodosD")).thenReturn("true");
		
		this.requisitarMovimentacoesDeCandidato.executa(req, res);
	}
	
	@Test
	public void simulaServletComCandidatoInexistente() throws Exception {
		when(req.getParameter("ano")).thenReturn("2006");
		when(req.getParameter("numero_cand")).thenReturn("05");
		when(req.getParameter("cargo_cod")).thenReturn("8");
		when(req.getParameter("uf")).thenReturn("DF");
		when(req.getParameter("inicioR")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaR")).thenReturn("0");
		when(req.getParameter("verTodosR")).thenReturn("true");
		when(req.getParameter("inicioD")).thenReturn("0");
		when(req.getParameter("qtdPorPaginaD")).thenReturn("0");
		when(req.getParameter("verTodosD")).thenReturn("true");
		
		this.requisitarMovimentacoesDeCandidato.executa(req, res);
	}

	@Override
	public void beforeTest() throws Exception {
		this.requisitarMovimentacoesDeCandidato = new RequisitarMovimentacoesDeCandidato();
		
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		
		this.req = mock(HttpServletRequest.class);
		this.res = mock(HttpServletResponse.class);
	}

	@Override
	public void afterTest() throws Exception {
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
	}

}
