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
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Despesa;
import modelo.beans.Fornecedor;


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
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	/**** Construtores *******************************************************/
	public DespesaDAO() {

	}
	
	public LinkedList<Despesa> getListaDespesas() throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = "SELECT * FROM t_despesa";
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
			
			while(resultadoSQL.next()) {
				Despesa despesa = new Despesa();
				//despesa.setEmNomeDe(...)
				despesa.setHoraRegistro(resultadoSQL.getString(HORAREGISTRO));
				if(resultadoSQL.getString(ENTREGACONJUNTO).equals("Sim")){
					despesa.setEntregaEmConjunto(true);
				} else {
					despesa.setEntregaEmConjunto(false);
				}
				despesa.setNumeroDocumento(resultadoSQL.getString(NUMERODOC));
				//despesa.setData(data) verificar formatacao
				despesa.setValor(resultadoSQL.getFloat(VALOR));
				despesa.setFonte(resultadoSQL.getString(FONTE));
				despesa.setTipo(resultadoSQL.getString(TIPO));
				despesa.setEspecie(resultadoSQL.getString(ESPECIE));
				despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
				despesa.setTipoDocumento(resultadoSQL.getString(TIPODOC));
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(resultadoSQL.getString(NOMEFORNECEDOR));
				fornecedor.setCadastroNacional("CADASTROFORNECEDOR");
				despesa.setFornecedor(fornecedor);
				
				if(despesa != null)
					listaDespesas.add(despesa);
			}
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			this.instrucaoSQL.close();
			this.conexao.close();
		}
		
		return listaDespesas;
	}
	
}

/*****************************************************************************/
