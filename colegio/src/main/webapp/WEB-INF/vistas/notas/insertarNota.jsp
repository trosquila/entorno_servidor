<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">
</head>
<body>
	<header>
		<h2>Crear nota</h2>
	</header>
	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/notas/insertarNotas" method="post">
			    <div id="formulario">
			        <label for="alumno">Alumno</label>
			        <select name="alumno">
			        	<c:forEach items="${listaAlumnos}" var="listaAlumnos">
							<option value="${listaAlumnos.id}">  ${listaAlumnos.nombre} ${listaAlumnos.apellido}</option>
						</c:forEach>
			        </select>
			        <label for="asignatura">Curso</label>
			        <select name="asignatura" id="asignatura">
			   			<c:forEach items="${listaAsignaturas}" var="listaAsignaturas">
							<option value="${listaAsignaturas.id}">  ${listaAsignaturas.nombre} </option>
						</c:forEach>
			        </select>
			
			        <label for="nota">Nota:</label>
			      	<input type="number" id="tasa" name="nota"><br>
			
			        <label for="fecha">Fecha (dejar vacío para fecha actual):</label>
			      	<input type="date"name="fecha">
			        <input type="submit" value="Enviar">
			    </div>
		    </form>
		    <c:if test="${resultado == 1}">
				<b>Nota insertada correctamente</b>
			</c:if>
		</div>
	</div>
</body>