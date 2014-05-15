<%@page import="controle.servlet.SelecionarCandidato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidatos - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalhocandidatos.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Buscar</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">

				<p>
					Entre com o uma parte do nome do <b>Candidato</b> que deseja
					buscar, e em seguida, click em burcar.
				</p>
				<form action="SelecionarCandidato">
					<table>
						<tr>
							<td>Nome:</td>
							<td><input type="text" name="nome" /></td>
						</tr>
						<tr>
							<td></td>
							<td><br><input type="submit" class="botao" value="Buscar" /></td>
						</tr>
					</table>
				</form>
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>

</body>
</html>
