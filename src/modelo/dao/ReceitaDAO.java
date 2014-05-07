/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  06/05/2014 (Luciano)
 * 
 *  COMENTARIOS: 
 *  - Cada receita deve estar em nome de um Candidato ou Partido.
 *  Portanto, deve ter atributos emNomeDe e Ano (para definir exatamente
 *  qual eh o candidato).
 *  - numeroDoc: Numero do documento
 *  - cadastroDoador: CPF ou CNPJ do doador.
**/

/*****************************************************************************/
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Doador;
import modelo.beans.Pessoa;
import modelo.beans.Receita;

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
	
	private Connection conexao;
	private PreparedStatement instrucaoSQL;
	
	/**** Construtores *******************************************************/
	public ReceitaDAO() {
		
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
	
	
}