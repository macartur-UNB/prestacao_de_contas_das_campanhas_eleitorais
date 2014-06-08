package teste.parse.controle;

import modelo.beans.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.controle.TipoDocumentoParseControle;
import parse.indices.TipoDocumentoIndicesParse;
import teste.TemplateTeste;

public class TipoDocumentoParseControleTeste extends TemplateTeste {

	public static final int ID = 0;
	public static final int CODIGO = 1;
	public static final int DESCRICAO = 2;
	
	private String campo[];
	private TipoDocumentoDAO tipoDocumentoDAO;
	private TipoDocumentoIndicesParse tipoDocumentoIndicesParse;
	private TipoDocumentoParseControle tipoDocumentoParseControle;

	public void beforeTest() throws Exception {
		this.campo = new String[3];
		this.tipoDocumentoDAO = new TipoDocumentoDAO();
		this.tipoDocumentoIndicesParse = new TipoDocumentoIndicesParse();
		this.tipoDocumentoParseControle = new TipoDocumentoParseControle(this.tipoDocumentoIndicesParse);
		
		iniciarCampos();
		iniciarIndices();
	}
	
	public void afterTest() {
		
	}

	
	@Test
	public void cadastrarTipoDocumento() throws Exception {
		
		this.tipoDocumentoParseControle.addInstancia(campo);
		this.tipoDocumentoParseControle.cadastrarInstancias();
		this.tipoDocumentoParseControle.resetar();
		
		TipoDocumento tipoDocumentoCadastrado = this.tipoDocumentoDAO.getLista().get(0);
				
		Assert.assertEquals(this.campo[ID], tipoDocumentoCadastrado.getId().toString());
		Assert.assertEquals(this.campo[CODIGO], tipoDocumentoCadastrado.getCodigo().toString());
		Assert.assertEquals(this.campo[DESCRICAO], tipoDocumentoCadastrado.getDescricao());
		
	}
	
	private void iniciarIndices() {
		
		this.tipoDocumentoIndicesParse.setIndiceCodigo(ID);
		this.tipoDocumentoIndicesParse.setIndiceCodigo(CODIGO);
		this.tipoDocumentoIndicesParse.setIndiceDescricao(DESCRICAO);
		
	}
	
	private void iniciarCampos() {
		
		this.campo[ID] = "1";
		this.campo[CODIGO] = "125";
		this.campo[DESCRICAO] = "TIPO DOCUMENTO INEXISTENTE";
		
	}

}
