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
import java.util.LinkedList;

import model.Candidato;
import model.Partido;

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
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	public CandidatoDAO() {
		
	}
		
	public LinkedList<Candidato> getListaCandidatos() throws SQLException {
		LinkedList<Candidato> listaCandidatos = new LinkedList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_candidato";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
						
			
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
				if(resultadoSQL.getString(RESULTADO).equals("Eleito")){
					candidato.setFoiEleito(true);
				} else {
					candidato.setFoiEleito(false);
				}
				
				candidato.setUf(resultadoSQL.getString(DOMINIO));
				
				if(candidato != null)
					listaCandidatos.add(candidato);
			}
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			this.instrucaoSQL.close();
			this.conexao.close();
		}
		
		return listaCandidatos;
	}
		
}
