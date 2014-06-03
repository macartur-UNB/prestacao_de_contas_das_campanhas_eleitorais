package teste.parse.indices;

import modelo.beans.Candidato;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.CandidatoIndicesParse;

public class CandidatoIndicesParseTeste {

	private CandidatoIndicesParse candidatoIndicesParse;
	private String campo[];

	@Before
	public void setUp() throws Exception {
		this.candidatoIndicesParse = new CandidatoIndicesParse();
		this.campo = new String[2];
		iniciarCampos();
		iniciarIndices();
	}
	
	@Test
	public void iniciarUmCandidatoComIndicesValidos() throws Exception {
		
		Candidato candidato = new Candidato();
		this.candidatoIndicesParse.iniciarInstancia(candidato, campo);
		Assert.assertEquals(this.campo[0], candidato.getNome());
		Assert.assertEquals(this.campo[1], candidato.getTituloEleitoral());
	}
	
	@Test
	public void iniciarUmCandidatoComIndicesInvalidos() throws Exception {
		
		this.candidatoIndicesParse = new CandidatoIndicesParse();
		Candidato candidato = new Candidato();
		this.candidatoIndicesParse.iniciarInstancia(candidato, campo);
		Assert.assertNotEquals(this.campo[0], candidato.getNome());
		Assert.assertNotEquals(this.campo[1], candidato.getTituloEleitoral());
	}
	
	private void iniciarIndices() {
		this.candidatoIndicesParse.setIndiceNome(0);
		this.candidatoIndicesParse.setIndiceTituloEleitoral(1);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "LUCIA HELENA DE CARVALHO";
		this.campo[1] = "123456";
	}
}