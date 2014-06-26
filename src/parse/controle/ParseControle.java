package parse.controle;

import java.util.ArrayList;

import parse.ParseDAO;
import parse.ParseException;
import parse.indices.IndicesParse;

public abstract class ParseControle<O> {

	private O objetoVazio;
	private ParseDAO<O> basicoDAO;
	private IndicesParse<O> indicesParse;
	
	protected ArrayList<O> listaInstancias;
	
	public ParseControle(IndicesParse<O> indicesParse, ParseDAO<O> basicoDAO) {
		this.listaInstancias = new ArrayList<>();

		this.basicoDAO = basicoDAO;
		this.indicesParse = indicesParse;
		this.objetoVazio = novaInstancia();
	}

	public abstract O novaInstancia();
	public abstract boolean iguais(O objetoUm, O objetoDois);
	
	public void addInstancia(String campo[]) {
		O objeto = fazerNovaInstancia(campo);		
		if( (!iguais(objeto, objetoVazio)) && 
				(!this.listaInstancias.contains(objeto)) ) {
			this.listaInstancias.add(objeto);
		}
	}

	public void addInstanciaIgual(String campo[]) {
		O objeto = fazerNovaInstancia(campo);
		if( (!iguais(objeto, objetoVazio)) ) {
			this.listaInstancias.add(objeto);
		}
	}
	
	public void cadastrarInstancias() throws ParseException {
		this.basicoDAO.cadastrarListaParse(this.listaInstancias);
	}
	
	public void resetar() {
		this.listaInstancias.clear();
	}
	
	private O fazerNovaInstancia(String campo[]) {
		O objeto = novaInstancia();
		this.indicesParse.iniciarInstancia(objeto, campo);
		return objeto;
	}
}
