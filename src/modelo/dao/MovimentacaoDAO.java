/**
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

import modelo.beans.Despesa;
import modelo.beans.Candidato;
import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import modelo.beans.Receita;

/*****************************************************************************/
public class MovimentacaoDAO {

	/**** Atributos **********************************************************/
	public static final String CANDIDATONOME   = "candidato_nome";
	public static final String PARTIDOSIGLA   = "partido_sigla";

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

	/**** Construtores 
	 * @throws SQLException **********************************************/
	public MovimentacaoDAO() throws SQLException {
		this.conexao = new ConexaoBancoDados().getConexao();
	}

	public LinkedList<Receita> getListaReceitas(Candidato candidato) throws SQLException {
		LinkedList<Receita> listaReceitas = new LinkedList<>();

		this.conexao = new ConexaoBancoDados().getConexao();

		try {

			String comandoSQL = "SELECT * FROM t_receitaC "
							  + "WHERE candidato_nome "
							  + " = \"" + candidato.getNome() + "\" "
							  + "AND ano = "
							  + candidato.getAno();
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);	
			System.out.println(comandoSQL);

			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);

			while(resultadoSQL.next()) {

				Receita receita = new Receita();
				receita.setEmNomeDe(candidato);

				receita.setHoraRegistro(resultadoSQL.getString(HORAREGISTRO));
				if(resultadoSQL.getString(ENTREGACONJUNTO).equals("S")){
					receita.setEntregaEmConjunto(true);
				} else {
					receita.setEntregaEmConjunto(false);
				}
				receita.setNumeroDocumento(resultadoSQL.getString(NUMERODOC));
				//receita.setData(data) verificar formatacao
				//receita.setValor(resultadoSQL.getFloat(VALOR)); verificar formatacao
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
			System.out.println("Um erro aconteceu");
			throw new SQLException(e.getMessage());
		} finally {
			this.instrucaoSQL.close();
			this.conexao.close();
		}

		return listaReceitas;
	}

	public LinkedList<Despesa> getListaDespesas(Candidato candidato) throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();

		this.conexao = new ConexaoBancoDados().getConexao();

		try {

			String comandoSQL = "SELECT * FROM t_despesaC "
							  + "WHERE candidato_nome "
							  + " = \"" + candidato.getNome() + "\" "
							  + "AND ano = "
							  + candidato.getAno();
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);	
			System.out.println(comandoSQL);

			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			while(resultadoSQL.next()) {

				Despesa despesa = new Despesa();
				despesa.setEmNomeDe(candidato);
				despesa.setHoraRegistro(resultadoSQL.getString(HORAREGISTRO));
				String SN = resultadoSQL.getString(ENTREGACONJUNTO);
				if(resultadoSQL.getString(ENTREGACONJUNTO)==null){
					SN = "N";
				}
				if(SN.equals("S")) {
					despesa.setEntregaEmConjunto(true);
				} else{
					despesa.setEntregaEmConjunto(false);
				}

				despesa.setNumeroDocumento(resultadoSQL.getString(NUMERODOC));
				//despesa.setData(data) verificar formatacao
				//despesa.setValor(resultadoSQL.getFloat(VALOR)); verificar formatacao
				despesa.setFonte(resultadoSQL.getString(FONTE));
				despesa.setTipo(resultadoSQL.getString(TIPO));
				despesa.setEspecie(resultadoSQL.getString(ESPECIE));
				despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
				despesa.setTipoDocumento(resultadoSQL.getString(TIPODOC));
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(resultadoSQL.getString(NOMEFORNECEDOR));
				fornecedor.setCadastroNacional(resultadoSQL.getString(CADASTROFORNECEDOR));
				despesa.setFornecedor(fornecedor);


				if(despesa != null) listaDespesas.add(despesa);

			}
		} catch(Exception e) {
			System.out.println("Um erro aconteceu");
			throw new SQLException(e.getMessage());
		} finally {
			this.instrucaoSQL.close();
			this.conexao.close();
		}

		return listaDespesas;
	}


}