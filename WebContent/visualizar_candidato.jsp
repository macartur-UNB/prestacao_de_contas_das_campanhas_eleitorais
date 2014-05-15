<%@ page import="java.util.List"%>
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

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Visualizar</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p>
					Abaixo o Perfil do <b>Candidato</b> selecionado.
				</p>

				<!-- Identificacao do candidato -->
				<table>
					<tr>
						<td>Nome:</td>
						<td>
							${param.nome}
						</td>
					</tr>
					<tr>
						<td>CPF:</td>
						<td>
							<c:out value="${cpf}" />
						</td>
					</tr>
				</table>

				<!-- Anos em que ele concorreu -->
				<c:forEach var="candidato" items="${listaCandidato}" >

					<table border="2" width="600"><tbody>
					<tr>
						<td rowspan="2">
							<c:url var="AnoUrl" value="/requisitarMovimentacoes">
								<c:param name="tabela" value="candidato"></c:param>
								<c:param name="nome" value="${candidato.nome}"></c:param>
								<c:param name="ano" value="${candidato.ano}"></c:param>
							</c:url>
							<a href="${AnoUrl}">${candidato.ano}</a>
						</td>
						<td>
							<c:url var="partidoUrl" value="/SelecionarPartido">
								<c:param name="sigla" value="${candidato.partido.sigla}"></c:param>
							</c:url>
							Partido: <a href="${partidoUrl}">${candidato.partido.sigla}</a>
						</td>
						<td>
							Cargo Pleiteado: ${candidato.cargo}
						</td>
					</tr>
					<tr>
						<td>
							UF: ${candidato.uf}
						</td>
						<td>
							Número: ${candidato.numero}
						</td>
					</tr>
				</tbody></table>
				<br />
			</c:forEach>


				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>