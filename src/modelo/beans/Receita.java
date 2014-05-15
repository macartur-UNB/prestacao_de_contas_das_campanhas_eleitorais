/** CRIADO POR:          Rafael Valenca
 *  ULTIMA MODIFICACAO:  01/05/2014
 * 
 *  COMENTARIOS: 
**/

package modelo.beans;

public class Receita extends MovimentacaoFinanceira {
	
	public static final Doador DOADOR_VAZIO = new Doador();
	
	private String reciboEleitoral;
	private Doador doador;
	
	public Receita() {
		this.reciboEleitoral = STRING_VAZIO;
		this.doador = DOADOR_VAZIO;
	}
	
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
