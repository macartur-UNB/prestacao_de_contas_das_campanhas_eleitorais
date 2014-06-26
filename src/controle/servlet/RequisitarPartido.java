package controle.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

public class RequisitarPartido implements Logica {

	private PartidoControle controle;
	private List<Partido> listaPartidos;

	private HttpServletRequest req;

	private int inicio;
	private int qtdPorPagina;
	private boolean verTodos;
	private int atual;

	private int indice;
	private int qtdDePP;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.req = req;
		
		recebeParametrosDeListagem();
		estabeleceParametros();
		preparaEnvioDeParametros();
		
		return "/listar_partidos.jsp";	
	}

	private void recebeParametrosDeListagem() {
		this.inicio = Integer.parseInt(this.req.getParameter("inicio"));
		this.qtdPorPagina = Integer.parseInt(this.req.getParameter("qtdPorPagina"));
		this.verTodos = Boolean.parseBoolean(this.req.getParameter("verTodos"));
	}

	private void estabeleceParametros() throws SQLException {
		this.controle = new PartidoControle();

		this.listaPartidos = controle.getListaTodosPartidos();
		this.indice = geraIndiceDaLista(this.listaPartidos,this.qtdPorPagina);
		this.qtdDePP = geraIndiceDePaginacao(this.listaPartidos);
		
		this.atual = (int) Math.round((float) this.inicio / (float) this.qtdPorPagina)+1;
	}

	private void preparaEnvioDeParametros() {
		this.req.setAttribute("listaPartidos", this.listaPartidos);
		this.req.setAttribute("inicio", this.inicio);
		if(this.verTodos)
			this.qtdPorPagina = this.listaPartidos.size();
		this.req.setAttribute("qtdPorPagina", this.qtdPorPagina);
		this.req.setAttribute("indice", this.indice);
		this.req.setAttribute("qtdDePP", this.qtdDePP);
		
		this.req.setAttribute("atual", this.atual);
	}

	private int geraIndiceDaLista(List<Partido> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}

	private int geraIndiceDePaginacao(List<Partido> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}
}
