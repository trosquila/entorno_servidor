<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/ejemploGuiadoColegio/css/index.css">
<link rel="stylesheet" type="text/css" href="/ejemploGuiadoColegio/css/formularios.css">
<link rel="stylesheet" type="text/css" href="/ejemploGuiadoColegio/css/tablas.css">
<meta charset="ISO-8859-1">
<title>Listado Alumnos</title>
</head>
<body>
	<h1>Listado alumnos</h1>
	<%@include file="/menu.html"%>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/ejemploGuiadoColegio/alumnos/listadoAlumnoss"
				method="post">
				<label for="id">Id Alumno</label> <input type="text" id="id"
					name="id"> <label for="nombre">Nombre Alumno</label> <input
					type="text" id="nombre" name="nombre"><br> <label
					for="apellido">Apellido Alumno</label> <input type="text"
					id="apellido" name="apellido"><br> <input
					type="submit" value="Enviar">
			</form>
		</div>
	</div>
</body>
</html>