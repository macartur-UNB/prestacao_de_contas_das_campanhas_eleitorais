package controle.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

public class RequisitarPartido implements Logica {

	PartidoControle controle;
	List<Partido> listaPartidos;

	HttpServletRequest req;
	HttpServletResponse res;

	int inicio;
	int qtdPorPagina;
	boolean verTodos;

	int indice;
	int qtdDePP;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.res = res;
		this.req = req;
		recebeParametrosDeListagem();

		estabeleceParametros();
		preparaEnvioDeParametros();
		req = this.req;
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
	}

	private void preparaEnvioDeParametros() {
		this.req.setAttribute("listaPartidos", this.listaPartidos);
		this.req.setAttribute("inicio", this.inicio);
		if(this.verTodos)
			this.qtdPorPagina = this.listaPartidos.size();
		this.req.setAttribute("qtdPorPagina", this.qtdPorPagina);
		this.req.setAttribute("indice", this.indice);
		this.req.setAttribute("qtdDePP", this.qtdDePP);
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
