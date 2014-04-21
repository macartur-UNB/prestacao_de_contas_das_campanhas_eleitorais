package teste;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parse.LeitorCSV;

public class LeitorCSVTeste {
	
	private LeitorCSV leitorCSV;
	private String diretorio;
	private String arquivoCSVTeste;
	private String divisao;

	@Before
	public void setUp() throws Exception {
		this.leitorCSV = new LeitorCSV();
		this.diretorio = new File("./src/teste/").getCanonicalPath();
		this.arquivoCSVTeste = this.diretorio + "/csv_testes.csv";
		this.divisao = "\";\"";
	}

	@Test
	public void numeroDeLinhasDoArquivoDeveSerIgualAoNumeroDeCampos() throws IOException {
		int numeroLinhas;
		int numeroCampos;
		
		numeroLinhas = this.leitorCSV.getNumeroLinhas(this.arquivoCSVTeste);
		numeroCampos = this.leitorCSV.getCamposCSV(this.arquivoCSVTeste, this.divisao).size();
		assertEquals(numeroLinhas, numeroCampos);
	}
	
	@Test
	public void deveIgnorarAsQuatroPrimeirasLinhasDoArquivo() throws IOException {
		int linhaQuatro = 4;
		String quartaLinha;
		List<String[]> linha = (List<String[]>) this.leitorCSV.getCamposCSV(this.arquivoCSVTeste, divisao);
		
		quartaLinha = linha.get(3)[0];		
		linha = (List<String[]>) this.leitorCSV.getCamposCSV(this.arquivoCSVTeste, this.divisao, linhaQuatro);
		
		assertEquals(quartaLinha, linha.get(0)[0]);
	}
	
	@Test
	public void deveCarregarTresCampos() throws IOException {
		int linhaInicial = 1;
		int linhaFinal = linhaInicial + 3 - 1;
		List<String[]> campo = (List<String[]>) this.leitorCSV.getCamposCSV(this.arquivoCSVTeste, this.divisao, linhaInicial, linhaFinal);
		
		assertEquals(3, campo.size());
	}

}

