package model;

import java.util.ArrayList;

public class Partido {
	
	private String sigla;
	ArrayList<Candidato> candidatos;
	
	public Partido() {
		
	}
	
	@Override
	public boolean equals(Object object) {
		if( !(object instanceof Partido) )
			return false;
		
		Partido outroPartido = (Partido) object;
		
		return ( this.sigla.equals(outroPartido.getSigla()) );
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}