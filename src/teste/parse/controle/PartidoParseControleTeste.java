package teste.parse.controle;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.controle.PartidoParseControle;
import parse.indices.PartidoIndicesParse;
import teste.TemplateTeste;

public class PartidoParseControleTeste extends TemplateTeste {
	
	public static final int SIGLA = 0;
	public static final int NUMERO = 1;
	
	private String campo[];
	private PartidoDAO partidoDAO;
	private PartidoIndicesParse partidoIndicesParse;
	private PartidoParseControle partidoParseControle;

	@Override
	public void beforeTest() throws Exception {
		this.campo = new String[2];
		this.partidoDAO = new PartidoDAO();
		this.partidoIndicesParse = new PartidoIndicesParse();
		this.partidoParseControle = new PartidoParseControle(this.partidoIndicesParse);
		
		iniciarCampos();
		iniciarIndices();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void cadastrarPartido() throws Exception {
		this.partidoParseControle.addPartido(campo);
		this.partidoParseControle.cadastrarPartidos();
		this.partidoParseControle.resetar();
		
		Partido partidoCadastrado = this.partidoDAO.getListaPartidos().getFirst();
				
		Assert.assertEquals(this.campo[SIGLA], partidoCadastrado.getSigla());
		Assert.assertEquals(this.campo[NUMERO], partidoCadastrado.getNumeroPartido());
	}
	
	private void iniciarIndices() {
		this.partidoIndicesParse.setIndiceSigla(SIGLA);
		this.partidoIndicesParse.setIndiceNumeroPartido(NUMERO);
	}
	
	private void iniciarCampos() {
		this.campo[SIGLA] = "AB";
		this.campo[NUMERO] = "1";
	}
}
