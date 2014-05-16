<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Partidos - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalhopartidos.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Partidos</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p>
					Listagem de <b>Partidos</b>. Click no partido desejado para
					visualizar mais informações.
				</p>
				<jsp:useBean id="controle" class="controle.PartidoControle" />

				<c:forEach var="partido" items="${controle.listaPartidos}">
					<c:url var="partidoUrl" value="/SelecionarPartido">
						<c:param name="sigla" value="${partido.sigla}"></c:param>
						<c:param name="numeroPartido" value="${partido.numeroPartido}"></c:param>
					</c:url>
					<a href="${partidoUrl}">${partido.sigla}</a>
					<br>
					<br>
				</c:forEach>
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>

</body>
</html>