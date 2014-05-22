package teste.parse.indices;

import modelo.beans.Candidato;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.CandidatoIndicesParse;

public class CandidatoIndicesParseTeste {
	
	public static final String ANO_2002 = "2002";
	
	private String campo[];
	private CandidatoIndicesParse candidatoIndicesParse;

	@Before
	public void setUp() throws Exception {
		this.candidatoIndicesParse = new CandidatoIndicesParse(ANO_2002);
		this.campo = new String[8];
		iniciarIndices();
		iniciarCampos();
	}
	
	@Test
	public void iniciarUmCandidatoComIndicesValidos() throws Exception {
		Candidato candidato = new Candidato();
		this.candidatoIndicesParse.iniciarInstancia(candidato, this.campo);
		Assert.assertEquals(this.candidatoIndicesParse.getAno(), candidato.getAno());
		Assert.assertEquals(this.campo[0], candidato.getNome());
		Assert.assertEquals(this.campo[1], candidato.getCpf());
		Assert.assertEquals(this.campo[2], candidato.getCargo());
		Assert.assertEquals(this.campo[3], candidato.getPartido().getSigla());
		Assert.assertEquals(this.campo[4], candidato.getNumero());
		Assert.assertEquals(this.campo[5], candidato.getUf());
		Assert.assertEquals(this.campo[6], candidato.getFoiEleito().toString());
		Assert.assertEquals(this.campo[7], candidato.getResultadoUltimaEleicao().toString());
	}
	
	@Test
	public void iniciarUmCandidatoComIndicesInvalidos() throws Exception {
		this.candidatoIndicesParse = new CandidatoIndicesParse(ANO_2002);
		Candidato candidato = new Candidato();
		this.candidatoIndicesParse.iniciarInstancia(candidato, this.campo);
		Assert.assertNotEquals(this.campo[0], candidato.getNome());
		Assert.assertNotEquals(this.campo[1], candidato.getCpf());
		Assert.assertNotEquals(this.campo[2], candidato.getCargo());
		Assert.assertNotEquals(this.campo[3], candidato.getPartido().getSigla());
		Assert.assertNotEquals(this.campo[4], candidato.getNumero());
		Assert.assertNotEquals(this.campo[5], candidato.getUf());
		Assert.assertNotEquals(this.campo[6], candidato.getFoiEleito().toString());
		Assert.assertNotEquals(this.campo[7], candidato.getResultadoUltimaEleicao().toString());
	}
	
	@Test
	public void iniciarCandidatosComFoiEleitoTrue() throws Exception {
		Candidato candidato = new Candidato();
		this.candidatoIndicesParse.iniciarInstancia(candidato, this.campo);
		this.campo[6] = "true";
		Assert.assertEquals(this.candidatoIndicesParse.getAno(), candidato.getAno());
		Assert.assertEquals(this.campo[0], candidato.getNome());
		Assert.assertEquals(this.campo[1], candidato.getCpf());
		Assert.assertEquals(this.campo[2], candidato.getCargo());
		Assert.assertEquals(this.campo[3], candidato.getPartido().getSigla());
		Assert.assertEquals(this.campo[4], candidato.getNumero());
		Assert.assertEquals(this.campo[5], candidato.getUf());
		Assert.assertEquals(this.campo[6], candidato.getFoiEleito().toString());
		Assert.assertEquals(this.campo[7], candidato.getResultadoUltimaEleicao().toString());
	}
	
	@Test
	public void valoresDosIndicesSaoIguais() throws Exception {
		Assert.assertEquals(this.campo[0], this.campo[this.candidatoIndicesParse.getIndiceNome()]);

	}

	private void iniciarIndices() {
		this.candidatoIndicesParse.setAno(Integer.parseInt(ANO_2002));
		this.candidatoIndicesParse.setIndiceNome(0);
		this.candidatoIndicesParse.setIndiceCpf(1);
		this.candidatoIndicesParse.setIndiceCargo(2);
		this.candidatoIndicesParse.setIndicePartidoSigla(3);
		this.candidatoIndicesParse.setIndiceNumero(4);
		this.candidatoIndicesParse.setIndiceUf(5);
		this.candidatoIndicesParse.setIndiceFoiEleito(6);
		this.candidatoIndicesParse.setIndiceResultadoUltimaEleicao(7);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "Nome";
		this.campo[1] = "CPF";
		this.campo[2] = "Cargo";
		this.campo[3] = "Partido";
		this.campo[4] = "1";
		this.campo[5] = "AB";
		this.campo[6] = "true";
		this.campo[7] = "1";
	}
}

















