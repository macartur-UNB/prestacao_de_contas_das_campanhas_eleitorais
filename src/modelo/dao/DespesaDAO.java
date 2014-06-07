package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Despesa;
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
		
	private static final String NOME_TABELA = "campanha";
	private final String ID = "id_Campanha";
	private final String COD_RESULTADO = "resultado_cod_resultado";
	private final String COD_CARGO = "cargo_cod_cargo";
	private final String SIGLA_PARTIDO = "partido_sigla";
	private final String TITULO_CANDIDATO = "candidato_titulo_eleitoral";
	private final String ANO = "ano";
	private final String NUM_CANDIDATO = "numero_candidatura";
	private final String NOME_URNA = "nome_de_urna";
	private final String UF = "uf";
	private final String DESPESA_MAX_DECLARADA = "despesa_maxima_declarada";
	private final String DESPESA_MAX_CALCULADA = "despesa_maxima_calculada";
	private final String RECEITA_MAX_CALCULADA = "receita_maxima_calculada";
	
	private final String SQL_SELECT = "SELECT * FROM " + NOME_TABELA;
	private final String SQL_INSERT = "INSERT INTO "
					   + NOME_TABELA + " (" + ID + ", " + COD_RESULTADO + ", "
					   + COD_CARGO + ", " + SIGLA_PARTIDO + ", " 
					   + TITULO_CANDIDATO + ", " + ANO + ", " + NUM_CANDIDATO
					   + ", " + NOME_URNA + ", " + UF + ", "
					   + DESPESA_MAX_DECLARADA + ", " + DESPESA_MAX_CALCULADA
					   + ", " + RECEITA_MAX_CALCULADA 
					   + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	

	public DespesaDAO(String nomeTabela, Comparator<Despesa> comparador) {
		super(nomeTabela, comparador);
		// TODO Auto-generated constructor stub
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
	protected void adicionarListaNoBatch(ArrayList<Despesa> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Despesa> lista,
			ResultSet resultadoSQL) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
