package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.TipoDocumento;
import parse.ParseDAO;

public class TipoDocumentoDAO extends BasicoDAO<TipoDocumento> implements
		ParseDAO<TipoDocumento> {

	public enum Comparacao implements Comparator<TipoDocumento> {
		COD_E_DESCRICAO {
			@Override
			public int compare(TipoDocumento t1, TipoDocumento t2) {
				if (t1.getCodigo() != t2.getCodigo())
					return t1.getCodigo().compareTo(t2.getCodigo());
				else
					return t1.getDescricao().compareToIgnoreCase(
							t2.getDescricao());
			}
		};
	}

	private static final String ID = "id_tipo_documento";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "tipo_documento";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + ID + ", " + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public TipoDocumentoDAO() {
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

	public TipoDocumento getPeloId(Integer id) throws SQLException {
		TipoDocumento tipoDocumento = new TipoDocumento();
		String comandoSQL = SQL_SELECAO + " WHERE " + ID + " = " + id + " ";

		this.conexao = new ConexaoBancoDados().getConexao();

		this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		while (resultadoSQL.next()) {
			tipoDocumento.setId(resultadoSQL.getInt(ID));
			tipoDocumento.setCodigo(resultadoSQL.getInt(CODIGO));
			tipoDocumento.setDescricao(resultadoSQL.getString(DESCRICAO));
		}

		return tipoDocumento;
	}
}
