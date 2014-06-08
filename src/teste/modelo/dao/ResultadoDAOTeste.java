package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Resultado;
import modelo.dao.ResultadoDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class ResultadoDAOTeste extends TemplateTeste {

	private ResultadoDAO dao;
	
	@Override
	public void beforeTest() throws Exception {
		this.dao = new ResultadoDAO();
	}

	@Override
	public void afterTest() throws Exception {		
	}
	
	@Test
	public void deveRecuperarUmResultadoPeloCodigo() throws SQLException {
		
		ArrayList<Resultado> lista = new ArrayList<>();
		
		Resultado r1 = new Resultado();
		r1.setCodigo(1);
		r1.setDescricao("Resultado 1");
		lista.add(r1);
		
		Resultado r2 = new Resultado();
		r2.setCodigo(2);
		r2.setDescricao("Resultado 2");
		lista.add(r2);
		
		this.dao.cadastrarLista(lista);
			
		Resultado r3 = new Resultado();
		r3 = this.dao.getPeloCod(1);
		Assert.assertEquals(r1, r3);
		
	}
	
	@Test
	public void naoDeveAcharResultado() throws SQLException {
		
		ArrayList<Resultado> lista = new ArrayList<>();
		
		Resultado r1 = new Resultado();
		r1.setCodigo(1);
		r1.setDescricao("Resultado 1");
		lista.add(r1);
		
		Resultado r2 = new Resultado();
		r2.setCodigo(2);
		r2.setDescricao("Resultado 2");
		lista.add(r2);
		
		this.dao.cadastrarLista(lista);
			
		Resultado r3 = new Resultado();
		r3 = this.dao.getPeloCod(5);
		Assert.assertNotEquals(r1, r3);
		
	}
	
	@Test
	public void valoresComparacao() throws Exception {
		
		Resultado r1 = new Resultado();
		Resultado r2 = new Resultado();
		r1.setCodigo(1);
		r2.setCodigo(2);
		int resultado;

		resultado = ResultadoDAO.Comparacao.CODIGO.compare(r1, r2);
		
		Assert.assertNotEquals(0,resultado);
		
	}

}
