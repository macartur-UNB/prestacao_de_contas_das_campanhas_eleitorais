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

	<div id="pagina">
		<div class="titulo_topo">
			<center>
				<h3>Partido</h3>
			</center>
		</div>
		
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<div id="perfil_partido">
					<center><h1>${partido.nome}</h1></center>
					<br />
					
					<div id="informacoes_partido">
						<div id="logo_partido">
							<a href="http://www.tse.jus.br/partidos/partidos-politicos/${linktse}" target="_blank">
							<img src="img/${partido.numero}.jpg" width="140" height="150" />
							</a>
						</div>
						
						<center>

						<table>

							<tr>
								<td><b>Sigla:</b></td>
								<td>${partido.sigla}</td>
							</tr>
							<tr>
								<td><b>Número:</b></td>
								<td>${partido.numero}</td>
							</tr>
							
							<c:choose>
							<c:when test="${not empty partido.deferimento}">
								<tr>
									<td><b>Deferimento:</b></td>
									<td>${partido.deferimento}</td>
								</tr>
								<tr>
									<td><b>Mais informações:</b></td>
									<td><a
										href="http://www.tse.jus.br/partidos/partidos-politicos/${linktse}"
										target="_blank"> clique aqui</a></td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr><br /> </tr>
								<tr><br /> </tr>
							</c:otherwise>
							</c:choose>
						</table>
						</center>
						
					<div id="ano_partido">
						<h2 align="center">Consulta de Candidatos</h2>
							
						<center>
						<p><i>Clique em um dos anos para acessar <br/>
							a lista de candidatos deste Partido. </i></p>
	
							
							<table id="gradient-style1" summary="Meeting Results">
								<thead>
									<tr>
										<th scope="col"><center>Ano</center></th>
									</tr>
								</thead>

								<c:forEach var="ano" items="${anos}">
									<tbody>
										<tr>
											<td><c:url var="AnoUrl" value="/mvc">
													<c:param name="logica" value="VisualizarCandidatosPartido" />
													<c:param name="sigla" value="${partido.sigla}" />
													<c:param name="ano" value="${ano}" />
												</c:url>
												<center>
													<a href="${AnoUrl}">${ano}</a>
												</center></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</center>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="imports/rodape.jsp"%>
</body>
</html>