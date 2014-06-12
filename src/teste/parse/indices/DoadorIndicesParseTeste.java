package teste.parse.indices;

import modelo.beans.Doador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.DoadorIndicesParse;

public class DoadorIndicesParseTeste {

	private String campo[];
	private DoadorIndicesParse doadorIndicesParse;

	@Before
	public void setUp() throws Exception {
		this.doadorIndicesParse = new DoadorIndicesParse();
		this.campo = new String[4];
		
		iniciarCampos();
		iniciarIndices();
	}
	
	@Test
	public void iniciarUmDoadorComIndicesValidos() throws Exception {
		Doador doador = new Doador();
		this.doadorIndicesParse.iniciarInstancia(doador, campo);
		Assert.assertEquals(this.campo[0], doador.getCpf_cnpj().toString());
		Assert.assertEquals(this.campo[1], doador.getNome());
		Assert.assertEquals(this.campo[2], doador.getUf());
		Assert.assertEquals(this.campo[3], doador.getSituacaoCadastral());
	}
	
	@Test
	public void iniciarUmDoadorComIndicesInvalidos() {
		this.doadorIndicesParse = new DoadorIndicesParse();
		Doador doador = new Doador();
		this.doadorIndicesParse.iniciarInstancia(doador, campo);
		Assert.assertNotEquals(this.campo[0], doador.getCpf_cnpj().toString());
		Assert.assertNotEquals(this.campo[1], doador.getNome());
		Assert.assertNotEquals(this.campo[2], doador.getUf());
		Assert.assertNotEquals(this.campo[3], doador.getSituacaoCadastral());
	}
	
	private void iniciarIndices() {
		this.doadorIndicesParse.setIndiceCpf_Cnpj(0);
		this.doadorIndicesParse.setIndiceNome(1);
		this.doadorIndicesParse.setIndiceUf(2);
		this.doadorIndicesParse.setIndiceSituacaoCadastral(3);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "55325424149";
		this.campo[1] = "VANDERLEI";
		this.campo[2] = "DF";
		this.campo[3] = "REGULAR";
	}

}
