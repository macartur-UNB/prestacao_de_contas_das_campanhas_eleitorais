package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;
import modelo.beans.Partido;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.partido.CadastroPartidoParse;
import parse.controle.ParseControle;
import parse.controle.PartidoParseControle;
import parse.indices.IndicesParse;
import teste.TemplateTeste;

public class CadastroPartidoParseTeste extends TemplateTeste {
	
	private CadastroPartidoParse cadastroPartido;
	private IndicesParse indicesPartido;
	private PartidoParseControle partidoParseControle;
	private ParseControle<Partido> PC;
	public final static String TEXTO = "teste.txt";
	public final static String PARTIDO = "partido";
	public final static String ANO = "2010";
	
	

	@Override
	public void beforeTest() throws Exception {
		this.partidoParseControle = new PartidoParseControle(indicesPartido);
		this.cadastroPartido = new CadastroPartidoParse(TEXTO,ANO);
	}
	
	
	@Test
	public void deveRetornarUmClasseDePartidoParseControle() throws ParseException {
		assertEquals(partidoParseControle, cadastroPartido.novaInstancia(indicesPartido));
	}
	


	@Test
	public void TestaCondicaoDoMetodoGetIndicesParse() throws ParseException {
		
	}
	
	

	@Override
	public void afterTest() throws Exception {
		
	}
}
