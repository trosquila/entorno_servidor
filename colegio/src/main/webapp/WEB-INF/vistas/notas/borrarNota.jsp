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
		<form action="http://localhost:8080/colegio/notas/formularioBorrarNotas" method="post">
					 <label for="alumno">Alumno</label>
                    <input type="text" name="alumno">

                    <label for="asignatura">Asignatura:</label>
                    <input type="text" id="asignatura" name="asignatura"><br>

                    <label for="fecha">Fecha (dejar vacío para fecha actual):</label>
                    <input type="date" name="fecha">

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
				<th>ALUMNO</th>
				<th>ASIGNATURA</th>
				<th>FECHA</th>
				<th>BORRAR</th>
			</tr>
			<c:forEach items="${lista}" var="nota">
				<tr>
					<td id="id">${nota.id}</td>
					<td>${nota.alumnoDTO.nombre}</td>
					<td>${nota.asignaturaDTO.nombre}</td>
					<td>${nota.fecha}</td>
					<td>
						<form action="http://localhost:8080/colegio/notas/borrarNotas" method="POST" >
							<input type="hidden" name="id" value="${nota.id}">
							<input type ="submit" value="Borrar">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>