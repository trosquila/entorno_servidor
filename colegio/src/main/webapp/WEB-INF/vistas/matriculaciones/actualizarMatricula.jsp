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
            <form action="http://localhost:8080/colegio/matriculaciones/formularioActualizarMatriculas" method="post">
                <div id="formulario">
                    <label for="alumno">Alumno</label>
                    <input type="text" name="nombreAlumno">

                    <label for="asignatura">Asignatura:</label>
                    <input type="text" id="asignatura" name="nombreAsignatura"><br>

                    <label for="fecha">Fecha (dejar vacío para fecha actual):</label>
                    <input type="date" name="fecha">

                    <input type="submit" value="Enviar">
                </div>
            </form>
        </div>
    </div>

    <!-- Mostrar lista de notas recuperadas -->
    <c:forEach items="${listaMatriculas}" var="listaMatriculas">
        <div class="form">
            <form action="http://localhost:8080/colegio/matriculaciones/actualizarMatricula" method="post">
                <div id="formulario">
                    <input type="hidden" name="id" value="${listaMatriculas.id}" />

                   <label for="curso">Alumno: </label>
                    <select name="idAlumno" id="idAlumno">
                        <c:forEach items="${listaAlumnos}" var="listaAlumnos">
							<option value="${listaAlumnos.id}" <c:if test="${listaAlumnos.id == listaMatriculas.id}">selected</c:if>>  ${listaAlumnos.nombre} </option>
						</c:forEach>
                    </select><br>
                    
                    <label for="curso">Asignatura</label>
                    <select name="asignatura" id="asignatura">
				    	<c:forEach items="${listaAsignaturas}" var="asignatura">
						        <option value="${asignatura.id}"
						            <c:if test="${asignatura.id == listaMatriculas.asignaturasDTO.id}">selected</c:if>>
						            ${asignatura.nombre}
						        </option>
						    </c:forEach>
					</select><br>
				                    <label for="fecha">Fecha:</label>
                    <input type="date" name="fecha" value="${listaMatriculas.fecha}">
                    
                     <label for="nota">Importe:</label>
                    <input type="number" id="importe" name="importe" value="${listaMatriculas.cajaDTO.importe}"><br>
                    

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