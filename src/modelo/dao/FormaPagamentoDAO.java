package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.FormaPagamento;
import parse.ParseDAO;

public class FormaPagamentoDAO extends BasicoDAO<FormaPagamento> implements ParseDAO<FormaPagamento> {

	public enum Comparacao implements Comparator<FormaPagamento> {
		COD_E_DESCRICAO {
			@Override
			public int compare(FormaPagamento t1, FormaPagamento t2) {
				if (t1.getCodigo() != t2.getCodigo())
					return t1.getCodigo().compareTo(t2.getCodigo());
				else
					return t1.getDescricao().compareToIgnoreCase(t2.getDescricao());
			}
		};
	}

	private static final String ID = "id_forma_pagamento";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "forma_de_pagamento";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + ID + ", " + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public FormaPagamentoDAO() {
		super(NOME_TABELA, Comparacao.COD_E_DESCRICAO);
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
	protected void adicionarListaNoBatch(ArrayList<FormaPagamento> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (FormaPagamento formaPagamento : lista) {
			instrucaoSQL.setInt(1, formaPagamento.getId());
			instrucaoSQL.setInt(2, formaPagamento.getCodigo());
			instrucaoSQL.setString(3, formaPagamento.getDescricao());

			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<FormaPagamento> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			FormaPagamento formaPagamento = new FormaPagamento();
			formaPagamento.setCodigo(resultadoSQL.getInt(ID));
			formaPagamento.setCodigo(resultadoSQL.getInt(CODIGO));
			formaPagamento.setDescricao(resultadoSQL.getString(DESCRICAO));

			lista.add(formaPagamento);
		}
	}

	public FormaPagamento getPeloId(Integer id) {
		FormaPagamento formaPagamento = new FormaPagamento();
		String comandoSQL = SQL_SELECAO + " WHERE " + CODIGO +" = "+id+" ";
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			while(resultadoSQL.next())
			{
				formaPagamento.setId(resultadoSQL.getInt(ID));
				formaPagamento.setCodigo(resultadoSQL.getInt(CODIGO));
				formaPagamento.setDescricao(resultadoSQL.getString(DESCRICAO));
			}

		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 
		return formaPagamento;
	}
}
