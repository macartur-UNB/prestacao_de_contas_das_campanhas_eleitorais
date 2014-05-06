package parse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class LeitorCSV {
	
	public interface ExecutorLeitorCSV {
		public void executarMetodoPorLinhaDoArquivo(String campo[]);
	}
	
	public LeitorCSV() {
		
	}
	
	public void executarMetodoPorLinhaLida(FileItem arquivo, String divisao, ExecutorLeitorCSV executorLeitorCSV, int linhaInicial) throws IOException {
		String campo[];
		String linha;
		BufferedReader leitorArquivo = new BufferedReader(new InputStreamReader(arquivo.getInputStream()));
		
		ignorarLinhas(leitorArquivo, linhaInicial);
		for(int i = linhaInicial; ((linha = leitorArquivo.readLine()) != null) && (!linha.isEmpty()); i++ ) {
			System.out.println("lendo linha: " + i);
			linha = removerAspas(linha);
			campo = linha.split(divisao);
			executorLeitorCSV.executarMetodoPorLinhaDoArquivo(campo);
		}		
		
		leitorArquivo.close();
	}
	
	public LinkedList<String[]> getCamposCSV(FileItem arquivo, String divisao, int linhaInicial, int linhaFinal) throws IOException {
		LinkedList<String[]> listaCampos;
		BufferedReader leitorArquivo;
		
		leitorArquivo = new BufferedReader(new InputStreamReader(arquivo.getInputStream()));
		
		ignorarLinhas(leitorArquivo, linhaInicial);
		listaCampos = (LinkedList<String[]>) lerLinhas(leitorArquivo, divisao, linhaInicial, linhaFinal);
		
		leitorArquivo.close();
		
		return listaCampos;
	}
	
	public List<String[]> getCamposCSV(FileItem arquivo, String divisao, int linhaInicial) throws IOException {
		int numeroLinhas;
		numeroLinhas = getNumeroLinhas(arquivo);
		return getCamposCSV(arquivo, divisao, linhaInicial, numeroLinhas);
	}
	
	public List<String[]> getCamposCSV(FileItem arquivo, String divisao) throws IOException {
		return getCamposCSV(arquivo, divisao, 1);
	}
	
	public int getNumeroLinhas(FileItem arquivo) throws IOException {
		int numeroLinhas;
		
		long tamanhoArquivo = arquivo.getSize();
		InputStream inputStream = arquivo.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		
		LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(dataInputStream));
		lineRead.skip(tamanhoArquivo);
		
		numeroLinhas = lineRead.getLineNumber() + 1;
		
		lineRead.close();
		dataInputStream.close();
		inputStream.close();
		
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
	
	private String removerAspas(String palavra) {
		if(palavra.charAt(0) == '"') {
			palavra = palavra.substring(1, palavra.length()-2);
		}
		return palavra;
	}
		
}
