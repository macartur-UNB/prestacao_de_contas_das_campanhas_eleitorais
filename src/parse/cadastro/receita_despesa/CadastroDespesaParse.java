package parse.cadastro.receita_despesa;

import modelo.beans.Despesa;
import parse.ParseException;
import parse.controle.DespesaParseControle;
import parse.controle.ParseControle;
import parse.indices.DespesaIndicesParse;
import parse.indices.IndicesParse;

public class CadastroDespesaParse extends CadastroParseReceitasDespesas<Despesa> {

	public CadastroDespesaParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Despesa> novaInstancia(
			IndicesParse<Despesa> indicesParse) {
		return new DespesaParseControle(indicesParse);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2002() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2002);
		despesaIndicesParse.setIndiceCampanhaNumero(4);
		despesaIndicesParse.setIndiceCampanhaCargo(2);
		despesaIndicesParse.setIndiceTipoMovimentacao(10);
		despesaIndicesParse.setIndiceData(5);
		despesaIndicesParse.setIndiceFornecedorCpfCnpj(6);
		despesaIndicesParse.setIndiceFornecedorNome(8);
		despesaIndicesParse.setIndiceValor(9);	
		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2006() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2006);
		despesaIndicesParse.setIndiceCampanhaNumero(3);
		despesaIndicesParse.setIndiceCampanhaCargo(1);
		despesaIndicesParse.setIndiceTipoMovimentacao(11);
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceFormaPagamento(13);
		despesaIndicesParse.setIndiceNumeroDocumento(15);
		despesaIndicesParse.setIndiceData(10);
		despesaIndicesParse.setIndiceFornecedorCpfCnpj(19);
		despesaIndicesParse.setIndiceFornecedorCpfCnpj(18);
		despesaIndicesParse.setIndiceValor(9);	
		return despesaIndicesParse;

	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2010() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2006);
		despesaIndicesParse.setIndiceCampanhaNumero(3);
		despesaIndicesParse.setIndiceCampanhaCargo(4);
		despesaIndicesParse.setIndiceTipoMovimentacao(14);
		despesaIndicesParse.setIndiceTipoDocumento(8);
		despesaIndicesParse.setIndiceFormaPagamento(16);
		despesaIndicesParse.setIndiceNumeroDocumento(9);
		despesaIndicesParse.setIndiceData(12);
		despesaIndicesParse.setIndiceFornecedorCpfCnpj(10);
		despesaIndicesParse.setIndiceFornecedorNome(11);
		despesaIndicesParse.setIndiceValor(13);	
		despesaIndicesParse.setIndiceDescricao(17);
		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2002() {
		return new DespesaIndicesParse(ANO_2002);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2006() {
		return new DespesaIndicesParse(ANO_2006);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2010() {
		return new DespesaIndicesParse(ANO_2010);
	}

}
