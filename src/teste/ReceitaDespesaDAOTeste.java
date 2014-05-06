/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  06/05/2014 (Luciano)
 * 
 *  COMENTARIOS: Nao verifiquei o cadastro de receitas repetidas porque esse
 *  nao eh um problema critico como no caso de Candidato e Partido.
**/

package teste;

import static org.mockito.Mockito.mock;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Receita;
import modelo.dao.DespesaDAO;
import modelo.dao.ReceitaDAO;

import org.junit.Before;
import org.junit.Test;

public class ReceitaDespesaDAOTeste {

	private ReceitaDAO mockReceitaDAO;
	private DespesaDAO mockDespesaDAO;

	@Before
	public void setUp() throws Exception {
		this.mockReceitaDAO = mock(ReceitaDAO.class);
		this.mockDespesaDAO = mock(DespesaDAO.class);
		
	}

	@Test
	public void obterListaReceitas() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("Rafael Valenca");
		LinkedList<Receita> listaReceitas = mockReceitaDAO.getListaReceitas(candidato);
		System.out.println(listaReceitas.size());
		//for(Receita receita:listaReceitas)
		//{
		//	System.out.println(receita);
		//}

	}

	/**
	@Test
	public void obterListaDespesas() throws SQLException {
		Despesa despesa = new Despesa();
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Jose");
		despesa.setFornecedor(fornecedor);
		despesa.setDescricao("Impressao de panfletos.");

		this.mockDespesaDAO.cadastrarDespesa(despesa);
		
	}
	*/

}
