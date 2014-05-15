package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Partido;

public class CandidatoDAO extends BasicoDAO<Candidato> {

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

	private Connection conexao;
	private PreparedStatement instrucaoSQL;

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
	
	public Candidato getUmCandidato(String nome) throws SQLException {
		Candidato candidato = new Candidato();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_candidato WHERE nome LIKE '" + nome + "'";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			
			ArrayList<Candidato> listaCandidatos = new ArrayList<>();
			adicionarResultSetNaLista(listaCandidatos, resultadoSQL);
			
			if(!listaCandidatos.isEmpty()) {
				candidato = listaCandidatos.get(0);
			}
			
			instrucaoSQL.close();
			
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return candidato;	
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Candidato> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Candidato candidato : lista) {
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
		while (resultadoSQL.next()) {
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
	
	public ResultSet selectSQL(Candidato candidato, String tabela)
	{
		ResultSet resultadoSQL;
		String campoNome = "candidato_nome";
		if(tabela.equals("t_candidato")) campoNome = "nome";

		try
		{
			Connection conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = "SELECT * FROM " + tabela
							  + " WHERE " + campoNome
							  + " = \"" + candidato.getNome() + "\" "
							  + "AND ano = "
							  + candidato.getAno();
			PreparedStatement instrucaoSQL = conexao.prepareStatement(comandoSQL);	
			System.out.println(comandoSQL);

			resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			return resultadoSQL;

		} catch (SQLException e)
		{
			System.out.println("Um erro ocorreu ao tentar acessar o BD.");
			e.getMessage();	
			return null;
		} 

	}


	public LinkedList<Candidato> getCandidato(String nome) {
		
		LinkedList<Candidato> listaCandidato = new LinkedList<>();;
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = "SELECT * FROM t_candidato WHERE nome = '" + nome + "'";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			
			while (resultadoSQL.next()) {
				Candidato candidato = new Candidato();
				candidato.setNome(resultadoSQL.getString(NOME));
				candidato.setAno(resultadoSQL.getInt(ANO));
				candidato.setCpf(resultadoSQL.getString(CPF));
				candidato.setNumero(resultadoSQL.getString(NUMERO));
				candidato.setCargo(resultadoSQL.getString(CARGO));
				//candidato.setFoiEleito(resultado.getSQL(RESULTADO);
				Partido partido = new Partido();
				partido.setSigla(resultadoSQL.getString(PARTIDO));
				candidato.setPartido(partido);
				candidato.setPessoaJuridica(false);
				candidato.setUf(resultadoSQL.getString(UF));

				if (candidato != null) listaCandidato.add(candidato);
			}

		} catch (SQLException e) {
			System.out.println("Um erro aconteceu.");
			e.getMessage();
		} 

		return listaCandidato;
	}

}