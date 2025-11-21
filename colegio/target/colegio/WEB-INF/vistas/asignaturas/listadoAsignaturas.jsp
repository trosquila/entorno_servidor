<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/colegio/css/index.css">
<link rel="stylesheet" type="text/css"
	href="/colegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/colegio/css/tablas.css">
<meta charset="ISO-8859-1">
<title>Listado asignaturas</title>
</head>
	<body>
	
		<h1>Listado asignaturas</h1>
		<%@include file="/menu.html"%>
	
		<div class="container">
			<div class="form">
				<form action="http://localhost:8080/colegio/asignaturas/listarAsignaturas"
					method="post">
					<label for="id">Id Asignatura</label> 
					<input type="text" id="id" name="id"> 
					<label for="nombre">Nombre Asignatura</label> 
					<input type="text" id="nombre" name="nombre"><br>
					<label for="nombre">Curso</label> 
					<input type="text" id="curso" name="curso"><br>
					<label for="nombre">Tasa</label> 
					<input type="text" id="tasa" name="tasa"><br>    
					<input type="submit" value="Enviar">
				</form>
			</div>
		</div>
	
		<c:if test="${empty listaAsignaturas}">
			<h2>No hay resultados que mostrar con esos filtros</h2>
		</c:if>
		<c:if test="${not empty listaAsignaturas}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CURSO</th>
					<th>TASA</th>
					<th>ACTIVADO</th>
				</tr>
				<c:forEach items="${listaAsignaturas}" var="listaAsignaturas">
					<tr>
						<td>${listaAsignaturas.id}</td>
						<td>${listaAsignaturas.nombre}</td>
						<td>${listaAsignaturas.curso}</td>
						<td>${listaAsignaturas.tasa}</td>
						<td>${listaAsignaturas.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>

