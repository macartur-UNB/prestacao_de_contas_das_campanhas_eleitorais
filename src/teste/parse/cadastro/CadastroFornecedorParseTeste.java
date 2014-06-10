package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Fornecedor;
import modelo.dao.FornecedorDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.receita_despesa.CadastroFornecedorParse;
import teste.TemplateTeste;

public class CadastroFornecedorParseTeste extends TemplateTeste {

	private CadastroFornecedorParse cadastro1;
	private CadastroFornecedorParse cadastro2;
	private FornecedorDAO fornecedorDAO;
	String  tipoArquivo = "despesa";
	String  ano1         = "2006";
	String  ano2         = "2002";
	String  ano3         = "2010";
	
	@Override
	public void beforeTest() throws Exception {
		this.cadastro1 = 
				new CadastroFornecedorParse(this.tipoArquivo, this.ano1);
		this.cadastro2 = 
				new CadastroFornecedorParse(this.tipoArquivo, this.ano2);
		this.fornecedorDAO = new FornecedorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRetornarUmFornecedorCadastradoPara2006() throws ParseException, SQLException {
		String campo[] = new String[50];
		campo[19] = "123";
		campo[18] = "NOME";
		campo[20] = "UF";
		campo[21] = "SITUACAO";		
		cadastro1.executarLinhaDoArquivo(campo);
		cadastro1.cadastrarInstancias();
		
		ArrayList<Fornecedor> listaFornecedores = fornecedorDAO.getLista();
		System.out.println(listaFornecedores.get(0).getCpf_cnpj());
		assertEquals(listaFornecedores.get(0).getCpf_cnpj(), "123");
		
	}
	
	@Test
	public void deveRetornarUmFornecedorCadastradoPara2002() throws ParseException, SQLException {
		String campo[] = new String[50];
		campo[6] = "12345";
		campo[8] = "NOME NOME";
		campo[7] = "UF UF";	
		cadastro2.executarLinhaDoArquivo(campo);
		cadastro2.cadastrarInstancias();
		
		ArrayList<Fornecedor> listaFornecedores = fornecedorDAO.getLista();
		System.out.println(listaFornecedores.get(0).getCpf_cnpj());
		assertEquals(listaFornecedores.get(0).getCpf_cnpj(), "12345");
		
	}

}
