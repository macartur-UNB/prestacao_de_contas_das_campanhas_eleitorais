package modelo.beans;

public class Despesa extends MovimentacaoFinanceira {

	public static final Object OBJETO_VAZIO = null; 
	
	private TipoDocumento tipoDocumento;
	private Fornecedor fornecedor;
	
	public Despesa(){
		this.tipoDocumento = (TipoDocumento) OBJETO_VAZIO;
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
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
