package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Doador;
import modelo.beans.Receita;
import parse.ParseDAO;

public class ReceitaDAO extends BasicoDAO<Receita> implements ParseDAO<Receita> {
		
	//private DoadorDAO doadorDAO;
		
	private static final String NOME_TABELA = "receita";
	private final String ID = "id_receita";
	private final String CAMPANHA_ANO = "campanha_ano";
	private final String CAMPANHA_NUMERO = "campanha_numero_candidato";
	private final String VALOR = "valor";
	private final String FORMA_PAGAMENTO = "forma_pagamento";
	private final String DESCRICAO = "descricao";
	private final String DATA  = "data_receita";
	private final String TIPO_MOVIMENTACAO = "tipo_movimentacao";
	private final String RECIBO_ELEITORAL = "recibo_eleitoral";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String NOME_DOADOR = "doador_nome";
	private final String CPF_CNPJ_DOADOR = "doador_cpf_cnpj";
	private final String CAMPANHA_CARGO = "cargo";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + CAMPANHA_ANO + ", "
					   + CAMPANHA_NUMERO + ", " + VALOR + ", " 
					   + FORMA_PAGAMENTO + ", " + DESCRICAO + ", " + DATA
					   + ", " + TIPO_MOVIMENTACAO + ", " + RECIBO_ELEITORAL 
					   + ", " + NUMERO_DOCUMENTO + ", "
					   + NOME_DOADOR + ", " + CPF_CNPJ_DOADOR + ", " 
					   + CAMPANHA_CARGO 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public ReceitaDAO() {
		super(NOME_TABELA, null);
		//this.doadorDAO = new DoadorDAO();
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
	protected void adicionarListaNoBatch(ArrayList<Receita> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for (Receita receita : lista) {
			instrucaoSQL.setInt(1, receita.getId());
			instrucaoSQL.setInt(2, receita.getCampanha().getAno());
			instrucaoSQL.setInt(3, receita.getCampanha().getNumeroCandidato());
			instrucaoSQL.setFloat(4, receita.getValor());
			instrucaoSQL.setString(5, receita.getFormaPagamento());
			instrucaoSQL.setString(6, receita.getDescricao());
			instrucaoSQL.setString(7, receita.getData());
			instrucaoSQL.setString(8, receita.getTipoMovimentacao());
			instrucaoSQL.setString(9, receita.getReciboEleitoral());
			instrucaoSQL.setString(10, receita.getNumeroDocumento());
			instrucaoSQL.setString(11, receita.getDoador().getNome());
			instrucaoSQL.setString(12, receita.getDoador().getCpf_cnpj());
			instrucaoSQL.setString(13, receita.getCampanha().getCargo().getDescricao());
			instrucaoSQL.addBatch();
		}
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Receita> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Campanha campanha = new Campanha();
			Cargo cargo = new Cargo();
			cargo.setDescricao(resultadoSQL.getString(CAMPANHA_CARGO));
			campanha.setAno(resultadoSQL.getInt(CAMPANHA_ANO));	
			campanha.setNumeroCandidato(resultadoSQL.getInt(CAMPANHA_NUMERO));	
			campanha.setCargo(cargo);

			Doador doador = new Doador();
			doador.setNome(resultadoSQL.getString(NOME_DOADOR));
			doador.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ_DOADOR));

			Receita receita = new Receita();
			receita.setId(resultadoSQL.getInt(ID));
			receita.setTipoMovimentacao(resultadoSQL.getString(TIPO_MOVIMENTACAO));
			receita.setFormaPagamento(resultadoSQL.getString(FORMA_PAGAMENTO));
			receita.setCampanha(campanha);
			receita.setDoador(doador);
			receita.setReciboEleitoral(resultadoSQL.getString(RECIBO_ELEITORAL));
			receita.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
			receita.setData(resultadoSQL.getString(DATA));
			receita.setValor(resultadoSQL.getFloat(VALOR));
			receita.setDescricao(resultadoSQL.getString(DESCRICAO));
			
			lista.add(receita);
		}
		
	}
	

	public ArrayList<Receita> getPorAnoNumeroCargo(Campanha campanha) throws SQLException {
		String comandoSQL = SQL_SELECT + " WHERE "
				  + CAMPANHA_ANO + " = " + campanha.getAno() + " AND "
				  + CAMPANHA_NUMERO + " = " + campanha.getNumeroCandidato()
				  + " AND " + CAMPANHA_CARGO + " LIKE '%" 
				  + campanha.getCargo().getDescricao() 
				  + "%'";
		return buscaBD(comandoSQL);
	}
	
	public ArrayList<Receita> buscaBD(String SQL) throws SQLException {

		ArrayList<Receita> listaReceita = new ArrayList<>();

		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = SQL;

			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);

			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			while (resultadoSQL.next()) {
				Receita receita = new Receita();
				
				Cargo cargo = new Cargo();
				cargo.setDescricao(resultadoSQL.getString(CAMPANHA_CARGO));

				Campanha campanha = new Campanha();
				campanha.setAno(resultadoSQL.getInt(CAMPANHA_ANO));
				campanha.setNumeroCandidato(resultadoSQL.getInt(CAMPANHA_NUMERO));
				campanha.setCargo(cargo);
				receita.setCampanha(campanha);
				
				Doador doador = new Doador();
				doador.setNome(resultadoSQL.getString(NOME_DOADOR));
				doador.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ_DOADOR));
				//receita.setDoador(fornecedorDAO.getPeloNomeOuCpfCnpj(fornecedor));
				receita.setDoador(doador);

				receita.setData(resultadoSQL.getString(DATA));
				receita.setDescricao(resultadoSQL.getString(DESCRICAO));
				receita.setFormaPagamento(resultadoSQL.getString(FORMA_PAGAMENTO));
				receita.setId(resultadoSQL.getInt(ID));
				receita.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
				receita.setReciboEleitoral(resultadoSQL.getString(RECIBO_ELEITORAL));
				receita.setTipoMovimentacao(resultadoSQL.getString(TIPO_MOVIMENTACAO));
				receita.setValor(resultadoSQL.getFloat(VALOR));
				
				if (receita != null) listaReceita.add(receita);
			}

		} catch (SQLException e) {
			throw new SQLException("ReceitaDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}

		return listaReceita;
	}


}
