<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimentações Financeiras - Campanhas-ON</title>
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
			<h3>Movimentações</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h1>
					<c:out value="${campanha.nomeDeUrna}"/>
				</h1>

				<!-- Mostrar na tela os dados do Candidato -->
				<!-- <h4>Resultado da busca:</h4>-->
				<table>
					<tr>
						<td width="200">Nome do Candidato:</td>
						<td>
						<c:out value="${campanha.candidato.nome}"/>
						</td>
					</tr>
					<tr>
						<td>Número do Candidato:</td>
						<td>
						<c:out value="${campanha.numeroCandidato}"/>
						</td>
					</tr>
					<tr>
						<td>Cargo Pleiteado:</td>
						<td>
						<c:out value="${campanha.cargo.descricao}"/>
						</td>
					</tr>
					<tr>
						<td>Ano:</td>
						<td>
						<c:out value="${campanha.ano}"/>
						</td>
					</tr>
					<tr>
						<td>Resultado:</td>
						<td>
						<c:out value="${campanha.resultado.descricao}"/>
						</td>
					</tr>
					<tr>
						<td>Despesa Máxima Declarada:</td>
						<td>
						<c:out value="${depesaTot}"/>
						</td>
					</tr>
				</table>

				<!-- Tabela de receitas -->
				<h4>Receitas:</h4>

				<table border="2" cellpadding="10">
					<tr>
						<th>Hora Registro</th>
						<!-- <th>Entraga em Conjunto</th>  -->
						<th>Número do Documento</th>
						<th>Ano</th>
						<th>Valor</th>
						<th>Fonte</th>
						<th>Tipo</th>
						<th>Espécie</th>
						<th>Descrição</th>
						<th>Recibo Eleitoral</th>
						<th>Nome do Doador</th>
						<th>Cadastro do Doador</th>
					</tr>
					<!-- Elementos da tabela -->
					<c:forEach var="receita" items="${listaReceitas}">
						<tr>
							<td>${receita.horaRegistro}</td>
							<td>${receita.numeroDocumento}</td>
							<td>${receita.ano}</td>
							<td>${receita.valor}</td>
							<td>${receita.fonte}</td>
							<td>${receita.tipo}</td>
							<td>${receita.especie}</td>
							<td>${receita.descricao}</td>
							<td>${receita.reciboEleitoral}</td>
							<td>${receita.doador.nome}</td>
							<td>${receita.doador.cadastroNacional}</td>
						</tr>
					</c:forEach>
				</table>

				<!-- Tabela de despesas -->
				<h4>Despesas:</h4>

				<table border="2" cellpadding="7">
					<tr>
						<th>Hora Registro</th>
						<!-- <th>Entraga em Conjunto</th>  -->
						<th>Número do Documento</th>
						<th>Ano</th>
						<th>Valor</th>
						<th>Fonte</th>
						<th>Tipo</th>
						<th>Espécie</th>
						<th>Descrição</th>
						<th>Tipo do Documento</th>
						<th>Nome do Fornecedor</th>
						<th>Cadastro do Fornecedor</th>
					</tr>
					<!-- Elementos da tabela -->
					<c:forEach var="despesa" items="${listaDespesas}">
						<tr>
							<td>${despesa.horaRegistro}</td>
							<td>${despesa.numeroDocumento}</td>
							<td>${despesa.ano}</td>
							<td>${despesa.valor}</td>
							<td>${despesa.fonte}</td>
							<td>${despesa.tipo}</td>
							<td>${despesa.especie}</td>
							<td>${despesa.descricao}</td>
							<td>${despesa.tipoDocumento}</td>
							<td>${despesa.fornecedor.nome}</td>
							<td>${despesa.fornecedor.cadastroNacional}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>
</body>
</html>