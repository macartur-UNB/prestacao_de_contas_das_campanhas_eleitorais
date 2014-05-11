package parse;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.beans.Doador;
import modelo.dao.DoadorDAO;
import parse.indices.DoadorIndicesParse;

public class DoadorParse {
	
	private DoadorIndicesParse doadorIndicesParse;
	private ArrayList<Doador> listaDoadores;
	private DoadorDAO doadorDAO;
	
	public DoadorParse(DoadorIndicesParse doadorIndicesParse) {
		this.doadorDAO = new DoadorDAO();
		this.listaDoadores = new ArrayList<>();
		this.doadorIndicesParse = doadorIndicesParse;
	}
	
	public void addDoador(String campo[]) {
		Doador doador = this.doadorIndicesParse.iniciarDoador(campo);
		if(!this.listaDoadores.contains(doador)) {
			this.listaDoadores.add(doador);
		}
	}
	
	public void cadastrarDoadores() throws SQLException {
		this.doadorDAO.cadastrarLista(listaDoadores);
	}
	
	public void resetar() {
		this.listaDoadores.clear();
	}

}
