/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
**/

package modelo.beans;

public class Despesa extends MovimentacaoFinanceira {

	private String tipoDocumento;
	private Fornecedor fornecedor;
	
	public Despesa(){ }
	
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
