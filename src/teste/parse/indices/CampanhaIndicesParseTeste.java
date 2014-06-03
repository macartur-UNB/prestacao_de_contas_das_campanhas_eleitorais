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
		this.campo = new String[12];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmaCampanhaComIndicesValidos() throws Exception {
		
		Campanha campanha = new Campanha();
		this.campanhaIndicesParse.iniciarInstancia(campanha, campo);
		Assert.assertEquals(this.campo[0], campanha.getId().toString());
		Assert.assertEquals(this.campo[1], campanha.getResultado().toString());
		Assert.assertEquals(this.campo[2], campanha.getCargo().toString());
		Assert.assertEquals(this.campo[3], campanha.getPartido().toString());
		Assert.assertEquals(this.campo[4], campanha.getCandidato().toString());
		Assert.assertEquals(this.campo[5], campanha.getAno().toString());
		Assert.assertEquals(this.campo[6], campanha.getNumeroCandidato().toString());
		Assert.assertEquals(this.campo[7], campanha.getNomeDeUrna());
		Assert.assertEquals(this.campo[8], campanha.getUf());
		Assert.assertEquals(this.campo[9], campanha.getDespesaMaxDeclarada().toString());
		Assert.assertEquals(this.campo[10], campanha.getDespesaTotalCalculada().toString());
		Assert.assertEquals(this.campo[11], campanha.getReceitaTotalCalculada().toString());
	}
	
	@Test
	public void iniciarUmaCampanhaComIndicesInvalidos() throws Exception {
		
		this.campanhaIndicesParse = new CampanhaIndicesParse();
		Campanha campanha = new Campanha();
		this.campanhaIndicesParse.iniciarInstancia(campanha, campo);
		Assert.assertNotEquals(this.campo[0], campanha.getId().toString());
		Assert.assertNotEquals(this.campo[1], campanha.getResultado().toString());
		Assert.assertNotEquals(this.campo[2], campanha.getCargo().toString());
		Assert.assertNotEquals(this.campo[3], campanha.getPartido().toString());
		Assert.assertNotEquals(this.campo[4], campanha.getCandidato().toString());
		Assert.assertNotEquals(this.campo[5], campanha.getAno().toString());
		Assert.assertNotEquals(this.campo[6], campanha.getNumeroCandidato().toString());
		Assert.assertNotEquals(this.campo[7], campanha.getNomeDeUrna());
		Assert.assertNotEquals(this.campo[8], campanha.getUf());
		Assert.assertNotEquals(this.campo[9], campanha.getDespesaMaxDeclarada().toString());
		Assert.assertNotEquals(this.campo[10], campanha.getDespesaTotalCalculada().toString());
		Assert.assertNotEquals(this.campo[11], campanha.getReceitaTotalCalculada().toString());
		
	}
	
	private void iniciarIndices() {
		
		this.campanhaIndicesParse.setIndiceId(0);
		this.campanhaIndicesParse.setIndiceResultadoCod(1);
		this.campanhaIndicesParse.setIndiceCargoCod(2);
		this.campanhaIndicesParse.setIndicePartidoSigla(3);
		this.campanhaIndicesParse.setIndiceCandidatoTitulo(4);
		this.campanhaIndicesParse.setIndiceAno(5);
		this.campanhaIndicesParse.setIndiceNumeroCandidato(6);
		this.campanhaIndicesParse.setIndiceNomeDeUrna(7);
		this.campanhaIndicesParse.setIndiceUf(8);
		this.campanhaIndicesParse.setIndiceDespesaMaxDeclarada(9);
		this.campanhaIndicesParse.setIndiceDespesaTotalCalculada(10);
		this.campanhaIndicesParse.setIndiceReceitaTotalCalculada(11);
		
	}
	
	private void iniciarCampos() {
		this.campo[0] = "1";
		this.campo[1] = "6";
		this.campo[2] = "8";
		this.campo[3] = "PT";
		this.campo[4] = "000000000";
		this.campo[5] = "2010";
		this.campo[6] = "13";
		this.campo[7] = "Soares";
		this.campo[8] = "DF";
		this.campo[9] = "450000";
		this.campo[10] = "450000";
		this.campo[11] = "451000";
		
	}
	
	@Test
	public void verificarIndices() {
		
		Assert.assertEquals(1, this.campanhaIndicesParse.getIndiceResultadoCod());
		
	}

}
