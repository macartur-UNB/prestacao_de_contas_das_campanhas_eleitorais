package parse;

import java.util.ArrayList;

public interface ParseDAO<O> {

	public void cadastrarListaParse(ArrayList<O> lista) throws ParseException;
	public ArrayList<O> getListaParse() throws ParseException;
	
}
