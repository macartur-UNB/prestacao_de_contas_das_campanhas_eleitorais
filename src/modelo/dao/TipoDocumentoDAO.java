package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.TipoDocumento;
import parse.ParseDAO;

public class TipoDocumentoDAO extends BasicoDAO<TipoDocumento> implements ParseDAO<TipoDocumento> {

	public enum Comparacao implements Comparator<TipoDocumento> {
		DESCRICAO {
			@Override
			public int compare(TipoDocumento tp1, TipoDocumento tp2) {
				return tp1.getDescricao().compareToIgnoreCase(tp2.getDescricao());
			}
		};
	}

	private static final String ID = "id";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "cargo";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + ID + ", " + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public TipoDocumentoDAO() {
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
	protected void adicionarListaNoBatch(ArrayList<TipoDocumento> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (TipoDocumento tipoDocumento : lista) {
			instrucaoSQL.setInt(1, tipoDocumento.getId());
			instrucaoSQL.setInt(2, tipoDocumento.getCodigo());
			instrucaoSQL.setString(3, tipoDocumento.getDescricao());
			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<TipoDocumento> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			TipoDocumento tipoDocumento = new TipoDocumento();
			tipoDocumento.setId(resultadoSQL.getInt(ID));
			tipoDocumento.setCodigo(resultadoSQL.getInt(CODIGO));
			tipoDocumento.setDescricao(resultadoSQL.getString(DESCRICAO));

			lista.add(tipoDocumento);
		}
	}

	public TipoDocumento getPeloId(Integer id) {
		TipoDocumento tipoDocumento = new TipoDocumento();
		String comandoSQL = SQL_SELECAO + " WHERE " + ID +" = "+id+" ";
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			while(resultadoSQL.next())
			{
				tipoDocumento.setId(resultadoSQL.getInt(ID));
				tipoDocumento.setCodigo(resultadoSQL.getInt(CODIGO));
				tipoDocumento.setDescricao(resultadoSQL.getString(DESCRICAO));
			}

		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 
		return tipoDocumento;
	}
}
