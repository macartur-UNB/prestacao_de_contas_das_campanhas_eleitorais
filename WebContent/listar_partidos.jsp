<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Partidos - Campanhas-ON</title>
<script src="script/sorttable.js"></script>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
<link href="css/tabelas.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body>

	<%@include file="imports/cabecalhopartidos.jsp"%>

	<div id="pagina">
		<div class="titulo_topo" id="tt_pesquisa">
			<h3>Listagem</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<center>
					<h3>Selecione um Partido abaixo para visitar seu Perfil</h3>
				</center>

				<center>

					<table class="sortable" id="gradient-style"
						summary="Meeting Results">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Sigla</th>
							</tr>

						</thead>
						<c:forEach var="partido" items="${listaPartidos}"
							begin="${inicio}" end="${inicio+(qtdPorPagina-1)}"
							varStatus="listagem">
							<tr>
								<td><c:url var="url_partido" value="/mvc">
										<c:param name="logica" value="SelecionarPartido" />
										<c:param name="sigla" value="${partido.sigla}" />
									</c:url> <a href="${url_partido}"> ${partido.nome} </a></td>
								<td>${partido.sigla}</td>
							</tr>
						</c:forEach>

						<tfoot>
							<tr>
								<td colspan="4"><center>
										Páginas:
										<c:forEach var="i" begin="1" end="${indice}">
											<c:url var="url_pag" value="/mvc">
												<c:param name="logica" value="RequisitarPartido" />
												<c:param name="inicio" value="${(i-1)*qtdPorPagina}" />
												<c:param name="qtdPorPagina" value="${qtdPorPagina}" />
												<c:param name="verTodos" value="${false}" />
											</c:url>
											<c:choose>
												<c:when test="${i == atual}">[ ${i} ]</c:when>
												<c:otherwise>
													<a href="${url_pag}"><c:out value="${i}" /></a>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<br> Partidos por Página:
										<c:url var="url_tamanhoOriginal" value="/mvc">
											<c:param name="logica" value="RequisitarPartido" />
											<c:param name="inicio" value="${0}" />
											<c:param name="qtdPorPagina" value="${10}" />
											<c:param name="verTodos" value="${false}" />
										</c:url>
										<a href="${url_tamanhoOriginal}"> ${10}</a>
										<c:forEach var="i" begin="1" end="${qtdDePP}">
											<c:url var="url_tamanhos" value="/mvc">
												<c:param name="logica" value="RequisitarPartido" />
												<c:param name="inicio" value="${0}" />
												<c:param name="qtdPorPagina" value="${i*25}" />
												<c:param name="verTodos" value="${false}" />
											</c:url>
											<a href="${url_tamanhos}"> ${i*25}</a>
										</c:forEach>
										<c:url var="url_todos" value="/mvc">
											<c:param name="logica" value="RequisitarPartido" />
											<c:param name="inicio" value="${0}" />
											<c:param name="qtdPorPagina" value="${0}" />
											<c:param name="verTodos" value="${true}" />
										</c:url>
										<a href="${url_todos}"> Ver Todos</a>
									</center></td>
							</tr>
							<tr>
								<td colspan="4">Os nomes e as siglas dos Partidos Políticos
									estão exibidos da forma em que foram registrados no TSE.</td>
							</tr>
						</tfoot>
					</table>
				</center>
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>