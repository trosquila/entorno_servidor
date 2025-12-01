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
<title>Modificar nota</title>
</head>
<body>
    <h1>Modificar nota</h1>
    <%@include file="/menu.html" %>

    <div class="container">
        <h2>Buscar nota a modificar</h2>
        <div class="form">
            <form action="http://localhost:8080/colegio/notas/formularioActualizarNotas" method="post">
                <div id="formulario">
                    <label for="alumno">Alumno</label>
                    <input type="text" name="alumno">

                    <label for="asignatura">Asignatura:</label>
                    <input type="text" id="asignatura" name="asignatura"><br>

                    <label for="fecha">Fecha (dejar vacío para fecha actual):</label>
                    <input type="date" name="fecha">

                    <input type="submit" value="Enviar">
                </div>
            </form>
        </div>
    </div>

    <!-- Mostrar lista de notas recuperadas -->
    <c:forEach items="${lista}" var="nota">
        <div class="form">
            <form action="http://localhost:8080/colegio/notas/actualizarNotas" method="post">
                <div id="formulario">
                    <input type="hidden" name="id" value="${nota.id}" />

                    <label for="asignaturaNombre">Nombre Asignatura</label>
                    <input type="text" id="asignaturaNombre" name="asignaturaNombre" 
                           value="${nota.alumnoDTO.nombre}"><br>

                    <label for="curso">Curso</label>
                    <select name="idAsignatura" id="curso">
                        <c:forEach items="${listaAsignaturas}" var="listaAsignaturas">
							<option value="${listaAsignaturas.id}">  ${listaAsignaturas.nombre} </option>
						</c:forEach>
                    </select><br>

                    <label for="nota">Nota:</label>
                    <input type="number" id="nota" name="nota" value="${nota.nota}"><br>

                    <label for="fecha">Fecha:</label>
                    <input type="date" name="fecha" value="${nota.fecha}">

                    <input type="submit" value="Editar">
                </div>
            </form>

            <c:if test="${resultado == 1}">
                <b>Asignatura modificada correctamente</b>
            </c:if>
        </div>
    </c:forEach>
</body>
</html>