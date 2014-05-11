package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Fornecedor;

public class FornecedorDAO extends BasicoDAO<Fornecedor>{

	private enum Comparacao implements Comparator<Fornecedor> {
		NOME {
			@Override
			public int compare(Fornecedor f1, Fornecedor f2) {
				return f1.getNome().compareToIgnoreCase(f2.getNome());
			}
		};
	}
	
	private static final String NOME_TABELA = "t_fornecedor";
	private static final String NOME = "nome";
	private static final String CADASTRO_NACIONAL = "cadastro_nacional";
	private static final String SQL_INSERT = "INSERT INTO t_fornecedor (nome, cadastro_nacional) VALUES(?,?)";
	private static final String SQL_SELECT = "SELECT * FROM t_fornecedor";
	
	public FornecedorDAO() {
		super(NOME_TABELA, Comparacao.NOME);
	}
	
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT;
	}
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT;
	}
	@Override
	protected void adicionarListaNoBatch(ArrayList<Fornecedor> lista, PreparedStatement instrucaoSQL) throws SQLException {
		for(Fornecedor fornecedor : lista) {
			instrucaoSQL.setString(1, fornecedor.getNome());
			instrucaoSQL.setString(2, fornecedor.getCadastroNacional());
			instrucaoSQL.addBatch();
		}
	}
	@Override
	protected void adicionarResultSetNaLista(ArrayList<Fornecedor> lista, ResultSet resultadoSQL) throws SQLException {
		while(resultadoSQL.next()) {
			Fornecedor fornecedor = new Fornecedor();				
			fornecedor.setNome(resultadoSQL.getString(NOME));
			fornecedor.setCadastroNacional(resultadoSQL.getString(CADASTRO_NACIONAL));
			
			lista.add(fornecedor);
		}
	}	
	
}
