package parse;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.fileupload.FileItem;

import parse.LeitorCSV.ExecutorLeitorCSVObservador;
import parse.cadastro.CadastroParse;
import parse.cadastro.CandidatoCadastroParse;
import parse.cadastro.DespesaCadastroParse;
import parse.cadastro.DoadorCadastroParse;
import parse.cadastro.FornecedorCadastroParse;
import parse.cadastro.PartidoCadastroParse;

public class Parse implements ExecutorLeitorCSVObservador {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	private LeitorCSV leitorCSV;
	private ArrayList<CadastroParse<?>> listaCadastrosParse;
	
	private FornecedorCadastroParse fornecedorCadastroParse;
	private DoadorCadastroParse doadorCadastroParse;
	private DespesaCadastroParse despesaCadastroParse;
	
	private String tipoArquivo;
	private String ano;
	
	public Parse(String tipoArquivo, String ano) throws ParseException {
		this.tipoArquivo = tipoArquivo;
		this.ano = ano;
		this.leitorCSV = new LeitorCSV();
		this.leitorCSV.setExecutorLeitorCSVObservador(this);

		this.listaCadastrosParse = new ArrayList<>();
		this.listaCadastrosParse.add(new PartidoCadastroParse(this.tipoArquivo, this.ano));
		this.listaCadastrosParse.add(new CandidatoCadastroParse(this.tipoArquivo, this.ano));
		
		this.fornecedorCadastroParse = new FornecedorCadastroParse(this.tipoArquivo, this.ano);
		this.doadorCadastroParse = new DoadorCadastroParse(this.tipoArquivo, this.ano);
		this.despesaCadastroParse = new DespesaCadastroParse(this.tipoArquivo, this.ano);
	}
	
	public void executarParse(FileItem arquivo, String divisao, int linhaInicial) throws IOException, ParseException {
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, linhaInicial);
		finalizarCadastros();
	}
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		try {
			for(CadastroParse<?> cadastroParse : this.listaCadastrosParse) {
				cadastroParse.executarLinhaDoArquivo(campo);
			}
			
			if(this.tipoArquivo.equals(DESPESA)) {
				this.fornecedorCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
				this.despesaCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
			} 
			else {
				this.doadorCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void finalizarCadastros() throws ParseException {
		for(CadastroParse<?> cadastroParse : this.listaCadastrosParse) {
			cadastroParse.cadastrarInstancias();
		}
		
		if(this.tipoArquivo.equals(DESPESA)) {
			this.fornecedorCadastroParse.finalizarCadastros();
			this.despesaCadastroParse.finalizarCadastros();
		} 
		else {
			this.doadorCadastroParse.finalizarCadastros();
		}
	}

}





















