package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Fornecedor;

public class DespesaDAO extends BasicoDAO<Despesa> {
	
	private enum Comparacao implements Comparator<Despesa> {
		NOME {
			@Override
			public int compare(Despesa d1, Despesa d2) {
				return d1.getEmNomeDe().getNome().compareToIgnoreCase(d2.getEmNomeDe().getNome());
			}
		};
	}
	
	public static final String EM_NOME_DE = "em_nome_de";
	public static final String HORA_REGISTRO = "hora_registro";
	public static final String ENTREGA_EM_CONJUNTO = "entrega_em_conjunto";
	public static final String NUMERO_DOCUMENTO = "numero_documento";
	public static final String ANO = "ano";
	public static final String VALOR= "valor";
	public static final String FONTE = "fonte";
	public static final String TIPO = "tipo";
	public static final String ESPECIE = "especie";
	public static final String DESCRICAO = "descricao";
	public static final String TIPO_DOCUMENTO = "tipo_documento";
	public static final String FORNECEDOR = "fornecedor";
	
	public static final String NOME_TABELA = "t_despesa";
	private static final String SQL_SELECT = "SELECT * FROM t_despesa ORDER BY em_nome_de";
	private static final String SQL_INSERT = "INSERT INTO t_despesa (em_nome_de, hora_registro, "
			+ "entrega_em_conjunto, numero_documento, ano, valor, fonte, tipo, especie, "
			+ "descricao, tipo_documento, fornecedor) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

	private CandidatoDAO candidatoDAO;
	private FornecedorDAO fornecedorDAO;
	
	public DespesaDAO() {
		super(NOME_TABELA, Comparacao.NOME);
		
		this.candidatoDAO = new CandidatoDAO();
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
		for (Despesa despesa: lista) {
			instrucaoSQL.setString(1, despesa.getEmNomeDe().getNome());
			instrucaoSQL.setString(2, despesa.getHoraRegistro());
			instrucaoSQL.setBoolean(3, despesa.isEntregaEmConjunto());
			instrucaoSQL.setString(4, despesa.getNumeroDocumento());
			instrucaoSQL.setString(5, despesa.getAno());
			instrucaoSQL.setFloat(6, despesa.getValor());
			instrucaoSQL.setString(7, despesa.getFonte());
			instrucaoSQL.setString(8, despesa.getTipo());
			instrucaoSQL.setString(9, despesa.getEspecie());
			instrucaoSQL.setString(10, despesa.getDescricao());
			instrucaoSQL.setString(11, despesa.getTipoDocumento());
			instrucaoSQL.setString(12, despesa.getFornecedor().getNome());
			instrucaoSQL.addBatch();
		}
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Despesa> lista,
			ResultSet resultadoSQL) throws SQLException {
		while (resultadoSQL.next()) {
			Despesa despesa = new Despesa();
			Fornecedor fornecedor = new Fornecedor();
			Candidato candidato = new Candidato();
			
			candidato = this.candidatoDAO.getUmCandidato(resultadoSQL.getString(EM_NOME_DE),
					resultadoSQL.getInt(ANO));
			fornecedor = this.fornecedorDAO.getUmFornecedor(resultadoSQL.getString(FORNECEDOR));
			
			despesa.setEmNomeDe(candidato);
			despesa.setHoraRegistro(resultadoSQL.getString(HORA_REGISTRO));
			despesa.setEntregaEmConjunto(Boolean.valueOf(resultadoSQL.getString(ENTREGA_EM_CONJUNTO)));
			despesa.setNumeroDocumento(resultadoSQL.getString(NUMERO_DOCUMENTO));
			despesa.setAno(resultadoSQL.getString(ANO));
			despesa.setValor(resultadoSQL.getFloat(VALOR));
			despesa.setFonte(resultadoSQL.getString(FONTE));
			despesa.setTipo(resultadoSQL.getString(TIPO));
			despesa.setEspecie(resultadoSQL.getString(ESPECIE));
			despesa.setDescricao(resultadoSQL.getString(DESCRICAO));
			despesa.setTipoDocumento(resultadoSQL.getString(TIPO_DOCUMENTO));
			despesa.setFornecedor(fornecedor);
			
			lista.add(despesa);
		}
	}

	public ArrayList<Despesa> getDespesasPorSelecao(String campo, String valor, String ano) throws SQLException {
		ArrayList<Despesa> listaDespesas = new ArrayList<>();
		try {
			this.conexao = new ConexaoBancoDados().getConexao();
			
			String comandoSQL = "SELECT * FROM t_despesa WHERE " + campo + " LIKE '" + valor + "'"
					+ "AND ano LIKE '" + ano + "'";
			
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);			
			
			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();
			adicionarResultSetNaLista(listaDespesas, resultadoSQL);
			
			instrucaoSQL.close();
			
		} catch(Exception e) {
			throw new SQLException(e.getMessage());
		} finally {
			fecharConexao();
		}
		
		return listaDespesas;	
	}
	
}
