/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
 *  - Cada despesa deve estar em nome de um Candidato ou Partido.
 *  Portanto, deve ter atributos emNomeDe e Ano (para definir exatamente
 *  qual eh o candidato).
 *  - numeroDoc: Numero do documento
 *  - cadastroFornecedor: CPF ou CNPJ do fornecedor.
**/

/*****************************************************************************/
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Despesa;

/*****************************************************************************/
public class DespesaDAO {

	/**** Atributos **********************************************************/
	public static final String EMNOMEDE           = "emNomeDe";
	public static final String ANO                = "ano";
	public static final String HORAREGISTRO       = "horaRegistro";
	public static final String ENTREGACONJUNTO    = "entregaEmConjunto";
	public static final String NUMERODOC          = "numeroDoc";
	public static final String DATA               = "data";
	public static final String VALOR              = "valor";
	public static final String FONTE              = "fonte";
	public static final String TIPO               = "tipo";
	public static final String ESPECIE            = "especie";
	public static final String DESCRICAO          = "descricao";
	public static final String TIPODOC            = "tipoDoc";
	public static final String NOMEFORNECEDOR     = "nomeFornecedor";
	public static final String CADASTROFORNECEDOR = "cadastroFornecedor";
	
	private ConexaoMySQL conexaoMySQL;
	
	/**** Construtores *******************************************************/
	public DespesaDAO() {
		this.conexaoMySQL = ConexaoMySQL.getInstancia();
	}
	
	/**** Metodos ************************************************************/
	public void cadastrarDespesa(Despesa despesa) throws SQLException {
		
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "INSERT INTO t_despesa (emNomeDe,ano,horaRegistro,"
				+ "entregaEmConjunto,numeroDoc,data,valor,fonte,tipo,especie,"
				+ "descricao,tipoDoc,nomeFornecedor,cadastroFornecedor)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement instrucaoSQL = 
				this.conexaoMySQL.prepararInstrucao(comandoSQL);

		// incluir os demais campos (metodos get herdados de movimentacao 
		// financeira)
		instrucaoSQL.setString(12, despesa.getTipoDocumento());
		instrucaoSQL.setString(13, despesa.getFornecedor().getNome());
		instrucaoSQL.setString(14, despesa.getFornecedor().getCadastroNacional());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
}

/*****************************************************************************/
