package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Fornecedor;
import parse.ParseDAO;

public class FornecedorDAO extends BasicoDAO<Fornecedor> implements ParseDAO<Fornecedor> {
	
	public enum Comparacao implements Comparator<Fornecedor> {
		CPF_CNPJ {
			public int compare(Fornecedor f1, Fornecedor f2) {
				return f1.getCpf_cnpj().compareToIgnoreCase(f2.getCpf_cnpj());
			}

		}	
	}
	
	private static final String NOME_TABELA = "fornecedor";
	private static final String CPF_CNPJ = "cpf_cnpj_fornecedor";
	private static final String NOME = "nome";
	private static final String UF = "uf";
	private static final String SITUACAO_CADASTRAL = "situacao_cadastral";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + CPF_CNPJ + ", " + NOME + ", " + UF + ", " + SITUACAO_CADASTRAL + ") "
			+ "VALUES(?, ?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;
	
	public FornecedorDAO() {
		super(NOME_TABELA, Comparacao.CPF_CNPJ);
	}
	
	@Override
	protected String getSqlInsert() {
		return SQL_INSERCAO;
	}

	@Override
	protected String getSqlSelect() {
		return SQL_SELECAO;
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Fornecedor> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for(Fornecedor fornecedor : lista) {
			instrucaoSQL.setString(1, fornecedor.getCpf_cnpj());
			instrucaoSQL.setString(2, fornecedor.getNome());
			instrucaoSQL.setString(3, fornecedor.getUf());
			instrucaoSQL.setString(4, fornecedor.getSituacaoCadastral());
			instrucaoSQL.addBatch();
		}	
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Fornecedor> lista,
			ResultSet resultadoSQL) throws SQLException {
		while(resultadoSQL.next()) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ));
			fornecedor.setNome(resultadoSQL.getString(NOME));
			fornecedor.setUf(resultadoSQL.getString(UF));
			fornecedor.setSituacaoCadastral(resultadoSQL.getString(SITUACAO_CADASTRAL));
			lista.add(fornecedor);
		}
		
	}

}

