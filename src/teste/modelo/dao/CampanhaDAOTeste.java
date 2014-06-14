package teste.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.beans.Candidato;
import modelo.beans.Cargo;
import modelo.beans.Partido;
import modelo.beans.Resultado;
import modelo.dao.CampanhaDAO;

import org.junit.Assert;
import org.junit.Test;

import teste.TemplateTeste;

public class CampanhaDAOTeste extends TemplateTeste {
	
	private CampanhaDAO campanhaDAO;
	private Resultado resultado1;
	private Cargo cargo1;
	private Partido partido1;
	private Candidato candidato1;
	private Resultado resultado2;
	private Cargo cargo2;
	private Partido partido2;
	private Candidato candidato2;

	@Override
	public void beforeTest() throws Exception {
		this.campanhaDAO = new CampanhaDAO();
		this.resultado1 = new Resultado();
		this.cargo1 = new Cargo();
		this.partido1 = new Partido();
		this.candidato1 = new Candidato();
		this.resultado2 = new Resultado();
		this.cargo2 = new Cargo();
		this.partido2 = new Partido();
		this.candidato2 = new Candidato();
		
	}

	@Override
	public void afterTest() throws Exception {
		
	}
	
	@Test
	public void deveRecuperarUmaListaDeCampanhas() throws SQLException {
		ArrayList<Campanha> listaCampanhas = new ArrayList<>();
		
		Campanha camp1 = new Campanha();
		this.resultado1.setCodigo(2);
		this.cargo1.setCodigo(3);
		this.partido1.setNumero(45);
		this.candidato1.setTituloEleitoral("55325424149");
		camp1.setId(1);
		camp1.setAno(2006);
		camp1.setNumeroCandidato(45555);
		camp1.setResultado(resultado1);
		camp1.setCargo(cargo1);
		camp1.setPartido(partido1);
		camp1.setCandidato(candidato1);
		camp1.setNomeDeUrna("NOME DE URNA UM");
		camp1.setUf("DF");
		camp1.setDespesaMaxDeclarada((float) 450000.);
		camp1.setDespesaTotalCalculada((float) 450000.0);
		camp1.setReceitaTotalCalculada((float) 450000.0);
		listaCampanhas.add(camp1);
		
		Campanha camp2 = new Campanha();
		this.resultado2.setCodigo(3);
		this.cargo2.setCodigo(1);
		this.partido2.setNumero(13);
		this.candidato2.setTituloEleitoral("04725698130");
		camp2.setId(2);
		camp2.setAno(2006);
		camp2.setNumeroCandidato(13122);
		camp2.setResultado(resultado2);
		camp2.setCargo(cargo2);
		camp2.setPartido(partido2);
		camp2.setCandidato(candidato2);
		camp2.setNomeDeUrna("NOME DE URNA DOIS");
		camp2.setUf("DF");
		camp2.setDespesaMaxDeclarada((float) 500000.);
		camp2.setDespesaTotalCalculada((float) 500000.0);
		camp2.setReceitaTotalCalculada((float) 500000.0);
		listaCampanhas.add(camp2);
		
		this.campanhaDAO.cadastrarLista(listaCampanhas);
		
		Assert.assertEquals(listaCampanhas, this.campanhaDAO.getLista());
		
	}

	

}
