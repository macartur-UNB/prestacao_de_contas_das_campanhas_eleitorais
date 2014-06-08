package modelo.beans;


public class MovimentacaoFinanceira {
	
	public static final String STRING_VAZIO = "";
	public static final Integer INTEGER_VAZIO = 0;
	public static final Float FLOAT_VAZIO = (float) 0;
	public static final Object OBJETO_VAZIO = null;
	
	private Integer id;
	private Campanha campanha;
	private String numeroDocumento;
	private Integer ano;
	private String data;
	private Float valor;
	private TipoMovimentacao tipoMovimentacao;
	private FormaPagamento formaPagamento;
	private String descricao;

	public MovimentacaoFinanceira(){
		this.id = INTEGER_VAZIO;
		this.campanha = (Campanha) OBJETO_VAZIO;
		this.numeroDocumento = STRING_VAZIO;
		this.data = STRING_VAZIO;
		this.ano = INTEGER_VAZIO;
		this.valor = FLOAT_VAZIO;
		this.descricao = STRING_VAZIO;
		this.tipoMovimentacao = (TipoMovimentacao) OBJETO_VAZIO;
		this.formaPagamento = (FormaPagamento) OBJETO_VAZIO;
	}

	@Override
	public boolean equals(Object object) {
		if( !(object instanceof MovimentacaoFinanceira) || object == null) {
			return false;
		}
		
		MovimentacaoFinanceira outraMovimentacao = (MovimentacaoFinanceira) object;
		
		return 	
				this.campanha.equals(outraMovimentacao.getCampanha()) &&
				this.numeroDocumento.equalsIgnoreCase(outraMovimentacao.getNumeroDocumento()) &&
				this.ano.equals(outraMovimentacao.getAno()) &&
				this.valor.equals(outraMovimentacao.getValor()) &&
				this.descricao.equalsIgnoreCase(outraMovimentacao.getDescricao()) &&
				this.tipoMovimentacao.equals(outraMovimentacao.getTipoMovimentacao()) &&
				this.formaPagamento.equals(outraMovimentacao.getFormaPagamento());
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}	
	
	
	
}