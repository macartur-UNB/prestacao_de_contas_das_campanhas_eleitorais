package controle.servlet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import controle.CampanhaControle;

@WebServlet("/VisualizarTopFive")
public class VisualizarTopFive implements Logica {
	
	private CampanhaControle campanhaControle;
	private ArrayList<Campanha> listaCampanha;
	
	private String cargo;
	private Integer ano;
	
	HttpServletRequest req;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		this.req = req;
		recebeParametros();
		estabeleceParametros();
		preparaEnvioDeParametros();
		
		return "/top_five.jsp";
	}
	
	private void recebeParametros() {
		this.ano =  Integer.parseInt(this.req.getParameter("ano"));
		this.cargo = this.req.getParameter("cargo");
	}
	
	private void estabeleceParametros() throws SQLException {
		this.campanhaControle = new CampanhaControle();
		this.listaCampanha = new ArrayList<>();
		this.listaCampanha = this.campanhaControle.topFivePorCargoEAno(this.cargo, this.ano);
	}
	
	private void preparaEnvioDeParametros() {
		this.req.setAttribute("ano", this.ano);
		this.req.setAttribute("cargo", this.cargo);
		this.req.setAttribute("candidato1", this.listaCampanha.get(0));
		this.req.setAttribute("candidato2", this.listaCampanha.get(1));
		this.req.setAttribute("candidato3", this.listaCampanha.get(2));
		this.req.setAttribute("candidato4", this.listaCampanha.get(3));
		this.req.setAttribute("candidato5", this.listaCampanha.get(4));
		
	}
}
