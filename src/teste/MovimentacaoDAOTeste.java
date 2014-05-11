/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  06/05/2014 (Luciano)
 * 
 *  COMENTARIOS: Nao verifiquei o cadastro de receitas repetidas porque esse
 *  nao eh um problema critico como no caso de Candidato e Partido.
**/

package teste;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Receita;

import org.junit.Before;
import org.junit.Test;

public class MovimentacaoDAOTeste {

	private LinkedList<Receita> listaReceitas;
	private LinkedList<Despesa> listaDespesas;
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void obterListaReceitas() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("WLADIMIR SILVA FURTADO");
		candidato.setAno(2014);
		
		listaReceitas = candidato.getListaReceitas();
		System.out.println(listaReceitas);

	}

	@Test
	public void obterListaDespesas() throws SQLException {
		Candidato candidato = new Candidato();
		candidato.setNome("WLADIMIR SILVA FURTADO");
		candidato.setAno(2014);
		
		listaDespesas = candidato.getListaDespesas();
		System.out.println(listaDespesas);

	}

}
