<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <%@ page isELIgnored="false" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <link rel="stylesheet" href="/colegio/css/index.css">
                <link rel="stylesheet" href="/colegio/css/formularios.css">
                <title>LISTAR Matriculación</title>
            </head>

            <body>
                <h1>LISTAR Matriculación</h1>
                <%@include file="/menu.html" %>
                    <div class="container">
                        <h2>LISTAR Matriculación</h2>
                        <div class="form">
                            <form action="http://localhost:8080/colegio/matriculaciones/listarMatriculaciones"
                                method="post">
                                <label for="asignatura">Nombre Asignatura</label>
                                <input type="text" name="nombreAsignatura"><br>
                                
                                <label for="alumno">Nombre Alumno</label>
                                <input type="text" name="nombreAlumno"><br>

                                <label for="fecha">Fecha (dejar vacío para fecha actual)</label>
                                <input type="date" id="fecha" name="fecha"><br>
                                
                                <label for="fecha">Activo</label>
                                <input type="checkbox" id="checkbox" name="activo"><br>

                                <input type="submit" value="listar">
                            </form>
                        </div>
                    </div>

                    <c:if test="${empty listaMatriculas}">
							<h2>No hay resultados que mostrar con esos filtros</h2>
						</c:if>
						<c:if test="${not empty listaMatriculas}">
							<table>
								<tr>
									<th>ASIGNATURA</th>
									<th>NOMBRE ALUMNO</th>
									<th>FECHA</th>
									<th>ACTIVADO</th>
									<th>IMPORTE</th>
								</tr>
								<c:forEach items="${listaMatriculas}" var="matricula">
    <tr>
        <td>${matricula.asignaturasDTO.nombre}</td>
        <td>${matricula.alumnoDTO.nombre}</td>
        <td>${matricula.fecha}</td>
        <td>${matricula.activo}</td>
        <td>${matricula.cajaDTO.importe}</td>
    </tr>
</c:forEach>
							</table>
						</c:if>
            </body>
            
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
             <script>
    $(document).ready(function () {
        $(document).on('change', '#alumno, #asignatura', function () {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/colegio/tasa",
                data: {
                    alumnos: $("#alumno").val(),
                    asignaturas: $("#asignatura").val()
                },
                success: function (data) {
                    $("#tasa").val(data);
                }
            });
        });
    });
</script>

            </html>