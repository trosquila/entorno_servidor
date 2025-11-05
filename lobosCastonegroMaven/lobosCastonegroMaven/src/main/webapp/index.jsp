<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<body>
<h2><%= "Hello World!" %></h2>
<select name='provincias'>
<c:forEach items="${listaJugadores}" var="juguadores">
<option value="${juguadores.id}">${juguadores.nombre}</option>
</c:forEach>
</select>
</body>
</html>
