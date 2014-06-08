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
		despesaIndicesParse.setIndiceFornecedor(8);
		despesaIndicesParse.setIndiceEmNomeDe(3);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(10);		

		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2004() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2004);
		despesaIndicesParse.setIndiceFornecedor(18);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceEspecie(13);

		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2006() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2006);
		despesaIndicesParse.setIndiceFornecedor(18);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(9);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(16);
		despesaIndicesParse.setIndiceEspecie(13);

		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2008() {
		DespesaIndicesParse despesaIndicesParse = new DespesaIndicesParse(ANO_2008);
		despesaIndicesParse.setIndiceFornecedor(22);
		despesaIndicesParse.setIndiceEmNomeDe(0);
		despesaIndicesParse.setIndiceValor(13);
		despesaIndicesParse.setIndiceTipo(11);	
		despesaIndicesParse.setIndiceTipoDocumento(20);
		despesaIndicesParse.setIndiceEspecie(17);
		despesaIndicesParse.setIndiceNumeroDocumento(19);

		return despesaIndicesParse;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2002() {
		return new DespesaIndicesParse(ANO_2002);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2004() {
		return new DespesaIndicesParse(ANO_2004);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2006() {
		return new DespesaIndicesParse(ANO_2006);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2008() {
		return new DespesaIndicesParse(ANO_2008);
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseDespesa2010() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IndicesParse<Despesa> getIndicesParseReceita2010() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
