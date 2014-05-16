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
import modelo.beans.Partido;
import modelo.beans.Receita;

public class MovimentacaoDAO {

	/**** Atributos Static Final *******************************************/
	public static final String CANDIDATONOME   = "candidato_nome";
	public static final String PARTIDOSIGLA    = "partido_sigla";
	public static final String ANO             = "ano";
	public static final String HORAREGISTRO    = "hora_registro";
	public static final String ENTREGACONJUNTO = "entrega_em_conjunto";
	public static final String NUMERODOC       = "numero_documento";
	public static final String VALOR           = "valor";
	public static final String FONTE           = "fonte";
	public static final String TIPO            = "tipo";
	public static final String ESPECIE         = "especie";
	public static final String DESCRICAO       = "descricao";

	public static final String RECIBOELEITORAL = "reciboEleitoral";
	public static final String NOMEDOADOR      = "nomeDoador";
	public static final String CADASTRODOADOR  = "cadastroDoador";

	public static final String TIPODOC            = "tipo_documento";
	public static final String NOMEFORNECEDOR     = "fornecedor";
	public static final String CADASTROFORNECEDOR = "cadastroFornecedor";
	
	public LinkedList<Receita> getListaReceitas(Candidato candidato) {
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		CandidatoDAO dao = new CandidatoDAO();
		ResultSet resultadoSQL = dao.selectSQL(candidato, "t_receitaC");		

		try {			
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
				receita.setAno(Integer.parseInt(resultadoSQL.getString(ANO)));
				receita.setValor(Float.parseFloat(resultadoSQL.getString(VALOR))); 
				receita.setFonte(resultadoSQL.getString(FONTE));
				receita.setTipo(resultadoSQL.getString(TIPO));
				receita.setEspecie(resultadoSQL.getString(ESPECIE));
				receita.setDescricao(resultadoSQL.getString(DESCRICAO));
				receita.setReciboEleitoral(resultadoSQL.getString(RECIBOELEITORAL));
				Doador doador = new Doador();
				doador.setNome(resultadoSQL.getString(NOMEDOADOR));
				doador.setCadastroNacional("CADASTRODOADOR");
				receita.setDoador(doador);

				if(receita != null)	listaReceitas.add(receita);
			};

		} catch(SQLException e) {
			System.out.println("Um erro aconteceu");
			e.getMessage();
		}

		return listaReceitas;

	}

	public LinkedList<Despesa> getListaDespesas(Candidato candidato) {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		CandidatoDAO dao = new CandidatoDAO();
		ResultSet resultadoSQL = dao.selectSQL(candidato, "t_despesa");

		try	{
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
				despesa.setAno(resultadoSQL.getInt("ANO"));
				despesa.setValor(resultadoSQL.getFloat(VALOR)); 
				despesa.setFonte(resultadoSQL.getString(FONTE));
				despesa.setTipo(resultadoSQL.getString(TIPO));
				despesa.setEspecie(resultadoSQL.getString(ESPECIE));
				despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
				despesa.setTipoDocumento(resultadoSQL.getString(TIPODOC));
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(resultadoSQL.getString(NOMEFORNECEDOR));
				//fornecedor.setCadastroNacional(resultadoSQL.getString(CADASTROFORNECEDOR));
				despesa.setFornecedor(fornecedor);

				if(despesa != null) listaDespesas.add(despesa);
			}
		} catch(SQLException e) {	
			System.out.println("Um erro aconteceu");
			e.getMessage();
		}

		return listaDespesas;

	}
	

	public LinkedList<Receita> getListaReceitas(Partido partido, Integer ano) throws SQLException {
		LinkedList<Receita> listaReceitas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_receitaP "
							  + "WHERE partido_sigla "
							  + " = \"" + partido.getSigla() + "\" "
							  + "AND ano = "
							  + ano;
			PreparedStatement instrucaoSQL = conexao.prepareStatement(comandoSQL);
			System.out.println(comandoSQL);
			
			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			
			while(resultadoSQL.next()) {
				
				Receita receita = new Receita();
				receita.setEmNomeDe(partido);
				
				receita.setHoraRegistro(resultadoSQL.getString(HORAREGISTRO));
				if(resultadoSQL.getString(ENTREGACONJUNTO).equals("S")){
					receita.setEntregaEmConjunto(true);
				} else {
					receita.setEntregaEmConjunto(false);
				}
				receita.setNumeroDocumento(resultadoSQL.getString(NUMERODOC));
				receita.setAno(resultadoSQL.getInt("ANO"));
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
			instrucaoSQL.close();
			
		} catch(Exception e) {
			System.out.println("Um erro aconteceu");
			throw new SQLException(e.getMessage());
		} finally {
			conexao.close();
		}

		return listaReceitas;
	}

	public LinkedList<Despesa> getListaDespesas(Partido partido,Integer ano) throws SQLException {
		LinkedList<Despesa> listaDespesas = new LinkedList<>();
		
		Connection conexao = new ConexaoBancoDados().getConexao();
		
		try {

			String comandoSQL = "SELECT * FROM t_despesaP "
							  + "WHERE partido_sigla "
							  + " = \"" + partido.getSigla() + "\""
							  + " AND ano = "
							  + ano;
			PreparedStatement instrucaoSQL = conexao.prepareStatement(comandoSQL);	
			System.out.println(comandoSQL);
			
			ResultSet resultadoSQL = instrucaoSQL.executeQuery(comandoSQL);
			while(resultadoSQL.next()) {
				
				Despesa despesa = new Despesa();
				despesa.setEmNomeDe(partido);
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
				despesa.setAno(resultadoSQL.getInt("ANO"));
				despesa.setValor(resultadoSQL.getFloat(VALOR)); 
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
