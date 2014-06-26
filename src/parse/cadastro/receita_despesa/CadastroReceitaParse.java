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
		receitaIndicesParse.setIndiceCampanhaUf(0);
		receitaIndicesParse.setIndiceCampanhaNumero(4);
		receitaIndicesParse.setIndiceCampanhaCargo(2);
		receitaIndicesParse.setIndiceFormaPagamento(10);
		receitaIndicesParse.setIndiceData(5);
		receitaIndicesParse.setIndiceDoadorCpfCnpj(6);
		receitaIndicesParse.setIndiceDoadorNome(8);
		receitaIndicesParse.setIndiceValor(9);
		
		return receitaIndicesParse;
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseReceita2006() {
		ReceitaIndicesParse receitaIndicesParse = new ReceitaIndicesParse(ANO_2006);
		receitaIndicesParse.setIndiceCampanhaUf(4);
		receitaIndicesParse.setIndiceCampanhaNumero(3);
		receitaIndicesParse.setIndiceCampanhaCargo(1);
		receitaIndicesParse.setIndiceTipoMovimentacao(11);
		receitaIndicesParse.setIndiceFormaPagamento(13);
		receitaIndicesParse.setIndiceData(10);
		receitaIndicesParse.setIndiceDoadorCpfCnpj(16);
		receitaIndicesParse.setIndiceDoadorNome(15);
		receitaIndicesParse.setIndiceValor(9);
		
		return receitaIndicesParse;
	}

	@Override
	protected IndicesParse<Receita> getIndicesParseReceita2010() {
		ReceitaIndicesParse receitaIndicesParse = new ReceitaIndicesParse(ANO_2010);
		receitaIndicesParse.setIndiceCampanhaUf(1);
		receitaIndicesParse.setIndiceCampanhaNumero(3);
		receitaIndicesParse.setIndiceCampanhaCargo(4);
		receitaIndicesParse.setIndiceTipoMovimentacao(14);
		receitaIndicesParse.setIndiceFormaPagamento(16);
		receitaIndicesParse.setIndiceReciboEleitoral(8);
		receitaIndicesParse.setIndiceNumeroDocumento(9);
		receitaIndicesParse.setIndiceData(12);
		receitaIndicesParse.setIndiceDoadorCpfCnpj(10);
		receitaIndicesParse.setIndiceDoadorNome(11);
		receitaIndicesParse.setIndiceValor(13);
		receitaIndicesParse.setIndiceDescricao(17);
		
		return receitaIndicesParse;
	}

}
