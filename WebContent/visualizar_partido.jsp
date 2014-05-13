<%@ page import="modelo.beans.Partido" %>
<%@ page import="controle.PartidoControle" %>
<%@ page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualização do Partido</title>
</head>
<body>

<%
Partido partido;
PartidoControle partidoControle = new PartidoControle();

String sigla = request.getParameter("sigla");

partido = partidoControle.getPartido(sigla);

out.println("Partido: " + partido.getSigla());
out.println("\n");
out.println("Número do Partido: " + partido.getNumeroPartido());
%>

</body>
</html>