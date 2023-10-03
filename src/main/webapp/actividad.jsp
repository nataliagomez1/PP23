<%--
  Created by IntelliJ IDEA.
  User: Gomez Garzon
  Date: 2/10/2023
  Time: 4:57 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actividades</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center">Lista de Actividades</h2>
    <hr>
    <c:forEach var="actividad" items="${actividades}">
        <div class="card mb-3">
            <div class="card-body">
                <h5 class="card-title">${actividad.nombre}</h5>
                <p class="card-text">
                    Tipo: ${actividad.tipoActividad} <br>
                    Ponderado: ${actividad.ponderado} <br>
                    Fecha: ${actividad.fecha} <br>
                    Nota: ${actividad.nota} <br>
                </p>
            </div>
        </div>
    </c:forEach>
    <h2 class="text-center mt-5">Agregar Nueva Actividad</h2>
    <form action="actividad-servlet" method="post" class="mt-3">
        <label for="idAsignatura">Asignatura:</label>
        <select name="idAsignatura" id="idAsignatura">
            <c:forEach var="asignatura" items="${todasLasasignaturas}">
                <option value="${asignatura.id}">${asignatura.nombre}</option>
            </c:forEach>
        </select>
        Nombre: <input type="text" name="nombre" required><br><br>
        Tipo:
        <select name="tipoActividad">
            <option value="TALLER">Taller</option>
            <option value="EVALUACION">Evaluación</option>
            <option value="PROYECTO">Proyecto</option>
        </select><br><br>
        Ponderado: <input type="text" name="ponderado" required><br><br>
        Fecha: <input type="date" name="fecha" required><br><br>
        Nota: <input type="text" name="nota" required><br><br>
        <!-- Suponiendo que conoces el ID de la asignatura cuando estás en esta página. Si no es el caso, deberías pasar el idAsignatura de otra manera -->
        <input type="hidden" name="idAsignatura" value="${idAsignatura}">
        <input type="submit" value="Agregar">
        <a href="index.jsp" class="btn btn-yellow">Ir a Principal</a>
    </form>
</div>
</body>
</html>







<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Actividades</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Lista de Actividades</h2>--%>

<%--<!-- Mostrar actividades -->--%>
<%--<c:forEach var="actividad" items="${actividades}">--%>
<%--    <div>--%>
<%--        <strong>Nombre:</strong> ${actividad.nombre} <br>--%>
<%--        <strong>Tipo:</strong> ${actividad.tipoActividad} <br>--%>
<%--        <strong>Ponderado:</strong> ${actividad.ponderado} <br>--%>
<%--        <strong>Fecha:</strong> ${actividad.fecha} <br>--%>
<%--        <strong>Nota:</strong> ${actividad.nota} <br>--%>
<%--        <!-- Agrega más detalles según lo necesites -->--%>
<%--    </div>--%>
<%--    <hr>--%>
<%--</c:forEach>--%>

<%--<h2>Agregar Nueva Actividad</h2>--%>

<%--<!-- Formulario para agregar nueva actividad -->--%>
<%--<form action="actividad-servlet" method="post">--%>
<%--    <label for="idAsignatura">Asignatura:</label>--%>
<%--    <select name="idAsignatura" id="idAsignatura">--%>
<%--        <c:forEach var="asignatura" items="${todasLasasignaturas}">--%>
<%--            <option value="${asignatura.id}">${asignatura.nombre}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    Nombre: <input type="text" name="nombre" required><br>--%>
<%--    Tipo:--%>
<%--    <select name="tipoActividad">--%>
<%--        <option value="TALLER">Taller</option>--%>
<%--        <option value="EVALUACION">Evaluación</option>--%>
<%--        <option value="PROYECTO">Proyecto</option>--%>
<%--    </select><br>--%>
<%--    Ponderado: <input type="text" name="ponderado" required><br>--%>
<%--    Fecha: <input type="date" name="fecha" required><br>--%>
<%--    Nota: <input type="text" name="nota" required><br>--%>
<%--    <!-- Suponiendo que conoces el ID de la asignatura cuando estás en esta página. Si no es el caso, deberías pasar el idAsignatura de otra manera -->--%>
<%--    <input type="hidden" name="idAsignatura" value="${idAsignatura}">--%>
<%--    <input type="submit" value="Agregar">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
