/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
 *  - Cada receita deve estar em nome de um Candidato ou Partido.
 *  Portanto, deve ter atributos emNomeDe e Ano (para definir exatamente
 *  qual eh o candidato).
 *  - numeroDoc: Numero do documento
 *  - cadastroDoador: CPF ou CNPJ do doador.
**/

/*****************************************************************************/
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Despesa;
import model.Doador;
import model.Fornecedor;
import model.Receita;

/*****************************************************************************/
public class ReceitaDAO {

	/**** Atributos **********************************************************/
	public static final String EMNOMEDE        = "emNomeDe";
	public static final String ANO             = "ano";
	public static final String HORAREGISTRO    = "horaRegistro";
	public static final String ENTREGACONJUNTO = "entregaEmConjunto";
	public static final String NUMERODOC       = "numeroDoc";
	public static final String DATA            = "data";
	public static final String VALOR           = "valor";
	public static final String FONTE           = "fonte";
	public static final String TIPO            = "tipo";
	public static final String ESPECIE         = "especie";
	public static final String DESCRICAO       = "descricao";
	public static final String RECIBOELEITORAL = "reciboEleitoral";
	public static final String NOMEDOADOR      = "nomeDoador";
	public static final String CADASTRODOADOR  = "cadastroDoador";
	
	private ConexaoMySQL conexaoMySQL;
	
	/**** Construtores *******************************************************/
	public ReceitaDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	/**** Metodos ************************************************************/
	public void cadastrarReceita(Receita receita) throws SQLException {
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO t_receita (emNomeDe,ano,horaRegistro,"
				+ "entregaEmConjunto,numeroDoc,data,valor,fonte,tipo,especie,"
				+ "descricao,reciboEleitoral,nomeDoador,cadastroDoador)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement instrucaoSQL = 
				this.conexaoMySQL.prepararInstrucao(comandoSQL);

		instrucaoSQL.setString(1, receita.getEmNomeDe().getNome());
		//instrucaoSQL.setString(2, receita.getEmNomeDe().getAno()); (decidir se e candidato ou partido)
		instrucaoSQL.setString(3, receita.getHoraRegistro());
		//instrucaoSQL.setString(4, receita.getEntregaEmConjunto()); (formatacao)
		instrucaoSQL.setString(5, receita.getNumeroDocumento());
		//instrucaoSQL.setString(6, receita.getData()); (formatacao)
		//instrucaoSQL.setString(7, receita.getValor()); (transformar em String)
		instrucaoSQL.setString(8, receita.getFonte());
		instrucaoSQL.setString(9, receita.getTipo());
		instrucaoSQL.setString(10, receita.getEspecie());
		instrucaoSQL.setString(11, receita.getDescricao());
		instrucaoSQL.setString(12, receita.getReciboEleitoral());
		instrucaoSQL.setString(13, receita.getDoador().getNome());
		instrucaoSQL.setString(14, receita.getDoador().getCadastroNacional());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<Receita> getListaReceitas() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM t_receita";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		
		while(resultadoSQL.next()) {
			Receita receita = new Receita();
			//receita.setEmNomeDe(...)
			receita.setHoraRegistro(resultadoSQL.getString(HORAREGISTRO));
			if(resultadoSQL.getString(ENTREGACONJUNTO).equals("Sim")){
				receita.setEntregaEmConjunto(true);
			} else {
				receita.setEntregaEmConjunto(false);
			}
			receita.setNumeroDocumento(resultadoSQL.getString(NUMERODOC));
			//receita.setData(data) verificar formatacao
			receita.setValor(resultadoSQL.getFloat(VALOR));
			receita.setFonte(resultadoSQL.getString(FONTE));
			receita.setTipo(resultadoSQL.getString(TIPO));
			receita.setEspecie(resultadoSQL.getString(ESPECIE));
			receita.setDescricao(resultadoSQL.getString(DESCRICAO));
			receita.setReciboEleitoral(resultadoSQL.getString(RECIBOELEITORAL));
			Doador doador = new Doador();
			doador.setNome(resultadoSQL.getString(NOMEDOADOR));
			doador.setCadastroNacional("CADASTRODOADOR");
			receita.setDoador(doador);
			
			if(receita != null)
				listaReceitas.add(receita);
		}
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaReceitas;
	}
	
	
}

/*****************************************************************************/
