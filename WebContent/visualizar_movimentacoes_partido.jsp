<%@page import="modelo.beans.Partido"%>
<%@page import="modelo.beans.Receita"%>
<%@page import="modelo.beans.Despesa"%>
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

<!-- Pegando os parametros do Candidato -->
<jsp:useBean id="partido" class="modelo.beans.Partido" />
<jsp:setProperty name="partido" property="sigla" value="${param.nome}" /> 

<!-- Passando ano para integer-->
<%
int ano;
try{
	ano = Integer.parseInt(request.getParameter("ano"));
} catch (NumberFormatException e)
{
	out.println("Erro na obtenção do ano.");
	return;
}
%>

<!-- Mostrar na tela os dados do Candidato -->
<h1>Resultado da busca:</h1>
<table>
<tr>
	<td> Partido: </td>
	<td>${partido.sigla}</td>
</tr>
<tr>
	<td> Ano: </td>
	<td>${param.ano}</td>
</tr>
</table>

<%
//Buscar dados no BD
LinkedList<Receita> listaReceitas;
LinkedList<Despesa> listaDespesas;
try {
	listaReceitas = partido.getListaReceitas(ano);
	listaDespesas = partido.getListaDespesas(ano);
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
	<th>Ano</th>
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
	out.println("<td>"+receita.getAno()+"</td>");
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
	<th>Ano</th>
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
	out.println("<td>"+despesa.getAno()+"</td>");
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