<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado asignaturas</title>
</head>
<body>
	<c:forEach items="${listaAsignaturas}" var="listaAsignaturas">
		<li> ID: ${listaAsignaturas.id}. Nombre: ${listaAsignaturas.nombre} </li>
	</c:forEach>
</body>
</html>