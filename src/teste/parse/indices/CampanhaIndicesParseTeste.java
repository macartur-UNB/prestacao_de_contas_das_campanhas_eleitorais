package teste.parse.indices;

import modelo.beans.Campanha;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.CampanhaIndicesParse;

public class CampanhaIndicesParseTeste {

	private String campo[];
	private CampanhaIndicesParse campanhaIndicesParse;

	@Before
	public void setUp() throws Exception {
		this.campanhaIndicesParse = new CampanhaIndicesParse();
		this.campo = new String[11];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmaCampanhaComIndicesValidos() throws Exception {
		
		Campanha campanha = new Campanha();
		this.campanhaIndicesParse.iniciarInstancia(campanha, campo);
		Assert.assertEquals(this.campo[0], campanha.getResultado().getCodigo().toString());
		Assert.assertEquals(this.campo[1], campanha.getCargo().getCodigo().toString());
		Assert.assertEquals(this.campo[2], campanha.getPartido().getNumero().toString());
		Assert.assertEquals(this.campo[3], campanha.getCandidato().getTituloEleitoral());
		Assert.assertEquals(this.campo[4], campanha.getAno().toString());
		Assert.assertEquals(this.campo[5], campanha.getNumeroCandidato().toString());
		Assert.assertEquals(this.campo[6], campanha.getNomeDeUrna());
		Assert.assertEquals(this.campo[7], campanha.getUf());
		Assert.assertEquals(this.campo[8], campanha.getDespesaMaxDeclarada().toString());
		Assert.assertEquals(this.campo[9], campanha.getDespesaTotalCalculada().toString());
		Assert.assertEquals(this.campo[10], campanha.getReceitaTotalCalculada().toString());
	}
	
	@Test
	public void iniciarUmaCampanhaComIndicesInvalidos() throws Exception {
		
		this.campanhaIndicesParse = new CampanhaIndicesParse();
		Campanha campanha = new Campanha();
		this.campanhaIndicesParse.iniciarInstancia(campanha, campo);
		Assert.assertNotEquals(this.campo[0], campanha.getResultado().getCodigo().toString());
		Assert.assertNotEquals(this.campo[1], campanha.getCargo().getCodigo().toString());
		Assert.assertNotEquals(this.campo[2], campanha.getPartido().getNumero().toString());
		Assert.assertNotEquals(this.campo[3], campanha.getCandidato().getTituloEleitoral());
		Assert.assertNotEquals(this.campo[4], campanha.getAno().toString());
		Assert.assertNotEquals(this.campo[5], campanha.getNumeroCandidato().toString());
		Assert.assertNotEquals(this.campo[6], campanha.getNomeDeUrna());
		Assert.assertNotEquals(this.campo[7], campanha.getUf());
		Assert.assertNotEquals(this.campo[8], campanha.getDespesaMaxDeclarada().toString());
		Assert.assertNotEquals(this.campo[9], campanha.getDespesaTotalCalculada().toString());
		Assert.assertNotEquals(this.campo[10], campanha.getReceitaTotalCalculada().toString());
		
	}
	
	private void iniciarIndices() {
		
		this.campanhaIndicesParse.setIndiceResultadoCod(0);
		this.campanhaIndicesParse.setIndiceCargoCod(1);
		this.campanhaIndicesParse.setIndicePartidoNumero(2);
		this.campanhaIndicesParse.setIndiceCandidatoTitulo(3);
		this.campanhaIndicesParse.setIndiceAno(4);
		this.campanhaIndicesParse.setIndiceNumeroCandidato(5);
		this.campanhaIndicesParse.setIndiceNomeDeUrna(6);
		this.campanhaIndicesParse.setIndiceUf(7);
		this.campanhaIndicesParse.setIndiceDespesaMaxDeclarada(8);
		this.campanhaIndicesParse.setIndiceDespesaTotalCalculada(9);
		this.campanhaIndicesParse.setIndiceReceitaTotalCalculada(10);
		
	}
	
	private void iniciarCampos() {
		this.campo[0] = "1";
		this.campo[1] = "6";
		this.campo[2] = "13";
		this.campo[3] = "55896321447";
		this.campo[4] = "2010";
		this.campo[5] = "13222";
		this.campo[6] = "SOARES";
		this.campo[7] = "DF";
		this.campo[8] = "450000.0";
		this.campo[9] = "450000.0";
		this.campo[10] = "451000.0";
		
	}

}
