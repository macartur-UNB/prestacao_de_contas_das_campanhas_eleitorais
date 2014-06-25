package teste.parse.indices;

import modelo.beans.MovimentacaoFinanceira;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parse.indices.MovimentacaoFinanceiraIndicesParse;

public class MovimentacaoFinanceiraIndicesParseTeste {

	private String campo[];
	private MovimentacaoFinanceiraIndicesParse movimentacaoFinanceiraIndicesParse;
	private String ano = "2006";
	private String anoTeste = "2010";

	@Before
	public void setUp() throws Exception {
		
		this.movimentacaoFinanceiraIndicesParse = new MovimentacaoFinanceiraIndicesParse<>(ano);
		this.campo = new String[9];
		
		iniciarCampos();
		iniciarIndices();
	}

	@Test
	public void iniciarUmaMovimentacaoFinanceiraComIndicesValidos() throws Exception {
		
		MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
		this.movimentacaoFinanceiraIndicesParse.iniciarInstancia(movimentacaoFinanceira, campo);
		Assert.assertEquals(this.campo[0], movimentacaoFinanceira.getCampanha().getAno().toString());
		Assert.assertEquals(this.campo[1], movimentacaoFinanceira.getCampanha().getNumeroCandidato().toString());
		Assert.assertEquals(this.campo[2], movimentacaoFinanceira.getCampanha().getCargo().getDescricao());
		Assert.assertEquals(this.campo[3], movimentacaoFinanceira.getNumeroDocumento());
		Assert.assertEquals(this.campo[4], movimentacaoFinanceira.getData());
		Assert.assertEquals(this.campo[5], movimentacaoFinanceira.getValor().toString());
		Assert.assertEquals(this.campo[6], movimentacaoFinanceira.getTipoMovimentacao());
		Assert.assertEquals(this.campo[7], movimentacaoFinanceira.getFormaPagamento());
		Assert.assertEquals(this.campo[8], movimentacaoFinanceira.getDescricao());
	}
	
	@Test
	public void iniciarUmaMovimentacaoFinanceiraComIndicesInvalidos() throws Exception {
		
		this.movimentacaoFinanceiraIndicesParse = new MovimentacaoFinanceiraIndicesParse<>(anoTeste);
		MovimentacaoFinanceira movimentacaoFinanceira = new MovimentacaoFinanceira();
		this.movimentacaoFinanceiraIndicesParse.iniciarInstancia(movimentacaoFinanceira, campo);
		Assert.assertNotEquals(this.campo[0], movimentacaoFinanceira.getCampanha().getAno().toString());
		Assert.assertNotEquals(this.campo[1], movimentacaoFinanceira.getCampanha().getNumeroCandidato().toString());
		Assert.assertNotEquals(this.campo[2], movimentacaoFinanceira.getCampanha().getCargo().getDescricao());
		Assert.assertNotEquals(this.campo[3], movimentacaoFinanceira.getNumeroDocumento());
		Assert.assertNotEquals(this.campo[4], movimentacaoFinanceira.getData());
		Assert.assertNotEquals(this.campo[5], movimentacaoFinanceira.getValor().toString());
		Assert.assertNotEquals(this.campo[6], movimentacaoFinanceira.getTipoMovimentacao());
		Assert.assertNotEquals(this.campo[7], movimentacaoFinanceira.getFormaPagamento());
		Assert.assertNotEquals(this.campo[8], movimentacaoFinanceira.getDescricao());
	}
	
	private void iniciarIndices() {
		
		this.movimentacaoFinanceiraIndicesParse.setIndiceCampanhaAno(0);
		this.movimentacaoFinanceiraIndicesParse.setIndiceCampanhaNumero(1);
		this.movimentacaoFinanceiraIndicesParse.setIndiceCampanhaCargo(2);
		this.movimentacaoFinanceiraIndicesParse.setIndiceNumeroDocumento(3);
		this.movimentacaoFinanceiraIndicesParse.setIndiceData(4);
		this.movimentacaoFinanceiraIndicesParse.setIndiceValor(5);
		this.movimentacaoFinanceiraIndicesParse.setIndiceTipoMovimentacao(6);
		this.movimentacaoFinanceiraIndicesParse.setIndiceFormaPagamento(7);
		this.movimentacaoFinanceiraIndicesParse.setIndiceDescricao(8);
	}
	
	private void iniciarCampos() {
		
		this.campo[0] = "2006";
		this.campo[1] = "45555";
		this.campo[2] = "CARGO";
		this.campo[3] = "55896321447";
		this.campo[4] = "12/10/2006";
		this.campo[5] = "450.0";
		this.campo[6] = "TIPO MOVIMENTACAO";
		this.campo[7] = "FORMA PAGAMENTO";
		this.campo[8] = "DESCRICAO";
	}

}
