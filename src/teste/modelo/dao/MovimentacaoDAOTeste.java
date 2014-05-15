/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  06/05/2014 (Luciano)
 * 
 *  COMENTARIOS: Nao verifiquei o cadastro de receitas repetidas porque esse
 *  nao eh um problema critico como no caso de Candidato e Partido.
**/

package teste.modelo.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Partido;
import modelo.beans.Receita;

import org.junit.Test;

import teste.TemplateTeste;

public class MovimentacaoDAOTeste extends TemplateTeste {

	private LinkedList<Receita> listaReceitas;
	private LinkedList<Despesa> listaDespesas;

	@Override
	public void beforeTest() throws Exception {
		this.listaReceitas = new LinkedList<>();
		this.listaDespesas = new LinkedList<>();
	}

	@Override
	public void afterTest() throws Exception {
	
	}

	@Test
	public void obterListaCandidato() throws SQLException {
		
		Candidato candidato = new Candidato();
		candidato.setNome("WLADIMIR SILVA FURTADO");
		candidato.setAno(2014);

		listaReceitas = candidato.getListaReceitas();
		System.out.println(listaReceitas);

		listaDespesas = candidato.getListaDespesas();
		System.out.println(listaDespesas);

	}

	@Test
	public void obterListaPartido() throws SQLException {
		
		Partido partido = new Partido();
		partido.setNome("PT");

		listaReceitas = partido.getListaReceitas(2008);
		System.out.println(listaReceitas);

		listaDespesas = partido.getListaDespesas(2008);
		System.out.println(listaDespesas);
	}

	
}
	