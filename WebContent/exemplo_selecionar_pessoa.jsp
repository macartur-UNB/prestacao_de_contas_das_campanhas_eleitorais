<%@page import="parse.exemplo.ExemploPessoa"%>
<%@page import="parse.exemplo.ExemploPessoaControle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo Pessoa</title>
</head>
<body>

<jsp:useBean id="controle" class="parse.exemplo.ExemploPessoaControle"/>

<h4> Lista de Pessoas: </h4>
<c:forEach var="pessoa" items="${controle.lista}">
	<c:url var="pessoaUrl" value="/selecionarPessoa">
		<c:param name="nome" value="${pessoa.nome}"></c:param>
		<c:param name="idade" value="${pessoa.idade}"></c:param>
	</c:url>
	<a href="${pessoaUrl}" >${pessoa.nome}</a>
	</br>
	</br>
</c:forEach>


</body>
</html>

































