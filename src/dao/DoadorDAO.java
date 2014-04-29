package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Doador;

public class DoadorDAO {

	public static final String NOME = "nome";
	public static final String PESSOAJURIDICA = "pessoa_juridica";
	public static final String CADASTRONACIONAL = "cadastro_nacional";
	
	private ConexaoMySQL conexaoMySQL;
	
	public DoadorDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	public void cadastrarDoador(Doador doador) throws SQLException {
		validarSeDoadorNaoExiste(doador);
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO t_doador (nome, pessoa_juridica, cadastro_nacional)"
						  + "VALUES(?,?,?)";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		instrucaoSQL.setString(1, doador.getNome());
		instrucaoSQL.setBoolean(2, doador.getPessoaJuridica());
		instrucaoSQL.setInt(3, doador.getCadastroNacional());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<Doador> getListaDoadores() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM t_doador";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<Doador> listaDoadores = new LinkedList<>();
		
		while(resultadoSQL.next()) {
			Doador doador = new Doador();
			doador.setNome(resultadoSQL.getString(NOME));
			doador.setPessoaJuridica(resultadoSQL.getBoolean(PESSOAJURIDICA));
			doador.setCadastroNacional(resultadoSQL.getInt(CADASTRONACIONAL));
			
			if(doador != null)
				listaDoadores.add(doador);
		}
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaDoadores;
	}
	
	private void validarSeDoadorNaoExiste(Doador doador) throws SQLException {
		LinkedList<Doador> listaDoadores = getListaDoadores();
		
		for(Doador doadorLista : listaDoadores) {
			if(doadorLista.equals(doador)) {
				throw new SQLException("Doador " + doador.getNome() + " ja existe");
			}
		}
	}
}
