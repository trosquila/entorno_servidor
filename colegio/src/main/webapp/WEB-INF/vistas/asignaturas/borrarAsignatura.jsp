<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/colegio/css/index.css">
	 <link rel="stylesheet" href="/colegio/css/formularios.css">
	 <link rel="stylesheet" href="/colegio/css/tablas.css">
</head>
<body>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Borrar Asignaturas</h2>
		<div class="form">
		<form action="http://localhost:8080/colegio/asignaturas/formularioBorrarAsignaturas" method="post">
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


	<c:if test="${empty lista}">
		<h2>No hay resultados que mostrar con esos filtros</h2>
	</c:if>
	<c:if test="${not empty lista}">
		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>CURSO</th>
				<th>TASA</th>
				<th>BORRAR</th>
			</tr>
			<c:forEach items="${lista}" var="asignatura">
				<tr>
					<td id="id">${alumno.id}</td>
					<td>${asignatura.nombre}</td>
					<td>${asignatura.curso}</td>
					<td>${asignatura.tasa}</td>
					<td>
						<form action="http://localhost:8080/colegio/asignaturas/borrarAsignatura" method="POST" >
							<input type="hidden" name="id" value="${asignatura.id}">
							<input type ="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>