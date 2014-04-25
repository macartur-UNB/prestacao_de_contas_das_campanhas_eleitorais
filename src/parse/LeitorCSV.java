package parse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;

public class LeitorCSV {
	
	public interface ExecutorLeitorCSV {
		public void executarMetodoPorLinhaDoArquivo(String campo[]);
	}
	
	public LeitorCSV() {
		
	}
	
	public void executarMetodoPorLinhaLida(String arquivo, String divisao, ExecutorLeitorCSV executorLeitorCSV, int linhaInicial, int linhaFinal) throws IOException {
		String campo[];
		String linha;
		BufferedReader leitorArquivo = new BufferedReader(new FileReader(arquivo));
		
		ignorarLinhas(leitorArquivo, linhaInicial);
		for(int i = linhaInicial; ((linha = leitorArquivo.readLine()) != null) && (i <= linhaFinal) && (!linha.isEmpty()); i++ ) {
			System.out.println("lendo linha: " + i);
			campo = linha.split(divisao);
			executorLeitorCSV.executarMetodoPorLinhaDoArquivo(campo);
		}		
		
		leitorArquivo.close();
	}
	
	public void executarMetodoPorLinhaLida(String arquivo, String divisao, ExecutorLeitorCSV executorLeitorCSV, int linhaInicial) throws IOException {
		int numeroLinhas = getNumeroLinhas(arquivo);
		executarMetodoPorLinhaLida(arquivo, divisao, executorLeitorCSV, linhaInicial, numeroLinhas);
	}
	
	public LinkedList<String[]> getCamposCSV(String arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		LinkedList<String[]> listaCampos;
		BufferedReader leitorArquivo;
		
		leitorArquivo = new BufferedReader(new FileReader(arquivo));
		
		ignorarLinhas(leitorArquivo, linhaInicial);
		listaCampos = (LinkedList<String[]>) lerLinhas(leitorArquivo, divisao, linhaInicial, linhaFinal);
		
		leitorArquivo.close();
		
		return listaCampos;
	}
	
	public List<String[]> getCamposCSV(String arquivo, String divisao, int linhaInicial) throws IOException {
		int numeroLinhas;
		numeroLinhas = getNumeroLinhas(arquivo);
		return getCamposCSV(arquivo, divisao, linhaInicial, numeroLinhas);
	}
	
	public List<String[]> getCamposCSV(String arquivo, String divisao) throws IOException {
		return getCamposCSV(arquivo, divisao, 1);
	}
	
	public int getNumeroLinhas(String arquivo) throws IOException {
		int numeroLinhas;
		
		File arquivoLeitura = new File(arquivo);
		long tamanhoArquivo = arquivoLeitura.length();
		FileInputStream fileInputStream = new FileInputStream(arquivoLeitura);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		
		LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(dataInputStream));
		lineRead.skip(tamanhoArquivo);
		
		numeroLinhas = lineRead.getLineNumber() + 1;
		
		lineRead.close();
		dataInputStream.close();
		fileInputStream.close();
		
		return numeroLinhas;
	}
	
	private void ignorarLinhas(BufferedReader leitorArquivo, int numeroLinhas) throws IOException {
		for(int i = 1; (i < numeroLinhas) && (leitorArquivo.readLine() != null); i++);
	}
	
	private LinkedList<String[]> lerLinhas(BufferedReader leitorArquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		LinkedList<String[]> listaCampos;
		String linha;
		
		listaCampos = new LinkedList<>();
		
		for(int i = linhaInicial; ((linha = leitorArquivo.readLine()) != null) && (i <= linhaFinal) && (!linha.isEmpty()); i++ ) {
			listaCampos.add(linha.split(divisao));
		}
		
		return listaCampos;
	}
		
}
