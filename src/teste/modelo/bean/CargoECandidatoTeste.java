package teste.modelo.bean;

import static org.junit.Assert.assertEquals;
import modelo.beans.Candidato;
import modelo.beans.Cargo;

import org.junit.Test;

public class CargoECandidatoTeste {
	
	@Test
	public void deveRetornarVerdadeiroSeDoisCargosForemIguais() {
		Cargo cargo = new Cargo();
		cargo.setCodigo(156);
		cargo.setDescricao("Cargo Teste");
		
		Cargo cargo2 = new Cargo();
		cargo2.setCodigo(156);
		cargo2.setDescricao("Cargo Teste");
		
		assertEquals(true, cargo.equals(cargo2));
	}
	
	@Test
	public void deveRetornarVerdadeiroSeDoisCandidatosForemIguais() {
		Candidato candidato = new Candidato();
		candidato.setNome("Nome do Candidato Teste");
		candidato.setTituloEleitoral("123");
		
		Candidato candidato2 = new Candidato();
		candidato2.setNome("Nome do Candidato Teste");
		candidato2.setTituloEleitoral("123");
		
		assertEquals(true, candidato.equals(candidato2));
	}
	
	@Test
	public void deveRetornarFalsoSeDoisCargosForemDireferentes() {
		Cargo cargo = new Cargo();
		cargo.setCodigo(156);
		cargo.setDescricao("Cargo Teste");
		
		Cargo cargo2 = new Cargo();
		cargo2.setCodigo(145);
		cargo2.setDescricao("Cargo 2 Teste");

		assertEquals(false, cargo.equals(cargo2));
	}
	
	@Test
	public void deveRetornarFalsoSeDoisCandidatosForemDiferentes() {
		Candidato candidato = new Candidato();
		candidato.setNome("Nome do Candidato Teste");
		candidato.setTituloEleitoral("123");
		
		Candidato candidato2 = new Candidato();
		candidato2.setNome("Nome do Candidato 2 Teste");
		candidato2.setTituloEleitoral("120");
		
		assertEquals(false, candidato.equals(candidato2));
		}
	
	@Test
	public void deveRetornarFalsoSeInstanciarUmObjetoNuloOuDeOutraClasse() {
		Cargo cargo = new Cargo();
		cargo.setCodigo(156);
		cargo.setDescricao("Cargo Teste");
		
		Cargo cargo2 = null;
		Candidato candidato2 = null;
		
		assertEquals("156", cargo.getCodigo().toString());
		
		Candidato candidato = new Candidato();
		candidato.setNome("Nome do Candidato Teste");
		candidato.setTituloEleitoral("123");

		assertEquals("Nome do Candidato Teste", candidato.getNome());
		
		assertEquals(false, cargo.equals(candidato));
		assertEquals(false, cargo.equals(cargo2));
		assertEquals(false, candidato.equals(cargo));
		assertEquals(false, candidato.equals(candidato2));
	}

}