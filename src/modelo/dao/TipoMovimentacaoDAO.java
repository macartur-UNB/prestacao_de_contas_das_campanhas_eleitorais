package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.TipoMovimentacao;
import parse.ParseDAO;

public class TipoMovimentacaoDAO extends BasicoDAO<TipoMovimentacao> implements ParseDAO<TipoMovimentacao> {

	public enum Comparacao implements Comparator<TipoMovimentacao> {
		COD_E_DESCRICAO {
			@Override
			public int compare(TipoMovimentacao t1, TipoMovimentacao t2) {
				if (t1.getCodigo() != t2.getCodigo())
					return t1.getCodigo().compareTo(t2.getCodigo());
				else
					return t1.getDescricao().compareToIgnoreCase(t2.getDescricao());
			}
		};
	}

	private static final String ID = "id";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "tipo_movimentacao";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + ID + ", " + CODIGO + ", " + DESCRICAO + ") "
			+ "values (?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public TipoMovimentacaoDAO() {
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
	protected void adicionarListaNoBatch(ArrayList<TipoMovimentacao> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (TipoMovimentacao tipoMovimentacao : lista) {
			instrucaoSQL.setInt(1, tipoMovimentacao.getId());
			instrucaoSQL.setInt(2, tipoMovimentacao.getCodigo());
			instrucaoSQL.setString(3, tipoMovimentacao.getDescricao());

			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<TipoMovimentacao> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
			tipoMovimentacao.setCodigo(resultadoSQL.getInt(ID));
			tipoMovimentacao.setCodigo(resultadoSQL.getInt(CODIGO));
			tipoMovimentacao.setDescricao(resultadoSQL.getString(DESCRICAO));

			lista.add(tipoMovimentacao);
		}
	}

	public TipoMovimentacao getPeloId(Integer id) {
		TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
		String comandoSQL = SQL_SELECAO + " WHERE " + CODIGO +" = "+id+" ";
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			while(resultadoSQL.next())
			{
				tipoMovimentacao.setId(resultadoSQL.getInt(ID));
				tipoMovimentacao.setCodigo(resultadoSQL.getInt(CODIGO));
				tipoMovimentacao.setDescricao(resultadoSQL.getString(DESCRICAO));
			}

		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 
		return tipoMovimentacao;
	}
}
