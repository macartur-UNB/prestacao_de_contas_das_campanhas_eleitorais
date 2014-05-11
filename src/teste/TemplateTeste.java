package teste;

import java.io.File;

import modelo.dao.ConexaoBancoDados;

import org.junit.After;
import org.junit.Before;

public abstract class TemplateTeste {
	
	public static final String NOME_BANCO_OFICIAL = "gpp";
	public static final String LOCAL_BANCO_OFICIAL = "jdbc:mysql://";
	
	public static final String NOME_BANCO_TESTES = "banco_de_testes";
	public static final String LOCAL_BANCO_ERROR = "Erro na Conexao";
	
	protected ConexaoBancoDados conexaoBancoDados;
	
	@Before
	public void setUp() throws Exception {
		String diretorioSQL = new File("./lib/").getCanonicalPath();
		String arquivoSQL = diretorioSQL + "/MER_Parse_SQL.sql";		
		this.conexaoBancoDados = new ConexaoBancoDados();
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_OFICIAL);
		this.conexaoBancoDados.setLocalBanco(LOCAL_BANCO_OFICIAL);
		this.conexaoBancoDados.criarBanco(NOME_BANCO_TESTES);
		this.conexaoBancoDados.alterarBanco(NOME_BANCO_TESTES);
		this.conexaoBancoDados.importarSQL(arquivoSQL);
		
		beforeTest();
	}

	@After
	public void tearDown() throws Exception {
		if(!this.conexaoBancoDados.getLocalBanco().equals(LOCAL_BANCO_ERROR)) {
			this.conexaoBancoDados.deletarBanco();
		}
		
		afterTest();
	}
	
	public abstract void beforeTest();
	public abstract void afterTest();

}
