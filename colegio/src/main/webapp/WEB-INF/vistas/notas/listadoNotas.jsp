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
	<title>Listado notas</title>
	</head>
		<body>
		
			<h1>Listado notas</h1>
			<%@include file="/menu.html"%>
		
			<div class="container">
				<div class="form">
					<form action="http://localhost:8080/colegio/notas/listarNotas" method="post">
						<label for="id">Id nota</label> 
						<input type="text" id="id" name="id"> 
						<label for="idAlumno">Id Alumno</label> 
						<input type="text" id="idAlumno" name="idAlumno"><br>
						<label for="idAsignatura">Id Asignatura</label> 
						<input type="text" id="idAsignatura" name="idAsignatura"><br>
						<label for="nota">Nota</label> 
						<input type="text" id="nota" name="nota"><br> 
						<label for="fecha">Fecha</label> 
						<input type="date" id="fecha" name="fecha"><br> 
						<label for="nombre">Activo</label> 
						<input type="checkbox" id="activo" name="activo"><br>   
						<input type="submit" value="Enviar">
					</form>
				</div>
			</div>
		
			<c:if test="${empty listaNotas}">
		<h2>No hay resultados que mostrar con esos filtros</h2>
	</c:if>
	<c:if test="${not empty listaNotas}">
		<table>
			<tr>
				<th>ID</th>
				<th>ID ALUMNO</th>
				<th>ID ASIGNATURA</th>
				<th>NOTA</th>
				<th>FECHA</th>
				<!-- Opcional: si quieres mostrar nombres en lugar de IDs -->
				<th>NOMBRE ALUMNO</th>
				<th>NOMBRE ASIGNATURA</th>
			</tr>
			<c:forEach items="${listaNotas}" var="nota">
				<tr>
					<td>${nota.id}</td>
					<td>${nota.idAlumno}</td>
					<td>${nota.idAsignatura}</td>
					<td>${nota.nota}</td>
					<td>${nota.fecha}</td>
					<!-- Si tienes los objetos DTO cargados -->
					<td>${nota.alumnoDTO.nombre}</td>
					<td>${nota.asignaturaDTO.nombre}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		</body>
	</html>
	
