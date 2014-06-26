package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.beans.Resultado;

public class CampanhaDAO extends BasicoDAO<Campanha> {

	private CandidatoDAO candidatoDAO;
	private PartidoDAO partidoDAO;
	private CargoDAO cargoDAO;
	private ResultadoDAO resultadoDAO;

	private static final String NOME_TABELA = "campanha";
	private final String ID = "id_campanha";
	private final String ANO = "ano";
	private final String NUM_CANDIDATO = "numero_candidato";
	private final String COD_RESULTADO = "resultado_cod_resultado";
	private final String COD_CARGO = "cargo_cod_cargo";
	private final String NUMERO_PARTIDO = "partido_numero";
	private final String TITULO_CANDIDATO = "candidato_titulo_eleitoral";
	private final String NOME_URNA = "nome_de_urna";
	private final String UF = "uf";
	private final String DESPESA_MAX_DECLARADA = "despesa_maxima_declarada";
	private final String DESPESA_MAX_CALCULADA = "despesa_maxima_calculada";
	private final String RECEITA_MAX_CALCULADA = "receita_maxima_calculada";

	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO " + NOME_TABELA + " (" + ID
			+ ", " + ANO + ", " + NUM_CANDIDATO + ", " + COD_RESULTADO + ", "
			+ COD_CARGO + ", " + NUMERO_PARTIDO + ", " + TITULO_CANDIDATO
			+ ", " + NOME_URNA + ", " + UF + ", " + DESPESA_MAX_DECLARADA
			+ ", " + DESPESA_MAX_CALCULADA + ", " + RECEITA_MAX_CALCULADA
			+ ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private final String INDEX_CANDIDATO = "campanha_fk_3";
	private final String INDEX_PARTIDO = "campanha_fk_4";
	private final String INDEX_ANO = "campanha_sk_1";

	public CampanhaDAO() {
		super(NOME_TABELA, null);
	}

	@Override
	protected String getSqlInsert() {
		return SQL_INSERT;
	}

	@Override
	protected String getSqlSelect() {
		return SQL_SELECT;
	}

	public String getSqlSelectNomeUrna(String nome) {
		return "SELECT " + TITULO_CANDIDATO + " FROM " + NOME_TABELA
				+ " WHERE " + NOME_URNA + " LIKE '%" + nome + "%'";
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Campanha> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Campanha campanha : lista) {
			instrucaoSQL.setInt(1, campanha.getId());
			instrucaoSQL.setInt(2, campanha.getAno());
			instrucaoSQL.setInt(3, campanha.getNumeroCandidato());
			instrucaoSQL.setInt(4, campanha.getResultado().getCodigo());
			instrucaoSQL.setInt(5, campanha.getCargo().getCodigo());
			instrucaoSQL.setInt(6, campanha.getPartido().getNumero());
			instrucaoSQL.setString(7, campanha.getCandidato()
					.getTituloEleitoral());
			instrucaoSQL.setString(8, campanha.getNomeDeUrna());
			instrucaoSQL.setString(9, campanha.getUf());
			instrucaoSQL.setFloat(10, campanha.getDespesaMaxDeclarada());
			instrucaoSQL.setFloat(11, campanha.getDespesaTotalCalculada());
			instrucaoSQL.setFloat(12, campanha.getReceitaTotalCalculada());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Campanha> lista, ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Cargo cargo = new Cargo();
			Resultado resultado = new Resultado();
			Partido partido = new Partido();
			Candidato candidato = new Candidato();
			PreparaCamposCargoEResultado(cargo, resultado, resultadoSQL);
			PreparaCamposCandidatoEPartido(partido, candidato, resultadoSQL);

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

	private void PreparaCamposCargoEResultado(Cargo cargo, Resultado resultado,
			ResultSet resultadoSQL) throws SQLException {
		cargo.setCodigo(resultadoSQL.getInt(COD_CARGO));
		resultado.setCodigo(resultadoSQL.getInt(COD_RESULTADO));
	}

	private void PreparaCamposCandidatoEPartido(Partido partido,
			Candidato candidato, ResultSet resultadoSQL) throws SQLException {
		partido.setNumero(resultadoSQL.getInt(NUMERO_PARTIDO));
		candidato.setTituloEleitoral(resultadoSQL.getString(TITULO_CANDIDATO));
	}

	public ArrayList<Campanha> getCampanhasPeloTituloEleitoral(
			Candidato candidato) throws SQLException {
		ArrayList<Campanha> listaCampanha = new ArrayList<>();
		String comandoSQL = SQL_SELECT + " USE INDEX (" + INDEX_CANDIDATO + ")"
				+ " WHERE " + TITULO_CANDIDATO + " = '"
				+ candidato.getTituloEleitoral() + "' ";
		listaCampanha = buscaBD(comandoSQL);
		return listaCampanha;
	}

	public ArrayList<Campanha> getCampanhasPorSiglaEAno(String sigla, String ano)
			throws SQLException {
		this.partidoDAO = new PartidoDAO();

		ArrayList<Campanha> listaCampanha = new ArrayList<>();
		Partido partido = this.partidoDAO.getPelaSigla(sigla);
		String comandoSQL = SQL_SELECT + " USE INDEX (" + INDEX_PARTIDO + ", "
				+ INDEX_ANO + ")" + " WHERE " + NUMERO_PARTIDO + " = '"
				+ partido.getNumero() + "' AND " + ANO + " = '" + ano + "' ";
		listaCampanha = buscaBD(comandoSQL);
		return listaCampanha;
	}

	public Campanha getPeloAnoNumeroCodCargoEUf(Campanha campanha)
			throws SQLException {
		ArrayList<Campanha> listaCampanha = new ArrayList<>();
		String comandoSQL = SQL_SELECT + " WHERE " + ANO + " = "
				+ campanha.getAno() + " AND " + UF + " = '" + campanha.getUf()
				+ "' AND " + NUM_CANDIDATO + " = '"
				+ campanha.getNumeroCandidato() + "' AND " + COD_CARGO + " = "
				+ campanha.getCargo().getCodigo();
		listaCampanha = buscaBD(comandoSQL);
		if (listaCampanha.isEmpty())
			return null;
		else
			return listaCampanha.get(0);
	}

	public ArrayList<Campanha> buscaBD(String SQL) throws SQLException {

		ArrayList<Campanha> listaCampanha = new ArrayList<>();
		this.candidatoDAO = new CandidatoDAO();
		this.cargoDAO = new CargoDAO();
		this.partidoDAO = new PartidoDAO();
		this.resultadoDAO = new ResultadoDAO();

		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = SQL;
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			while (resultadoSQL.next()) {
				Campanha campanha = new Campanha();
				campanha.setAno(resultadoSQL.getInt(ANO));
				campanha.setCargo(cargoDAO.getPeloCod(resultadoSQL.getInt(COD_CARGO)));
				campanha.setDespesaMaxDeclarada(resultadoSQL.getFloat(DESPESA_MAX_DECLARADA));
				campanha.setDespesaTotalCalculada(resultadoSQL.getFloat(DESPESA_MAX_CALCULADA));
				campanha.setNomeDeUrna(resultadoSQL.getString(NOME_URNA));
				campanha.setNumeroCandidato(resultadoSQL.getInt(NUM_CANDIDATO));
				campanha.setPartido(partidoDAO.getPeloNumero(resultadoSQL.getString(NUMERO_PARTIDO)));
				campanha.setReceitaTotalCalculada(resultadoSQL.getFloat(RECEITA_MAX_CALCULADA));
				campanha.setResultado(resultadoDAO.getPeloCod(resultadoSQL.getInt(COD_RESULTADO)));
				campanha.setUf(resultadoSQL.getString(UF));
				campanha.setCandidato(candidatoDAO.getCandidatoPeloTitulo(resultadoSQL.getString(TITULO_CANDIDATO)));
				if (campanha != null)
					listaCampanha.add(campanha);
			}
		} catch (SQLException e) {
			throw new SQLException("CampanhaDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}
		return listaCampanha;
	}
	
	public ArrayList<Campanha> TopFive (String cargo, Integer ano) throws SQLException {
		int codigo = 0;
		switch (cargo.toLowerCase()) {
		
			case "presidente": 
				codigo = 1; break;
			case "governador": 
				codigo = 3; break;
			case "senador": 
				codigo = 5; break;
			default: 
				return null;
					
		}
		String comandoSQL = SQL_SELECT + " WHERE " + ANO + " = " + ano + " and " 
		                   +COD_CARGO + " = " + codigo + " ORDER BY " + DESPESA_MAX_DECLARADA
		                   +" DESC LIMIT 5";
		
		return buscaBD(comandoSQL);
	}
}