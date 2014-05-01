/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
**/

package model;

public class Receita extends MovimentacaoFinanceira {

	private String reciboEleitoral;
	private Doador doador;
	
	public String getReciboEleitoral() {
		return reciboEleitoral;
	}
	public void setReciboEleitoral(String reciboEleitoral) {
		this.reciboEleitoral = reciboEleitoral;
	}
	public Doador getDoador() {
		return doador;
	}
	public void setDoador(Doador doador) {
		this.doador = doador;
	}
	
	
	
}
