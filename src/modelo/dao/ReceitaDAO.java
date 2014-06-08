package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Campanha;
import modelo.beans.Doador;
import modelo.beans.FormaPagamento;
import modelo.beans.Receita;
import modelo.beans.TipoMovimentacao;
import parse.ParseDAO;

public class ReceitaDAO extends BasicoDAO<Receita> implements ParseDAO<Receita> {
	
	public enum Comparacao implements Comparator<Receita> {
		ANO_E_NUMERO {
			public int compare(Receita r1, Receita r2) {
				Integer ano1 = r1.getAno();
				Integer ano2 = r2.getAno();
				if(ano1 != ano2)
					return ano1.compareTo(ano2);
				else
					return r1.getNumeroDocumento().compareTo(r2.getNumeroDocumento());
			}
		}
	}
	
	private CampanhaDAO campanhaDAO;
	private DoadorDAO doadorDAO;
		
	private static final String NOME_TABELA = "receita";
	private final String ID = "id_receita";
	private final String ID_TIPO_MOVIMENTACAO = "tipo_movimentacao_id_tipo_movimentacao";
	private final String ID_FORMA_PAGAMENTO = "forma_de_pagamento_id_forma_pagamento";
	private final String ID_CAMPANHA = "campanha_id_campanha";
	private final String CPF_CNPJ_DOADOR = "doador_cpf_cnpj";
	private final String RECIBO_ELEITORAL = "recibo_eleitoral";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String ANO = "ano";
	private final String DATA_RECEITA  = "data_receita";
	private final String VALOR = "valor";
	private final String DESCRICAO = "descricao";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + ID_TIPO_MOVIMENTACAO + ", "
					   + ID_FORMA_PAGAMENTO + ", " + ID_CAMPANHA + ", " 
					   + CPF_CNPJ_DOADOR + ", " + RECIBO_ELEITORAL + ", " + NUMERO_DOCUMENTO
					   + ", " + ANO + ", " + DATA_RECEITA + ", " + VALOR + ", "
					   + DESCRICAO + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public ReceitaDAO() {
		super(NOME_TABELA, Comparacao.ANO_E_NUMERO);
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
			instrucaoSQL.setInt(2, receita.getTipoMovimentacao().getId());
			instrucaoSQL.setInt(3, receita.getFormaPagamento().getId());
			instrucaoSQL.setInt(4, receita.getCampanha().getId());
			instrucaoSQL.setString(5, receita.getDoador().getCpf_cnpj());
			instrucaoSQL.setString(6, receita.getReciboEleitoral());
			instrucaoSQL.setString(7, receita.getNumeroDocumento());
			instrucaoSQL.setInt(8, receita.getAno());
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
			FormaPagamento formaPagamento = new FormaPagamento();
			TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
			Doador doador = new Doador();
			
			PreparaCampos(campanha, formaPagamento, tipoMovimentacao, doador, resultadoSQL);
			
			Receita receita = new Receita();
			receita.setId(resultadoSQL.getInt(ID));
			receita.setTipoMovimentacao(tipoMovimentacao);
			receita.setFormaPagamento(formaPagamento);
			receita.setCampanha(campanha);
			receita.setDoador(doador);
			receita.setReciboEleitoral(resultadoSQL.getString(RECIBO_ELEITORAL));
			receita.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
			receita.setAno(resultadoSQL.getInt(ANO));
			receita.setData(resultadoSQL.getString(DATA_RECEITA));
			receita.setValor(resultadoSQL.getFloat(VALOR));
			receita.setDescricao(resultadoSQL.getString(DESCRICAO));
			
			lista.add(receita);
		}
		
	}
	
	private void PreparaCampos(Campanha campanha,
			FormaPagamento formaPagamento, TipoMovimentacao tipoMovimentacao, Doador doador, ResultSet resultadoSQL) 
				throws SQLException {
		campanha.setId(resultadoSQL.getInt(ID_CAMPANHA));		
		formaPagamento.setId(resultadoSQL.getInt(ID_FORMA_PAGAMENTO));		
		tipoMovimentacao.setId(resultadoSQL.getInt(ID_TIPO_MOVIMENTACAO));
		doador.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ_DOADOR));
	}

}
