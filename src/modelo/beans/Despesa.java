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
		if( !(object instanceof Despesa) || object == null) {
			return false;
		} else {
		
			Despesa outraDespesa = (Despesa) object;
		
			if(this.getAno().equals(outraDespesa.getAno())) {
				return this.fornecedor.equals(outraDespesa.getFornecedor()) &&
					   this.tipoDocumento.equals(outraDespesa.getTipoDocumento()) &&
					   super.equals(object);
			}
			return false;
		}
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
