/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
**/

package modelo.beans;

public class Despesa extends MovimentacaoFinanceira {

	public static final Fornecedor FORNECEDOR_VAZIO = null; 
	
	private String tipoDocumento;
	private Fornecedor fornecedor;
	
	public Despesa(){
		this.tipoDocumento = STRING_VAZIO;
		this.fornecedor = FORNECEDOR_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Despesa) ) {
			return false;
		}
		
		Despesa outraDespesa = (Despesa) object;
		
		if(this.getAno().equals(outraDespesa.getAno())) {
			return this.fornecedor.equals(outraDespesa.getFornecedor()) &&
					this.tipoDocumento.equals(outraDespesa.getTipoDocumento());
		}
		return false;
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
