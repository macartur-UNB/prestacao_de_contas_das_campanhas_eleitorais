<%@page import="java.io.PrintWriter"%>
<%@ page import="modelo.beans.Candidato"%>
<%@ page import="controle.CandidatoControle"%>
<%@ page import="java.util.LinkedList"%>
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
			<h3>Visualizar</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p>
					Abaixo o Perfil do <b>Candidato</b> selecionado.
				</p>


				<%
					CandidatoControle candidatoControle = new CandidatoControle();

					String nome = request.getParameter("nome");
					String cpf = request.getParameter("cpf");

					LinkedList<Candidato> listaCandidato = candidatoControle
							.getCandidato(nome);
				%>

				<!-- Identificacao do candidato -->
				<table>
					<tr>
						<td>Nome:</td>
						<td>
							<%
								out.println(nome);
							%>
						</td>
					</tr>
					<tr>
						<td>CPF:</td>
						<td>
							<%
								out.println(cpf);
							%>
						</td>
					</tr>
				</table>

				<!-- Anos em que ele concorreu -->

				<%
					String ano;
					String sigla;
					for (Candidato candidato : listaCandidato) {
						ano = candidato.getAno().toString();
						sigla = candidato.getPartido().getSigla();
						out.println("<table border=\"2\" width=\"600\"><tbody>");
						out.println("<tr>");
						out.println("<td rowspan=\"2\">");
						nome.replaceAll(" ", "+");
						out.println("<a href=\"requisitarMovimentacoes"
								+ "?tabela=candidato&nome=" + nome + "&ano=" + ano
								+ "\">" + ano + "</a>");
						out.println("</td>");
						out.println("<td>");
						out.println("Partido: " + "<a href=\"SelecionarPartido?sigla="
								+ sigla + "\">" + sigla + "</a>");
						out.println("</td>");
						out.println("<td>");
						out.println("Cargo Pleiteado: " + candidato.getCargo());
						out.println("</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>");
						out.println("UF: " + candidato.getUf());
						out.println("</td>");
						out.println("<td>");
						out.println("Número: " + candidato.getNumero());
						out.println("</td>");
						out.println("</tr>");
						out.println("</tbody></table><br />");
					}
				%>

				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>