package teste;

import modelo.beans.Partido;
import org.junit.Test;
import controle.excecao.PartidoExcecao;
import controle.validacao.PartidoValidacao;

public class PartidoValidacaoTeste extends TemplateTeste {
	
	private PartidoValidacao partidoValidacao;
	private PartidoExcecao partidoExcecao;
	private Partido partido;
	
	@Override
	public void beforeTest() throws Exception {
		this.partidoValidacao = new PartidoValidacao();
		this.partidoExcecao = new PartidoExcecao();
		this.partido = new Partido();
	}

	@Override
	public void afterTest() throws Exception {
		
	}

	@Test (expected = PartidoExcecao.class)
	public void lancaExcecaoSeSiglaEhNula() throws PartidoExcecao {
		this.partido.setSigla(null);
		
		this.partidoValidacao.siglaNaoNula(partido);
	}
	
	@Test
	public void naoLancaExcecaoSeSiglaNaoEhNula() throws PartidoExcecao {
		this.partido.setSigla("PT");
		
		this.partidoValidacao.siglaNaoNula(partido);
	}
	
	@Test (expected = PartidoExcecao.class)
	public void lancaExcecaoSeNumeroPartidoEhNulo() throws PartidoExcecao {
		this.partido.setNumeroPartido(null);
		
		this.partidoValidacao.numeroNaoNulo(partido);
	}
	
	@Test
	public void naoLancaExcecaoSeNumeroPartidoNaoEhNulo() throws PartidoExcecao {
		this.partido.setNumeroPartido("13");
		
		this.partidoValidacao.numeroNaoNulo(partido);
	}

}
