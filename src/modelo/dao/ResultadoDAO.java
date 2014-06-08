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
		CODIGO {
			@Override
			public int compare(Resultado r1, Resultado r2) {
				return r1.getCodigo().compareTo(r2.getCodigo());
			}
		};
	}
	
	private static final String NOME_TABELA = "resultado";
	private static final String CODIGO = "cod_resultado";
	private static final String DESCRICAO = "descricao";
	private static final String SQL_INSERCAO = "INSERT INTO "+ NOME_TABELA
			+" (" +CODIGO+", "+ DESCRICAO + ") values (?, ?)" ;
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;
	
	public ResultadoDAO() {
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
	protected void adicionarListaNoBatch(ArrayList<Resultado> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for(Resultado resultado : lista) {
			instrucaoSQL.setInt(1, resultado.getCodigo());
			instrucaoSQL.setString(2, resultado.getDescricao());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Resultado> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Resultado resultado = new Resultado();
			resultado.setCodigo(resultadoSQL.getInt(CODIGO));
			resultado.setDescricao(resultadoSQL.getString(DESCRICAO));
			
			lista.add(resultado);
		}
	}

	public Resultado getPeloCod(Integer codigo) {
		Resultado resultado = new Resultado();
		String comandoSQL = SQL_SELECAO + " WHERE " + CODIGO +" = "+codigo+" ";

		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			resultado.setCodigo(resultadoSQL.getInt(CODIGO));
			resultado.setDescricao(resultadoSQL.getString(DESCRICAO));

		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 
		return resultado;
	}
}
