/** CRIADO POR:          
 * 
 *  COMENTARIOS:
 *  Rafael: (01/05/14) Adequei os atributos a modelagem UML.
 *  Rafael: (10/05/14) Transferi os metodos de MovimentacaoDAO pra ca. Com
 *  isso, esses metodos se tornam metodos sem parametros e podem mais 
 *  facilmente serem usados atraves de tags na view.
**/

package modelo.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.dao.ConexaoBancoDados;

public class Candidato extends Pessoa{

	/**** Atributos Static Final *******************************************/
	public static final String CANDIDATONOME   = "candidato_nome";
	public static final String PARTIDOSIGLA    = "partido_sigla";
	
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

	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Boolean BOOLEAN_VAZIO = false;
	public static final Partido PARTIDO_VAZIO = new Partido();
	
	/**** Atributos de Classe *******************************************/
	
	private Integer ano;
	private String cpf;
	private String cargo;
	private Partido partido;
	private String numero;
	private String uf;
	private Boolean foiEleito;
	private Integer resultadoUltimaEleicao;
	
	public Candidato() {
		this.ano = INTEGER_VAZIO;
		this.cpf = STRING_VAZIO;
		this.cargo = STRING_VAZIO;
		this.partido = PARTIDO_VAZIO;
		this.numero = STRING_VAZIO;
		this.uf = STRING_VAZIO;
		this.foiEleito = BOOLEAN_VAZIO;
		this.resultadoUltimaEleicao = INTEGER_VAZIO;
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Candidato) || object == null )
			return false;

		Candidato outroCandidato = (Candidato) object;

		return ( this.getNome().equals(outroCandidato.getNome()) &&
				 this.ano.equals(outroCandidato.getAno()) );
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Boolean getFoiEleito() {
		return foiEleito;
	}

	public void setFoiEleito(Boolean foiEleito) {
		this.foiEleito = foiEleito;
	}

	public Integer getResultadoUltimaEleicao() {
		return resultadoUltimaEleicao;
	}

	public void setResultadoUltimaEleicao(Integer resultadoUltimaEleicao) {
		this.resultadoUltimaEleicao = resultadoUltimaEleicao;
	}
	
	public LinkedList<Receita> getListaReceitas() throws SQLException {
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_receitaC "
							  + "WHERE candidato_nome "
							  + " = \"" + this.getNome() + "\" "
							  + "AND ano = "
							  + this.getAno();
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

	public LinkedList<Despesa> getListaDespesas() throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_despesaC "
							  + "WHERE candidato_nome "
							  + " = \"" + this.getNome() + "\" "
							  + "AND ano = "
							  + this.getAno();
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