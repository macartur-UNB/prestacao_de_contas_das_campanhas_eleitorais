package model;

import java.util.ArrayList;

public class Partido {
	
	private String numeroPartido;
	private String sigla;
	ArrayList<Candidato> candidatos;
	ArrayList<Receita> arrecadacao;
	ArrayList<Despesa> gasto;
	
	public Partido() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) )
			return false;
		
		Partido outroPartido = (Partido) object;
		
		return ( this.sigla.equals(outroPartido.getSigla()));
	}
	
	public String getNumeroPartido() {
		return numeroPartido;
	}
	
	public void setNumeroPartido(String numeroPartido) {
		this.numeroPartido = numeroPartido;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
