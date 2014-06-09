package teste.modelo.bean;

import static teste.modelo.bean.BeanTeste.instanciarDespesa;
import static teste.modelo.bean.BeanTeste.instanciarDoador;
import static teste.modelo.bean.BeanTeste.instanciarFornecedor;
import static teste.modelo.bean.BeanTeste.instanciarReceita;
import modelo.beans.Despesa;
import modelo.beans.Receita;

import org.junit.Assert;
import org.junit.Test;

public class DespesaTeste {

	@Test
	public void equalsDeveRetornarFalsoEmQualquerCondicao() {
		Despesa despesa = instanciarDespesa();
		Receita receita = instanciarReceita();
		Assert.assertFalse(despesa.equals(receita));
		Assert.assertFalse(receita.equals(despesa));
		
		Assert.assertEquals(BeanTeste.STRING_TESTE, despesa.getTipoDocumento());
		Assert.assertEquals(instanciarFornecedor(), despesa.getFornecedor());
		
		Assert.assertEquals(BeanTeste.STRING_TESTE, receita.getReciboEleitoral());
		Assert.assertEquals(instanciarDoador(), receita.getDoador());
	}

}
