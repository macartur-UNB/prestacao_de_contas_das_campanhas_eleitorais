package parse;

import java.io.IOException;

import org.apache.commons.fileupload.FileItem;

import parse.LeitorCSV.ExecutorLeitorCSV;
import parse.cadastro.CandidatoCadastroParse;
import parse.cadastro.DoadorCadastroParse;
import parse.cadastro.FornecedorCadastroParse;
import parse.cadastro.PartidoCadastroParse;

public class Parse implements ExecutorLeitorCSV {

	public static final String DESPESA = "despesa";
	public static final String RECEITA = "receita";
	
	private LeitorCSV leitorCSV;
	private PartidoCadastroParse partidoCadastroParse;
	private CandidatoCadastroParse candidatoCadastroParse;
	private FornecedorCadastroParse fornecedorCadastroParse;
	private DoadorCadastroParse doadorCadastroParse;
	
	private String tipoArquivo;
	private String ano;
	
	public Parse(String tipoArquivo, String ano) {
		this.tipoArquivo = tipoArquivo;
		this.ano = ano;
	}
	
	public void executarParse(FileItem arquivo, String divisao, int linhaInicial) throws IOException {
		this.leitorCSV = new LeitorCSV();
		this.partidoCadastroParse = new PartidoCadastroParse(this.tipoArquivo, this.ano);
		this.candidatoCadastroParse = new CandidatoCadastroParse(this.tipoArquivo, this.ano);
		this.fornecedorCadastroParse = new FornecedorCadastroParse(this.tipoArquivo, this.ano);
		this.doadorCadastroParse = new DoadorCadastroParse(this.tipoArquivo, this.ano);
		
		this.leitorCSV.executarMetodoPorLinhaLida(arquivo, divisao, this, linhaInicial);
		finalizarCadastros();
	}
	
	@Override
	public void executarMetodoPorLinhaDoArquivo(String[] campo) {
		this.partidoCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
		this.candidatoCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
		
		if(this.tipoArquivo.equals(DESPESA)) {
			this.fornecedorCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
		} 
		else {
			this.doadorCadastroParse.executarMetodoPorLinhaDoArquivo(campo);
		}
	}
	
	private void finalizarCadastros() {
		this.partidoCadastroParse.finalizarCadastros();
		this.candidatoCadastroParse.finalizarCadastros();
		
		if(this.tipoArquivo.equals(DESPESA)) {
			this.fornecedorCadastroParse.finalizarCadastros();
		} 
		else {
			this.doadorCadastroParse.finalizarCadastros();
		}
	}

}





















