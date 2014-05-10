/** CRIADO POR:          Rafael Valenca

 *  COMENTARIOS: 
 *  (06/05/14) Rafael
 *  - Cada receita deve estar em nome de um Candidato ou Partido.
 *  Portanto, deve ter atributos emNomeDe e Ano (para definir exatamente
 *  qual eh o candidato).
 *  - numeroDoc: Numero do documento
 *  - cadastroDoador: CPF ou CNPJ do doador.
 *  (10/05/14)
 *  - Uni ReceitaDAO e DespesaDAO na mesma classe.
**/

/*****************************************************************************/
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import modelo.beans.Pessoa;
import modelo.beans.Receita;

/*****************************************************************************/
public class MovimentacaoDAO {

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
	
	public static final String TIPODOC            = "tipoDoc";
	public static final String NOMEFORNECEDOR     = "nomeFornecedor";
	public static final String CADASTROFORNECEDOR = "cadastroFornecedor";
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	/**** Construtores *******************************************************/
	public MovimentacaoDAO() {
		
	}
	
	public LinkedList<Receita> getListaReceitas(Pessoa pessoa) throws SQLException {
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_receita WHERE emNomeDe = " +
			     "\"" + pessoa.getNome() + "\"";
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
			
			while(resultadoSQL.next()) {
				Receita receita = new Receita();
				receita.setEmNomeDe(pessoa);
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
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			this.instrucaoSQL.close();
			this.conexao.close();
		}
		
		return listaReceitas;
	}
	
	public LinkedList<Despesa> getListaDespesas(Pessoa pessoa) throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = "SELECT * FROM t_despesa WHERE emNomeDe = " +
			     "\"" + pessoa.getNome() + "\"";
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			ResultSet resultadoSQL = (ResultSet) this.instrucaoSQL.executeQuery();
			
			while(resultadoSQL.next()) {
				Despesa despesa = new Despesa();
				despesa.setEmNomeDe(pessoa);
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