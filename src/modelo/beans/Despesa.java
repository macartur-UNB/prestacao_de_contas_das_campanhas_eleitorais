package modelo.beans;

public class Despesa extends MovimentacaoFinanceira {

	public static final Object OBJETO_VAZIO = null; 
	
	private String tipoDocumento;
	private Fornecedor fornecedor;
	
	public Despesa(){
		this.tipoDocumento = STRING_VAZIO;
		this.fornecedor = (Fornecedor) OBJETO_VAZIO;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
