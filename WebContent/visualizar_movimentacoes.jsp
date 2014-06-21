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
					<c:out value="${campanha.nomeDeUrna}" />
				</h1>

				<!-- Mostrar na tela os dados do Candidato -->
				<!-- <h4>Resultado da busca:</h4>-->
				<table>
					<tr>
						<td width="200"><b>Nome do Candidato:</b></td>
						<td><c:out value="${campanha.candidato.nome}" /></td>
					</tr>
					<tr>
						<td><b>Número do Candidato:</b></td>
						<td><c:out value="${campanha.numeroCandidato}" /></td>
					</tr>
					<tr>
						<td><b>Cargo Pleiteado:</b></td>
						<td><c:out value="${campanha.cargo.descricao}" /></td>
					</tr>
					<tr>
						<td><b>Ano:</b></td>
						<td><c:out value="${campanha.ano}" /></td>
					</tr>
					<tr>
						<td><b>Resultado:</b></td>
						<td><c:out value="${campanha.resultado.descricao}" /></td>
					</tr>
					<tr>
						<td><b>Despesa Máxima Declarada:</b></td>
						<td><c:out value="${depesaTot}" /></td>
					</tr>
				</table>

				<!-- Tabela de receitas -->
				<h4>Receitas:</h4>

				<c:choose>
					<c:when test="${empty listaReceitas}">
						<p>Não há receitas declaradas.</p>
					</c:when>
					<c:otherwise>
						<table border="2" cellpadding="10" align="center">
							<tr>
								<th width="100">Data</th>
								<th width="600">Tipo de Receita</th>
								<th width="100">Valor</th>
							</tr>

							<c:forEach var="receita" items="${listaReceitas}">
								<tr>
									<td>${receita.data}</td>
									<td><details> <summary>${receita.tipoMovimentacao}</summary>
										<table border="0">
											<tr>
												<td colspan="2">Nome do Doador: <c:out
														value="${receita.doador.nome}" />
												</td>
											</tr>
											<tr>
												<td colspan="1">CPJ/CNPJ do Doador: <c:out
														value="${receita.doador.cpf_cnpj}" />
												</td>
												<td colspan="1">UF do Doador: <c:out
														value="${receita.doador.uf}" />
												</td>
											</tr>
											<tr>
												<td colspan="2">Situação Cadastral do Doador: <c:out
														value="${receita.doador.situacaoCadastral}" />
												</td>
											</tr>
											<tr>
												<td colspan="2">Número do Documento: <c:out
														value="${receita.numeroDocumento}" />
												</td>
											</tr>
											<tr>
												<td colspan="1">Forma de Pagamento: <c:out
														value="${receita.formaPagamento}" />
												</td>
												<td colspan="1">Recibo Eleitoral: <c:out
														value="${receita.reciboEleitoral}" />
												</td>
											</tr>
											<tr>
												<td colspan="2" width="600" align="justify">Descrição:
													<c:out value="${receita.descricao}" />
												</td>
											</tr>
										</table>
										</details></td>
									<td>R$ ${receita.valor}</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>


				<!-- Tabela de despesas -->
				<h4>Despesas:</h4>

				<c:choose>
					<c:when test="${empty listaDespesas}">
						<p>Não há despesas declaradas.</p>
					</c:when>
					<c:otherwise>
						<table border="2" cellpadding="10" align="center">
							<tr>
								<th width="100">Data</th>
								<th width="600">Tipo de Despesa</th>
								<th width="100">Valor</th>
							</tr>

							<!-- Elementos da tabela -->
							<c:forEach var="despesa" items="${listaDespesas}">
								<tr>
									<td>${despesa.data}</td>
									<td><details> <summary>${despesa.tipoMovimentacao}</summary>
										<table border="0">
											<tr>
												<td colspan="2">Nome do Doador: <c:out
														value="${despesa.fornecedor.nome}" />
												</td>
											</tr>
											<tr>
												<td colspan="1">CPJ/CNPJ do Doador: <c:out
														value="${despesa.fornecedor.cpf_cnpj}" />
												</td>
												<td colspan="1">UF do Doador: <c:out
														value="${despesa.fornecedor.uf}" />
												</td>
											</tr>
											<tr>
												<td colspan="2">Situação Cadastral do Doador: <c:out
														value="${despesa.fornecedor.situacaoCadastral}" />
												</td>
											</tr>
											<tr>
												<td colspan="2">Número do Documento: <c:out
														value="${despesa.numeroDocumento}" />
												</td>
											</tr>
											<tr>
												<td colspan="2">Forma de Pagamento: <c:out
														value="${despesa.formaPagamento}" />
												</td>
											</tr>
											<tr>
												<td colspan="2" width="600" align="justify">Descrição:
													<c:out value="${despesa.descricao}" />
												</td>
											</tr>
										</table>
										</details></td>
									<td>R$ ${despesa.valor}</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>
</body>
</html>