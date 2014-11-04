<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Departamentos</title>
</head>
<body>
<h4><b>Atenção: </b> Os departamentos em <i>itálico</i> não possuem funcionários associados.</h4>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Ações</th>
		</tr>
		<c:forEach items="${departamentos}" var="departamento">
			<tr>
				<td>${departamento.id}</td>
				<td><c:if test="${empty departamento.empregados }"><i></c:if>${departamento.nome}</td>
				<td>
					<a href="editarDepartamento?id=${departamento.id}">editar</a><c:if test="${empty departamento.empregados }"> | 
					<a href="excluirDepartamento?id=${departamento.id}">excluir</a></c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>