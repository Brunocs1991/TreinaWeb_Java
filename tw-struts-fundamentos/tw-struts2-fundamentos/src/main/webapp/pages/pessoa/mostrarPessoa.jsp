<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação</title>
</head>
<body>
	<p>Nome:</p>
	<p>
		<s:property value="pessoa.nome" />
	</p>
	<p>Idade:</p>
	<p>
		<s:property value="pessoa.idade" />
	</p>

</body>
</html>