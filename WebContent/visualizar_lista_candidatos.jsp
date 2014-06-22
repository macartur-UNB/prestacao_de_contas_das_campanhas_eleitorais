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
<link href="css/tabelas.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body>

	<%@include file="imports/cabecalhocandidatos.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Candidatos</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p>
					Listagem de <b>Candidatos</b>. Clique no candidato desejado para
					visualizar mais informações.
				</p>

				<table id="gradient-style">
					<thead>
						<tr>
							<th scope="col">Candidato</th>
						</tr>
					</thead>

					<c:forEach var="candidato" items="${listaCandidatos}"
						begin="${inicio}" end="${inicio+(qtdPorPagina-1)}"
						varStatus="listagem">
						<tbody>
							<tr>
								<td><c:url var="candidatoUrl" value="/mvc">
										<c:param name="logica" value="SelecionarCandidato" />
										<c:param name="tituloEleitoral"
											value="${candidato.tituloEleitoral}" />
									</c:url> <a href="${candidatoUrl}">${candidato.nome}</a> <br></td>
							</tr>
						</tbody>
					</c:forEach>

					<tfoot>
						<tr>
							<td colspan="4"><center>
									Páginas:
									<c:forEach var="i" begin="1" end="${indice}">
										<c:url var="url_pag" value="/mvc">
											<c:param name="logica"
												value="VisualizarResultadoListaBuscaCandidato" />
											<c:param name="nome" value="${nome}" />
											<c:param name="inicio" value="${(i-1)*qtdPorPagina}" />
											<c:param name="qtdPorPagina" value="${qtdPorPagina}" />
											<c:param name="verTodos" value="${false}" />
										</c:url>
										<a href="${url_pag}"><c:out value="${i}" /></a>
									</c:forEach>
									<br> Candidatos por Página:
									<c:url var="url_tamanhoOriginal" value="/mvc">
										<c:param name="logica"
											value="VisualizarResultadoListaBuscaCandidato" />
										<c:param name="nome" value="${nome}" />
										<c:param name="inicio" value="${0}" />
										<c:param name="qtdPorPagina" value="${10}" />
										<c:param name="verTodos" value="${false}" />
									</c:url>
									<a href="${url_tamanhoOriginal}"> ${10}</a>
									<c:forEach var="i" begin="1" end="${qtdDePP}">
										<c:url var="url_tamanhos" value="/mvc">
											<c:param name="logica"
												value="VisualizarResultadoListaBuscaCandidato" />
											<c:param name="nome" value="${nome}" />
											<c:param name="inicio" value="${0}" />
											<c:param name="qtdPorPagina" value="${i*25}" />
											<c:param name="verTodos" value="${false}" />
										</c:url>
										<a href="${url_tamanhos}"> ${i*25}</a>
									</c:forEach>
									<c:url var="url_todos" value="/mvc">
										<c:param name="logica"
											value="VisualizarResultadoListaBuscaCandidato" />
										<c:param name="nome" value="${nome}" />
										<c:param name="inicio" value="${0}" />
										<c:param name="qtdPorPagina" value="${0}" />
										<c:param name="verTodos" value="${true}" />
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
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>

</body>
</html>