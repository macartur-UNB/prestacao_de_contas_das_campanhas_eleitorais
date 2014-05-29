package controle.validacao;

import controle.excecao.PartidoExcecao;
import modelo.beans.Partido;

public class PartidoValidacao {

	private static final String SIGLA_VAZIA = "Campo Sigla do Partido vazia!";
	private static final String NUMERO_PARTIDO_VAZIO = "Campo Número do Partido vazio!";

	public PartidoValidacao() {

	}

	public void siglaNaoNula(Partido partido) throws PartidoExcecao {
		if ((partido.getSigla() == null)) {
			throw new PartidoExcecao(SIGLA_VAZIA);
		}
	}
	
	public void numeroNaoNulo(Partido partido) throws PartidoExcecao {
		if((partido.getNumero() == null)) {
			throw new PartidoExcecao(NUMERO_PARTIDO_VAZIO);
		}
	}

}
