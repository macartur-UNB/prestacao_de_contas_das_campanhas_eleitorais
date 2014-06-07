package modelo.beans;

public class TipoDocumento {

	public static final String STRING_VAZIO = "";
	public static final int INTEGER_VAZIO = 0;

	private Integer id;
	private Integer codigo;
	private String descricao;

	public TipoDocumento() {
		this.id = INTEGER_VAZIO;
		this.codigo = INTEGER_VAZIO;
		this.descricao = STRING_VAZIO;
	}
		

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TipoDocumento) || object == null)
			return false;

		TipoDocumento tipoDocumento = (TipoDocumento) object;
		return this.descricao.equalsIgnoreCase(tipoDocumento.getDescricao());
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
