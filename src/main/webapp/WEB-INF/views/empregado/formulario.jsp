<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Empregado</title>
</head>
<body>
	<form action="salvarEmpregado" method="post">
		<input type="hidden" name="id" value="${empregado.id}" />
	
		Nome: <input type="text" name="nome" value="${empregado.nome}"> <br /> 
		
		Departamento: <select id="departamento" name="departamento">
			<c:forEach items="${departamentos}" var="departamento">
				<option value="${departamento.id}"
					<c:if test="${departamento.id eq empregado.departamento.id}">
							 selected="selected" 
						</c:if>>${departamento.nome}

				</option>

			</c:forEach>
		</select><br> <input type="submit" value="Salvar" />
	</form>
</body>
</html>