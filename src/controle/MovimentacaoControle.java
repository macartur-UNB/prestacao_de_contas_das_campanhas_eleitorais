package controle;

import java.sql.SQLException;
import java.util.LinkedList;

import modelo.beans.Candidato;
import modelo.beans.Despesa;
import modelo.beans.Partido;
import modelo.beans.Receita;
import modelo.dao.MovimentacaoDAO;

public class MovimentacaoControle {

	private MovimentacaoDAO movimentacaoDAO;

	
	public MovimentacaoControle()
	{
		this.movimentacaoDAO = new MovimentacaoDAO();
	}
	
	public LinkedList<Despesa> getListaDespesas(Partido partido,Integer ano) throws SQLException
	{
		return this.movimentacaoDAO.getListaDespesas(partido, ano);

	}
	
	public LinkedList<Receita> getListaReceitas(Partido partido,Integer ano) throws SQLException
	{
		return this.movimentacaoDAO.getListaReceitas(partido, ano);

	}
	
	public LinkedList<Despesa> getListaDespesas(Candidato candidato)
	{
		return this.movimentacaoDAO.getListaDespesas(candidato);

	}
	
	public LinkedList<Receita> getListaReceitas(Candidato candidato) 
	{
		return this.movimentacaoDAO.getListaReceitas(candidato);

	}
	
}
