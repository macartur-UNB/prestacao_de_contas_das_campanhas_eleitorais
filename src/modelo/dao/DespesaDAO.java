package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Campanha;
import modelo.beans.Despesa;
import modelo.beans.FormaPagamento;
import modelo.beans.Fornecedor;
import modelo.beans.TipoDocumento;
import modelo.beans.TipoMovimentacao;
import parse.ParseDAO;

public class DespesaDAO extends BasicoDAO<Despesa> implements ParseDAO<Despesa>{

	public enum Comparacao implements Comparator<Despesa> {
		ANO_E_NUMERO {
			@Override
			public int compare(Despesa d1, Despesa d2) {
				Integer ano1 = d1.getAno();
				Integer ano2 = d2.getAno();
				if(ano1 != ano2)
					return ano1.compareTo(ano2);
				else
					return d1.getNumeroDocumento().compareTo(d2.getNumeroDocumento());	
			}
		}
	}
	
	
	private CampanhaDAO campanhaDAO;
	private TipoMovimentacaoDAO tipoMovimentacaoDAO;
	private FormaPagamentoDAO formaPagamentoDAO;
	private TipoDocumentoDAO tipoDocumentoDAO;
	private FornecedorDAO fornecedorDAO;
		
	private static final String NOME_TABELA = "despesa";
	private final String ID = "id_despesa";
	private final String ID_TIPO_MOVIMENTACAO = "tipo_movimentacao_id_tipo_movimentacao";
	private final String ID_TIPO_DOCUMENTO = "tipo_documento_id_tipo_documento";
	private final String ID_FORMA_PAGAMENTO = "forma_de_pagamento_id_forma_pagamento";
	private final String ID_CAMPANHA = "campanha_id_campanha";
	private final String CPF_CNPJ_FORNECEDOR = "fornecedor_cpf_cnpj";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String ANO = "ano";
	private final String VALOR = "valor";
	private final String DESCRICAO = "descricao";
	private final String DATA = "data_despesa";	
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + ID_TIPO_MOVIMENTACAO + ", "
					   + ID_TIPO_DOCUMENTO + ", " + ID_FORMA_PAGAMENTO + ", " + ID_CAMPANHA
					   + ", " + CPF_CNPJ_FORNECEDOR + ", " + NUMERO_DOCUMENTO + ", "
					   + VALOR + ", " + DESCRICAO + ", " + DATA
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public DespesaDAO() {
		super(NOME_TABELA, Comparacao.ANO_E_NUMERO);
		this.campanhaDAO = new CampanhaDAO();
		this.tipoMovimentacaoDAO = new TipoMovimentacaoDAO();
		this.formaPagamentoDAO = new FormaPagamentoDAO();
		this.tipoDocumentoDAO = new TipoDocumentoDAO();
		this.fornecedorDAO = new FornecedorDAO();
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
			instrucaoSQL.setInt(2, despesa.getTipoMovimentacao().getId());
			instrucaoSQL.setInt(3, despesa.getTipoDocumento().getId());
			instrucaoSQL.setInt(4, despesa.getFormaPagamento().getId());
			instrucaoSQL.setInt(5, despesa.getCampanha().getId());
			instrucaoSQL.setString(6, despesa.getFornecedor().getCpf_cnpj());	
			instrucaoSQL.setString(7, despesa.getNumeroDocumento());
			instrucaoSQL.setInt(8, despesa.getAno());
			instrucaoSQL.setFloat(9, despesa.getValor());	
			instrucaoSQL.setString(10, despesa.getDescricao());
			instrucaoSQL.setString(11, despesa.getData());	
			instrucaoSQL.addBatch();
		}
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Despesa> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Campanha campanha = new Campanha();
			TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
			TipoDocumento tipoDocumento = new TipoDocumento();
			FormaPagamento formaPagamento = new FormaPagamento();
			Fornecedor fornecedor = new Fornecedor();
			
			PreparaCampos(campanha, tipoMovimentacao, tipoDocumento, formaPagamento, 
					fornecedor, resultadoSQL);
			
			Despesa despesa = new Despesa();
			despesa.setId(resultadoSQL.getInt(ID));			
			despesa.setAno(resultadoSQL.getInt(ANO));
			despesa.setCampanha(campanha);
			despesa.setData(resultadoSQL.getString(DATA));
			despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
			despesa.setFormaPagamento(formaPagamento);
			despesa.setFornecedor(fornecedor);
			despesa.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
			despesa.setTipoDocumento(tipoDocumento);
			despesa.setTipoMovimentacao(tipoMovimentacao);
			despesa.setValor(resultadoSQL.getFloat(VALOR));
			
			lista.add(despesa);

		}
	}
	
	private void PreparaCampos(Campanha campanha, TipoMovimentacao tipoMovimentacao,
			TipoDocumento tipoDocumento, FormaPagamento formaPagamento, 
			Fornecedor fornecedor,ResultSet resultadoSQL) 
				throws SQLException {
		
		campanha.setId(resultadoSQL.getInt(ID_CAMPANHA));		
		tipoMovimentacao.setId(resultadoSQL.getInt(ID_TIPO_MOVIMENTACAO));		
		tipoDocumento.setId(resultadoSQL.getInt(ID_TIPO_DOCUMENTO));
		formaPagamento.setId(resultadoSQL.getInt(ID_FORMA_PAGAMENTO));
		fornecedor.setCpf_cnpj(CPF_CNPJ_FORNECEDOR);
		
	}
}
