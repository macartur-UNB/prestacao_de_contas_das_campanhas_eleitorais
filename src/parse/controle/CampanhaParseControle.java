package parse.controle;

import java.util.ArrayList;

import modelo.beans.Campanha;
import modelo.dao.CampanhaDAO;
import parse.ParseException;
import parse.indices.IndicesParse;

public class CampanhaParseControle extends ParseControle<Campanha>{

	public CampanhaParseControle(IndicesParse<Campanha> indicesParse) {
		super(indicesParse, new CampanhaDAO());
	}

	@Override
	public Campanha novaInstancia() {
		Campanha campanha = new Campanha();
		return campanha;
	}

	@Override
	public boolean iguais(Campanha objetoUm, Campanha objetoDois) {
		return objetoUm.equals(objetoDois);
	}
	
	@Override
	public void cadastrarInstancias() throws ParseException {
		ArrayList<Campanha> listaCampanhas = new ArrayList<>();
		
		boolean foiEleito;
		for(int i = 0; i < this.listaInstancias.size(); i++) {
			
			foiEleito = false;
			
			if(listaCampanhas.contains(this.listaInstancias.get(i))) {
				continue;
			}
			
			for(int j = i; j < this.listaInstancias.size(); j++) {
				if(this.listaInstancias.get(i).getNomeDeUrna().equalsIgnoreCase(this.listaInstancias.get(j).getNomeDeUrna())) {
					if(this.listaInstancias.get(j).getResultado().getCodigo() == 1 ||
					   this.listaInstancias.get(j).getResultado().getCodigo() == 5) {
						foiEleito = true;
						listaCampanhas.add(this.listaInstancias.get(j));
						break;
					}
				}
			}
			
			if(!foiEleito) {
				this.listaInstancias.get(i).getResultado().setCodigo(4);
				listaCampanhas.add(this.listaInstancias.get(i));
			}

		}
		
		this.listaInstancias = new ArrayList<>(listaCampanhas);
		super.cadastrarInstancias();
	}

}
