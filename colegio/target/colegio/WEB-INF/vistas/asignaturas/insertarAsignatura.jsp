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
<h2>Inserción de nuevo alumno</h2>
</header>
<%@include file="/menu.html"%>

<div class="container">
<div class="form">
<form action="http://localhost:8080/colegio/alumnos/insertarAlumno" method="post">
    <div id="formulario">
        <label for="nombre">Nombre Asignatura</label>
        <input type="text" id="nombre" name="nombre"><br>
        <label for="curso">Curso</label>
        <select name="curso" id="curso">
        	<option value ="1">1</option>
        	<option value ="2">2</option>
        	<option value ="3">3</option>
        	<option value ="4">4</option>
        </select>

        <label for="tasa">Tasa:</label>
      	<input type="number" id="tasa" name="tasa"><br>

        <label for="activo">Activo:</label>
      	<select name="activo" id="activo">
        	<option value ="0">0</option>
        	<option value ="1">1</option>
        </select>
        <input type="submit" value="Enviar">
    </div>
    </form>
    
    <c:if test="${resultado == 1}">
		<b>Asignatura insertada correctamente</b>
	</c:if>
</div>
</div>
</body>