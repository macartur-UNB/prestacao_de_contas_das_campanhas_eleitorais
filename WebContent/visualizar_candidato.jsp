<%@ page import="modelo.beans.Candidato" %>
<%@ page import="controle.CandidatoControle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualização de Candidatos</title>
</head>
<body>
<%
Candidato candidato;
CandidatoControle candidatoControle = new CandidatoControle();

String nome = request.getParameter("nome");


candidato = candidatoControle.getCandidato(nome);


out.println("Candidato: " + candidato.getNome());
%>

</body>
</html>