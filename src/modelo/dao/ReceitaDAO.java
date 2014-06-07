package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Receita;
import modelo.dao.CampanhaDAO.Comparacao;
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
	private TipoMovimentacaoDAO tipoMovimentacaoDAO;
	private FormaPagamentoDAO formaPagamentoDAO;
		
	private static final String NOME_TABELA = "receita";
	private final String ID = "id_receita";
	private final String ID_TIPO_MOVIMENTACAO = "tipo_movimentacao_id_tipo_movimentacao";
	private final String ID_FORMA_PAGAMENTO = "forma_de_pagamento_id_forma_pagamento";
	private final String ID_CAMPANHA = "campanha_id_campanha";
	private final String CPF_CNPJ_DOADOR = "doador_cpf_cnpj";
	private final String RECIBO_ELEITORAL = "recibo_eleitoral";
	private final String NUMERO_DOCUMENTO = "numero_documento";
	private final String DATA_RECEITA  = "data_receita";
	private final String VALOR = "valor";
	private final String DESCRICAO = "descricao";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + COD_RESULTADO + ", "
					   + COD_CARGO + ", " + SIGLA_PARTIDO + ", " 
					   + TITULO_CANDIDATO + ", " + ANO + ", " + NUM_CANDIDATO
					   + ", " + NOME_URNA + ", " + UF + ", "
					   + DESPESA_MAX_DECLARADA + ", " + DESPESA_MAX_CALCULADA
					   + ", " + RECEITA_MAX_CALCULADA 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public ReceitaDAO() {
		super(NOME_TABELA, Comparacao.ANO_E_NUMERO);
		this.campanhaDAO = new CampanhaDAO();
		this.doadorDAO = new DoadorDAO();
		this.formaPagamentoDAO = new FormaPagamentoDAO();
		this
	}

	public ReceitaDAO(String nomeTabela, Comparator<Receita> comparador) {
		super(nomeTabela, comparador);
	}

	@Override
	protected String getSqlInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSqlSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Receita> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Receita> lista,
			ResultSet resultadoSQL) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
