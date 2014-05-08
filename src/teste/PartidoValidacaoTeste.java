package teste;

import static org.junit.Assert.*;
import modelo.beans.Partido;

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

}
