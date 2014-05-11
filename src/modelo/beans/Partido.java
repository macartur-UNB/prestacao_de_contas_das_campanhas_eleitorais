/** CRIADO POR:          
 * 
 *  COMENTARIOS:
 *  Rafael: (10/05/14) Transferi os metodos de MovimentacaoDAO pra ca. Com
 *  isso, esses metodos se tornam metodos sem parametros e podem mais 
 *  facilmente serem usados atraves de tags na vies.
**/

package modelo.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.dao.ConexaoBancoDados;

public class Partido extends Pessoa {
	
	/**** Atributos Static Final *******************************************/
	public static final String PARTIDOSIGLA    = "partido_sigla";
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
	
	public static final String CAMPO_VAZIO = "";
	
	/**** Atributos de Classe *******************************************/
	private String numeroPartido;
	private String sigla;
	
	public Partido() {
		this.sigla = CAMPO_VAZIO;
		this.numeroPartido = CAMPO_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) || object == null )
			return false;
		
		Partido outroPartido = (Partido) object;
		return this.sigla.equalsIgnoreCase(outroPartido.getSigla());
	}
	
	public String getNumeroPartido() {
		return numeroPartido;
	}
	
	public void setNumeroPartido(String numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

	public LinkedList<Receita> getListaReceitas(Integer ano) throws SQLException {
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_receitaP "
							  + "WHERE partido_sigla "
							  + " = \"" + this.getNome() + "\" ";
							  //+ "AND ano = "
							  //+ ano;
			PreparedStatement instrucaoSQL = conexao.prepareStatement(comandoSQL);
			System.out.println(comandoSQL);
			
			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			
			while(resultadoSQL.next()) {
				
				Receita receita = new Receita();
				receita.setEmNomeDe(this);
				
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
			instrucaoSQL.close();
			
		} catch(Exception e) {
			System.out.println("Um erro aconteceu");
			throw new SQLException(e.getMessage());
		} finally {
			conexao.close();
		}

		return listaReceitas;
	}

	public LinkedList<Despesa> getListaDespesas(Integer ano) throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_despesaP "
							  + "WHERE partido_sigla "
							  + " = \"" + this.getNome() + "\"";
							  //+ "AND ano = "
							  //+ ano;
			PreparedStatement instrucaoSQL = conexao.prepareStatement(comandoSQL);	
			System.out.println(comandoSQL);
			
			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			while(resultadoSQL.next()) {
				
				Despesa despesa = new Despesa();
				despesa.setEmNomeDe(this);
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
			instrucaoSQL.close();
		} catch(Exception e) {
			System.out.println("Um erro aconteceu");
			throw new SQLException(e.getMessage());
		} finally {	
			conexao.close();
		}

		return listaDespesas;
	}

	
}
