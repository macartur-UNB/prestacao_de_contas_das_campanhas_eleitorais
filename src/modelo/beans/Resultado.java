package modelo.beans;

public class Resultado {

	public static final String STRING_VAZIO = "";
	public static final int INTEGER_VAZIO = 0;
	
	private Integer codigo;
	private String  descricao;
	
	public Resultado() {
		this.codigo = INTEGER_VAZIO;
		this.descricao = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Resultado) || object == null )
			return false;
		
		Resultado outroResultado = (Resultado) object;
		return this.descricao.equalsIgnoreCase(outroResultado.getDescricao());
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
