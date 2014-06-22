package teste.servlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import teste.TemplateTeste;
import controle.servlet.SelecionarCandidato;

public class SelecionarCandidatoTeste extends TemplateTeste {

	SelecionarCandidato selecionarCandidato;
	HttpServletRequest req;
	HttpServletResponse res;

	@Test
	public void simulaServlet() throws Exception {
		when(req.getParameter("tituloEleitoral")).thenReturn("002143582054");
		
		this.selecionarCandidato.executa(req, res);
		
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
	}

	@Override
	public void beforeTest() throws Exception {
		this.selecionarCandidato = new SelecionarCandidato();
		
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		
		this.req = mock(HttpServletRequest.class);
		this.res = mock(HttpServletResponse.class);
	}

	@Override
	public void afterTest() throws Exception {
	}
}
