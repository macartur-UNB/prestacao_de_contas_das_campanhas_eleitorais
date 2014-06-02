package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.beans.Resultado;

public class CampanhaDAO extends BasicoDAO<Campanha> {
	
	public CampanhaDAO(String nomeTabela, Comparator<Campanha> comparador) {
		super(nomeTabela, comparador);
		// TODO Auto-generated constructor stub
	}

	public enum Comparacao implements Comparator<Campanha> {
		ANO {
			@Override
			public int compare(Campanha c1, Campanha c2) {
				return c1.getAno().compareTo(c2.getAno());
			}
		},
		NUMERO_CANDIDATO {
			@Override
			public int compare(Campanha c1, Campanha c2) {
				return c1.getNumeroCandidato().compareTo(c2.getNumeroCandidato());
			}
		};
	}
		
	private static final String NOME_TABELA = "campanha";
	private final String ID = "id_Campanha";
	private final String ID_RESULTADO = "resultado_id_resultado";
	private final String ID_CARGO = "cargo_id_cargo";
	private final String SIGLA_PARTIDO = "partido_sigla";
	private final String TITULO_CANDIDATO = "candidato_titulo_eleitoral";
	private final String ANO = "ano";
	private final String NUM_CANDIDATO = "numero_candidatura";
	private final String NOME_URNA = "nome_de_urna";
	private final String UF = "uf";
	private final String DESPESA_MAX_DECLARADA = "despesa_maxima_declarada";
	private final String DESPESA_MAX_CALCULADA = "despesa_maxima_calculada";
	private final String RECEITA_MAX_CALCULADA = "receita_maxima_calculada";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + ID_RESULTADO + ", "
					   + ID_CARGO + ", " + SIGLA_PARTIDO + ", " 
					   + TITULO_CANDIDATO + ", " + ANO + ", " + NUM_CANDIDATO
					   + ", " + NOME_URNA + ", " + UF + ", "
					   + DESPESA_MAX_DECLARADA + ", " + DESPESA_MAX_CALCULADA
					   + ", " + RECEITA_MAX_CALCULADA 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public CampanhaDAO() {
		super(NOME_TABELA, Comparacao.ANO);
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
	protected void adicionarListaNoBatch(ArrayList<Campanha> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Campanha campanha : lista) {
			instrucaoSQL.setInt(1, campanha.getId());			
			instrucaoSQL.setInt(2, campanha.getResultado().getId());
			instrucaoSQL.setInt(3, campanha.getCargo().getId());	
			instrucaoSQL.setString(4, campanha.getPartido().getSigla());	
			instrucaoSQL.setInt(5, campanha.getCandidato().getTituloEleitoral());	
			instrucaoSQL.setInt(6, campanha.getAno());	
			instrucaoSQL.setInt(7, campanha.getNumeroCandidato());	
			instrucaoSQL.setString(8, campanha.getNomeDeUrna());	
			instrucaoSQL.setString(9, campanha.getUf());	
			instrucaoSQL.setFloat(10, campanha.getDespesaMaxDeclarada());	
			instrucaoSQL.setFloat(11, campanha.getDespesaTotalCalculada());	
			instrucaoSQL.setFloat(12, campanha.getReceitaTotalCalculada());	
			instrucaoSQL.addBatch();	
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Campanha> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Cargo cargo = new Cargo();
			Resultado resultado = new Resultado();
			Partido partido = new Partido();
			Candidato candidato = new Candidato();
			PreparaCampos(cargo,resultado,partido,candidato,resultadoSQL);
			
			Campanha campanha = new Campanha();
			campanha.setId(resultadoSQL.getInt(ID));			
			campanha.setResultado(resultado);
			campanha.setCargo(cargo);
			campanha.setPartido(partido);
			campanha.setCandidato(candidato);
			campanha.setAno(resultadoSQL.getInt(ANO));
			campanha.setNumeroCandidato(resultadoSQL.getInt(NUM_CANDIDATO));
			campanha.setNomeDeUrna(resultadoSQL.getString(NOME_URNA));
			campanha.setUf(resultadoSQL.getString(UF));
			campanha.setDespesaMaxDeclarada(resultadoSQL.getFloat(DESPESA_MAX_DECLARADA));
			campanha.setDespesaTotalCalculada(resultadoSQL.getFloat(DESPESA_MAX_CALCULADA));
			campanha.setReceitaTotalCalculada(resultadoSQL.getFloat(RECEITA_MAX_CALCULADA));

			lista.add(campanha);
		}
		
	}

	private void PreparaCampos(Cargo cargo, Resultado resultado,
			Partido partido, Candidato candidato, ResultSet resultadoSQL) 
				throws SQLException {
		cargo.setId(resultadoSQL.getInt(ID_CARGO));
		// Buscar no BD a descricao e o codigo do cargo
		
		resultado.setId(resultadoSQL.getInt(ID_RESULTADO));
		// Buscar no BD a descricao e o codigo do resultado
		
		partido.setSigla(resultadoSQL.getString(SIGLA_PARTIDO));
		// Buscar no BD o nome, numero e deferimento do partido
		
		candidato.setTituloEleitoral(resultadoSQL.getInt(TITULO_CANDIDATO));
		// Buscar no BD o nome do candidato
		
	}

		
}