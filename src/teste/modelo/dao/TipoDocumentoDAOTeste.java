package teste.modelo.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.TipoDocumento;
import modelo.dao.TipoDocumentoDAO;

import org.junit.Test;

import teste.TemplateTeste;

public class TipoDocumentoDAOTeste extends TemplateTeste {

	private TipoDocumento tipoDocumento;
	private TipoDocumentoDAO tipoDocumentoDAO;

	@Override
	public void beforeTest() throws Exception {
		this.tipoDocumento = new TipoDocumento();
		this.tipoDocumentoDAO = new TipoDocumentoDAO();
	}

	@Override
	public void afterTest() throws Exception {

	}

	@Test
	public void deveCadastrarUmaListaDeTipoDocumento() throws SQLException {

		ArrayList<TipoDocumento> listaDocumentos = new ArrayList<>();

		TipoDocumento td1 = new TipoDocumento();
		td1.setId(1);
		td1.setCodigo(25);
		td1.setDescricao("TIPO DOCUMENTO 1");
		listaDocumentos.add(td1);

		TipoDocumento td2 = new TipoDocumento();
		td2.setId(2);
		td2.setCodigo(28);
		td2.setDescricao("TIPO DOCUMENTO 2");
		listaDocumentos.add(td2);

		this.tipoDocumentoDAO.cadastrarLista(listaDocumentos);

		assertEquals(listaDocumentos, this.tipoDocumentoDAO.getLista());

	}

	@Test
	public void deveRecuperarUmTipoDocumentoPeloId() throws SQLException {

		ArrayList<TipoDocumento> listaDocumentos = new ArrayList<>();

		TipoDocumento td1 = new TipoDocumento();
		td1.setId(1);
		td1.setCodigo(25);
		td1.setDescricao("TIPO DOCUMENTO 1");
		listaDocumentos.add(td1);

		TipoDocumento td2 = new TipoDocumento();
		td2.setId(2);
		td2.setCodigo(28);
		td2.setDescricao("TIPO DOCUMENTO 2");
		listaDocumentos.add(td2);
		
		this.tipoDocumentoDAO.cadastrarLista(listaDocumentos);
		tipoDocumento = this.tipoDocumentoDAO.getPeloId(1);
		
		assertEquals(tipoDocumento, td1);
	}

}
