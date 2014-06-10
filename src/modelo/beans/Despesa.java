package modelo.beans;

public class Despesa extends MovimentacaoFinanceira {

	public static final Object OBJETO_VAZIO = null; 
	
	private String tipoDocumento;
	private Fornecedor fornecedor;
	
	public Despesa(){
		this.tipoDocumento = STRING_VAZIO;
		this.fornecedor = (Fornecedor) OBJETO_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Despesa)) {
			return false;
		}
		
		Despesa outraDespesa = (Despesa) object;
		
		return super.equals(object) &&
			   this.tipoDocumento.equals(outraDespesa.getTipoDocumento()) &&
			   this.fornecedor.equals(outraDespesa.getFornecedor()); 

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
