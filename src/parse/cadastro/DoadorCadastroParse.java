package parse.cadastro;

import parse.DoadorParse;
import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.indices.DoadorIndicesParse;

public class DoadorCadastroParse implements ExecutorLeitorCSV {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;

	private DoadorParse doadorParse;
	private DoadorIndicesParse doadorIndicesParse;
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try{
			this.doadorParse.addDoador(campo);
			this.linhasLidas++;
			
			if(this.linhasLidas >= 40000) {
				this.doadorParse.cadastrarDoadores();
				this.doadorParse.resetar();
				this.linhasLidas = 0;
			}
		} catch(Exception e) {
			this.doadorParse.resetar();
			this.linhasLidas = 0;
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try{
			this.doadorParse.cadastrarDoadores();
			this.doadorParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public DoadorCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.doadorIndicesParse = getPartidoIndicesParse(tipoArquivo, ano);
		this.doadorParse = new DoadorParse(this.doadorIndicesParse);
	}
	
	private DoadorIndicesParse getPartidoIndicesParse(String tipoArquivo, String ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				
			case ANO_2004:

			case ANO_2006:

			case ANO_2008:

			default:
				return null;
			}
		} else {
			switch (ano) {
			case ANO_2002:
				return getDoadorIndicesParseReceita2002();

			case ANO_2004:
				return getDoadorIndicesParseReceita2004();

			case ANO_2006:
				return getDoadorIndicesParseReceita2006();

			case ANO_2008:
				return getDoadorIndicesParseReceita2008();

			default:
				return null;
			}
		}
	}
	
	private DoadorIndicesParse getDoadorIndicesParseReceita2002() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(8);
		doadorIndicesParse.setIndiceCadastroNacional(6);
		
		return doadorIndicesParse;
	}
	
	private DoadorIndicesParse getDoadorIndicesParseReceita2004() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(18);
		doadorIndicesParse.setIndiceCadastroNacional(19);
		return doadorIndicesParse;
	}
	
	private DoadorIndicesParse getDoadorIndicesParseReceita2006() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(18);
		doadorIndicesParse.setIndiceCadastroNacional(19);
		
		return doadorIndicesParse;
	}
	
	private DoadorIndicesParse getDoadorIndicesParseReceita2008() {
		DoadorIndicesParse doadorIndicesParse = new DoadorIndicesParse();
		doadorIndicesParse.setIndiceNome(19);
		doadorIndicesParse.setIndiceCadastroNacional(20);
		
		return doadorIndicesParse;
	}
	
}
