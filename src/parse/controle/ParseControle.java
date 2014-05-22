package parse.controle;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dao.BasicoDAO;
import parse.indices.IndicesParse;

public abstract class ParseControle<O> {

	private BasicoDAO<O> basicoDAO;
	private ArrayList<O> listaInstancias;
	private IndicesParse<O> indicesParse;
	
	public ParseControle(IndicesParse<O> indicesParse, BasicoDAO<O> basicoDAO) {
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
	
	public void cadastrarInstancias() throws SQLException {
		this.basicoDAO.cadastrarLista(this.listaInstancias);
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
