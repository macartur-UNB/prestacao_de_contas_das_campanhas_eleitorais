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
import java.sql.SQLException;

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

		// incluir os demais campos (metodos get herdados de movimentacao 
		// financeira)
		instrucaoSQL.setString(12, receita.getReciboEleitoral());
		instrucaoSQL.setString(13, receita.getDoador().getNome());
		instrucaoSQL.setString(14, receita.getDoador().getCadastroNacional());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
}

/*****************************************************************************/
