package modelo.beans;

public class Receita extends MovimentacaoFinanceira {
	
	public static final Doador DOADOR_VAZIO = new Doador();
	
	private String reciboEleitoral;
	private Doador doador;
	
	public Receita() {
		super();
		this.reciboEleitoral = STRING_VAZIO;
		this.doador = DOADOR_VAZIO;
	}
	
	public boolean equals(Object object) {
		if( !(object instanceof Receita) || object == null) {
			return false;
		} else {
			Receita outraReceita = (Receita) object;
			
			if(this.getReciboEleitoral().equals(outraReceita.getReciboEleitoral())) {
				return	this.doador.equals(outraReceita.getDoador()) &&
						super.equals(object);
			}
			return false;
		}
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
