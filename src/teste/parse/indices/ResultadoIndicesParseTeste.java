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
		this.campo = new String[3];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmResultadoComIndicesValidos() throws Exception {
		
		Resultado resultado = new Resultado();
		this.resultadoIndicesParse.iniciarInstancia(resultado, campo);
		Assert.assertEquals(this.campo[0], resultado.getId().toString());
		Assert.assertEquals(this.campo[1], resultado.getCodigo().toString());
		Assert.assertEquals(this.campo[2], resultado.getDescricao());
		
	}
	
	@Test
	public void iniciarUmResultadoComIndicesInvalidos() throws Exception {
		
		this.resultadoIndicesParse = new ResultadoIndicesParse();
		Resultado resultado = new Resultado();
		this.resultadoIndicesParse.iniciarInstancia(resultado, campo);
		Assert.assertNotEquals(this.campo[0], resultado.getId().toString());
		Assert.assertNotEquals(this.campo[1], resultado.getCodigo().toString());
		Assert.assertNotEquals(this.campo[2], resultado.getDescricao());
		
	}
	
	private void iniciarIndices() {
		
		this.resultadoIndicesParse.setIndiceId(0);
		this.resultadoIndicesParse.setIndiceCodigo(1);
		this.resultadoIndicesParse.setIndiceDescricao(2);

	}
	
	private void iniciarCampos() {
		
		this.campo[0] = "1";
		this.campo[1] = "123";
		this.campo[2] = "RESULTADO INEXISTENTE";
		
	}
	
	@Test
	public void verificarIndices() {
		
		Assert.assertEquals(0, this.resultadoIndicesParse.getIndiceId());
		Assert.assertEquals(1, this.resultadoIndicesParse.getIndiceCodigo());
		Assert.assertEquals(2, this.resultadoIndicesParse.getIndiceDescricao());
		
	}

}
