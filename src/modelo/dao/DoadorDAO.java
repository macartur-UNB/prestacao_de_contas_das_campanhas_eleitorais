package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import modelo.beans.Doador;
import modelo.beans.Fornecedor;
import parse.ParseDAO;

public class DoadorDAO extends BasicoDAO<Doador> implements ParseDAO<Doador> {
	
	public enum Comparacao implements Comparator<Doador> {
		NOME {
			public int compare(Doador d1, Doador d2) {
				return d1.getCpf_cnpj().compareToIgnoreCase(d2.getCpf_cnpj());
			}
		}
	}
	
	private static final String NOME_TABELA = "doador";
	private static final String CPF_CNPJ = "cpf_cnpj";
	private static final String NOME = "nome";
	private static final String UF = "uf";
	private static final String SITUACAO_CADASTRAL = "situacao_cadastral";
	private static final String SQL_INSERCAO = "INSERT INTO " + NOME_TABELA
			+ " (" + CPF_CNPJ + ", " + NOME + ", " + UF + ", " + SITUACAO_CADASTRAL + ") "
			+ "values (?, ?, ?, ?)";
	private static final String SQL_SELECAO = "SELECT * FROM " + NOME_TABELA;
	
	public DoadorDAO() {
		super(NOME_TABELA, Comparacao.NOME);
	}

	@Override
	protected String getSqlInsert() {
		return SQL_INSERCAO;
	}

	@Override
	protected String getSqlSelect() {
		return SQL_SELECAO;
	}

	@Override
	protected void adicionarListaNoBatch(ArrayList<Doador> lista,
			PreparedStatement instrucaoSQL) throws SQLException {
		for(Doador doador : lista) {
			instrucaoSQL.setString(1, doador.getCpf_cnpj());
			instrucaoSQL.setString(2, doador.getNome());
			instrucaoSQL.setString(3, doador.getUf());
			instrucaoSQL.setString(4, doador.getSituacaoCadastral());
			instrucaoSQL.addBatch();
		}
		
	}

	@Override
	protected void adicionarResultSetNaLista(ArrayList<Doador> lista,
			ResultSet resultadoSQL) throws SQLException {
		while(resultadoSQL.next()) {
			Doador doador = new Doador();
			doador.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ));
			doador.setNome(resultadoSQL.getString(NOME));
			doador.setUf(resultadoSQL.getString(UF));
			doador.setSituacaoCadastral(resultadoSQL.getString(SITUACAO_CADASTRAL));
			
			lista.add(doador);
		}
		
	}
	
	public ArrayList<Doador> buscaBD(String SQL) throws SQLException {

		ArrayList<Doador> listaDoador = new ArrayList<>();
		
		try {
			this.conexao = new ConexaoBancoDados().getConexao();

			String comandoSQL = SQL;
			this.instrucaoSQL = this.conexao.prepareStatement(comandoSQL);
			ResultSet resultadoSQL = (ResultSet) instrucaoSQL.executeQuery();

			while (resultadoSQL.next()) {
				Doador doador = new Doador();
				doador.setNome(resultadoSQL.getString(NOME));
				doador.setCpf_cnpj(resultadoSQL.getString(CPF_CNPJ));
				doador.setSituacaoCadastral(resultadoSQL.getString(SITUACAO_CADASTRAL));
				doador.setUf(resultadoSQL.getString(UF));

				if (doador != null) listaDoador.add(doador);
			}
		}  catch (SQLException e) {
			throw new SQLException("DoadorDAO - " + e.getMessage());
		} finally {
			fecharConexao();
		}
		return listaDoador;
	}
	
	public Doador getPeloNomeOuCpfCnpj(Doador doador) throws Exception {
		String comandoSQL = SQL_SELECAO + " WHERE ";
		if(!doador.getNome().equals(Fornecedor.STRING_VAZIO)){
			comandoSQL = comandoSQL + NOME + " = " 
		  + doador.getNome();
		}
		else if(!doador.getCpf_cnpj().equals(Fornecedor.STRING_VAZIO)){
			comandoSQL = comandoSQL + CPF_CNPJ + " = " 
		  + doador.getCpf_cnpj();
		}else{
			throw new Exception();
		}
		return buscaBD(comandoSQL).get(0);
	}

}
