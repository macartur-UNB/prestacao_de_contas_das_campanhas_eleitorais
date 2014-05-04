<%@page import="model.Candidato"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="carregarParse" enctype="multipart/form-data">  
    <input type="file" name="arquivo">  
    <input type="hidden" name="teste" value="blablabla">  
    <input type="submit">  
</form>  

</body>
</html>