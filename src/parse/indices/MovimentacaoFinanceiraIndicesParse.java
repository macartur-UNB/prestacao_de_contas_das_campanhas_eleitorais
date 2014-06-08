package parse.indices;

import modelo.beans.Campanha;
import modelo.beans.FormaPagamento;
import modelo.beans.MovimentacaoFinanceira;
import modelo.beans.TipoMovimentacao;


public class MovimentacaoFinanceiraIndicesParse<O> extends IndicesParse<O> {

	public static final int INDICE_INVALIDO = -1;

	private Integer ano;
	
	private int indiceId;
	private int indiceCampanha;
	private int indiceNumeroDocumento;
	private int indiceData;
	private int indiceValor;
	private int indiceTipoMovimentacao;
	private int indiceFormaPagamento;
	private int indiceDescricao;

	public MovimentacaoFinanceiraIndicesParse(String ano) {
		this.ano = Integer.valueOf(ano);
		this.indiceId = INDICE_INVALIDO;
		this.indiceCampanha = INDICE_INVALIDO;
		this.indiceNumeroDocumento = INDICE_INVALIDO;
		this.indiceData = INDICE_INVALIDO;
		this.indiceValor = INDICE_INVALIDO;
		this.indiceTipoMovimentacao = INDICE_INVALIDO;
		this.indiceFormaPagamento = INDICE_INVALIDO;
		this.indiceDescricao = INDICE_INVALIDO;
	}
	
	@Override
	protected void setIndicesValidos(O objeto, String[] campo) {
		MovimentacaoFinanceira movimentacaoFinanceira = (MovimentacaoFinanceira) objeto;
		
		movimentacaoFinanceira.setAno(ano);
		if(indiceValido(this.indiceId)) {
			movimentacaoFinanceira.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCampanha)) {
			Campanha campanha = new Campanha();
			campanha.setId(Integer.parseInt(campo[this.indiceCampanha]));
			movimentacaoFinanceira.setCampanha(campanha);
		}
		if(indiceValido(this.indiceNumeroDocumento)) {
			movimentacaoFinanceira.setNumeroDocumento(campo[this.indiceNumeroDocumento]);
		}
		if(indiceValido(this.indiceData)) {
			movimentacaoFinanceira.setData(campo[this.indiceData]);
		}
		if(indiceValido(this.indiceValor)) {
			float valor = Float.parseFloat(campo[this.indiceValor].replace(',', '.'));
			movimentacaoFinanceira.setValor(valor);
		}
		if(indiceValido(this.indiceTipoMovimentacao)) {
			TipoMovimentacao tipoMovimentacao = new TipoMovimentacao();
			tipoMovimentacao.setId(Integer.parseInt(campo[this.indiceTipoMovimentacao]));
			movimentacaoFinanceira.setTipoMovimentacao(tipoMovimentacao);
		}
		if(indiceValido(this.indiceFormaPagamento)) {
			FormaPagamento formaPagamento = new FormaPagamento();
			formaPagamento.setId(Integer.parseInt(campo[this.indiceFormaPagamento]));
			movimentacaoFinanceira.setFormaPagamento(formaPagamento);
		}
		if(indiceValido(this.indiceDescricao)) {
			movimentacaoFinanceira.setDescricao(campo[this.indiceDescricao]);
		}
	}

	@Override
	protected void setVazioEmTodosOsSetters(O objeto) {
		MovimentacaoFinanceira movimentacaoFinanceira = (MovimentacaoFinanceira) objeto;
		movimentacaoFinanceira.setId(MovimentacaoFinanceira.INTEGER_VAZIO);
		movimentacaoFinanceira.setCampanha((Campanha)MovimentacaoFinanceira.OBJETO_VAZIO);
		movimentacaoFinanceira.setNumeroDocumento(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setAno(MovimentacaoFinanceira.INTEGER_VAZIO);
		movimentacaoFinanceira.setData(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setValor(MovimentacaoFinanceira.FLOAT_VAZIO);
		movimentacaoFinanceira.setFormaPagamento((FormaPagamento)MovimentacaoFinanceira.OBJETO_VAZIO);
		movimentacaoFinanceira.setTipoMovimentacao((TipoMovimentacao)MovimentacaoFinanceira.OBJETO_VAZIO);
		movimentacaoFinanceira.setDescricao(MovimentacaoFinanceira.STRING_VAZIO);
	}
	
	protected boolean indiceValido(int indice) {
		return indice > INDICE_INVALIDO;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setIndiceId(int indiceId) {
		this.indiceId = indiceId;
	}

	public void setIndiceCampanha(int indiceCampanha) {
		this.indiceCampanha = indiceCampanha;
	}

	public void setIndiceNumeroDocumento(int indiceNumeroDocumento) {
		this.indiceNumeroDocumento = indiceNumeroDocumento;
	}

	public void setIndiceData(int indiceData) {
		this.indiceData = indiceData;
	}

	public void setIndiceValor(int indiceValor) {
		this.indiceValor = indiceValor;
	}

	public void setIndiceTipoMovimentacao(int indiceTipoMovimentacao) {
		this.indiceTipoMovimentacao = indiceTipoMovimentacao;
	}

	public void setIndiceFormaPagamento(int indiceFormaPagamento) {
		this.indiceFormaPagamento = indiceFormaPagamento;
	}

	public void setIndiceDescricao(int indiceDescricao) {
		this.indiceDescricao = indiceDescricao;
	}
	
}
