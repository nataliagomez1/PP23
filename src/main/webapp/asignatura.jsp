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
    <title>Asignatura</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center">Asignaturas</h2>
    <hr>
    <c:forEach var="asignatura" items="${asignaturas}">
        <div class="card mb-3">
            <div class="card-header">ID: ${asignatura.id} - ${asignatura.nombre}</div>
            <ul class="list-group list-group-flush">
                <c:forEach var="actividad" items="${asignatura.listaActividades}">
                    <li class="list-group-item">${actividad.nombre} (Tipo: ${actividad.tipoActividad}, Ponderado: ${actividad.ponderado}, Fecha: ${actividad.fecha})</li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
    <form action="asignatura-servlet" method="post" class="mt-5">
        <div class="form-group">
            <label>Nombre de la asignatura</label>
            <input type="text" name="nombre" class="form-control" placeholder="Nombre de la asignatura" required>
        </div>
        <button type="submit" class="btn btn-primary">Agregar Asignatura</button>
    </form>
    <a href="index.jsp" class="btn btn-red">Ir a Principal</a>

</div>
</body>
</html>










<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Asignatura</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:forEach var="asignatura" items="${asignaturas}">--%>
<%--    <div>--%>
<%--        <strong>ID:</strong> ${asignatura.id} <br>--%>
<%--        <strong>Nombre:</strong> ${asignatura.nombre} <br>--%>
<%--        <strong>Actividades:</strong>--%>
<%--        <ul>--%>
<%--            <c:forEach var="actividad" items="${asignatura.listaActividades}">--%>
<%--                <li>${actividad.nombre} (Tipo: ${actividad.tipoActividad}, Ponderado: ${actividad.ponderado}, Fecha: ${actividad.fecha})</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <hr>--%>
<%--</c:forEach>--%>

<%--<form action="asignatura-servlet" method="post">--%>
<%--    <input type="text" name="nombre" placeholder="Nombre de la asignatura" required>--%>
<%--    <input type="submit" value="Agregar Asignatura">--%>
<%--</form>--%>



<%--</body>--%>
<%--</html>--%>
