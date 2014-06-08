package parse.cadastro.receita_despesa;

import modelo.beans.Receita;
import parse.ParseException;
import parse.controle.ParseControle;
import parse.controle.ReceitaParseControle;
import parse.indices.IndicesParse;
import parse.indices.ReceitaIndicesParse;

public class CadastroReceitaParse extends CadastroParseReceitasDespesas<Receita> {

	public CadastroReceitaParse(String tipoArquivo, String ano)
			throws ParseException {
		super(tipoArquivo, ano);
	}

	@Override
	public ParseControle<Receita> novaInstancia(
			IndicesParse<Receita> indicesParse) {
		return new ReceitaParseControle(indicesParse);
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseDespesa2002() {
		return new ReceitaIndicesParse(ANO_2002);
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseDespesa2006() {
		return new ReceitaIndicesParse(ANO_2006);
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseDespesa2010() {
		return new ReceitaIndicesParse(ANO_2010);
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseReceita2002() {
		ReceitaIndicesParse receitaIndicesParse = new ReceitaIndicesParse(ANO_2002);
		//receitaIndicesParse.setIndiceCampanha(?);
		//receitaIndicesParse.setIndiceFormaPagamento(?);
		receitaIndicesParse.setIndiceData(5);
		receitaIndicesParse.setIndiceDoador(6);
		receitaIndicesParse.setIndiceValor(9);
		
		return receitaIndicesParse;
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseReceita2006() {
		ReceitaIndicesParse receitaIndicesParse = new ReceitaIndicesParse(ANO_2006);
		//receitaIndicesParse.setIndiceCampanha(?);
		//receitaIndicesParse.setIndiceTipoMovimentacao(?);
		//receitaIndicesParse.setIndiceFormaPagamento(?);
		receitaIndicesParse.setIndiceData(10);
		receitaIndicesParse.setIndiceDoador(16);
		receitaIndicesParse.setIndiceValor(9);
		
		return receitaIndicesParse;
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseReceita2010() {
		ReceitaIndicesParse receitaIndicesParse = new ReceitaIndicesParse(ANO_2010);
		//receitaIndicesParse.setIndiceCampanha(?);
		//receitaIndicesParse.setIndiceTipoMovimentacao(?);
		//receitaIndicesParse.setIndiceFormaPagamento(?);
		receitaIndicesParse.setIndiceReciboEleitoral(8);
		receitaIndicesParse.setIndiceNumeroDocumento(9);
		receitaIndicesParse.setIndiceData(12);
		receitaIndicesParse.setIndiceDoador(10);
		receitaIndicesParse.setIndiceValor(13);
		receitaIndicesParse.setIndiceDescricao(17);
		
		return receitaIndicesParse;
	}

}
