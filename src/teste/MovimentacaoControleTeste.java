package teste;

import java.sql.SQLException;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.dao.DespesaDAO;
import modelo.dao.ReceitaDAO;

import org.junit.Test;

import controle.MovimentacaoControle;

public class MovimentacaoControleTeste extends TemplateTeste {

	private DespesaDAO despesaDAO;
	private ReceitaDAO receitaDAO;
	private MovimentacaoControle movimentacaoControle;
	private Candidato candidato;
	private Partido partido;
	private Campanha campanha;
	private Cargo cargo;

	@Override
	public void beforeTest() throws Exception {

		
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRetornarUmaListaDeMovimentacoesDeUmDeterminadoCandidato() throws SQLException {
	
	}


}
