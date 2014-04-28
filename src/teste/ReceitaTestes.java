package teste;

import model.Receita;
import model.Doador;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReceitaTestes {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Doador doadorTeste = new Doador();
		doadorTeste.setNome("Fulano");	
		
		Receita receitaTeste = new Receita();
		receitaTeste.setDoador(doadorTeste);
		
		assertEquals(receitaTeste.getDoador().getNome(),"Fulano");
		
	}

}
