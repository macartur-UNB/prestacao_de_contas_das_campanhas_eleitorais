package teste.parse.cadastro;

import static org.junit.Assert.*;
import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import parse.cadastro.PartidoCadastroParse;
import parse.indices.PartidoIndicesParse;
import teste.TemplateTeste;

public class PartidoCadastroParseTeste extends TemplateTeste {

	
	private String campo[];
	private PartidoCadastroParse partidoCadastroParse;
	private PartidoDAO partidoDAO;
	
	private int indiceSigla = 0;
	private int indiceNumero = 0;
	
	@Override
	public void beforeTest() throws Exception {
		this.partidoDAO = new PartidoDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void cadastrarPartidoPelaDespesa2002() throws Exception {
		String tipoArquivo = PartidoCadastroParse.DESPESA;
		String ano = PartidoCadastroParse.ANO_2002;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesDespesa2002();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
	}
	
	@Test
	public void cadastrarPartidoPelaDespesa2004() throws Exception {
		String tipoArquivo = PartidoCadastroParse.DESPESA;
		String ano = PartidoCadastroParse.ANO_2004;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesDespesa2004();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}

	@Test
	public void cadastrarPartidoPelaDespesa2006() throws Exception {
		String tipoArquivo = PartidoCadastroParse.DESPESA;
		String ano = PartidoCadastroParse.ANO_2006;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesDespesa2006();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}
	
	@Test
	public void cadastrarPartidoPelaDespesa2008() throws Exception {
		String tipoArquivo = PartidoCadastroParse.DESPESA;
		String ano = PartidoCadastroParse.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesDespesa2008();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2002() throws Exception {
		String tipoArquivo = PartidoCadastroParse.RECEITA;
		String ano = PartidoCadastroParse.ANO_2002;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesReceita2002();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2004() throws Exception {
		String tipoArquivo = PartidoCadastroParse.RECEITA;
		String ano = PartidoCadastroParse.ANO_2004;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesReceita2004();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}

	@Test
	public void cadastrarPartidoPelaReceita2006() throws Exception {
		String tipoArquivo = PartidoCadastroParse.RECEITA;
		String ano = PartidoCadastroParse.ANO_2006;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesReceita2006();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2008() throws Exception {
		String tipoArquivo = PartidoCadastroParse.RECEITA;
		String ano = PartidoCadastroParse.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesReceita2008();
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.finalizarCadastros();
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}
	
	@Test
	public void executarMetodosPorLinhaAteCadastrarPartido() throws Exception {
		String tipoArquivo = PartidoCadastroParse.RECEITA;
		String ano = PartidoCadastroParse.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParse(tipoArquivo, ano);
		
		setIndicesReceita2008();
		
		for(int i = 0; i < PartidoCadastroParse.LINHAS_PARA_COMMITAR; i++) {
			this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(this.campo);
		}
		
		Partido partido = this.partidoDAO.getListaPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumeroPartido());
	}
	
	private void setIndicesCampo(int indiceSigla, int indiceNumero) {
		this.campo = new String[13];
		this.indiceSigla = indiceSigla;
		this.indiceNumero = indiceNumero;
		iniciarCampos();
	}
	
	private void setIndicesDespesa2002() throws Exception {
		setIndicesCampo(1, 0);
	}
	
	private void setIndicesDespesa2004() throws Exception {
		setIndicesCampo(8, 7);
	}
	
	private void setIndicesDespesa2006() throws Exception {
		setIndicesCampo(8, 7);
	}

	private void setIndicesDespesa2008() throws Exception {
		setIndicesCampo(12, 11);
	}
	private void setIndicesReceita2002() throws Exception {
		setIndicesCampo(1, 0);
	}
	
	private void setIndicesReceita2004() throws Exception {
		setIndicesCampo(8, 7);
	}
	
	private void setIndicesReceita2006() throws Exception {
		setIndicesCampo(8, 7);
	}

	private void setIndicesReceita2008() throws Exception {
		setIndicesCampo(12, 11);
	}

	private void iniciarCampos() {
		this.campo[this.indiceSigla] = "AB";
		this.campo[this.indiceNumero] = "1";
	}

}
