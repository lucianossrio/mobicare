<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Empregados</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Departamento</th>
			<th>Ações</th>
		</tr>
		<c:forEach items="${empregados}" var="empregado">
			<tr>
				<td>${empregado.id}</td>
				<td>${empregado.nome}</td>
				<td>${empregado.departamento.nome}</td>
				<td>
					<a href="editarEmpregado?id=${empregado.id}">editar</a> | 
					<a href="excluirEmpregado?id=${empregado.id}">excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>