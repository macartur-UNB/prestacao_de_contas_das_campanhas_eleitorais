<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informações - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>
<!-- CABECALHO e MENU -->
	<div id="topo">
		<div id="cabecalho">
			<div id="logo">
				<a href="index.jsp"> <img src="img/logo.png" width="257"
					height="58" alt="Logo" title="CampanhasOn">
				</a> <span class="titulo">Informe-se JÁ!</span>
			</div>

			<!-- MENU -->
			<div id="menu">
				<ul>
					<li><a href="index.jsp" class="home" title>Home</a></li>
					<li><a href="candidatos.jsp" class="candidatos" title>Candidatos</a>
					</li>
					<li><a href="partidos.jsp" class="partidos" title>Partidos</a>
					</li>
					<li><a href="pesquisar.jsp" class="pesquisar" title>Pesquisar</a>
					</li>
				</ul>
			</div>
			<!-- FIM MENU -->

		</div>
	</div>
	<!-- FIM CABECALHO e MENU -->
	
	<!-- CONTEUDO DA PAGINA DE INFORMAÇÕES -->
	<div id="pagina">
		<div class="titulo_topo">
		<h3>Erro!</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h4>Um erro ocorreu! Não será possível exibir a Página!</h4>
				<br>
				<form name="voltar" action="index.jsp">
					<input type="submit" value="Voltar">
				</form>
	
	<!-- RODAPE -->
	<div id="rodape">
		<div id="centro_rodape">
			<a href="index.jsp"> <img src="img/logo.png" width="257"
				height="58" alt="Logo" title="CampanhasOn"></a>
			<div id="redes_sociais">
				<a href="index.jsp"><img src="img/facebook.png" width="32"
					height="32" alt="Facebook" title="Facebook"></a> <a
					href="index.jsp"><img src="img/twitter.png" width="32"
					height="32" alt="Twitter" title="Twitter"></a> <a
					href="https://github.com/macartur/prestacao_de_contas_das_campanhas_eleitorais"><img
					src="img/github.png" width="32" height="32" alt="GitHub"
					title="GitHub"></a>
			</div>
			<div id="dado_rodape">
				Universidade de Brasília <br> Faculdade do Gama - FGA <br>
				Projeto: Campanhas-On / MDS
			</div>
		</div>
	</div>
	<!-- FIM RODAPE -->
	

</body>
</html>