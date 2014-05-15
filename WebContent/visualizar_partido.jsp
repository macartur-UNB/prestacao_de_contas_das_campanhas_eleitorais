<%@ page import="modelo.beans.Partido" %>
<%@ page import="controle.PartidoControle" %>
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

int Anos[] = {2012,2010,2008,2006,2004,2002};

%>

<h1><% partido.getNome(); %></h1>

<table>
<tr>
	<td>Sigla: </td>
	<td>${param.sigla}</td>
</tr>
<tr>
	<td>Número: </td>
	<td> <% out.println(partido.getNumeroPartido());%> </td>
</tr>
</table>
<br />

<%
for(int ano:Anos){
	out.println("<table border=\"2\" width=\"300\"");
	out.println("<tr><td>" + "<a href=\"requisitarMovimentacoes"
			+ "?tabela=partido&nome=" + partido.getSigla()
			+ "&ano=" + ano + "\">" + ano + "</td></tr>");
	out.println("</table><br />"); 
}

%>

</body>
</html>