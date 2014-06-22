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

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.req = req;
		recebeParametros();

		if (this.listaCandidatos.isEmpty()) {
			return "/erro_candidato_inexistente.jsp";
		} else {
			estabeleceParametros();
			preparaEnvioDeParametros();

			return "/visualizar_lista_candidatos.jsp";
		}
	}

	private void recebeParametros() throws SQLException {
		this.nome = this.req.getParameter("nome");

		this.inicio = Integer.parseInt(this.req.getParameter("inicio"));
		this.qtdPorPagina = Integer.parseInt(this.req.getParameter("qtdPorPagina"));
		this.verTodos = Boolean.parseBoolean(this.req.getParameter("verTodos"));

		this.controle = new CandidatoControle();

		this.listaCandidatos = this.controle.getListaCandidatos(this.nome);
	}

	private void estabeleceParametros() {
		this.indice = geraIndiceDaLista(this.listaCandidatos,this.qtdPorPagina);
		this.qtdDePP = geraIndiceDePaginacao(this.listaCandidatos);
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
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
