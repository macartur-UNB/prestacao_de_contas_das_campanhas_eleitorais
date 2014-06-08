package teste.parse.cadastro;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import modelo.beans.Candidato;
import modelo.dao.CandidatoDAO;

import org.junit.Test;

import parse.ParseException;
import parse.cadastro.campanha.CadastroCandidatoParse;
import teste.TemplateTeste;

public class CadastroCandidatoParseTeste extends TemplateTeste {

	private CadastroCandidatoParse cadastro;
	private CandidatoDAO dao;
	String  tipoArquivo = "campanha";
	String  ano         = "2006";
	
	
	@Override
	public void beforeTest() throws Exception {
		this.cadastro = 
				new CadastroCandidatoParse(this.tipoArquivo, this.ano);	
		this.dao = new CandidatoDAO();
	}
	
	@Override
	public void afterTest() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void deveRetornarUmCandidatoCadastrado() throws ParseException, SQLException {
		String campo[] = new String[50];
		campo[10] = "Nome";
		campo[26] = "123";
		cadastro.executarLinhaDoArquivo(campo);
		cadastro.cadastrarInstancias();
		
		Candidato candidato = dao.getCandidato("123");
		assertEquals(candidato.getNome(), "Nome");
		
	}

}
