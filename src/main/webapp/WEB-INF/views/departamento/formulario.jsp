<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Departamento</title>
</head>
<body>
	<form action="salvarDepartamento" method="post">
		<input type="hidden" name="id" value="${departamento.id}" />
	
		Nome: <input type="text" name="nome" value="${departamento.nome}"> <br /> 
		
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>