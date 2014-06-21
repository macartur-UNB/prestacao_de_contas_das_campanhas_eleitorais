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
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
<link href="css/tabelas.css" rel="stylesheet" type="text/css"
	media="all">
</head>
<body>

	<%@include file="imports/cabecalhopartidos.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Candidatos</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h1>
					<c:out value="${partido.nome}" />
				</h1>
				<p>
					Listagem de <b>Candidatos</b>. Clique no candidato desejado para
					visualizar mais informações.
				</p>

				<table id="gradient-style" summary="Meeting Results">
					<thead>
						<tr>
							<th scope="col">Candidato</th>
						</tr>
					</thead>

					<c:forEach var="campanha" items="${listaCampanhas}">
						<tbody>
							<tr>
								<td><c:url var="candidatoUrl" value="/mvc">
										<c:param name="logica" value="SelecionarCandidato"></c:param>
										<c:param name="tituloEleitoral"
											value="${campanha.candidato.tituloEleitoral}"></c:param>
									</c:url>
										<a href="${candidatoUrl}">${campanha.candidato.nome}</a>
										<br>
									</td>
							</tr>
						</tbody>
					</c:forEach>

					<tfoot>
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