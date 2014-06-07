package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import modelo.beans.Candidato;

public class CandidatoDAO extends BasicoDAO<Candidato> {

	public enum Comparacao implements Comparator<Candidato> {
		NOME {
			@Override
			public int compare(Candidato c1, Candidato c2) {
				return c1.getNome().compareToIgnoreCase(c2.getNome());
			}
		},
		
		TITULO_ELEITORAL {
			@Override
			public int compare(Candidato c1, Candidato c2) {
				return c1.getTituloEleitoral().compareTo(c2.getTituloEleitoral());
			}
		};
	}
	
	private static final String NOME_TABELA = "candidato";
	private final String NOME = "nome";
	private final String TITULO_ELEITORAL = "titulo_eleitoral";
	private final String SQL_SELECT = "SELECT * FROM " 
					   + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + TITULO_ELEITORAL + ", " 
					   + NOME + ") VALUES(?,?)";


	public CandidatoDAO() {
		super(NOME_TABELA, Comparacao.TITULO_ELEITORAL);
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
	protected void adicionarListaNoBatch(ArrayList<Candidato> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Candidato candidato : lista) {
			instrucaoSQL.setString(1, candidato.getTituloEleitoral());
			instrucaoSQL.setString(2, candidato.getNome());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Candidato> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Candidato candidato = new Candidato();
			candidato.setNome(resultadoSQL.getString(NOME));
			candidato.setTituloEleitoral(resultadoSQL.getString(TITULO_ELEITORAL));
			lista.add(candidato);
		}
	}
	
	public Candidato getCandidato(String tituloEleitoral) {

		LinkedList<Candidato> listaCandidato = new LinkedList<>();
		String comandoSQL = SQL_SELECT + " WHERE " + TITULO_ELEITORAL + " = '" + tituloEleitoral + "'";
		listaCandidato = buscaBD(comandoSQL);
		if(listaCandidato.isEmpty())
		{
			Candidato cand = new Candidato();
			cand.setTituloEleitoral("-1");
			return cand;
		}
		else if(listaCandidato.size() == 1)
			return listaCandidato.get(0);
		else
			System.out.println("Um erro ocorreu.");
			return null;
	}
	
	public LinkedList<Candidato> getLista(String nome) {

		LinkedList<Candidato> listaCandidato = new LinkedList<>();
		String comandoSQL = SQL_SELECT + " WHERE " + NOME +" LIKE '%"+nome+"%' ";
		listaCandidato = buscaBD(comandoSQL);
		return listaCandidato;
	}
	
	public LinkedList<Candidato> buscaBD(String SQL) {

		LinkedList<Candidato> listaCandidato = new LinkedList<>();

		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = SQL;

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			while (resultadoSQL.next()) {
				Candidato candidato = new Candidato();
				candidato.setNome(resultadoSQL.getString(NOME));
				candidato.setTituloEleitoral(resultadoSQL.getString(TITULO_ELEITORAL));

				if (candidato != null) listaCandidato.add(candidato);
			}

 		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 

		return listaCandidato;
	}
	
}