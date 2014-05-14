<%@page import="modelo.beans.Candidato"%>
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

<!-- Mostrar na tela os dados do Candidato -->
<h1>Resultado da busca:</h1>
<table>
<tr>
	<td> Candidato: </td>
	<td>${param.nome}</td>
</tr>
<tr>
	<td> Ano: </td>
	<td>${param.ano} </td>
</tr>
</table>

<jsp:useBean id="candidato" class="modelo.beans.Candidato" />
<jsp:setProperty name="candidato" property="nome" value="${param.nome}" /> 
<jsp:setProperty name="candidato" property="ano" value="${param.ano}" /> 

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
<c:forEach var="receita" items="${candidato.listaReceitas}">
	<tr>
		<td>${receita.horaRegistro}</td>
		<td>${receita.numeroDocumento}</td>
		<td>${receita.data}</td>
		<td>${receita.valor}</td>
		<td>${receita.fonte}</td>
		<td>${receita.tipo}</td>
		<td>${receita.especie}</td>
		<td>${receita.descricao}</td>
		<td>${receita.reciboEleitoral}</td>
		<td>${receita.doador.nome}</td>
		<td>${receita.doador.cadastroNacional}</td>
	</tr>
</c:forEach>
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
<c:forEach var="despesa" items="${candidato.listaDespesas}">
	<tr>
		<td>${despesa.horaRegistro}</td>
		<td>${despesa.numeroDocumento}</td>
		<td>${despesa.data}</td>
		<td>${despesa.valor}</td>
		<td>${despesa.fonte}</td>
		<td>${despesa.tipo}</td>
		<td>${despesa.especie}</td>
		<td>${despesa.descricao}</td>
		<td>${despesa.tipoDocumento}</td>
		<td>${despesa.fornecedor.nome}</td>
		<td>${despesa.fornecedor.cadastroNacional}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>