package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Doador;
import modelo.beans.Receita;
import parse.ParseDAO;

public class ReceitaDAO extends BasicoDAO<Receita> implements ParseDAO<Receita> {
		
	private CampanhaDAO campanhaDAO;
	private DoadorDAO doadorDAO;
		
	private static final String NOME_TABELA = "receita";
	private final String ID = "id_receita";
	private final String CAMPANHA_ANO = "campanha_ano";
	private final String CAMPANHA_NUMERO = "campanha_numero";
	private final String VALOR = "valor";
	private final String FORMA_PAGAMENTO = "forma_de_pagamento_id_forma_pagamento";
	private final String DESCRICAO = "descricao";
	private final String DATA  = "data_receita";
	private final String TIPO_MOVIMENTACAO = "tipo_movimentacao_id_tipo_movimentacao";
	private final String RECIBO_ELEITORAL = "recibo_eleitoral";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String CPF_CNPJ_DOADOR = "doador_cpf_cnpj_doador";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + CAMPANHA_ANO + ", "
					   + CAMPANHA_NUMERO + ", " + VALOR + ", " 
					   + FORMA_PAGAMENTO + ", " + DESCRICAO + ", " + DATA
					   + ", " + TIPO_MOVIMENTACAO + ", " + RECIBO_ELEITORAL 
					   + ", " + NUMERO_DOCUMENTO + ", "
					   + CPF_CNPJ_DOADOR 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public ReceitaDAO() {
		super(NOME_TABELA, null);
		this.campanhaDAO = new CampanhaDAO();
		this.doadorDAO = new DoadorDAO();
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
			instrucaoSQL.setString(2, receita.getTipoMovimentacao());
			instrucaoSQL.setString(3, receita.getFormaPagamento());
			instrucaoSQL.setInt(4, receita.getCampanha().getAno());
			instrucaoSQL.setString(5, receita.getDoador().getCpf_cnpj());
			instrucaoSQL.setString(6, receita.getReciboEleitoral());
			instrucaoSQL.setString(7, receita.getNumeroDocumento());
			instrucaoSQL.setString(9, receita.getData());
			instrucaoSQL.setFloat(10, receita.getValor());
			instrucaoSQL.setString(11, receita.getDescricao());
			instrucaoSQL.addBatch();
		}
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Receita> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Campanha campanha = new Campanha();
			campanha.setAno(resultadoSQL.getInt(CAMPANHA_ANO));	
			campanha.setNumeroCandidato(resultadoSQL.getInt(CAMPANHA_NUMERO));	

			Doador doador = new Doador();
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

}
