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

	private CadastroFornecedorParse cadastro;
	private FornecedorDAO dao;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	@Override
	public void beforeTest() throws Exception {
		this.cadastro = 
				new CadastroFornecedorParse(this.tipoArquivo, this.ano);	
		this.dao = new FornecedorDAO();
	}

	@Override
	public void afterTest() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void deveRetornarUmFornecedorCadastrado() throws ParseException, SQLException {
		String campo[] = new String[50];
		campo[19] = "123";
		campo[18] = "NOME";
		campo[20] = "UF";
		campo[21] = "SITUACAO";
		cadastro.executarLinhaDoArquivo(campo);
		cadastro.cadastrarInstancias();
		
		ArrayList<Fornecedor> fornecedor = dao.getLista();
		assertEquals(fornecedor.get(0).getNome(), "NOME");
		
	}



}
