<%@ page import="modelo.beans.Candidato"%>
<%@ page import="controle.CandidatoControle"%>	
<%@ page import="modelo.dao.CandidatoDAO"%>
<%@ page import="modelo.dao.BasicoDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selecionar Candidatos</title>
</head>
<body>
<jsp:useBean id="controle" class="controle.CandidatoControle"/>

<h4> Lista de Candidatos: </h4>
<c:forEach var="candidato" items="${controle.listaCandidatos}">
        <c:url var="candidatoUrl" value="/SelecionarCandidato">
               <c:param name="nome" value="${candidato.nome}"></c:param>
               <c:param name="partido" value="${candidato.partido}"></c:param>
        </c:url>
        <a href="${candidatoUrl}" >${candidato.nome}</a>
        </br>
        </br>
</c:forEach>

</body>
</html>