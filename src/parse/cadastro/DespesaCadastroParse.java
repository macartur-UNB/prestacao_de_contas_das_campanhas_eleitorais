package parse.cadastro;

import modelo.beans.Fornecedor;
import modelo.beans.Pessoa;
import parse.DespesaParse;
import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.indices.DespesaIndicesParse;

public class DespesaCadastroParse implements ExecutorLeitorCSV {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	public static final String ANO_2002 = "2002";
	public static final String ANO_2004 = "2004";
	public static final String ANO_2006 = "2006";
	public static final String ANO_2008 = "2008";
	
	private int linhasLidas;

	private DespesaParse despesaParse;
	private DespesaIndicesParse despesaIndicesParse;
	
	public DespesaCadastroParse(String tipoArquivo, String ano) {
		this.linhasLidas = 0;
		
		this.despesaIndicesParse = getCandidatoIndicesParse(tipoArquivo, ano);
		this.despesaParse = new DespesaParse(this.despesaIndicesParse);
	}
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try {
			this.despesaParse.addDespesa(campo);
			this.linhasLidas++;

			if(this.linhasLidas >= 20000) {
				this.despesaParse.cadastrarDespesas();
				this.despesaParse.resetar();
				this.linhasLidas = 0;
			}

		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	public void finalizarCadastros() {
		try {
			this.despesaParse.cadastrarDespesas();
			this.despesaParse.resetar();
			this.linhasLidas = 0;
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private DespesaIndicesParse getCandidatoIndicesParse(String tipoArquivo, String ano) {
		if(tipoArquivo.equals(DESPESA)) {
			switch (ano) {
			case ANO_2002:
				return getDespesaIndicesParse2002();
			case ANO_2004:
				return getDespesaIndicesParse2004();

			case ANO_2006:

			case ANO_2008:

			default:
				return null;
			}
		}
		return null;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2002() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2002);
		despesaIndicesParse.setIndiceFornecedor(8);
		despesaIndicesParse.setIndiceEmNomeDe(3);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(10);		

		return despesaIndicesParse;
	}
	
	private DespesaIndicesParse getDespesaIndicesParse2004() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2004);
		despesaIndicesParse.setIndiceFornecedor(18);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceEspecie(13);

		return despesaIndicesParse;
	}
	
//	private String tipoDocumento;
//	private Fornecedor fornecedor;
//	
//	private Pessoa emNomeDe;
//	private String horaRegistro;
//	private Boolean entregaEmConjunto;
//	private String numeroDocumento;
//	private String ano;
//	private Float valor;
//	private String fonte;
//	private String tipo;
//	private String especie;
//	private String descricao;
	
}
