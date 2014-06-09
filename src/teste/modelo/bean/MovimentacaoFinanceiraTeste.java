package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarCampanha;
import static teste.modelo.bean.BeanTeste.instanciarMovimentacaoFinanceira;
import modelo.beans.Campanha;
import modelo.beans.MovimentacaoFinanceira;

import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoFinanceiraTeste {

	@Test
	public void equalsDeveRetornarVerdadeiroSeForemMovimentacoesFinanceiraIguais() {
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		MovimentacaoFinanceira movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Assert.assertTrue(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
	}
	
	@Test
	public void equalsDeveRetornarFalsoSeForemMovimentacoesFinancierasDiferentes() {
		MovimentacaoFinanceira movimentacaoFinanceira = instanciarMovimentacaoFinanceira();
		MovimentacaoFinanceira movimentacaoFinanceira2 = instanciarMovimentacaoFinanceira();
		Campanha campanha = instanciarCampanha();
		campanha.setNomeDeUrna(BeanTeste.STRING_TESTE_2);
		movimentacaoFinanceira2.setCampanha(campanha);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		campanha.setNomeDeUrna(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setCampanha(campanha);
		movimentacaoFinanceira2.setDescricao(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setDescricao(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setFormaPagamento(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setFormaPagamento(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setNumeroDocumento(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setNumeroDocumento(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setTipoMovimentacao(BeanTeste.STRING_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		movimentacaoFinanceira2.setTipoMovimentacao(BeanTeste.STRING_TESTE);
		movimentacaoFinanceira2.setValor(BeanTeste.FLOAT_TESTE_2);
		Assert.assertFalse(movimentacaoFinanceira.equals(movimentacaoFinanceira2));
		
		Assert.assertEquals(BeanTeste.INT_TESTE, movimentacaoFinanceira.getId());
		Assert.assertEquals(BeanTeste.STRING_TESTE, movimentacaoFinanceira.getData());
		
		BeanTeste bt = new BeanTeste();
		bt.usarBeanTeste();
		
		Assert.assertEquals((float) 1000, BeanTeste.FLOAT_TESTE,0);
		Assert.assertEquals((float) 2000, BeanTeste.FLOAT_TESTE_2,0);
		Assert.assertEquals("String Teste", BeanTeste.STRING_TESTE);
	}

}
