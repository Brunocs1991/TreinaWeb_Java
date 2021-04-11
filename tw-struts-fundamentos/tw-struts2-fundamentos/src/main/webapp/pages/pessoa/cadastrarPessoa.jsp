<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<h3>Cadastro de pessoa</h3>
	<s:form action="inserirPessoa">
		<s:textfield label="Nome" name="pessoa.nome"></s:textfield>
		<s:textfield label="Idade" name="pessoa.idade"></s:textfield>
		<s:submit value="Salvar!"></s:submit>
	</s:form>
	<s:if test="mensagemErro != ''">
		<p style="color: red;">
			<s:property value="mensagemErro" />
		</p>
	</s:if>
</body>
</html>