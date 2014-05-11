<%@page import="controle.servlet.RequisitarMovimentacoesServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina de Perfil</title>
</head>
<body>

<h1>Visualizar Receitas e Despesas</h1>
<p>Essa funcionalidade estará dentro do perfil de um Candidato ou Partido.</p>

<form action="requisitarMovimentacoes">
	<table>
	<tr>
		<td></td>
		<td> <input type="radio" name="tabela" 
		onclick="link_requisitar_movimentacoes" value="candidato" checked /> 
		Candidato</td>
	</tr>
	<tr>
		<td></td>
		<td> <input type="radio" name="tabela" value="partido"
		 onclick="link_requisitar_movimentacoes"/> Partido</td>
	</tr>
    <tr>
    	<td>Nome: </td>
    	<td><input type="text" name="nome" /></td>
    </tr>
    <tr>
    	<td>Ano:</td>
    	<td><input type="text" name="ano" /></td>
    </tr>
    <tr>
    	<td></td>
    	<td><input type="submit" value="Buscar" /></td>
    </tr>
    </table>
</form>
</body>
</html>

































