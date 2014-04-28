<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parse</title>
</head>
<body>

<form action="carregarParse" method="POST">
	<table>
		<tr>
			<td> Arquivo do Parse: </td>
			<td> <input type="file" name="arquivo" size="50" /> </td>
		</tr>
			<td> Tipo do Arquivo: </td>
			<td> <input type="radio" name="tipo_arquivo" value="despesa" checked /> Despesa </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="tipo_arquivo" value="receita" /> Receita </td>
		</tr>
		<tr>
			<td> </td>
			<td>  <p align="right"> <input type="submit" value="carregar" /> </p> </td>
		</tr>
	</table>
	
	<br />
	
	Indique o numero da coluna no arquivo de acordo com o dado:
	<table>
		<tr>
			<td> Nome do Candidato: </td>
			<td> <input type="number" name="candidato_nome" /> </td>
		</tr>
		<tr>
			<td> Cargo do Candidato: </td>
			<td> <input type="number" name="candidato_cargo" /> </td>
		</tr>
		<tr>
			<td> Partido do Candidato: </td>
			<td> <input type="number" name="candidato_partido" /> </td>
		</tr>
		<tr>
			<td> Numero do Candidato: </td>
			<td> <input type="number" name="candidato_numero" /> </td>
		</tr>
		<tr>
			<td> Ano: </td>
			<td> <input type="number" name="dado_ano" /> </td>
		</tr>
	</table>
</form>

</body>
</html>