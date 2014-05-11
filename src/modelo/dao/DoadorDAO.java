package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Doador;

public class DoadorDAO extends BasicoDAO<Doador>{

	private enum Comparacao implements Comparator<Doador> {
		NOME {
			@Override
			public int compare(Doador d1, Doador d2) {
				return d1.getNome().compareToIgnoreCase(d2.getNome());
			}
		};
	}
	
	private static final String NOME_TABELA = "t_doador";
	private static final String NOME = "nome";
	private static final String CADASTRO_NACIONAL = "cadastro_nacional";
	private static final String SQL_INSERT = "INSERT INTO t_doador (nome, cadastro_nacional) VALUES(?,?)";
	private static final String SQL_SELECT = "SELECT * FROM t_doador";
	
	public DoadorDAO() {
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
	protected void adicionarListaNoBatch(ArrayList<Doador> lista, PreparedStatement instrucaoSQL) throws SQLException {
		for(Doador doador : lista) {
			instrucaoSQL.setString(1, doador.getNome());
			instrucaoSQL.setString(2, doador.getCadastroNacional());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Doador> lista,
			ResultSet resultadoSQL) throws SQLException {
		while(resultadoSQL.next()) {
			Doador doador = new Doador();				
			doador.setNome(resultadoSQL.getString(NOME));
			doador.setCadastroNacional(resultadoSQL.getString(CADASTRO_NACIONAL));
			
			lista.add(doador);
		}
	}
	
}
