/** CRIADO POR:          
 * 
 *  COMENTARIOS:
 *  Rafael: (10/05/14) Transferi os metodos de MovimentacaoDAO pra ca. Com
 *  isso, esses metodos se tornam metodos sem parametros e podem mais 
 *  facilmente serem usados atraves de tags na vies.
**/

package modelo.beans;

public class Partido extends Pessoa {
	
	public static final String STRING_VAZIO = "";
	public static final Boolean BOOLEAN_VAZIO = false;
	
	private String numeroPartido;
	private String sigla;
	
	public Partido() {
		this.setNome(STRING_VAZIO);
		this.setPessoaJuridica(BOOLEAN_VAZIO);
		this.sigla = STRING_VAZIO;
		this.numeroPartido = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) || object == null )
			return false;
		
		Partido outroPartido = (Partido) object;
		return this.sigla.equalsIgnoreCase(outroPartido.getSigla());
	}
	
	public String getNumeroPartido() {
		return numeroPartido;
	}
	
	public void setNumeroPartido(String numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
