package teste;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import model.Doador;

import org.junit.Before;
import org.junit.Test;

import dao.DoadorDAO;

public class DoadorDAOTeste {
	
	private DoadorDAO mockDoadorDAO;

	@Before
	public void setUp() {
		this.mockDoadorDAO = mock(DoadorDAO.class);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmDoadorNaoExistente() throws SQLException {
		Doador doador = new Doador();
		doador.setNome("Jose");
		doador.setCadastroNacional(012345);
		
		this.mockDoadorDAO.cadastrarDoador(doador);
	}

	@Test (expected = SQLException.class)
	public void deveLancarExcecaoAoCadastrarUmDoadorExistente() throws SQLException {
		Doador doador = new Doador();
		doador.setNome("Jose");
		doador.setCadastroNacional(012345);
		
		doThrow(new SQLException()).when(this.mockDoadorDAO).cadastrarDoador(doador);
		
		this.mockDoadorDAO.cadastrarDoador(doador);
	}
}
