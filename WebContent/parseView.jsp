<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parse</title>
</head>
<body>

<form action="carregarParse" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			<td> Arquivo do Parse: </td>
			<td> <input type="file" name="arquivo" size="50" /> </td>
		</tr>
			<td> Tipo do Arquivo: </td>
			<td> <input type="radio" name="arquivo_tipo" value="despesa" checked /> Despesa </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="arquivo_tipo" value="receita" /> Receita </td>
		</tr>
		<tr>
			<td> Linha Inicial: </td>
			<td> <input type="number" name="arquivo_linha_inicial" value="1" /> </td>
		</tr>
		<tr>
			<td> Linha Final: </td>
			<td> <input type="number" name="arquivo_linha_final" value="0" /> Preencha '0' para ler até o fim </td>
		</tr>
	</table>
	
	<br />
	
	
	Indique o numero da coluna no arquivo de acordo com o dado:
	<table>
		<tr>
			<td> Nome do Candidato: </td>
			<td> <input type="number" name="indice_candidato_nome" /> </td>
		</tr>
		<tr>
			<td> Partido do Candidato: </td>
			<td> <input type="number" name="indice_candidato_partido" /> </td>
		</tr>
		<tr>
			<td> Cargo do Candidato: </td>
			<td> <input type="number" name="indice_candidato_cargo" /> </td>
		</tr>
		<tr>
			<td> Numero do Candidato: </td>
			<td> <input type="number" name="indice_candidato_numero" /> </td>
		</tr>
		<tr>
			<td> Ano (Não é o índice, o ano mesmo): </td>
			<td> <input type="number" name="indice_dado_ano" /> </td>
		</tr>
		<tr>
			<td> </td>
			<td>  <p align="right"> <input type="submit" value="carregar" /> </p> </td>
		</tr>
	</table>
</form>

</body>
</html>