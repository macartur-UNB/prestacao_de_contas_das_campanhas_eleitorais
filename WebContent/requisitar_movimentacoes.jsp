<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidato - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecario.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Informações</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p></p>
				<h4>Para visualizar Receitas e Despesas deste candidato:</h4>
				<p>Selecione o ano desejado e click em Buscar:</p>

				<form action="requisitarMovimentacoes">
					<table>
						<tr>
    						<td>Nome: </td>
    						<td><input type="text" name="nome" /></td>
  					    </tr>
						<tr>
							<td>Ano:</td>
							<td><select name="ano">
									<option value="2002">2002</option>
									<option value="2004">2004</option>
									<option value="2006">2006</option>
									<option value="2008">2008</option>
									<option value="2010">2010</option>
									<option value="2012">2012</option>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><br>
							<input type="submit" value="Buscar" /></td>
						</tr>
					</table>
				</form>
				<br> <br>
			</div>
		</div>
		<!-- content  -->
	</div>
	<!-- FIM CONTEUDO-->
	
	<%@include file="imports/rodape.jsp"%>
	
</body>
</html>