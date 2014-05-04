package parse.exemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploPessoaControle {

	private ArrayList<ExemploPessoa> listaPessoas;
	private List<ExemploPessoa> listaSeguraPessoas;
	
	public ExemploPessoaControle() {
		this.listaPessoas = new ArrayList<>();
		this.listaSeguraPessoas = Collections.unmodifiableList(this.listaPessoas);
		
		iniciarPessoas();
	}
	
	public void add(ExemploPessoa pessoa) {
		if(!this.listaPessoas.contains(pessoa)) {
			this.listaPessoas.add(pessoa);
		}
	}
	
	public void remove(ExemploPessoa pessoa) {
		this.listaPessoas.remove(pessoa);
	}
	
	public List<ExemploPessoa> getLista() {
		return this.listaSeguraPessoas;
	}
	
	public ExemploPessoa getPessoa(String nome) {
		for(ExemploPessoa pessoa : listaSeguraPessoas) {
			if(pessoa.getNome().equalsIgnoreCase(nome))
				return pessoa;
		}
		return null;
	}
	
	private void iniciarPessoas() {
		ExemploPessoa exemploPessoa;
		exemploPessoa = new ExemploPessoa();
		exemploPessoa.setNome("Jose");
		exemploPessoa.setIdade(18);
		add(exemploPessoa);

		exemploPessoa = new ExemploPessoa();
		exemploPessoa.setNome("Maria");
		exemploPessoa.setIdade(15);
		add(exemploPessoa);

		exemploPessoa = new ExemploPessoa();
		exemploPessoa.setNome("Adao");
		exemploPessoa.setIdade(35);
		add(exemploPessoa);

		exemploPessoa = new ExemploPessoa();
		exemploPessoa.setNome("Eva");
		exemploPessoa.setIdade(18);
		add(exemploPessoa);
	}
	
}
