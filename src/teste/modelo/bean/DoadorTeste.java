package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarDoador;
import static teste.modelo.bean.BeanTeste.instanciarMovimentacaoFinanceira;
import modelo.beans.Doador;
import modelo.beans.MovimentacaoFinanceira;

import org.junit.Assert;
import org.junit.Test;

public class DoadorTeste {

	@Test
	public void equalsDeveRetornarVerdadeiroSeForemDoadoresIguais() {
		Doador doador = instanciarDoador();
		Doador doador2 = instanciarDoador();
		Assert.assertTrue(doador.equals(doador2));
	}

	@Test
	public void equalsDeveRetornarFalsoSeForemDoadoresDiferentes() {
		Doador doador = instanciarDoador();
		Doador doador2 = instanciarDoador();
		doador.setCpf_cnpj(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(doador.equals(doador2));		
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeNaoCompararComDoador() {
		Doador doador = instanciarDoador();
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		Assert.assertFalse(doador.equals(movimentacaoFinanceira));
		Assert.assertFalse(movimentacaoFinanceira.equals(doador));
		
		Assert.assertEquals(BeanTeste.STRING_TESTE,doador.getNome());
		Assert.assertEquals(BeanTeste.STRING_TESTE,doador.getUf());
		Assert.assertEquals(BeanTeste.STRING_TESTE,doador.getSituacaoCadastral());
	}
}
