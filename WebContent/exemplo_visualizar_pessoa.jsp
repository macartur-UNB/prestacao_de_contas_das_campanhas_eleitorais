<%@page import="parse.exemplo.ExemploPessoaControle"%>
<%@page import="parse.exemplo.ExemploPessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualizar Pessoa</title>
</head>
<body>

<%
ExemploPessoa pessoa;
ExemploPessoaControle pessoaControle = new ExemploPessoaControle();

String nome = request.getParameter("nome");

pessoa = pessoaControle.getPessoa(nome);

out.println("Pessoa: " + pessoa.getNome() + ", " + pessoa.getIdade() + " anos");
%>

</body>
</html>