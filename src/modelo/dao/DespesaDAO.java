package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Fornecedor;
import modelo.beans.Receita;
import parse.ParseDAO;

public class DespesaDAO extends BasicoDAO<Despesa> implements ParseDAO<Despesa>{

	//private FornecedorDAO fornecedorDAO;
		
	private static final String NOME_TABELA = "despesa";
	private final String ID = "id_despesa";
	private final String CAMPANHA_ANO = "campanha_ano";
	private final String CAMPANHA_NUMERO = "campanha_numero_candidato";
	private final String VALOR = "valor";
	private final String FORMA_PAGAMENTO = "forma_pagamento";
	private final String DESCRICAO = "descricao";
	private final String DATA = "data_despesa";	
	private final String TIPO_MOVIMENTACAO = "tipo_movimentacao";
	private final String TIPO_DOCUMENTO = "tipo_documento";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String NOME_FORNECEDOR = "fornecedor_nome";
	private final String CPF_CNPJ_FORNECEDOR = "fornecedor_cpf_cnpj";
	private final String CAMPANHA_CARGO = "cargo";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + CAMPANHA_ANO + ", "
					   + CAMPANHA_NUMERO + ", " + VALOR + ", " 
					   + FORMA_PAGAMENTO + ", " + DESCRICAO + ", " + DATA
					   + ", " + TIPO_MOVIMENTACAO + ", " + TIPO_DOCUMENTO 
					   + ", " + NUMERO_DOCUMENTO + ", " 
					   + NOME_FORNECEDOR + ", " + CPF_CNPJ_FORNECEDOR + ", " 
					   + CAMPANHA_CARGO 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public DespesaDAO() {
		super(NOME_TABELA, null);
		//this.fornecedorDAO = new FornecedorDAO();
	}

	@Override
	protected String getSqlInsert() {
		return SQL_INSERT;
	}

	@Override
	protected String getSqlSelect() {
		return SQL_SELECT;
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Despesa> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Despesa despesa : lista) {
			instrucaoSQL.setInt(1, despesa.getId());	
			instrucaoSQL.setInt(2, despesa.getCampanha().getAno());
			instrucaoSQL.setInt(3, despesa.getCampanha().getNumeroCandidato());
			instrucaoSQL.setFloat(4, despesa.getValor());	
			instrucaoSQL.setString(5, despesa.getFormaPagamento());
			instrucaoSQL.setString(6, despesa.getDescricao());
			instrucaoSQL.setString(7, despesa.getData());	
			instrucaoSQL.setString(8, despesa.getTipoMovimentacao());
			instrucaoSQL.setString(9, despesa.getTipoDocumento());
			instrucaoSQL.setString(10, despesa.getNumeroDocumento());
			instrucaoSQL.setString(11, despesa.getFornecedor().getNome());
			instrucaoSQL.setString(12, despesa.getFornecedor().getCpf_cnpj());
			instrucaoSQL.setString(13, despesa.getCampanha().getCargo().getDescricao());
			instrucaoSQL.addBatch();
		}
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Despesa> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Campanha campanha = new Campanha();
			Cargo cargo = new Cargo();
			cargo.setDescricao(resultadoSQL.getString(CAMPANHA_CARGO));
			campanha.setAno(resultadoSQL.getInt(CAMPANHA_ANO));
			campanha.setNumeroCandidato(resultadoSQL.getInt(CAMPANHA_NUMERO));
			campanha.setCargo(cargo);

			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ_FORNECEDOR));
			fornecedor.setNome(resultadoSQL.getString(NOME_FORNECEDOR));

			Despesa despesa = new Despesa();
			despesa.setId(resultadoSQL.getInt(ID));			
			despesa.setCampanha(campanha);
			despesa.setData(resultadoSQL.getString(DATA));
			despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
			despesa.setFormaPagamento(resultadoSQL.getString(FORMA_PAGAMENTO));
			despesa.setFornecedor(fornecedor);
			despesa.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
			despesa.setTipoDocumento(resultadoSQL.getString(TIPO_DOCUMENTO));
			despesa.setTipoMovimentacao(resultadoSQL.getString(TIPO_MOVIMENTACAO));
			despesa.setValor(resultadoSQL.getFloat(VALOR));
			
			lista.add(despesa);

		}
	}

	public ArrayList<Despesa> getPorAnoNumeroCargo(Campanha campanha) throws SQLException {
		String comandoSQL = SQL_SELECT + " WHERE "
				  + CAMPANHA_ANO + " = " + campanha.getAno() + " AND "
				  + CAMPANHA_NUMERO + " = " + campanha.getNumeroCandidato()
				  + " AND " + CAMPANHA_CARGO 
				  + " LIKE '%" + campanha.getCargo().getDescricao()
				  + "%'";
		return buscaBD(comandoSQL);
	}
	
	public Despesa getPeloId(int id) throws SQLException {
			String comandoSQL = SQL_SELECT + " WHERE "
					  + ID + " = " + id;
			return buscaBD(comandoSQL).get(0);
	}
	
	public ArrayList<Despesa> buscaBD(String SQL) throws SQLException {

		ArrayList<Despesa> listaDespesa = new ArrayList<>();

		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = SQL;

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			while (resultadoSQL.next()) {
				Despesa despesa = new Despesa();
				
				Cargo cargo = new Cargo();
				cargo.setDescricao(resultadoSQL.getString(CAMPANHA_CARGO));

				Campanha campanha = new Campanha();
				campanha.setAno(resultadoSQL.getInt(CAMPANHA_ANO));
				campanha.setNumeroCandidato(resultadoSQL.getInt(CAMPANHA_NUMERO));
				campanha.setCargo(cargo);
				despesa.setCampanha(campanha);
				
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(resultadoSQL.getString(NOME_FORNECEDOR));
				fornecedor.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ_FORNECEDOR));
				//despesa.setFornecedor(fornecedorDAO.getPeloNomeOuCpfCnpj(fornecedor));
				despesa.setFornecedor(fornecedor);

				
				despesa.setData(resultadoSQL.getString(DATA));
				despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
				despesa.setFormaPagamento(resultadoSQL.getString(FORMA_PAGAMENTO));
				despesa.setId(resultadoSQL.getInt(ID));
				despesa.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
				despesa.setTipoDocumento(resultadoSQL.getString(TIPO_DOCUMENTO));
				despesa.setTipoMovimentacao(resultadoSQL.getString(TIPO_MOVIMENTACAO));
				despesa.setValor(resultadoSQL.getFloat(VALOR));
				
				if (despesa != null) listaDespesa.add(despesa);
			}

		}  catch (SQLException e) {
			throw new SQLException("DespesaDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}

		return listaDespesa;
	}

	
}
