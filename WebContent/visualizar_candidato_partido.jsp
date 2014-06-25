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

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo" id="tt_partido">
			<h3>Candidatos</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h1>
					<c:url var="url_partido" value="/mvc">
						<c:param name="logica" value="SelecionarPartido"></c:param>
						<c:param name="sigla" value="${partido.sigla}"></c:param>
					</c:url>
					<center>
						<span id="perfilPartido"><a href="${url_partido}">${partido.nome}</a></span>
					</center>
				</h1>
				<center>
					<p>
						Listagem de <b>Candidatos</b> do ano de <b>${ano}</b>. Clique no
						candidato desejado para visualizar mais informações.
					</p>
				</center>
				<center>
					<table class="sortable" id="gradient-style-listaCandidatoPartido"
						summary="Meeting Results">
						<thead>
							<tr>
								<th scope="col"><center>Candidato</center></th>
								<th scope="col"><center>Nome de Urna</center></th>
								<th scope="col"><center>Cargo</center></th>
								<th scope="col"><center>Número de Eleição</center></th>
							</tr>
						</thead>

						<c:forEach var="campanha" items="${listaCampanhas}"
							begin="${inicio}" end="${inicio+(qtdPorPagina-1)}"
							varStatus="listagem">
							<tr>
								<td><c:url var="candidatoUrl" value="/mvc">
										<c:param name="logica" value="SelecionarCandidato"></c:param>
										<c:param name="tituloEleitoral"
											value="${campanha.candidato.tituloEleitoral}"></c:param>
									</c:url> <a href="${candidatoUrl}">${campanha.candidato.nome}</a> <br>
								</td>
								<td>
									<center>${campanha.nomeDeUrna}</center>
								</td>
								<td>
									<center>${campanha.cargo.descricao}</center>
								</td>
								<td>
									<center>${campanha.numeroCandidato}</center>
								</td>
							</tr>
						</c:forEach>

						<tfoot>
							<tr>
								<td colspan="4"><center>
										Páginas:
										<c:forEach var="i" begin="1" end="${indice}">
											<c:url var="url_pag" value="/mvc">
												<c:param name="logica" value="VisualizarCandidatosPartido"></c:param>
												<c:param name="sigla" value="${sigla}"></c:param>
												<c:param name="ano" value="${ano}"></c:param>
												<c:param name="inicio" value="${(i-1)*qtdPorPagina}"></c:param>
												<c:param name="qtdPorPagina" value="${qtdPorPagina}"></c:param>
												<c:param name="verTodos" value="${false}"></c:param>
											</c:url>
											<a href="${url_pag}"><c:out value="${i}" /></a>
										</c:forEach>
										<br> Partidos por Página:
										<c:url var="url_tamanhoOriginal" value="/mvc">
											<c:param name="logica" value="VisualizarCandidatosPartido"></c:param>
											<c:param name="sigla" value="${sigla}"></c:param>
											<c:param name="ano" value="${ano}"></c:param>
											<c:param name="inicio" value="${0}"></c:param>
											<c:param name="qtdPorPagina" value="${10}"></c:param>
											<c:param name="verTodos" value="${false}"></c:param>
										</c:url>
										<a href="${url_tamanhoOriginal}"> ${10}</a>
										<c:forEach var="i" begin="1" end="${qtdDePP}">
											<c:url var="url_tamanhos" value="/mvc">
												<c:param name="logica" value="VisualizarCandidatosPartido"></c:param>
												<c:param name="sigla" value="${sigla}"></c:param>
												<c:param name="ano" value="${ano}"></c:param>
												<c:param name="inicio" value="${0}"></c:param>
												<c:param name="qtdPorPagina" value="${i*25}"></c:param>
												<c:param name="verTodos" value="${false}"></c:param>
											</c:url>
											<a href="${url_tamanhos}"> ${i*25}</a>
										</c:forEach>
										<c:url var="url_todos" value="/mvc">
											<c:param name="logica" value="VisualizarCandidatosPartido"></c:param>
											<c:param name="sigla" value="${sigla}"></c:param>
											<c:param name="ano" value="${ano}"></c:param>
											<c:param name="inicio" value="${0}"></c:param>
											<c:param name="qtdPorPagina" value="${0}"></c:param>
											<c:param name="verTodos" value="${true}"></c:param>
										</c:url>
										<a href="${url_todos}"> Ver Todos</a>
									</center></td>
							</tr>
							<tr>
								<td colspan="4">Dados de acordo com os arquivos disponíveis
									no site: ----</td>
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