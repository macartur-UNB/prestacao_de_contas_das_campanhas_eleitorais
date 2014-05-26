package teste;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Candidato;
import modelo.beans.Partido;
import modelo.dao.CandidatoDAO;
import modelo.dao.PartidoDAO;

import org.junit.Test;

import controle.CandidatoControle;

public class CandidatoControleTeste extends TemplateTeste {

	private CandidatoDAO candidatoDAO;
	private CandidatoControle candidatoControle;
	private PartidoDAO partidoDAO;
	private Partido partidoCadastrado;

	@Override
	public void beforeTest() throws Exception {
		this.candidatoDAO = new CandidatoDAO();
		this.candidatoControle = new CandidatoControle();
		this.partidoDAO = new PartidoDAO();
		cadastrarPartido();
	}

	@Override
	public void afterTest() throws Exception {

	}

	@Test
	public void deveRecuperarUmCandidatoPeloNome() throws SQLException {		
		ArrayList<Candidato>   listaCandidatos = new ArrayList <Candidato> ();
			
		Candidato candidato = new Candidato();
		candidato.setNome("Nome_Candidato");
		listaCandidatos.add(candidato);
				
		/*this.candidatoDAO.adicionarResultSetNaLista(listaCandidatos);*/
		this.candidatoDAO.getCandidato("Nome_Candidato");
		this.candidatoControle.getUmCandidato("Nome_Candidato");
	}

	@Test
	public void deveRecuperarUmaListaDeCandidatos() throws SQLException {

		ArrayList<Candidato> listaCandidatos = new ArrayList<>();

		Candidato c1 = new Candidato();
		c1.setNome("Vanderlei Lima");
		c1.setUf("RJ");
		c1.setAno(2002);
		c1.setPartido(this.partidoCadastrado);
		listaCandidatos.add(c1);

		Candidato c2 = new Candidato();
		c2.setNome("Leonardo Souza");
		c2.setUf("DF");
		c2.setAno(2002);
		c2.setPartido(this.partidoCadastrado);
		listaCandidatos.add(c2);

		Candidato c3 = new Candidato();
		c3.setNome("Maria Silva");
		c3.setUf("AC");
		c2.setAno(2002);
		c3.setPartido(this.partidoCadastrado);
		listaCandidatos.add(c3);

		this.candidatoDAO.cadastrarLista(listaCandidatos);
		;
		this.candidatoDAO.getLista();
		this.candidatoControle.getListaCandidatos();

		assertEquals(listaCandidatos,
				this.candidatoControle.getListaCandidatos());
	}

	private void cadastrarPartido() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<>();

		this.partidoCadastrado = new Partido();
		this.partidoCadastrado.setSigla("A");
		this.partidoCadastrado.setNumeroPartido("1");
		listaPartidos.add(this.partidoCadastrado);

		this.partidoDAO.cadastrarPartidos(listaPartidos);
	}

}
