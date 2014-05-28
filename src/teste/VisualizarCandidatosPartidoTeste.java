package teste;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import modelo.beans.Candidato;
import modelo.beans.Partido;
import modelo.dao.CandidatoDAO;
import modelo.dao.PartidoDAO;

import org.junit.Test;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import controle.CandidatoControle;
import controle.servlet.VisualizarCandidatosPartido;

public class VisualizarCandidatosPartidoTeste extends TemplateTeste {

	private PartidoDAO partidoDAO;
	private Partido partidoCadastrado;
	private CandidatoDAO candidatoDAO;
	private CandidatoControle candidatoControle;

	@Override
	public void beforeTest() throws Exception {
		this.partidoDAO = new PartidoDAO();
		this.candidatoControle = new CandidatoControle();
		this.candidatoDAO = new CandidatoDAO();
		cadastrarPartido();
	}

	@Test
	public void deveRecuperarListaDosCandidatosDoDFDoPartido() throws MalformedURLException, IOException, ServletException, SQLException {

		ServletRunner sr = new ServletRunner();
		sr.registerServlet("VisualizarCandidatosPartido",
				VisualizarCandidatosPartido.class.getName());
		ServletUnitClient sc = sr.newClient();
		WebRequest request = new PostMethodWebRequest(
				"http://localhost/VisualizarCandidatosPartido");

		try {
			InvocationContext ic = sc.newInvocation(request);
			VisualizarCandidatosPartido visualizaCandidatos = (VisualizarCandidatosPartido) ic
					.getServlet();

			ArrayList<Candidato> lCandidatos = new ArrayList<>();

			Candidato c1 = new Candidato();
			c1.setNome("Candidato1");
			c1.setUf("RJ");
			c1.setAno(2002);
			c1.setPartido(this.partidoCadastrado);
			lCandidatos.add(c1);

			Candidato c2 = new Candidato();
			c2.setNome("Candidato2");
			c2.setUf("DF");
			c2.setAno(2002);
			c2.setPartido(this.partidoCadastrado);
			lCandidatos.add(c2);

			Candidato c3 = new Candidato();
			c3.setNome("Candidato3");
			c3.setUf("AC");
			c2.setAno(2002);
			c3.setPartido(this.partidoCadastrado);
			lCandidatos.add(c3);

			this.candidatoDAO.cadastrarLista(lCandidatos);
			this.candidatoDAO.getLista();
			this.candidatoControle.getListaCandidatos();

			ArrayList<Candidato> listaCandidatos = visualizaCandidatos
					.filtrarListaDeCandidatosPorUfPartidoAnoCadastroUnico(
							lCandidatos, ic.getRequest());

			assertTrue(listaCandidatos.contains(c2));
			assertEquals(listaCandidatos.size(), 1);

		} catch (NumberFormatException nfe) {
			System.out.println("Uma excecão foi capturada: " + nfe);
			nfe.printStackTrace();
		}
	}

	@Override
	public void afterTest() throws Exception {

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
