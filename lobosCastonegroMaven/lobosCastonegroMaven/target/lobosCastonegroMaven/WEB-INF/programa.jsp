<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ControladorJuegoMaven" method="POST">
		<p>Selecciona jugador para asignar un rol</p>
		<select name='nombre'>
		<c:forEach items="${listaJugadores}" var="jugadores" >
			<option value="${jugadores.nombre}">${jugadores.nombre}</option>
		</c:forEach>
		</select>
		<input type="submit" value="asignar">
	</form>
	<h3>Jugador ${nombre}</h3>
		<p>Rol asignado ${rolAleatorio}</p>
	<c:if test="${nombre  != ''} && ${rolAleatorio != ''} "> 
		<h3>Jugador ${nombre}</h3>
		<p>Rol asignado ${rolAleatorio}</p>
		
		<c:if test="${rolAleatorio == 'lobo'}"> 
			<p>¡Cuidado es lobo!</p>
		</c:if>
	</c:if>
</body>
</html>