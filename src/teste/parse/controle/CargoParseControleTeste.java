package teste.parse.controle;

import modelo.beans.Cargo;
import modelo.dao.CargoDAO;

import org.junit.Assert;
import org.junit.Test;

import parse.controle.CargoParseControle;
import parse.indices.CargoIndicesParse;

public class CargoParseControleTeste {

	public static final int CODIGO = 0;
	public static final int DESCRICAO = 1;
	
	private String campo[];
	private CargoDAO cargoDAO;
	private CargoIndicesParse cargoIndicesParse;
	private CargoParseControle cargoParseControle;

	public void beforeTest() throws Exception {
		this.campo = new String[2];
		this.cargoDAO = new CargoDAO();
		this.cargoIndicesParse = new CargoIndicesParse();
		this.cargoParseControle = new CargoParseControle(this.cargoIndicesParse);
		
		iniciarCampos();
		iniciarIndices();
	}
	
	public void afterTest() {
		
	}

	
	@Test
	public void cadastrarCargos() throws Exception {
		
		this.cargoParseControle.addInstancia(campo);
		this.cargoParseControle.cadastrarInstancias();
		this.cargoParseControle.resetar();
		
		Cargo cargoCadastrado = this.cargoDAO.getLista().get(0);
				
		Assert.assertEquals(this.campo[CODIGO], cargoCadastrado.getCodigo().toString());
		Assert.assertEquals(this.campo[DESCRICAO], cargoCadastrado.getDescricao());
		
	}
	
	private void iniciarIndices() {
		
		this.cargoIndicesParse.setIndiceCodigo(CODIGO);
		this.cargoIndicesParse.setIndiceDescricao(DESCRICAO);
		
	}
	
	private void iniciarCampos() {
		
		this.campo[CODIGO] = "125";
		this.campo[DESCRICAO] = "CARGO INEXISTENTE";
		
	}

}
