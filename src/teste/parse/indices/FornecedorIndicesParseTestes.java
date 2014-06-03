package teste.parse.indices;

import static org.junit.Assert.*;
import modelo.beans.Fornecedor;

import org.junit.Test;

import parse.indices.FornecedorIndicesParse;
import teste.TemplateTeste;

public class FornecedorIndicesParseTestes extends TemplateTeste {
	
	public static final int INDICE_NOME = 0;
	public static final int INDICE_CADASTRO_NACIONAL = 0;
	
	private String campo[];
	private FornecedorIndicesParse fornecedorIndicesParse;

	@Override
	public void beforeTest() throws Exception {
		this.campo = new String[2];
		this.fornecedorIndicesParse = new FornecedorIndicesParse();
		
		iniciarCampos();
		iniciarIndices();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void iniciarUmFornecedorComIndicesValidos() throws Exception {
		Fornecedor fornecedor = new Fornecedor();
		this.fornecedorIndicesParse.iniciarInstancia(fornecedor, campo);
//		assertEquals(this.campo[INDICE_NOME], fornecedor.getNome());
		assertEquals(this.campo[INDICE_CADASTRO_NACIONAL], fornecedor.getCadastroNacional());
	}
	
	
	@Test
	public void iniciarUmCandidatoComIndicesInvalidos() throws Exception {
		this.fornecedorIndicesParse = new FornecedorIndicesParse();
		Fornecedor fornecedor = new Fornecedor();
		this.fornecedorIndicesParse.iniciarInstancia(fornecedor, campo);
//		assertNotEquals(this.campo[INDICE_NOME], fornecedor.getNome());
		assertNotEquals(this.campo[INDICE_CADASTRO_NACIONAL], fornecedor.getCadastroNacional());
	}
	
	@Test
	public void indicesDevemSerIguais() throws Exception {
		assertEquals(INDICE_NOME, this.fornecedorIndicesParse.getIndiceNome());
		assertEquals(INDICE_CADASTRO_NACIONAL, this.fornecedorIndicesParse.getIndiceCadastroNacional());
	}
	
	private void iniciarIndices() {
		this.fornecedorIndicesParse.setIndiceNome(INDICE_NOME);
		this.fornecedorIndicesParse.setIndiceCadastroNacional(INDICE_CADASTRO_NACIONAL);
	}
	
	private void iniciarCampos() {
		this.campo[INDICE_NOME] = "NOME";
		this.campo[INDICE_CADASTRO_NACIONAL] = "123123";
	}
	
}
