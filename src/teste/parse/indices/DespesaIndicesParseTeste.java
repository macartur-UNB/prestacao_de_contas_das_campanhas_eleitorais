package teste.parse.indices;

import modelo.beans.Despesa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.DespesaIndicesParse;

public class DespesaIndicesParseTeste {

	private String campo[];
	private DespesaIndicesParse despesaIndicesParse;
	private String ano = "2006";

	@Before
	public void setUp() throws Exception {
		
		this.despesaIndicesParse = new DespesaIndicesParse(ano);
		this.campo = new String[3];
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Test
	public void iniciarUmaDespesaComIndicesValidos() throws Exception {
		
		Despesa despesa = new Despesa();
		this.despesaIndicesParse.iniciarInstancia(despesa, campo);
		Assert.assertEquals(this.campo[0], despesa.getFornecedor().getNome());
		Assert.assertEquals(this.campo[1], despesa.getFornecedor().getCpf_cnpj());
		Assert.assertEquals(this.campo[2], despesa.getTipoDocumento());
	}
	
	@Test
	public void iniciarUmaDespesaComIndicesInvalidos() {
		
		this.despesaIndicesParse = new DespesaIndicesParse(ano);
		Despesa despesa = new Despesa();
		this.despesaIndicesParse.iniciarInstancia(despesa, campo);
		Assert.assertNotEquals(this.campo[0], despesa.getFornecedor().getNome());
		Assert.assertNotEquals(this.campo[1], despesa.getFornecedor().getCpf_cnpj());
		Assert.assertNotEquals(this.campo[2], despesa.getTipoDocumento());
	}
	
	@Test
	public void deveRetornarOhAnoCadastrado() {
		
		despesaIndicesParse.setAno(2010);
	}
	
	private void iniciarIndices() {
		
		this.despesaIndicesParse.setIndiceFornecedorNome(0);
		this.despesaIndicesParse.setIndiceFornecedorCpfCnpj(1);
		this.despesaIndicesParse.setIndiceTipoDocumento(2);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "FORNECEDOR";
		this.campo[1] = "55325424149";
		this.campo[2] = "BOLETO";
	}

}
