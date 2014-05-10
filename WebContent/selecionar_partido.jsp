<%@ page import="modelo.beans.Partido" %>
<%@ page import="controle.PartidoControle" %>

<%@page import="modelo.dao.PartidoDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Partidos</title>
</head>
<body>

<jsp:useBean id="controle" class="controle.PartidoControle"/>

<h4> Lista de Partidos: </h4>
<c:forEach var="partido" items="${controle.listaPartidos}">
        <c:url var="partidoUrl" value="/SelecionarPartido">
               <c:param name="sigla" value="${partido.sigla}"></c:param>
               <c:param name="numeroPartido" value="${partido.numeroPartido}"></c:param>
        </c:url>
        <a href="${partidoUrl}" >${partido.sigla}</a>
        </br>
        </br>
</c:forEach>

</body>
</html>