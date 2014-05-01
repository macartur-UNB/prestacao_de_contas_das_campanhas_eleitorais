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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Despesa;
import model.Fornecedor;


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

		instrucaoSQL.setString(1, despesa.getEmNomeDe().getNome());
		//instrucaoSQL.setString(2, despesa.getEmNomeDe().getAno()); (decidir se e candidato ou partido)
		instrucaoSQL.setString(3, despesa.getHoraRegistro());
		//instrucaoSQL.setString(4, despesa.getEntregaEmConjunto()); (formatacao)
		instrucaoSQL.setString(5, despesa.getNumeroDocumento());
		//instrucaoSQL.setString(6, despesa.getData()); (formatacao)
		//instrucaoSQL.setString(7, despesa.getValor()); (transformar em String)
		instrucaoSQL.setString(8, despesa.getFonte());
		instrucaoSQL.setString(9, despesa.getTipo());
		instrucaoSQL.setString(10, despesa.getEspecie());
		instrucaoSQL.setString(11, despesa.getDescricao());
		instrucaoSQL.setString(12, despesa.getTipoDocumento());
		instrucaoSQL.setString(13, despesa.getFornecedor().getNome());
		instrucaoSQL.setString(14, despesa.getFornecedor().getCadastroNacional());
		
		instrucaoSQL.execute();
		
		this.conexaoMySQL.encerrarConexao();
	}
	
	public LinkedList<Despesa> getListaDespesas() throws SQLException {
		this.conexaoMySQL.iniciarConexao();
		
		String comandoSQL = "SELECT * FROM t_despesa";
		PreparedStatement instrucaoSQL = this.conexaoMySQL.prepararInstrucao(comandoSQL);
		
		ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
		
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		
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
		
		this.conexaoMySQL.encerrarConexao();
		
		return listaDespesas;
	}
	
}

/*****************************************************************************/
