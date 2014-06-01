package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Resultado;
import parse.ParseDAO;

public class ResultadoDAO extends BasicoDAO<Resultado> implements ParseDAO<Resultado> {

	public enum Comparacao implements Comparator<Resultado> {
		DESCRICAO {
			@Override
			public int compare(Resultado r1, Resultado r2) {
				return r1.getDescricao().compareToIgnoreCase(r2.getDescricao());
			}
		};
	}
	
	private static final String ID = "id";
	private static final String CODIGO = "codigo";
	private static final String DESCRICAO = "descricao";
	private static final String NOME_TABELA = "resultado";
	private static final String SQL_INSERCAO = "INSERT INTO "+ NOME_TABELA
			+" ("+ID+", "+CODIGO+", "+ DESCRICAO + "values (?, ?, ?)" ;
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;
	
	public ResultadoDAO(String nomeTabela, Comparator<Resultado> comparador) {
		super(nomeTabela, Comparacao.DESCRICAO);
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
	protected void adicionarListaNoBatch(ArrayList<Resultado> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for(Resultado resultado : lista) {
			instrucaoSQL.setInt(1, resultado.getId());
			instrucaoSQL.setInt(2, resultado.getCodigo());
			instrucaoSQL.setString(3, resultado.getDescricao());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Resultado> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Resultado resultado = new Resultado();
			resultado.setId(resultadoSQL.getInt(ID));
			resultado.setCodigo(resultadoSQL.getInt(CODIGO));
			resultado.setDescricao(resultadoSQL.getString(DESCRICAO));
			
			lista.add(resultado);
		}
	}

}
