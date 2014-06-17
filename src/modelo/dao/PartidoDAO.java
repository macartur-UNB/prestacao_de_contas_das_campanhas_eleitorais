package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Partido;
import parse.ParseDAO;

public class PartidoDAO extends BasicoDAO<Partido> implements ParseDAO<Partido> {

	public enum Comparacao implements Comparator<Partido> {
		SIGLA {
			@Override
			public int compare(Partido p1, Partido p2) {
				return p1.getSigla().compareToIgnoreCase(p2.getSigla());
			}
		};
	}

	private static final String NOME_TABELA = "partido";
	private static final String NUMERO = "numero";
	private static final String SIGLA = "sigla";
	private static final String NOME = "nome";
	private static final String DEFERIMENTO = "deferimento";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + NUMERO + ", " + SIGLA + ", " + NOME + ", " + DEFERIMENTO
			+ ") " + "values (?, ?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;

	public PartidoDAO() {
		super(NOME_TABELA, Comparacao.SIGLA);
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
	protected void adicionarListaNoBatch(ArrayList<Partido> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Partido partido : lista) {
			instrucaoSQL.setInt(1, partido.getNumero());
			instrucaoSQL.setString(2, partido.getSigla());
			instrucaoSQL.setString(3, partido.getNome());
			instrucaoSQL.setString(4, partido.getDeferimento());
			instrucaoSQL.addBatch();
		}

	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Partido> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Partido partido = new Partido();
			partido.setNome(resultadoSQL.getString(NOME));
			partido.setNumero(resultadoSQL.getInt(NUMERO));
			partido.setSigla(resultadoSQL.getString(SIGLA));
			partido.setDeferimento(resultadoSQL.getString(DEFERIMENTO));

			lista.add(partido);
		}
	}

	public Partido getPelaSigla(String sigla) throws SQLException {
		Partido partido = new Partido();
		String comandoSQL = SQL_SELECAO
				+ " WHERE " + SIGLA + " = '" + sigla + "'";

		this.conexao = new ConexaoBancoDados().getConexao();

		this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

		while (resultadoSQL.next()) {
			partido.setSigla(resultadoSQL.getString(SIGLA));
			partido.setNome(resultadoSQL.getString(NOME));
			partido.setDeferimento(resultadoSQL.getString(DEFERIMENTO));
			partido.setNumero(resultadoSQL.getInt(NUMERO));
		}

		return partido;
	}

	public Partido getPeloNumero(String numero) throws SQLException {
		Partido partido = new Partido();
		String comandoSQL = SQL_SELECAO + " WHERE " + NUMERO + " = '" + numero
				+ "' ";
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
	
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
	
			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
	
			while (resultadoSQL.next()) {
				partido.setSigla(resultadoSQL.getString(SIGLA));
				partido.setNome(resultadoSQL.getString(NOME));
				partido.setDeferimento(resultadoSQL.getString(DEFERIMENTO));
				partido.setNumero(resultadoSQL.getInt(NUMERO));
			}
	
			if(this.instrucaoSQL != null) {
				instrucaoSQL.close();
			}
			if(this.conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			throw new SQLException("PartidoDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return partido;
	}

}
