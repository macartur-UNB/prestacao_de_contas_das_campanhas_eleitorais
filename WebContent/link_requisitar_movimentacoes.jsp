<%@page import="controle.servlet.RequisitarMovimentacoesServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Candidato - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

<!-- CABECALHO e MENU -->
	<div id="topo">
		<div id="cabecalho">
			<div id="logo">
				<a href="index.jsp"> <img src="img/logo.png" width="257"
					height="58" alt="Logo" title="CampanhasOn">
				</a> <span class="titulo">Informe-se JÁ!</span>
			</div>

			<!-- MENU -->
			<div id="menu">
				<ul>
					<li><a href="index.jsp" class="home" title>Home</a></li>
					<li><a href="candidatos.jsp" class="candidatos" title>Candidatos</a>
					</li>
					<li><a href="partidos.jsp" class="partidos" title>Partidos</a>
					</li>
					<li><a href="pesquisar.jsp" class="pesquisar" title>Pesquisar</a>
					</li>
				</ul>
			</div>
			<!-- FIM MENU -->

		</div>
	</div>
	<!-- FIM CABECALHO e MENU -->

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

































