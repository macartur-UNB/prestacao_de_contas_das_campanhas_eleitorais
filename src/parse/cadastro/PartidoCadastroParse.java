package parse.cadastro;

import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.PartidoParse;
import parse.indices.PartidoIndicesParse;

public class PartidoCadastroParse implements ExecutorLeitorCSV{
	
	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;
	
	private PartidoIndicesParse partidoIndicesParse;
	private PartidoParse partidoParse;
	
	public PartidoCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.partidoIndicesParse = getPartidoIndicesParse(tipoArquivo, ano);
		this.partidoParse = new PartidoParse(this.partidoIndicesParse);
	}
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try{
			this.partidoParse.addPartido(campo);
			this.linhasLidas++;
			
			if(this.linhasLidas >= 20000) {
				this.partidoParse.cadastrarPartidos();
				this.partidoParse.resetar();
				this.linhasLidas = 0;
			}
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try{
			this.partidoParse.cadastrarPartidos();
			this.partidoParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	private PartidoIndicesParse getPartidoIndicesParse(String tipoArquivo, String ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return gePartidoIndicesParseDespesa2002();

			case ANO_2004:
				return gePartidoIndicesParseDespesa2004();

			case ANO_2006:
				return gePartidoIndicesParseDespesa2006();

			case ANO_2008:
				return gePartidoIndicesParseDespesa2008();

			default:
				return null;
			}
		} else {
			switch (ano) {
			case ANO_2002:
				return gePartidoIndicesParseReceita2002();

			case ANO_2004:
				return gePartidoIndicesParseReceita2004();

			case ANO_2006:
				return gePartidoIndicesParseReceita2006();

			case ANO_2008:
				return gePartidoIndicesParseReceita2008();

			default:
				return null;
			}
		}
	}
	
	private PartidoIndicesParse gePartidoIndicesParseReceita2002() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(1);
		
		return partidoIndicesParse;
	}

	private PartidoIndicesParse gePartidoIndicesParseDespesa2002() {		
		return gePartidoIndicesParseReceita2002();
	}
	
	private PartidoIndicesParse gePartidoIndicesParseReceita2004() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(8);
		partidoIndicesParse.setIndiceNumeroPartido(7);
		
		return partidoIndicesParse;
	}
	
	private PartidoIndicesParse gePartidoIndicesParseDespesa2004() {		
		return gePartidoIndicesParseReceita2004();
	}

	private PartidoIndicesParse gePartidoIndicesParseReceita2006() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(8);
		partidoIndicesParse.setIndiceNumeroPartido(7);
		
		return partidoIndicesParse;
	}
	
	private PartidoIndicesParse gePartidoIndicesParseDespesa2006() {		
		return gePartidoIndicesParseReceita2006();
	}

	private PartidoIndicesParse gePartidoIndicesParseReceita2008() {
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(12);
		partidoIndicesParse.setIndiceNumeroPartido(11);
		
		return partidoIndicesParse;
	}
	
	private PartidoIndicesParse gePartidoIndicesParseDespesa2008() {		
		PartidoIndicesParse partidoIndicesParse = new PartidoIndicesParse();
		partidoIndicesParse.setIndiceSigla(9);
		partidoIndicesParse.setIndiceNumeroPartido(8);
		
		return partidoIndicesParse;
	}
	
}
