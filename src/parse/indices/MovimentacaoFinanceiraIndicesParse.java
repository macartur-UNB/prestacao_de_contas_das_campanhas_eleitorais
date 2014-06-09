package parse.indices;

import modelo.beans.Campanha;
import modelo.beans.MovimentacaoFinanceira;


public class MovimentacaoFinanceiraIndicesParse<O> extends IndicesParse<O> {

	public static final int INDICE_INVALIDO = -1;

	private Integer ano;
	
	private int indiceId;
	private int indiceCampanhaAno;
	private int indiceCampanhaNumero;
	private int indiceCampanhaNome;
	private int indiceNumeroDocumento;
	private int indiceData;
	private int indiceValor;
	private int indiceTipoMovimentacao;
	private int indiceFormaPagamento;
	private int indiceDescricao;

	public MovimentacaoFinanceiraIndicesParse(String ano) {
		this.ano = Integer.valueOf(ano);
		this.indiceId = INDICE_INVALIDO;
		this.indiceCampanhaAno = INDICE_INVALIDO;
		this.indiceCampanhaNumero = INDICE_INVALIDO;
		this.indiceCampanhaNome = INDICE_INVALIDO;
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
		
		Campanha campanha = new Campanha();
		campanha.setAno(ano);
		
		if(indiceValido(this.indiceId)) {
			movimentacaoFinanceira.setId(Integer.parseInt(campo[this.indiceId]));
		}
		if(indiceValido(this.indiceCampanhaAno)) {
			campanha.setAno(Integer.parseInt(campo[this.indiceCampanhaAno]));
		}
		if(indiceValido(this.indiceCampanhaNumero)) {
			campanha.setNumeroCandidato(Integer.parseInt(campo[this.indiceCampanhaNumero]));
		}
		if(indiceValido(this.indiceCampanhaNome)) {
			campanha.setNomeDeUrna(campo[this.indiceCampanhaNome]);
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
			movimentacaoFinanceira.setTipoMovimentacao(campo[this.indiceTipoMovimentacao]);
		}
		if(indiceValido(this.indiceFormaPagamento)) {
			movimentacaoFinanceira.setFormaPagamento(campo[this.indiceFormaPagamento]);
		}
		if(indiceValido(this.indiceDescricao)) {
			movimentacaoFinanceira.setDescricao(campo[this.indiceDescricao]);
		}
		movimentacaoFinanceira.setCampanha(campanha);

	}

	@Override
	protected void setVazioEmTodosOsSetters(O objeto) {
		MovimentacaoFinanceira movimentacaoFinanceira = (MovimentacaoFinanceira) objeto;
		movimentacaoFinanceira.setId(MovimentacaoFinanceira.INTEGER_VAZIO);
		movimentacaoFinanceira.setCampanha((Campanha)MovimentacaoFinanceira.OBJETO_VAZIO);
		movimentacaoFinanceira.setNumeroDocumento(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setData(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setValor(MovimentacaoFinanceira.FLOAT_VAZIO);
		movimentacaoFinanceira.setFormaPagamento(MovimentacaoFinanceira.STRING_VAZIO);
		movimentacaoFinanceira.setTipoMovimentacao(MovimentacaoFinanceira.STRING_VAZIO);
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

	public void setIndiceCampanhaAno(int indiceCampanhaAno) {
		this.indiceCampanhaAno = indiceCampanhaAno;
	}
	
	public void setIndiceCampanhaNumero(int indiceCampanhaNumero) {
		this.indiceCampanhaNumero = indiceCampanhaNumero;
	}
	
	public void setIndiceCampanhaNome(int indiceCampanhaNome) {
		this.indiceCampanhaNome = indiceCampanhaNome;
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
