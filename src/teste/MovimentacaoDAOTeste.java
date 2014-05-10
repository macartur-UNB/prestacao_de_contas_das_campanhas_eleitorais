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
import modelo.beans.Despesa;
import modelo.beans.Receita;
import modelo.dao.MovimentacaoDAO;

import org.junit.Before;
import org.junit.Test;


public class MovimentacaoDAOTeste {

	private MovimentacaoDAO mockMovimentacaoDAO;

	@Before
	public void setUp() throws Exception {
		this.mockMovimentacaoDAO = mock(MovimentacaoDAO.class);
		
	}

	@Test
	public void obterListaReceitas() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("Rafael Valenca");
		LinkedList<Receita> listaReceitas = mockMovimentacaoDAO.getListaReceitas(candidato);
		System.out.println(listaReceitas.size());
		//for(Receita receita:listaReceitas)
		//{
		//	System.out.println(receita);
		//}

	}

	@Test
	public void obterListaDespesas() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("Rafael Valenca");
		LinkedList<Despesa> listaDespesas = mockMovimentacaoDAO.getListaDespesas(candidato);
		System.out.println(listaDespesas.size());


	}

}
