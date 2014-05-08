/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  06/05/2014 (Luciano)
 * 
 *  COMENTARIOS: Nao verifiquei o cadastro de receitas repetidas porque esse
 *  nao eh um problema critico como no caso de Candidato e Partido.
**/

package teste;

import static org.mockito.Mockito.mock;
import modelo.dao.DespesaDAO;
import modelo.dao.ReceitaDAO;

import org.junit.Before;


public class ReceitaDespesaDAOTeste {

	private ReceitaDAO mockReceitaDAO;
	private DespesaDAO mockDespesaDAO;
	
	@Before
	public void setUp() throws Exception {
		this.mockReceitaDAO = mock(ReceitaDAO.class);
		this.mockDespesaDAO = mock(DespesaDAO.class);
	}

}
