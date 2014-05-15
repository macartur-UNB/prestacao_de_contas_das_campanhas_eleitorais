package parse;

import java.sql.SQLException;
import java.util.ArrayList;

import parse.indices.FornecedorIndicesParse;
import modelo.beans.Fornecedor;
import modelo.dao.FornecedorDAO;

public class FornecedorParse {

	private FornecedorIndicesParse fornecedorIndicesParse;
	private ArrayList<Fornecedor> listaFornecedores;
	private FornecedorDAO fornecedorDAO;
	
	public FornecedorParse(FornecedorIndicesParse fornecedorIndicesParse) {
		this.fornecedorDAO = new FornecedorDAO();
		this.listaFornecedores = new ArrayList<>();
		this.fornecedorIndicesParse = fornecedorIndicesParse;
	}
	
	public void addFornecedor(String campo[]) {
		Fornecedor fornecedor = this.fornecedorIndicesParse.iniciarFornecedor(campo);
		if(!fornecedor.getNome().isEmpty() && !this.listaFornecedores.contains(fornecedor)) {
			this.listaFornecedores.add(fornecedor);
		}
	}
	
	public void cadastrarFornecedores() throws SQLException {
		this.fornecedorDAO.cadastrarLista(listaFornecedores);
	}
	
	public void resetar() {
		this.listaFornecedores.clear();
	}
}
