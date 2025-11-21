<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/colegio/css/index.css">
<link rel="stylesheet" href="/colegio/css/formularios.css">
<title>Modificar asignatura</title>
</head>
<body>
	<h1>Modificar asignatura</h1>
	<%@include file="/menu.html" %>
	<div class="container">
		<h2>Modificar asignatura</h2>
		<div class="form">
		<form action="http://localhost:8080/colegio/asignaturas/formularioActualizarAsignaturas" method="post">
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
	
	<c:forEach items="${lista}" var="asignatura">
    <div class="form">
        <form action="http://localhost:8080/colegio/asignaturas/actualizarAsignaturas" method="post">
            <div id="formulario">
                <input type="hidden" name="id" value="${asignatura.id}" />

                <label for="nombre">Nombre Asignatura</label>
                <input type="text" id="nombre" name="nombre" value="${asignatura.nombre}"><br>

                <label for="curso">Curso</label>
                <select name="curso" id="curso">
                    <option value="1" ${asignatura.curso == 1 ? 'selected' : ''}>1</option>
                    <option value="2" ${asignatura.curso == 2 ? 'selected' : ''}>2</option>
                    <option value="3" ${asignatura.curso == 3 ? 'selected' : ''}>3</option>
                    <option value="4" ${asignatura.curso == 4 ? 'selected' : ''}>4</option>
                </select><br>

                <label for="tasa">Tasa:</label>
                <input type="text" id="tasa" name="tasa" value="${asignatura.tasa}"><br>

                <label for="activo">Activo:</label>
                <select name="activo" id="activo">
                    <option value="0" ${asignatura.activo == 0 ? 'selected' : ''}>0</option>
                    <option value="1" ${asignatura.activo == 1 ? 'selected' : ''}>1</option>
                </select><br>

                <input type="submit" value="editar">
            </div>
        </form>

        <c:if test="${resultado == 1}">
            <b>Asignatura modificada correctamente</b>
        </c:if>
    </div>
</c:forEach>
</body>
</html>



