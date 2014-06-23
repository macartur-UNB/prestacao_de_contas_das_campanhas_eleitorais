<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimentações Financeiras - Campanhas-ON</title>
<script src="script/sorttable.js"></script>
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

				<div id="perfilCandidatoAno">
					<div id="fotoPerfil">
						<img src="img/perfil.jpg" width="140" height="150" />
					</div>
					<h1>
						<c:out value="${campanha.nomeDeUrna}" />
					</h1>

					<!-- Mostrar na tela os dados do Candidato -->
					<br>
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
				</div>

				<!-- Tabela de receitas -->
				<center>
					<h4>
						<br>
						<br>
						<br>Receitas:
					</h4>

					<c:choose>
						<c:when test="${empty listaReceitas}">
							<p>Não há receitas declaradas.</p>
						</c:when>
						<c:otherwise>
							<table class="sortable" id="gradient-style-movimentacao"
								summary="Meeting Results" cellpadding="10" align="center">
								<tr>
									<th width="100">Data</th>
									<th width="600">Detalhamento da Receita</th>
									<th width="100">Valor</th>
								</tr>

								<c:forEach var="receita" items="${listaReceitas}"
									begin="${inicioR}" end="${inicioR+(qtdPorPaginaR-1)}"
									varStatus="listagemR">
									<tr>
										<td>${receita.data}</td>
										<td><details> <summary>${receita.tipoMovimentacao}</summary>
											<table border="8">
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
													<td colspan="1">Número do Documento: <c:out
															value="${receita.numeroDocumento}" />
													</td>
													<td colspan="1">Situação Cadastral do Doador: <c:out
															value="${receita.doador.situacaoCadastral}" />
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
								<tfoot>
									<tr>
										<td colspan="4"><center>
												Páginas:
												<c:forEach var="i" begin="1" end="${indiceR}">
													<c:url var="url_pagR" value="/mvc">
														<c:param name="logica"
															value="RequisitarMovimentacoesDeCandidato" />
														<c:param name="numero_cand"
															value="${campanha.numeroCandidato}" />
														<c:param name="ano" value="${campanha.ano}" />
														<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
														<c:param name="uf" value="${campanha.uf}" />
														<c:param name="inicioR" value="${(i-1)*qtdPorPaginaR}" />
														<c:param name="qtdPorPaginaR" value="${qtdPorPaginaR}" />
														<c:param name="verTodosR" value="${false}" />
														<c:param name="inicioD" value="${inicioD}" />
														<c:param name="qtdPorPaginaD" value="${qtdPorPaginaD}" />
														<c:param name="verTodosD" value="${verTodosD}" />
													</c:url>
													<a href="${url_pagR}"><c:out value="${i}" /></a>
												</c:forEach>
												<br> Receitas por Página:
												<c:url var="url_tamanhoOriginalR" value="/mvc">
													<c:param name="logica"
														value="RequisitarMovimentacoesDeCandidato" />
													<c:param name="numero_cand"
														value="${campanha.numeroCandidato}" />
													<c:param name="ano" value="${campanha.ano}" />
													<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
													<c:param name="uf" value="${campanha.uf}" />
													<c:param name="inicioR" value="${0}" />
													<c:param name="qtdPorPaginaR" value="${10}" />
													<c:param name="verTodosR" value="${false}" />
													<c:param name="inicioD" value="${inicioD}" />
													<c:param name="qtdPorPaginaD" value="${qtdPorPaginaD}" />
													<c:param name="verTodosD" value="${verTodosD}" />
												</c:url>
												<a href="${url_tamanhoOriginalR}"> ${10}</a>
												<c:forEach var="i" begin="1" end="${qtdDePPR}">
													<c:url var="url_tamanhosR" value="/mvc">
														<c:param name="logica"
															value="RequisitarMovimentacoesDeCandidato" />
														<c:param name="numero_cand"
															value="${campanha.numeroCandidato}" />
														<c:param name="ano" value="${campanha.ano}" />
														<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
														<c:param name="uf" value="${campanha.uf}" />
														<c:param name="inicioR" value="${0}" />
														<c:param name="qtdPorPaginaR" value="${i*25}" />
														<c:param name="verTodosR" value="${false}" />
														<c:param name="inicioD" value="${inicioD}" />
														<c:param name="qtdPorPaginaD" value="${qtdPorPaginaD}" />
														<c:param name="verTodosD" value="${verTodosD}" />
													</c:url>
													<a href="${url_tamanhosR}"> ${i*25}</a>
												</c:forEach>
												<c:url var="url_todosR" value="/mvc">
													<c:param name="logica"
														value="RequisitarMovimentacoesDeCandidato" />
													<c:param name="numero_cand"
														value="${campanha.numeroCandidato}" />
													<c:param name="ano" value="${campanha.ano}" />
													<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
													<c:param name="uf" value="${campanha.uf}" />
													<c:param name="inicioR" value="${0}" />
													<c:param name="qtdPorPaginaR" value="${0}" />
													<c:param name="verTodosR" value="${true}" />
													<c:param name="inicioD" value="${inicioD}" />
													<c:param name="qtdPorPaginaD" value="${qtdPorPaginaD}" />
													<c:param name="verTodosD" value="${verTodosD}" />
												</c:url>
												<a href="${url_todosR}"> Ver Todos</a>
											</center></td>
									</tr>
									<tr>
										<td colspan="4">INSERIR INFORMAÇÕES A RESPEITO DOS DADOS
											DE RECEITA.</td>
									</tr>
								</tfoot>
							</table>
						</c:otherwise>
					</c:choose>
				</center>


				<!-- Tabela de despesas -->
				<center>
					<h4>
						<br>
						<br>Despesas:
					</h4>

					<c:choose>
						<c:when test="${empty listaDespesas}">
							<p>Não há despesas declaradas.</p>
						</c:when>
						<c:otherwise>
							<table class="sortable" id="gradient-style-movimentacao"
								summary="Meeting Results" cellpadding="10" align="center">
								<tr>
									<th width="100">Data</th>
									<th width="600">Tipo de Despesa</th>
									<th width="100">Valor</th>
								</tr>

								<!-- Elementos da tabela -->
								<c:forEach var="despesa" items="${listaDespesas}"
									begin="${inicioD}" end="${inicioD+(qtdPorPaginaD-1)}"
									varStatus="listagemD">
									<tr>
										<td>${despesa.data}</td>
										<td><details> <summary>${despesa.tipoMovimentacao}</summary>
											<table border="8">
												<tr>
													<td colspan="2">Nome do Fornecedor: <c:out
															value="${despesa.fornecedor.nome}" />
													</td>
												</tr>
												<tr>
													<td colspan="1">CPJ/CNPJ do Fornecedor: <c:out
															value="${despesa.fornecedor.cpf_cnpj}" />
													</td>
													<td colspan="1">UF do Fornecedor: <c:out
															value="${despesa.fornecedor.uf}" />
													</td>
												</tr>
												<tr>
													<td colspan="1">Número do Documento: <c:out
															value="${despesa.numeroDocumento}" />
													</td>
													<td colspan="1">Situação Cadastral do Fornecedor: <c:out
															value="${despesa.fornecedor.situacaoCadastral}" />
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
								<tfoot>
									<tr>
										<td colspan="4"><center>
												Páginas:
												<c:forEach var="i" begin="1" end="${indiceD}">
													<c:url var="url_pagD" value="/mvc">
														<c:param name="logica"
															value="RequisitarMovimentacoesDeCandidato" />
														<c:param name="numero_cand"
															value="${campanha.numeroCandidato}" />
														<c:param name="ano" value="${campanha.ano}" />
														<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
														<c:param name="uf" value="${campanha.uf}" />
														<c:param name="inicioD" value="${(i-1)*qtdPorPaginaD}" />
														<c:param name="qtdPorPaginaD" value="${qtdPorPaginaD}" />
														<c:param name="verTodosD" value="${false}" />
														<c:param name="inicioR" value="${inicioR}" />
														<c:param name="qtdPorPaginaR" value="${qtdPorPaginaR}" />
														<c:param name="verTodosR" value="${verTodosR}" />
													</c:url>
													<a href="${url_pagD}"><c:out value="${i}" /></a>
												</c:forEach>
												<br> Despesas por Página:
												<c:url var="url_tamanhoOriginalD" value="/mvc">
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
													<c:param name="inicioR" value="${inicioR}" />
													<c:param name="qtdPorPaginaR" value="${qtdPorPaginaR}" />
													<c:param name="verTodosR" value="${verTodosR}" />
												</c:url>
												<a href="${url_tamanhoOriginalD}"> ${10}</a>
												<c:forEach var="i" begin="1" end="${qtdDePPD}">
													<c:url var="url_tamanhosD" value="/mvc">
														<c:param name="logica"
															value="RequisitarMovimentacoesDeCandidato" />
														<c:param name="numero_cand"
															value="${campanha.numeroCandidato}" />
														<c:param name="ano" value="${campanha.ano}" />
														<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
														<c:param name="uf" value="${campanha.uf}" />
														<c:param name="inicioD" value="${0}" />
														<c:param name="qtdPorPaginaD" value="${i*25}" />
														<c:param name="verTodosD" value="${false}" />
														<c:param name="inicioR" value="${inicioR}" />
														<c:param name="qtdPorPaginaR" value="${qtdPorPaginaR}" />
														<c:param name="verTodosR" value="${verTodosR}" />
													</c:url>
													<a href="${url_tamanhosD}"> ${i*25}</a>
												</c:forEach>
												<c:url var="url_todosD" value="/mvc">
													<c:param name="logica"
														value="RequisitarMovimentacoesDeCandidato" />
													<c:param name="numero_cand"
														value="${campanha.numeroCandidato}" />
													<c:param name="ano" value="${campanha.ano}" />
													<c:param name="cargo_cod" value="${campanha.cargo.codigo}" />
													<c:param name="uf" value="${campanha.uf}" />
													<c:param name="inicioD" value="${0}" />
													<c:param name="qtdPorPaginaD" value="${0}" />
													<c:param name="verTodosD" value="${true}" />
													<c:param name="inicioR" value="${inicioR}" />
													<c:param name="qtdPorPaginaR" value="${qtdPorPaginaR}" />
													<c:param name="verTodosR" value="${verTodosR}" />
												</c:url>
												<a href="${url_todosD}"> Ver Todos</a>
											</center></td>
									</tr>
									<tr>
										<td colspan="4">INSERIR INFORMAÇÕES A RESPEITO DOS DADOS
											DE DESPESA.</td>
									</tr>
								</tfoot>
							</table>
						</c:otherwise>
					</c:choose>
				</center>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>
</body>
</html>