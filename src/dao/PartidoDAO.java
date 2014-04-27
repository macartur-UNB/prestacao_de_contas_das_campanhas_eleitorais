package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Partido;

public class PartidoDAO {
	
	private static final String SIGLA_PARTIDO = "sigla";
	private static final String NUMERO_PARTIDO = "numero";
	
	private ConexaoMySQL conexaoMySQL;
	
	public PartidoDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	public void cadastrarPartido(Partido partido) throws SQLException {
		validarSePartidoNaoExiste(partido);
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO t_partido (sigla, numero)"
				          + "VALUES(?,?)";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);

		instrucaoSQL.setString(1, partido.getSigla());
		instrucaoSQL.setString(2, partido.getNumeroPartido());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<Partido> getListaPartidos() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM t_partido";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<Partido> listaPartidos = new LinkedList<>();
		
		while(resultadoSQL.next()) {
			Partido partido = new Partido();
			partido.setSigla(resultadoSQL.getString(SIGLA_PARTIDO));
			partido.setNumeroPartido(resultadoSQL.getString(NUMERO_PARTIDO));
			
			if(partido != null)
				listaPartidos.add(partido);
		}
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaPartidos;
	}
	
	private void validarSePartidoNaoExiste(Partido partido) throws SQLException {
		LinkedList<Partido> listaPartidos = getListaPartidos();
		
		for(Partido partidoLista : listaPartidos) {
			if(partidoLista.equals(partido)) {
				throw new SQLException("Partido " + partido.getSigla() + " já existe");
			}
		}
	}
	
}
