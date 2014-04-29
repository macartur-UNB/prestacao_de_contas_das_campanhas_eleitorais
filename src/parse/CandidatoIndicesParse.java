package parse;

public class CandidatoIndicesParse {
	
	public static final int INDICE_INVALIDO = -1;
	
	private int ano;
	
	private int indiceNome;
	private int indiceCPF;
	private int indicePartido;
	private int indiceNumero;
	private int indiceCargoPleiteado;
	private int indiceDominio;
	private int indiceArrecadacao;
	private int indiceDespesa;	
	
	public CandidatoIndicesParse() {		
		this.ano = 0;		
		this.indiceNome = INDICE_INVALIDO;
		this.indiceCPF = INDICE_INVALIDO;
		this.indicePartido = INDICE_INVALIDO;
		this.indiceNumero = INDICE_INVALIDO;
		this.indiceCargoPleiteado = INDICE_INVALIDO;
		this.indiceDominio = INDICE_INVALIDO;
		this.indiceArrecadacao = INDICE_INVALIDO;
		this.indiceDespesa = INDICE_INVALIDO;
	}	

	public int getIndiceNome() {
		return indiceNome;
	}

	public void setIndiceNome(int indiceNome) {
		this.indiceNome = indiceNome;
	}

	public int getIndiceCPF() {
		return indiceCPF;
	}

	public void setIndiceCPF(int indiceCPF) {
		this.indiceCPF = indiceCPF;
	}

	public int getIndicePartido() {
		return indicePartido;
	}

	public void setIndicePartido(int indicePartido) {
		this.indicePartido = indicePartido;
	}

	public int getIndiceNumero() {
		return indiceNumero;
	}

	public void setIndiceNumero(int indiceNumero) {
		this.indiceNumero = indiceNumero;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getIndiceCargoPleiteado() {
		return indiceCargoPleiteado;
	}

	public void setIndiceCargoPleiteado(int indiceCargoPleiteado) {
		this.indiceCargoPleiteado = indiceCargoPleiteado;
	}

	public int getIndiceDominio() {
		return indiceDominio;
	}

	public void setIndiceDominio(int indiceDominio) {
		this.indiceDominio = indiceDominio;
	}

	public int getIndiceArrecadacao() {
		return indiceArrecadacao;
	}

	public void setIndiceArrecadacao(int indiceArrecadacao) {
		this.indiceArrecadacao = indiceArrecadacao;
	}

	public int getIndiceDespesa() {
		return indiceDespesa;
	}

	public void setIndiceDespesa(int indiceDespesa) {
		this.indiceDespesa = indiceDespesa;
	}

	public static int getIndiceInvalido() {
		return INDICE_INVALIDO;
	}
	
}
