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
<link href="css/tabelas.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalhopartidos.jsp"%>

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Listagem</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p><center>
					<h4>Abaixo a <b>lista de Partidos</b>.</h4>
				</center></p>

				<center>
					<table id="gradient-style" summary="Meeting Results">
						<thead>
						<tr>
        					<th scope="col">Nome</th>
            				<th scope="col">Sigla</th>
						</tr>
						</thead>
						
						<c:forEach var="partido" items="${listaPartidos}">
						<tbody>
    					<tr>
        					<td>
        						<c:url var="url_partido" value="/mvc">
									<c:param name="logica" value="SelecionarPartido"></c:param>
									<c:param name="sigla" value="${partido.sigla}"></c:param>
								</c:url>
								<a href="${url_partido}" > ${partido.nome} </a>
        					</td>
            				<td>${partido.sigla}</td>
        				</tr>
        				</tbody>
						</c:forEach>
						
						<tfoot>
    						<tr>
        					<td colspan="4">Dados de acordo com os arquivos disponíveis no site: ----</td>
       						</tr>
   						</tfoot>
					</table>
				</center>
						<!--  <tr>
							<td  width="70">
							Nome:
							</td>
							<td>							
								<c:url var="url_partido" value="/mvc">
									<c:param name="logica" value="SelecionarPartido"></c:param>
									<c:param name="sigla" value="${partido.sigla}"></c:param>
								</c:url>
								<a  href="${url_partido}" > ${partido.nome} </a>
							</td>
						</tr>
						<tr>
							<td  width="70">
							Sigla:
							</td>
							<td> ${partido.sigla}</td>
						</tr>
					</table> -->
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>