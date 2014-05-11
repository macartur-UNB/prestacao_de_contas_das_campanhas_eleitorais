
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Candidato;
import modelo.beans.Partido;

public class CandidatoDAO extends BasicoDAO<Candidato>{

	private enum Comparacao implements Comparator<Candidato> {
		NOME {
			@Override
			public int compare(Candidato c1, Candidato c2) {
				return c1.getNome().compareToIgnoreCase(c2.getNome());
			}
		};
	}

	public static final String NOME_TABELA = "t_candidato";
	public static final String NOME = "nome";
	public static final String CPF = "cpf";
	public static final String UF = "uf";
	public static final String PARTIDO = "partido_sigla";
	public static final String NUMERO = "numero";
	public static final String ANO = "ano";
	public static final String CARGO = "cargo_pleiteado";
	public static final String RESULTADO = "resultado_eleicao";
	private static final String SQL_SELECT = "SELECT * FROM t_candidato";
	private static final String SQL_INSERT = "INSERT INTO t_candidato (nome, cargo_pleiteado, "
			+ "partido_sigla, numero, ano, cpf, uf, resultado_eleicao)"
	        + "VALUES(?,?,?,?,?,?,?,?)";

	public CandidatoDAO() {
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
	protected void adicionarListaNoBatch(ArrayList<Candidato> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for(Candidato candidato : lista) {
			instrucaoSQL.setString(1, candidato.getNome());
			instrucaoSQL.setString(2, candidato.getCargo());
			instrucaoSQL.setString(3, candidato.getPartido().getSigla());
			instrucaoSQL.setString(4, candidato.getNumero());
			instrucaoSQL.setInt(5, candidato.getAno());
			instrucaoSQL.setString(6, candidato.getCpf());
			instrucaoSQL.setString(7, candidato.getUf());
			instrucaoSQL.setInt(8, candidato.getResultadoUltimaEleicao());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Candidato> lista,
			ResultSet resultadoSQL) throws SQLException {
		while(resultadoSQL.next()) {
			Candidato candidato = new Candidato();
			Partido partido = new Partido();
			candidato.setNome(resultadoSQL.getString(NOME));
			candidato.setCpf(resultadoSQL.getString(CPF));
			partido.setSigla(resultadoSQL.getString(PARTIDO));
			candidato.setPartido(partido);
			candidato.setNumero(resultadoSQL.getString(NUMERO));
			candidato.setAno(resultadoSQL.getInt(ANO));
			candidato.setCargo(resultadoSQL.getString(CARGO));
			candidato.setUf(resultadoSQL.getString(UF));
			candidato.setResultadoUltimaEleicao(resultadoSQL.getInt(RESULTADO));
			lista.add(candidato);
		}
	}

}