<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parse - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalho.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Parse</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
			
				<h1>Parse Partido</h1>
				<p>Atualiza tabela: Partido.</p>
				
				<form action="carregarParsePartido" method="POST"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Arquivo do Parse:</td>
							<td><input type="file" name="arquivo" size="50" /></td>
						</tr>

						<tr>
							<td>Linha Inicial:</td>
							<td><input type="number" name="arquivo_linha_inicial"
								value="1" /></td>
						</tr>

						<tr>
							<td></td>
							<td>
								<p align="right">
									<input type="submit" class="botao" value="Carregar" />
								</p>
							</td>
						</tr>
					</table>
				</form>
				

				<h1>Parse Campanha</h1>
				<p>Atualiza tabelas: Cargo, Resultado, Candidato e Campanha.</p>
				

				<form action="carregarParseCampanha" method="POST"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Arquivo do Parse:</td>
							<td><input type="file" name="arquivo" size="50" /></td>
						</tr>

						<tr>
							<td>Linha Inicial:</td>
							<td><input type="number" name="arquivo_linha_inicial"
								value="1" /></td>
						</tr>

						<tr>
							<td></td>
							<td>
								<p align="right">
									<input type="submit" class="botao" value="Carregar" />
								</p>
							</td>
						</tr>
					</table>
				</form>
				
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>

</body>
</html>