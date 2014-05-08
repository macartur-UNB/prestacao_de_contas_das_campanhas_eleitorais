package teste;

import modelo.beans.Partido;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controle.excecao.PartidoExcecao;
import controle.validacao.PartidoValidacao;

public class PartidoValidacaoTeste {
	
	private PartidoValidacao partidoValidacao;
	private Partido partido;
	
	@Before
	public void setUp() throws Exception {
		this.partidoValidacao = new PartidoValidacao();
		this.partido = new Partido();
	}

	@Test (expected = PartidoExcecao.class)
	public void lancaExcecaoSeSiglaEhNula() throws PartidoExcecao {
		partido.setSigla(null);
		
		this.partidoValidacao.siglaNaoNula(partido);
	}
	
	@Test
	public void naoLancaExcecaoSeSiglaNaoEhNula() throws PartidoExcecao {
		partido.setSigla("PT");
		
		this.partidoValidacao.siglaNaoNula(partido);
	}
	
	@Test (expected = PartidoExcecao.class)
	public void lancaExcecaoSeNumeroPartidoEhNulo() throws PartidoExcecao {
		partido.setNumeroPartido(null);
		
		this.partidoValidacao.numeroNaoNulo(partido);
	}
	
	@Test
	public void naoLancaExcecaoSeNumeroPartidoNaoEhNulo() throws PartidoExcecao {
		partido.setNumeroPartido("13");
		
		this.partidoValidacao.numeroNaoNulo(partido);
}

}
