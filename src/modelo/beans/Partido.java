/** CRIADO POR:          
 * 
 *  COMENTARIOS:
 *  Rafael: (10/05/14) Transferi os metodos de MovimentacaoDAO pra ca. Com
 *  isso, esses metodos se tornam metodos sem parametros e podem mais 
 *  facilmente serem usados atraves de tags na vies.
**/

package modelo.beans;

public class Partido {
	
	public static final String STRING_VAZIO = "";
	
	private String numero;
	private String sigla;
	private String deferimento;
	private String nome;
	
	public Partido() {
		this.nome = STRING_VAZIO;
		this.sigla = STRING_VAZIO;
		this.numero = STRING_VAZIO;
		this.deferimento = STRING_VAZIO;
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) || object == null )
			return false;
		
		Partido outroPartido = (Partido) object;
		return this.sigla.equalsIgnoreCase(outroPartido.getSigla());
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDeferimento() {
		return deferimento;
	}

	public void setDeferimento(String deferimento) {
		this.deferimento = deferimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
