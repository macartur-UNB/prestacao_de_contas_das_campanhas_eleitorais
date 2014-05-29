package teste.parse.cadastro;

import modelo.beans.Partido;
import modelo.dao.PartidoDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.cadastro.receita_despesa.PartidoCadastroParseDespesaReceita;
import teste.TemplateTeste;

public class PartidoCadastroParseTeste extends TemplateTeste {

	
	private String campo[];
	private PartidoCadastroParseDespesaReceita partidoCadastroParse;
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
		String tipoArquivo = PartidoCadastroParseDespesaReceita.DESPESA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2002;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesDespesa2002();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
	}
	
	@Test
	public void cadastrarPartidoPelaDespesa2004() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.DESPESA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2004;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesDespesa2004();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}

	@Test
	public void cadastrarPartidoPelaDespesa2006() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.DESPESA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2006;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesDespesa2006();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}
	
	@Test
	public void cadastrarPartidoPelaDespesa2008() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.DESPESA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesDespesa2008();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2002() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2002;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesReceita2002();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2004() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2004;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesReceita2004();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}

	@Test
	public void cadastrarPartidoPelaReceita2006() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2006;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesReceita2006();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}
	
	@Test
	public void cadastrarPartidoPelaReceita2008() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesReceita2008();
		this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		this.partidoCadastroParse.cadastrarInstancias();
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
	}
	
	@Test
	public void executarMetodosPorLinhaAteCadastrarPartido() throws Exception {
		String tipoArquivo = PartidoCadastroParseDespesaReceita.RECEITA;
		String ano = PartidoCadastroParseDespesaReceita.ANO_2008;
		this.partidoCadastroParse = new PartidoCadastroParseDespesaReceita(tipoArquivo, ano);
		
		setIndicesReceita2008();
		
		for(int i = 0; i < PartidoCadastroParseDespesaReceita.LINHAS_PARA_FAZER_CADASTRO; i++) {
			this.partidoCadastroParse.executarLinhaDoArquivo(this.campo);
		}
		
		Partido partido = this.partidoDAO.getTodosPartidos().getFirst();
		
		Assert.assertEquals(this.campo[this.indiceSigla], partido.getSigla());
		Assert.assertEquals(this.campo[this.indiceNumero], partido.getNumero());
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
