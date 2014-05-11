<%@page import="modelo.beans.Candidato"%>
<%@page import="modelo.beans.Receita"%>
<%@page import="modelo.beans.Despesa"%>
<%@page import="modelo.dao.MovimentacaoDAO"%>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatório de movimentações financeiras</title>
</head>

<body>

<!-- Pegando os parametros do candidato -->
<%
// Busca os dados do request
Candidato candidato = new Candidato();
candidato.setNome(request.getParameter("nome"));

try{
	int ano = Integer.parseInt(request.getParameter("ano"));
	candidato.setAno(ano);
} catch (NumberFormatException e)
{
	out.println("Erro na obtenção do ano.");
	return;
}

//Mostrar na tela os dados do Candidato
out.println("<h1>Resultado da busca:</h1>");
out.println("<table><tr>");
out.println("<td> Candidato: </td><td>"    + candidato.getNome() + "</td>");
out.println("</tr><tr><td> Ano: </td><td>" +  candidato.getAno() + "</td>");
out.println("</tr></table>");

//Buscar dados no BD
MovimentacaoDAO dao;
LinkedList<Receita> listaReceitas;
LinkedList<Despesa> listaDespesas;
try {
	dao = new MovimentacaoDAO();
	System.out.println("Conexao BD foi estabelecida");
	listaReceitas = dao.getListaReceitas(candidato);
	listaDespesas = dao.getListaDespesas(candidato);
} catch(Exception e){
	System.out.println("Erro no acesso ao BD");
	throw new ServletException(e);
}			
%>

<!-- Tabela de receitas -->
<h2> Receitas: </h2>

<table border="2" cellpadding="10">
<tr>
	<th>Hora Registro</th>
	<!-- <th>Entraga em Conjunto</th>  -->
	<th>Número do Documento</th>
	<th>Data</th>
	<th>Valor</th>
	<th>Fonte</th>
	<th>Tipo</th>
	<th>Espécie</th>
	<th>Descrição</th>
	<th>Recibo Eleitoral</th>
	<th>Nome do Doador</th>
	<th>Cadastro do Doador</th>	
</tr>
<!-- Elementos da tabela -->
<%
for(Receita receita:listaReceitas)
{
out.println("<tr>");
	out.println("<td>"+receita.getHoraRegistro()+"</td>");
	//out.println("<td>"+receita.isEntregaEmConjunto()+"</td>");
	out.println("<td>"+receita.getNumeroDocumento()+"</td>");
	out.println("<td>"+receita.getData()+"</td>");
	out.println("<td>"+receita.getValor()+"</td>");
	out.println("<td>"+receita.getFonte()+"</td>");
	out.println("<td>"+receita.getTipo()+"</td>");
	out.println("<td>"+receita.getEspecie()+"</td>");
	out.println("<td>"+receita.getDescricao()+"</td>");
	out.println("<td>"+receita.getReciboEleitoral()+"</td>");
	out.println("<td>"+receita.getDoador().getNome()+"</td>");
	out.println("<td>"+receita.getDoador().getCadastroNacional()
			+"</td>");

out.println("</tr>");	
}
%>
</table>

<!-- Tabela de despesas -->
<h2> Despesas: </h2>

<table border="2" cellpadding="7">
<tr>
	<th>Hora Registro</th>
	<!-- <th>Entraga em Conjunto</th>  -->
	<th>Número do Documento</th>
	<th>Data</th>
	<th>Valor</th>
	<th>Fonte</th>
	<th>Tipo</th>
	<th>Espécie</th>
	<th>Descrição</th>
	<th>Tipo do Documento</th>
	<th>Nome do Fornecedor</th>
	<th>Cadastro do Fornecedor</th>	
</tr>
<!-- Elementos da tabela -->
<%
for(Despesa despesa:listaDespesas)
{
	out.println("<tr>");
	out.println("<td>"+despesa.getHoraRegistro()+"</td>");
	//out.println("<td>"+despesa.isEntregaEmConjunto()+"</td>");
	out.println("<td>"+despesa.getNumeroDocumento()+"</td>");
	out.println("<td>"+despesa.getData()+"</td>");
	out.println("<td>"+despesa.getValor()+"</td>");
	out.println("<td>"+despesa.getFonte()+"</td>");
	out.println("<td>"+despesa.getTipo()+"</td>");
	out.println("<td>"+despesa.getEspecie()+"</td>");
	out.println("<td>"+despesa.getDescricao()+"</td>");
	out.println("<td>"+despesa.getTipoDocumento()+"</td>");
	out.println("<td>"+despesa.getFornecedor().getNome()+"</td>");
	out.println("<td>"+despesa.getFornecedor().getCadastroNacional()
			+"</td>");
	out.println("<tr>");
}
%>
</table>

</body>
</html>