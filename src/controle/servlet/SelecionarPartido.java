package controle.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Partido;
import controle.PartidoControle;

public class SelecionarPartido implements Logica {

	private final int[] ANOS = { 2010, 2006, 2002 };
	private PartidoControle partidoControle;
	private Partido partido;

	private String sigla;
	private String siglaComUnder;
	private String linkTSE;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.partido = new Partido();
		this.partidoControle = new PartidoControle();

		this.sigla = req.getParameter("sigla");
		this.siglaComUnder = this.sigla.replaceAll(" ", "_");
		this.siglaComUnder = this.siglaComUnder.toLowerCase();

		this.partido = this.partidoControle.getPelaSigla(this.sigla);
		this.linkTSE = trocaDeCaracteresEspeciais(this.partido);

		req.setAttribute("partido", this.partido);
		req.setAttribute("anos", this.ANOS);
		req.setAttribute("linktse", this.linkTSE);
		req.setAttribute("siglaUnder", this.siglaComUnder);

		return "/visualizar_partido.jsp";
	}

	private String trocaDeCaracteresEspeciais(Partido partido) {
		String local = partido.getNome().toLowerCase();
		local = local.replaceAll(" ", "-");
		local = local.replaceAll("á", "a");
		local = local.replaceAll("ã", "a");
		local = local.replaceAll("ó", "o");
		local = local.replaceAll("ú", "u");
		local = local.replaceAll("ç", "c");
		return local;
	}
}