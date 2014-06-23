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

	<%@include file="imports/cabecalho.jsp"%>

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Perfil</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<div id="perfil_partido">
					<center>
						<h1>
							<c:out value="${candidato.nome}" />
						</h1>
					</center>
					<br />

					<!-- Identificacao do candidato -->
					<div id="informacoes_partido">
						<div id="logo_partido">
							<img src="img/perfil.jpg" width="140" height="150" />
						</div>
						<center>
							<table>
								<tr>
									<td><b>Nome:</b></td>
									<td><c:out value="${candidato.nome}" /></td>

								</tr>
								<tr>
									<td><b>Título Eleitoral:</b></td>
									<td><c:out value="${candidato.tituloEleitoral}" /></td>
								</tr>

							</table>
							<center>
								<p>
									<i>Clique no ano para o qual deseja visualizar a <br />
										prestação de contas deste candidato:
									</i>
								</p>
							</center>

							<div id="ano_partido">
								<h2 align="center">Consulta a Movimentação</h2>
								<!-- Anos em que ele concorreu -->
								<c:forEach var="campanha" items="${campanhas}">
									<table id="gradient-style-perfilCandidato"
										summary="Meeting Results">
										<thead>
											<tr>
												<th scope="col" colspan="4"><c:url var="AnoUrl"
														value="/mvc">
														<c:param name="logica"
															value="RequisitarMovimentacoesDeCandidato" />
														<c:param name="numero_cand"
															value="${campanha.numeroCandidato}" />
														<c:param name="ano" value="${campanha.ano}" />
														<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
														<c:param name="uf" value="${campanha.uf}" />
														<c:param name="inicioD" value="${0}" />
														<c:param name="qtdPorPaginaD" value="${10}" />
														<c:param name="verTodosD" value="${false}" />
														<c:param name="inicioR" value="${0}" />
														<c:param name="qtdPorPaginaR" value="${10}" />
														<c:param name="verTodosR" value="${false}" />
													</c:url> <a href="${AnoUrl}"><center>${campanha.ano}</center></a></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td width=""><c:url var="partidoUrl" value="/mvc">
														<c:param name="logica" value="SelecionarPartido" />
														<c:param name="sigla" value="${campanha.partido.sigla}" />
													</c:url> <b>Partido:</b> <a href="${partidoUrl}">${campanha.partido.sigla}</a>
												</td>
												<td width="250"><b>Cargo Pleiteado:</b> <br>${campanha.cargo.descricao}</td>
												<td><b>UF:</b> ${campanha.uf}</td>
												<td><b>Número:</b> ${campanha.numeroCandidato}</td>
											</tr>
										</tbody>
									</table>
								</c:forEach>
							</div>
						</center>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>
</body>
</html>