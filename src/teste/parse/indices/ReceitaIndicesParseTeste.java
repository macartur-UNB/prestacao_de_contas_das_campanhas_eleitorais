package teste.parse.indices;

import modelo.beans.Receita;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.ReceitaIndicesParse;

public class ReceitaIndicesParseTeste {

	private String campo[];
	private ReceitaIndicesParse receitaIndicesParse;
	private String ano = "2006";

	@Before
	public void setUp() throws Exception {
		
		this.receitaIndicesParse = new ReceitaIndicesParse(ano);
		this.campo = new String[3];
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Test
	public void iniciarUmaReceitaComIndicesValidos() throws Exception {
		
		Receita receita = new Receita();
		this.receitaIndicesParse.iniciarInstancia(receita, campo);
		Assert.assertEquals(this.campo[0], receita.getReciboEleitoral());
		Assert.assertEquals(this.campo[1], receita.getDoador().getNome());
		Assert.assertEquals(this.campo[2], receita.getDoador().getCpf_cnpj());
	}
	
	@Test
	public void iniciarUmaReceitaComIndicesInvalidos() {
		
		this.receitaIndicesParse = new ReceitaIndicesParse(ano);
		Receita receita = new Receita();
		this.receitaIndicesParse.iniciarInstancia(receita, campo);
		Assert.assertNotEquals(this.campo[0], receita.getReciboEleitoral());
		Assert.assertNotEquals(this.campo[1], receita.getDoador().getNome());
		Assert.assertNotEquals(this.campo[2], receita.getDoador().getCpf_cnpj());
	}
	
	private void iniciarIndices() {
		
		this.receitaIndicesParse.setIndiceReciboEleitoral(0);
		this.receitaIndicesParse.setIndiceDoadorNome(1);
		this.receitaIndicesParse.setIndiceDoadorCpfCnpj(2);
	}
	
	private void iniciarCampos() {
		
		this.campo[0] = "55325424149";
		this.campo[1] = "DOADOR";
		this.campo[2] = "123456789";
	}

}
