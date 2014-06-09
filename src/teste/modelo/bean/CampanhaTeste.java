package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarCampanha;
import static teste.modelo.bean.BeanTeste.instanciarCandidato;
import static teste.modelo.bean.BeanTeste.instanciarCargo;
import static teste.modelo.bean.BeanTeste.instanciarPartido;
import static teste.modelo.bean.BeanTeste.instanciarResultado;
import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Resultado;

import org.junit.Assert;
import org.junit.Test;

public class CampanhaTeste {
	
	@Test
	public void equalsDeveRetornarVerdadeiroSeForemCampanhasIguais() {
		Campanha campanha = instanciarCampanha();
		Campanha campanha2 = instanciarCampanha();
		Assert.assertTrue(campanha.equals(campanha2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemCampanhasDiferentes() {
		Campanha campanha = instanciarCampanha();
		Campanha campanha2 = instanciarCampanha();
		campanha2.setAno(BeanTeste.INT_TESTE_2);
		Assert.assertFalse(campanha.equals(campanha2));
		campanha2.setAno(BeanTeste.INT_TESTE);
		Cargo cargo = instanciarCargo();
		cargo.setDescricao(BeanTeste.STRING_TESTE_2);
		campanha2.setCargo(cargo);
		Assert.assertFalse(campanha.equals(campanha2));
		cargo.setDescricao(BeanTeste.STRING_TESTE);
		campanha2.setNomeDeUrna(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(campanha.equals(campanha2));
		campanha2.setNomeDeUrna(BeanTeste.STRING_TESTE);
		campanha2.setNumeroCandidato(BeanTeste.INT_TESTE_2);
		Assert.assertFalse(campanha.equals(campanha2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComCampanha() {
		Campanha campanha = instanciarCampanha();
		Resultado resultado = instanciarResultado();
		Assert.assertFalse(campanha.equals(resultado));
		Assert.assertFalse(resultado.equals(campanha));
		
		Assert.assertEquals(resultado,campanha.getResultado());
		Assert.assertEquals(BeanTeste.INT_TESTE,campanha.getId());
		Assert.assertEquals(instanciarPartido(),campanha.getPartido());
		Assert.assertEquals(instanciarCandidato(),campanha.getCandidato());
		Assert.assertEquals(BeanTeste.STRING_TESTE,campanha.getUf());
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campanha.getDespesaMaxDeclarada(),0);
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campanha.getDespesaTotalCalculada(),0);
		Assert.assertEquals(BeanTeste.FLOAT_TESTE,campanha.getReceitaTotalCalculada(),0);
		
		Assert.assertEquals(BeanTeste.INT_TESTE,resultado.getCodigo());
	}
}
