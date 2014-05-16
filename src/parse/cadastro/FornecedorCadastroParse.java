package parse.cadastro;

import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.controle.FornecedorParseControle;
import parse.indices.FornecedorIndicesParse;

public class FornecedorCadastroParse implements ExecutorLeitorCSV {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;

	private FornecedorParseControle fornecedorParse;
	private FornecedorIndicesParse fornecedorIndicesParse;
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try{
			this.fornecedorParse.addFornecedor(campo);
			this.linhasLidas++;
			
			if(this.linhasLidas >= 20000) {
				this.fornecedorParse.cadastrarFornecedores();
				this.fornecedorParse.resetar();
				this.linhasLidas = 0;
			}
		} catch(Exception e) {
			this.fornecedorParse.resetar();
			this.linhasLidas = 0;
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try{
			this.fornecedorParse.cadastrarFornecedores();
			this.fornecedorParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public FornecedorCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.fornecedorIndicesParse = getPartidoIndicesParse(tipoArquivo, ano);
		this.fornecedorParse = new FornecedorParseControle(this.fornecedorIndicesParse);
	}
	
	private FornecedorIndicesParse getPartidoIndicesParse(String tipoArquivo, String ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return getFornecedorIndicesParseDespesa2002();

			case ANO_2004:
				return getFornecedorIndicesParseDespesa2004();

			case ANO_2006:
				return getFornecedorIndicesParseDespesa2006();

			case ANO_2008:
				return getFornecedorIndicesParseDespesa2008();

			default:
				return null;
			}
		} else {
			switch (ano) {
			case ANO_2002:
				
			case ANO_2004:

			case ANO_2006:

			case ANO_2008:

			default:
				return null;
			}
		}
	}
	
	private FornecedorIndicesParse getFornecedorIndicesParseDespesa2002() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(8);
		fornecedorIndicesParse.setIndiceCadastroNacional(6);
		
		return fornecedorIndicesParse;
	}
	
	private FornecedorIndicesParse getFornecedorIndicesParseDespesa2004() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceCadastroNacional(19);
		return fornecedorIndicesParse;
	}
	
	private FornecedorIndicesParse getFornecedorIndicesParseDespesa2006() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(18);
		fornecedorIndicesParse.setIndiceCadastroNacional(19);
		
		return fornecedorIndicesParse;
	}
	
	private FornecedorIndicesParse getFornecedorIndicesParseDespesa2008() {
		FornecedorIndicesParse fornecedorIndicesParse = new FornecedorIndicesParse();
		fornecedorIndicesParse.setIndiceNome(22);
		fornecedorIndicesParse.setIndiceCadastroNacional(23);
		
		return fornecedorIndicesParse;
	}
	
}
