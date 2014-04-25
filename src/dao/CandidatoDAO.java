package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Candidato;

public class CandidatoDAO {
	
	public static final String NOME = "nome";
	public static final String CPF = "cpf";
	public static final String PARTIDO = "partido";
	public static final String NUMERO = "numero";
	public static final String ANO = "ano";
	public static final String CARGO = "cargo_pleiteado";
	public static final String RESULTADO = "resultado_eleicao";
	public static final String DOMINIO = "dominio";
	public static final String ARRECADACAO = "arrecadacao";
	public static final String DESPESA = "despesa";
	
	private ConexaoMySQL conexaoMySQL;
	
	public CandidatoDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	public void cadastrarCandidato(Candidato candidato) throws SQLException {
		validarSeCandidatoNaoExiste(candidato);
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO t_candidato (nome, cargo_pleiteado, partido, numero, ano)"
				          + "VALUES(?,?,?,?,?)";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);

		instrucaoSQL.setString(1, candidato.getNome());
		instrucaoSQL.setString(2, candidato.getCargoPleiteado());
		instrucaoSQL.setString(3, candidato.getPartido());
		instrucaoSQL.setString(4, candidato.getNumero());
		instrucaoSQL.setInt(5, candidato.getAno());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<Candidato> getListaCandidatos() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM t_candidato";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<Candidato> listaCandidatos = new LinkedList<>();
		
		while(resultadoSQL.next()) {
			Candidato candidato = new Candidato();
			candidato.setNome(resultadoSQL.getString(NOME));
			candidato.setCpf(resultadoSQL.getString(CPF));
			candidato.setPartido(resultadoSQL.getString(PARTIDO));
			candidato.setNumero(resultadoSQL.getString(NUMERO));
			candidato.setAno(resultadoSQL.getInt(ANO));
			candidato.setCargoPleiteado(resultadoSQL.getString(CARGO));
			candidato.setResultadoEleicao(resultadoSQL.getString(RESULTADO));
			candidato.setDominio(resultadoSQL.getString(DOMINIO));
			candidato.setArrecadacao(resultadoSQL.getInt(ARRECADACAO));
			candidato.setDespesa(resultadoSQL.getInt(DESPESA));
			
			if(candidato != null)
				listaCandidatos.add(candidato);
		}
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaCandidatos;
	}
	
	private void validarSeCandidatoNaoExiste(Candidato candidato) throws SQLException {
		LinkedList<Candidato> listaCandidatos = getListaCandidatos();
		
		for(Candidato candidatoLista : listaCandidatos) {
			if(candidatoLista.equals(candidato)) {
				throw new SQLException("Candidato " + candidato.getNome() + " ja existe");
			}
		}
	}
	
}
