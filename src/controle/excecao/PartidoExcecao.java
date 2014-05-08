package controle.excecao;

public class PartidoExcecao extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PartidoExcecao() {
		
	}
	
	public PartidoExcecao(String message) {
		super(message);
	}

}
