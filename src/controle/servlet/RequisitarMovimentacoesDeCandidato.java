package controle.servlet;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Campanha;
import modelo.beans.Cargo;
import modelo.beans.Despesa;
import modelo.beans.Receita;
import controle.CampanhaControle;
import controle.MovimentacaoControle;

public class RequisitarMovimentacoesDeCandidato implements Logica {

	private CampanhaControle campanhaControle;
	private Campanha campanhaBusca;
	private Campanha campanha;
	private MovimentacaoControle movimentacaoControle;

	private String despesaTot;
	private List<Receita> listaReceita;
	private List<Despesa> listaDespesa;

	private HttpServletRequest req;

	private int inicioR;
	private int inicioD;
	private int qtdPorPaginaR;
	private int qtdPorPaginaD;
	private boolean verTodosR;
	private boolean verTodosD;
	private int indiceR;
	private int indiceD;
	private int qtdDePPR;
	private int qtdDePPD;


	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		this.req = req;
		recebeParametros();

		if (this.campanha == null) {
			return "/erro_candidato_inexistente.jsp";
		} else {
			estabeleceParametros();
			preparaEnvioDeParametros();

			return "/visualizar_movimentacoes.jsp";
		}

	}

	private void recebeParametros() throws SQLException {
		this.campanhaBusca = constroiCampanha(this.req);

		this.inicioR = Integer.parseInt(req.getParameter("inicioR"));
		this.qtdPorPaginaR = Integer.parseInt(req.getParameter("qtdPorPaginaR"));
		this.verTodosR = Boolean.parseBoolean(req.getParameter("verTodosR"));

		this.inicioD = Integer.parseInt(req.getParameter("inicioD"));
		this.qtdPorPaginaD = Integer.parseInt(req.getParameter("qtdPorPaginaD"));
		this.verTodosD = Boolean.parseBoolean(req.getParameter("verTodosD"));

		this.campanhaControle = new CampanhaControle();
		this.campanha = this.campanhaControle
				.getPeloAnoNumeroCodCargoEUf(this.campanhaBusca);
		this.movimentacaoControle = new MovimentacaoControle();
	}

	private void estabeleceParametros() throws Exception {
		this.despesaTot = 
				formataDespesa(this.campanha.getDespesaMaxDeclarada());

		this.listaReceita = 
				this.movimentacaoControle.getListaReceitas(this.campanha);
		this.listaDespesa = 
				this.movimentacaoControle.getListaDespesas(this.campanha);
		this.indiceR = geraIndiceDaListaR(this.listaReceita,this.qtdPorPaginaR);
		this.qtdDePPR = geraIndiceDePaginacaoR(this.listaReceita);
		this.indiceD = geraIndiceDaListaD(this.listaDespesa,this.qtdPorPaginaD);
		this.qtdDePPD = geraIndiceDePaginacaoD(this.listaDespesa);
	}

	private void preparaEnvioDeParametros() {
		this.req.setAttribute("listaReceitas", this.listaReceita);
		this.req.setAttribute("listaDespesas", this.listaDespesa);

		this.req.setAttribute("campanha", this.campanha);
		this.req.setAttribute("depesaTot", this.despesaTot);

		this.req.setAttribute("inicioR", this.inicioR);
		if(this.verTodosR)
			this.qtdPorPaginaR = this.listaReceita.size();
		this.req.setAttribute("qtdPorPaginaR", this.qtdPorPaginaR);
		this.req.setAttribute("indiceR", this.indiceR);
		this.req.setAttribute("qtdDePPR", this.qtdDePPR);

		this.req.setAttribute("inicioD", this.inicioD);
		if(this.verTodosD)
			this.qtdPorPaginaD = this.listaDespesa.size();
		this.req.setAttribute("qtdPorPaginaD", this.qtdPorPaginaD);
		this.req.setAttribute("indiceD", this.indiceD);
		this.req.setAttribute("qtdDePPD", this.qtdDePPD);	
	}

	private String formataDespesa(Float despesa) {
		DecimalFormatSymbols padraoBrasileiro = new DecimalFormatSymbols(Locale.GERMAN);

		DecimalFormat df  = new DecimalFormat("###,###,##0.00",padraoBrasileiro);  
		String despesaTot = df.format(despesa); 

		despesaTot = "R$ " + despesaTot;

		return despesaTot;
	}

	private Campanha constroiCampanha(HttpServletRequest req) {

		int ano = Integer.parseInt(req.getParameter("ano"));
		int numero = Integer.parseInt(req.getParameter("numero_cand"));
		int cargo_cod = Integer.parseInt(req.getParameter("cargo_cod"));
		String uf = req.getParameter("uf");

		Cargo cargo = new Cargo();
		cargo.setCodigo(cargo_cod);

		Campanha campanha = new Campanha();
		campanha.setNumeroCandidato(numero);
		campanha.setAno(ano);
		campanha.setCargo(cargo);
		campanha.setUf(uf);

		return campanha;
	}

	private int geraIndiceDaListaR(List<Receita> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}

	private int geraIndiceDePaginacaoR(List<Receita> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}

	private int geraIndiceDaListaD(List<Despesa> lista, int divisor) {
		if(divisor!=0)
		{
			int indice = (int) Math.ceil((double)lista.size()/(double)divisor);
			return indice;
		}
		else
			return 1;
	}

	private int geraIndiceDePaginacaoD(List<Despesa> lista) {
		int indice = (int) Math.floor((double)lista.size()/(double)25);
		return indice;
	}

}
