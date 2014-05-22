package parse.controle;

import java.util.ArrayList;

import parse.ParseDAO;
import parse.ParseException;
import parse.indices.IndicesParse;

public abstract class ParseControle<O> {

	private ParseDAO<O> basicoDAO;
	private ArrayList<O> listaInstancias;
	private IndicesParse<O> indicesParse;
	
	public ParseControle(IndicesParse<O> indicesParse, ParseDAO<O> basicoDAO) {
		this.listaInstancias = new ArrayList<>();

		this.basicoDAO = basicoDAO;
		this.indicesParse = indicesParse;
	}

	public abstract O novaInstancia();
	
	public void addInstanciaUnica(String campo[]) {
		O objeto = fazerNovaInstancia(campo);		
		if(!this.listaInstancias.contains(objeto)) {
			this.listaInstancias.add(objeto);
		}
	}
	
	public void addInstancia(String campo[]) {
		O objeto = fazerNovaInstancia(campo);
		this.listaInstancias.add(objeto);
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
