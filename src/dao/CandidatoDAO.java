/** CRIADO POR:          
 *  ULTIMA MODIFICACAO:  01/05/2014 (Rafael)
 * 
 *  COMENTARIOS:
 *  (Rafael): Adequei os atributos a modelagem UML.
**/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Candidato;
import model.Partido;

public class CandidatoDAO {
	
	private enum Comparacao implements Comparator<Candidato> {
		NOME {
			@Override
			public int compare(Candidato c1, Candidato c2) {
				return c1.getNome().compareToIgnoreCase(c2.getNome());
			}
		};
	}
	
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
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	private PartidoDAO partidoDAO;
	
	public CandidatoDAO() {
		this.partidoDAO = new PartidoDAO();
	}
	
	public void cadastrarCandidatos(ArrayList<Candidato> listaCandidatos) throws SQLException {
		try {
			ArrayList<Candidato> listaCandidatosNaoCadastrados = new ArrayList<>();
			ArrayList<Candidato> listaCandidatosCadastrados = getListaCandidatos();
			for(Candidato candidato : listaCandidatos) {
				if(Collections.binarySearch(listaCandidatosCadastrados, candidato, Comparacao.NOME) < 0) {
					listaCandidatosNaoCadastrados.add(candidato);
				}
			}
			
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "INSERT INTO t_candidato (nome, cargo_pleiteado, "
					+ "partido, numero, ano, cpf)"
			        + "VALUES(?,?,?,?,?,?)";
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			this.conexao.setAutoCommit(false);
			
			for(Candidato candidato : listaCandidatosNaoCadastrados) {
				this.instrucaoSQL.setString(1, candidato.getNome());
				this.instrucaoSQL.setString(2, candidato.getCargo());
				this.instrucaoSQL.setString(3, candidato.getPartido().getSigla());
				this.instrucaoSQL.setString(4, candidato.getNumero());
				this.instrucaoSQL.setInt(5, candidato.getAno());
				this.instrucaoSQL.setString(6, candidato.getCpf());
				this.instrucaoSQL.addBatch();
			}
			
			this.instrucaoSQL.executeBatch();
			
			this.conexao.commit();
			
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			fecharConexao();
		}
	}
		
	public ArrayList<Candidato> getListaCandidatos() throws SQLException {
		ArrayList<Candidato> listaCandidatos = new ArrayList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_candidato ORDER BY nome ASC";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			ResultSet resultadoSQL = this.instrucaoSQL.executeQuery();
			
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
				
				candidato.setUf(resultadoSQL.getString(DOMINIO));
				
				if(candidato != null)
					listaCandidatos.add(candidato);
			}
		} catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
			throw new SQLException(e.getMessage());
		} finally {
			fecharConexao();
		}
		
		ArrayList<Partido> listaPartidos = new ArrayList<>(this.partidoDAO.getListaPartidos());
		for(Candidato candidato : listaCandidatos) {
			for(Partido partido : listaPartidos) {
				if(candidato.getPartido().getSigla().equals(partido.getSigla())) {
					candidato.setPartido(partido);
				}
			}
		}
		
		return listaCandidatos;
	}
	
	private void fecharConexao() throws SQLException {
		if(this.instrucaoSQL != null) {
			this.instrucaoSQL.close();
		}
		if(this.conexao != null) {
			this.conexao.close();
		}
	}
}
