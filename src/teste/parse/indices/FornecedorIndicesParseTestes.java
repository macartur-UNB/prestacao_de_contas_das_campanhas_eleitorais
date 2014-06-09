package teste.parse.indices;

import modelo.beans.Fornecedor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.FornecedorIndicesParse;

public class FornecedorIndicesParseTestes {
	
	private String campo[];
	private FornecedorIndicesParse fornecedorIndicesParse;

	@Before
	public void setUp() throws Exception {
		this.fornecedorIndicesParse = new FornecedorIndicesParse();
		this.campo = new String[4];
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Test
	public void iniciarUmFornecedorComIndicesValidos() throws Exception {
		Fornecedor fornecedor = new Fornecedor();
		this.fornecedorIndicesParse.iniciarInstancia(fornecedor, campo);
		Assert.assertEquals(this.campo[0], fornecedor.getCpf_cnpj().toString());
		Assert.assertEquals(this.campo[1], fornecedor.getNome());
		Assert.assertEquals(this.campo[2], fornecedor.getUf());
		Assert.assertEquals(this.campo[3], fornecedor.getSituacaoCadastral());
	}
	
	@Test
	public void iniciarUmFornecedorComIndicesInvalidos() {
		this.fornecedorIndicesParse = new FornecedorIndicesParse();
		Fornecedor fornecedor = new Fornecedor();
		this.fornecedorIndicesParse.iniciarInstancia(fornecedor, campo);
		Assert.assertNotEquals(this.campo[0], fornecedor.getCpf_cnpj().toString());
		Assert.assertNotEquals(this.campo[1], fornecedor.getNome());
		Assert.assertNotEquals(this.campo[2], fornecedor.getUf());
		Assert.assertNotEquals(this.campo[3], fornecedor.getSituacaoCadastral());
	}
	
	private void iniciarIndices() {
		this.fornecedorIndicesParse.setIndiceCpf_Cnpj(0);
		this.fornecedorIndicesParse.setIndiceNome(1);
		this.fornecedorIndicesParse.setIndiceUf(2);
		this.fornecedorIndicesParse.setIndiceSituacaoCadastral(3);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "55325424149";
		this.campo[1] = "VANDERLEI";
		this.campo[2] = "DF";
		this.campo[3] = "REGULAR";
	}
	
}
