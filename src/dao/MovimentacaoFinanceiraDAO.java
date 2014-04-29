package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;

import model.MovimentacaoFinanceira;

public class MovimentacaoFinanceiraDAO {
	
	public static final String NOME = "em_nome_de";
	public static final String HORA = "hora_registro";
	public static final String ENTREGA = "entrega_em_conjunto";
	public static final String NUMERO = "numero_documento";
	public static final String DATA = "data";
	public static final String VALOR = "valor";
	public static final String FONTE = "fonte";
	public static final String TIPO = "tipo";
	public static final String ESPECIE = "especie";
	public static final String DESCRICAO = "descricao";
	
	private ConexaoMySQL conexaoMySQL;
	
	public MovimentacaoFinanceiraDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	public void cadastrarMovimentacaoFinanceira(MovimentacaoFinanceira MF) throws SQLException {
		
		//Validação para movimentação financeira
		//validarSeCandidatoNaoExiste(candidato);
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO MovimentacaoFinanceira (emNomeDe, dataRegistro, horaRegistro, entregaEmConjunto,"
				+ "numeroDocumento, valor, fonte, tipo, especie, descricao)"
				          + "VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		//instrucaoSQL.setString(1, MF.getEmNomeDe()); --Do tipo Pessoa
		//instrucaoSQL.setCalendar(2, MF.getData()); --Do tipo Calendar
		instrucaoSQL.setString(3, MF.getHoraRegistro());
		instrucaoSQL.setBoolean(4, MF.isEntregaEmConjunto());
		instrucaoSQL.setString(5, MF.getNumeroDocumento());
		instrucaoSQL.setFloat(6, MF.getValor());
		instrucaoSQL.setString(7, MF.getFonte());
		instrucaoSQL.setString(8, MF.getTipo());
		instrucaoSQL.setString(9, MF.getEspecie());
		instrucaoSQL.setString(10, MF.getDescricao());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<MovimentacaoFinanceira> getListaMovimentacaoFinanceira() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM MovimentacaoFinanceira";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<MovimentacaoFinanceira> listaMovimentacaoFinanceira = new LinkedList<>();
		
		while(resultadoSQL.next()) {
			MovimentacaoFinanceira MF = new MovimentacaoFinanceira();
			//MF.setEmNomeDe(resultadoSQL.getString(NOME));
			//MF.setData(resultadoSQL.getString(DATA));
			MF.setHoraRegistro(resultadoSQL.getString(HORA));
			MF.setEntregaEmConjunto(resultadoSQL.getBoolean(ENTREGA));
			MF.setNumeroDocumento(resultadoSQL.getString(NUMERO));
			MF.setValor(resultadoSQL.getFloat(VALOR));
			MF.setFonte(resultadoSQL.getString(FONTE));
			MF.setTipo(resultadoSQL.getString(TIPO));
			MF.setEspecie(resultadoSQL.getString(ESPECIE));
			MF.setDescricao(resultadoSQL.getString(DESCRICAO));
			
			if(MF != null)
				listaMovimentacaoFinanceira.add(MF);
		}
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaMovimentacaoFinanceira;
	}
	
	/* --VERIFICAR VALIDACAO PARA MOVIMENTACAO FINANCEIRA
	private void validarSeCandidatoNaoExiste(Candidato candidato) throws SQLException {
		LinkedList<Candidato> listaCandidatos = getListaCandidatos();
		
		for(Candidato candidatoLista : listaCandidatos) {
			if(candidatoLista.equals(candidato)) {
				throw new SQLException("Candidato " + candidato.getNome() + " ja existe");
			}
		}
	}*/
	

}
