package teste.parse.indices;

import modelo.beans.Partido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.PartidoIndicesParse;

public class PartidoIndicesParseTeste {
		
	private String campo[];
	private PartidoIndicesParse partidoIndicesParse;

	@Before
	public void setUp() throws Exception {
		this.partidoIndicesParse = new PartidoIndicesParse();
		this.campo = new String[4];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmPartidoComIndicesValidos() throws Exception {
		
		Partido partido = new Partido();
		this.partidoIndicesParse.iniciarInstancia(partido, campo);
		Assert.assertEquals(this.campo[0], partido.getSigla());
		Assert.assertEquals(this.campo[1], partido.getNumero());
		Assert.assertEquals(this.campo[2], partido.getDeferimento());
		Assert.assertEquals(this.campo[3], partido.getNome());
	}
	
	@Test
	public void iniciarUmPartidoComIndicesInvalidos() throws Exception {
		
		this.partidoIndicesParse = new PartidoIndicesParse();
		Partido partido = new Partido();
		this.partidoIndicesParse.iniciarInstancia(partido, campo);
		Assert.assertNotEquals(this.campo[0], partido.getSigla());
		Assert.assertNotEquals(this.campo[1], partido.getNumero());
		Assert.assertNotEquals(this.campo[2], partido.getDeferimento());
		Assert.assertNotEquals(this.campo[3], partido.getNome());
	}
	
	private void iniciarIndices() {
		this.partidoIndicesParse.setIndiceSigla(0);
		this.partidoIndicesParse.setIndiceNumero(1);
		this.partidoIndicesParse.setIndiceDeferimento(2);
		this.partidoIndicesParse.setIndiceNome(3);
	}
	
	private void iniciarCampos() {
		this.campo[0] = "DEM";
		this.campo[1] = "25";
		this.campo[2] = "11.9.1986";
		this.campo[3] = "DEMOCRATAS";
	}
	
}
