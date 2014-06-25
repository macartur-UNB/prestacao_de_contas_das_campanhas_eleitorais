package controle.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Candidato;
import controle.CandidatoControle;

public class VisualizarResultadoListaBuscaCandidato implements Logica {

	private CandidatoControle controle;
	private List<Candidato> listaCandidatos;

	private String nome;

	private HttpServletRequest req;

	private int inicio;
	private int qtdPorPagina;
	private boolean verTodos;
	private int indice;
	private int qtdDePP;
	
	private int centro;
	private int minRaio;
	private int maxRaio;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.req = req;
		recebeParametros();

		if (this.listaCandidatos.isEmpty()) {
			return "/erro_candidato_inexistente.jsp";
		} else {
			estabeleceParametros();
			estabeleceRaioDePaginacao();
			preparaEnvioDeParametros();

			return "/visualizar_lista_candidatos.jsp";
		}
	}

	private void recebeParametros() throws SQLException {
		this.nome = this.req.getParameter("nome");

		this.inicio = Integer.parseInt(this.req.getParameter("inicio"));
		this.qtdPorPagina = Integer.parseInt(this.req.getParameter("qtdPorPagina"));
		this.verTodos = Boolean.parseBoolean(this.req.getParameter("verTodos"));
		
		this.centro = Integer.parseInt(this.req.getParameter("centro"));

		this.controle = new CandidatoControle();

		this.listaCandidatos = this.controle.getListaCandidatos(this.nome);
	}

	private void estabeleceParametros() {
		this.indice = geraIndiceDaLista(this.listaCandidatos,this.qtdPorPagina);
		this.qtdDePP = geraIndiceDePaginacao(this.listaCandidatos);
	}

	private void estabeleceRaioDePaginacao() {
		int cont = 0;
		if (this.indice > 9)
			cont = 9;
		else
			cont = this.indice - 1;

		int raioMin = this.centro;
		int raioMax = this.centro;
		this.minRaio = 0;
		this.maxRaio = 0;
		while (cont != 0) {
			if (raioMin == 1)
				this.maxRaio++;
			else if (this.minRaio < 5) {
				this.minRaio++;
				raioMin--;
			} else if (raioMax == this.indice)
				this.minRaio++;
			else {
				this.maxRaio++;
				raioMax++;
			}
			cont--;
		}
		this.maxRaio += this.centro;
		this.minRaio = this.centro - this.minRaio;
	}
	private void preparaEnvioDeParametros() {
		this.req.setAttribute("listaCandidatos", this.listaCandidatos);

		this.req.setAttribute("nome", this.nome);
		this.req.setAttribute("inicio", this.inicio);
		if(this.verTodos)
			this.qtdPorPagina = this.listaCandidatos.size();
		this.req.setAttribute("qtdPorPagina", this.qtdPorPagina);
		this.req.setAttribute("indice", this.indice);
		this.req.setAttribute("qtdDePP", this.qtdDePP);	
		
		this.req.setAttribute("centro", this.centro);
		this.req.setAttribute("minRaio", this.minRaio);
		this.req.setAttribute("maxRaio", this.maxRaio);
	}	

	private int geraIndiceDaLista(List<Candidato> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}

	private int geraIndiceDePaginacao(List<Candidato> lista) {
		int indice = (int) Math.floor((double) lista.size() / (double) 25);
		if (indice >= 4 && indice < 10)
			return 4;
		else if (indice >= 10 && indice < 20)
			return 5;
		else if (indice >= 20 && indice < 40)
			return 6;
		else if (indice >= 40 && indice < 80)
			return 7;
		else if (indice >= 80)
			return 8;
		return indice;
	}
}
