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
		CODIGO {
			@Override
			public int compare(Cargo c1, Cargo c2) {
				return c1.getCodigo().compareTo(c2.getCodigo());
			}
		};
	}

	private static final String NOME_TABELA = "cargo";
	private static final String CODIGO = "cod_cargo";
	private static final String DESCRICAO = "descricao";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public CargoDAO() {
		super(NOME_TABELA, Comparacao.CODIGO);
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
			instrucaoSQL.setInt(1, cargo.getCodigo());
			instrucaoSQL.setString(2, cargo.getDescricao());
			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Cargo> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Cargo cargo = new Cargo();
			cargo.setCodigo(resultadoSQL.getInt(CODIGO));
			cargo.setDescricao(resultadoSQL.getString(DESCRICAO));

			lista.add(cargo);
		}
	}
	
	public Cargo getPeloCod(Integer codigo) throws SQLException {
		String comandoSQL = SQL_SELECAO + " WHERE " + CODIGO +" = "+codigo+" ";
		return buscaBD(comandoSQL);
	}
	
	public Cargo getPelaDescricao(String descricao) throws SQLException {
		String comandoSQL = SQL_SELECAO + " WHERE "
						  + DESCRICAO +" like '%"+descricao+"%' ";
		return buscaBD(comandoSQL);
	}
	
	public Cargo buscaBD(String SQL) throws SQLException {
		Cargo cargo = new Cargo();
		String comandoSQL = SQL;
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			while(resultadoSQL.next())
			{
				cargo.setCodigo(resultadoSQL.getInt(CODIGO));
				cargo.setDescricao(resultadoSQL.getString(DESCRICAO));
			}

		} catch (SQLException e) {
			throw new SQLException("CargoDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}
		return cargo;
	}
}
