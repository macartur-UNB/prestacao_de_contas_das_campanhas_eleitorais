<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Five - Campanhas-ON</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
<!-- Google Chart -->
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
    	  
        var data = google.visualization.arrayToDataTable([                                                
          ['Nome do Candidato',	'Despesa Total Declarado'],
          ["${candidato1.candidato.nome}",	"${candidato1.despesaMaxDeclarada}"],
          ["${candidato2.candidato.nome}",	"${candidato2.despesaMaxDeclarada}"],
          ["${candidato3.candidato.nome}",	"${candidato3.despesaMaxDeclarada}"],
          ["${candidato4.candidato.nome}",	"${candidato4.despesaMaxDeclarada}"],
          ["${candidato5.candidato.nome}",	"${candidato5.despesaMaxDeclarada}"],
        ]);

        var options = {
          title: '5 Maiores Despesas Máximas Declaradas para no ano de',
          hAxis: {title: 'Candidatos'}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
<!-- END Google Chart -->	
	
</head>

<body>

	<%@include file="imports/cabecalho.jsp"%>

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Top Five</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
			
			<div id="chart_div" width=900px height=500px></div>

				<c:url var="link_submit" value="/mvc">
					<c:param name="logica"
						value="VisualizarTopFive"></c:param>
				</c:url>
				

				<form action="${link_submit}" method="post">
					Ano:
					<select name="ano">
						<option value="2010" selected>2010
						<option value="2006">2006
						<option value="2002">2002
					</select>
					
					Cargo:
					<select name="cargo">
						<option value="presidente" selected>Presidente
						<option value="governador">Governador
						<option value="senador">Senador
					</select>

					<br><input
						type="submit" class="botao" value="Gerar Gráfico" />
				</form>

			</div>
		</div>
	</div>

	<%@include file="imports/rodape.jsp"%>
</body>
</html>