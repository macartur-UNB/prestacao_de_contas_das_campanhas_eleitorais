/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: Nao verifiquei o cadastro de receitas repetidas porque esse
 *  nao eh um problema critico como no caso de Candidato e Partido.
**/

package teste;

import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import model.Despesa;
import model.Doador;
import model.Fornecedor;
import model.Receita;

import org.junit.Before;
import org.junit.Test;

import dao.DespesaDAO;
import dao.ReceitaDAO;


public class ReceitaDespesaDAOTeste {

	private ReceitaDAO mockReceitaDAO;
	private DespesaDAO mockDespesaDAO;
	
	@Before
	public void setUp() throws Exception {
		this.mockReceitaDAO = mock(ReceitaDAO.class);
		this.mockDespesaDAO = mock(DespesaDAO.class);
	}

	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmaReceita() throws SQLException {
		Receita receita = new Receita();
		Doador doador = new Doador();
		doador.setNome("Jose");
		receita.setDoador(doador);
		receita.setDescricao("Doacao de pessoa fisica.");
		
		this.mockReceitaDAO.cadastrarReceita(receita);
	}
	
	@Test
	public void naoDeveLancarExcecaoAoCadastrarUmaDespesa() throws SQLException {
		Despesa despesa = new Despesa();
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Jose");
		despesa.setFornecedor(fornecedor);
		despesa.setDescricao("Impressao de panfletos.");
		
		this.mockDespesaDAO.cadastrarDespesa(despesa);
	}

}
