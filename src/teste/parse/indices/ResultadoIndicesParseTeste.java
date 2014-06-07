package teste.parse.indices;

import modelo.beans.Resultado;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.ResultadoIndicesParse;

public class ResultadoIndicesParseTeste {

	public String campo[];
	public ResultadoIndicesParse resultadoIndicesParse;
	
	@Before
	public void setUp() throws Exception {
		this.resultadoIndicesParse = new ResultadoIndicesParse();
		this.campo = new String[2];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmResultadoComIndicesValidos() throws Exception {
		
		Resultado resultado = new Resultado();
		this.resultadoIndicesParse.iniciarInstancia(resultado, campo);
		Assert.assertEquals(this.campo[0], resultado.getCodigo().toString());
		Assert.assertEquals(this.campo[1], resultado.getDescricao());
		
	}
	
	@Test
	public void iniciarUmResultadoComIndicesInvalidos() throws Exception {
		
		this.resultadoIndicesParse = new ResultadoIndicesParse();
		Resultado resultado = new Resultado();
		this.resultadoIndicesParse.iniciarInstancia(resultado, campo);
		Assert.assertNotEquals(this.campo[0], resultado.getCodigo().toString());
		Assert.assertNotEquals(this.campo[1], resultado.getDescricao());
		
	}
	
	private void iniciarIndices() {
		
		this.resultadoIndicesParse.setIndiceCodigo(0);
		this.resultadoIndicesParse.setIndiceDescricao(1);

	}
	
	private void iniciarCampos() {
		
		this.campo[0] = "123";
		this.campo[1] = "RESULTADO INEXISTENTE";
		
	}
	
	@Test
	public void verificarIndices() {
		
		Assert.assertEquals(0, this.resultadoIndicesParse.getIndiceCodigo());
		Assert.assertEquals(1, this.resultadoIndicesParse.getIndiceDescricao());
		
	}

}
