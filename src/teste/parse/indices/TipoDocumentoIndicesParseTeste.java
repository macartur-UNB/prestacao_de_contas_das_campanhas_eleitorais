package teste.parse.indices;

import modelo.beans.TipoDocumento;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.TipoDocumentoIndicesParse;

public class TipoDocumentoIndicesParseTeste {

	public String campo[];
	public TipoDocumentoIndicesParse tipoDocumentoIndicesParse;
	
	@Before
	public void setUp() throws Exception {
		this.tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		this.campo = new String[3];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmTipoDocumentoComIndicesValidos() throws Exception {
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		this.tipoDocumentoIndicesParse.iniciarInstancia(tipoDocumento, campo);
		Assert.assertEquals(this.campo[0], tipoDocumento.getId().toString());
		Assert.assertEquals(this.campo[1], tipoDocumento.getCodigo().toString());
		Assert.assertEquals(this.campo[2], tipoDocumento.getDescricao());
		
	}
	
	@Test
	public void iniciarUmTipoDocumentoComIndicesInvalidos() throws Exception {
		
		this.tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		TipoDocumento tipoDocumento = new TipoDocumento();
		this.tipoDocumentoIndicesParse.iniciarInstancia(tipoDocumento, campo);
		Assert.assertNotEquals(this.campo[0], tipoDocumento.getId().toString());
		Assert.assertNotEquals(this.campo[1], tipoDocumento.getCodigo().toString());
		Assert.assertNotEquals(this.campo[2], tipoDocumento.getDescricao());
		
	}
	
	private void iniciarIndices() {
		
		this.tipoDocumentoIndicesParse.setIndiceId(0);
		this.tipoDocumentoIndicesParse.setIndiceCodigo(1);
		this.tipoDocumentoIndicesParse.setIndiceDescricao(2);

	}
	
	private void iniciarCampos() {
		
		this.campo[0] = "1";
		this.campo[1] = "2";
		this.campo[2] = "TIPO DOCUMENTO INEXISTENTE";
		
	}

}
