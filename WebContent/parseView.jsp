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
		
		</tr>
			<td> Ano: </td>
			<td> <input type="radio" name="arquivo_ano" value="2002" checked /> 2002 </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="arquivo_ano" value="2004" /> 2004 </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="arquivo_ano" value="2006" /> 2006 </td>
		</tr>
		<tr>
			<td> </td>
			<td> <input type="radio" name="arquivo_ano" value="2008" /> 2008 </td>
		</tr>
		
		<tr>
			<td> </td>
			<td>  <p align="right"> <input type="submit" value="carregar" /> </p> </td>
		</tr>
	</table>
</form>

</body>
</html>