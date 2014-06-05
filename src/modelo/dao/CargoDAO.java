package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Cargo;
import parse.ParseDAO;

public class CargoDAO extends BasicoDAO<Cargo> implements ParseDAO<Cargo> {

	public enum Comparacao implements Comparator<Cargo> {
		DESCRICAO {
			@Override
			public int compare(Cargo c1, Cargo c2) {
				return c1.getDescricao().compareToIgnoreCase(c2.getDescricao());
			}
		};
	}

	private static final String ID = "id_cargo";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "cargo";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + ID + ", " + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public CargoDAO() {
		super(NOME_TABELA, Comparacao.DESCRICAO);
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
	protected void adicionarListaNoBatch(ArrayList<Cargo> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Cargo cargo : lista) {
			instrucaoSQL.setInt(1, cargo.getId());
			instrucaoSQL.setInt(2, cargo.getCodigo());
			instrucaoSQL.setString(3, cargo.getDescricao());
			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Cargo> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Cargo cargo = new Cargo();
			cargo.setId(resultadoSQL.getInt(ID));
			cargo.setCodigo(resultadoSQL.getInt(CODIGO));
			cargo.setDescricao(resultadoSQL.getString(DESCRICAO));

			lista.add(cargo);
		}
	}
}