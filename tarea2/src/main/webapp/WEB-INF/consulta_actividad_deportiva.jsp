<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.entrenamosuy.web.Facades" %>
<%@ page import="com.entrenamosuy.core.data.DataInstitucion" %>
<%@ page import="com.entrenamosuy.core.data.DataActividad" %>
<%@ page import="com.entrenamosuy.core.data.DataClase" %>
<%@ page import="com.entrenamosuy.core.data.DataCuponera" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        
        <link rel="stylesheet" href="styles/sidebar.css">
    </head>
	<body class="d-flex flex-column">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <%
            String actividadNombre = request.getParameter("actividad");
            DataActividad actividad = Facades
                .getFacades()
                .getFacadeActividad()
                .getDataActividad(actividadNombre);
            String nombre = actividad.getNombre();
            String descripcion = actividad.getDescripcion();
            Set<String> clasesOfrecidas = actividad.getClases()
                .stream()
                .map(DataClase::getNombre)
                .collect(Collectors.toSet());
            Set<String> cuponerasAsociadas = actividad.getCuponeras()
                .stream()
                .map(DataCuponera::getNombre)
                .collect(Collectors.toSet());
            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("clasesOfrecidas", clasesOfrecidas);
            request.setAttribute("cuponerasAsociadas", cuponerasAsociadas);
        %>
        <div class="d-flex flex-row">
            <jsp:include page="/WEB-INF/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <section class="d-flex flex-column">
                    <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
                    <p class="fs-6">${descripcion}</p>
                    <aside id="clase_cuponera">
                        <nav class="flex flex-column p-3 bg-light">
                            <div class="list-group pb-3">
                                <label class="list-group-item active">Clases Ofrecidas</label>
                                <c:forEach items="${clasesOfrecidas}" var="clase" >
                                <form action="consulta_dictado_clase">
                                    <input class="list-group-item list-group-item-action" type="submit" name="clase" value="${clase}">
                                </form>
                                </c:forEach>
                            </div>
                        </nav>
                        <nav class="flex flex-column p-3 bg-light">
                            <div class="list-group pb-3">
                                <label class="list-group-item active">Cuponeras Asociadas</label>
                                <c:forEach items="${cuponerasAsociadas}" var="cuponera" >
                                <form action="consulta_dictado_clase">
                                    <input class="list-group-item list-group-item-action" type="submit" name="cuponera" value="${cuponera}">
                                </form>
                                </c:forEach>
                            </div>
                        </nav>
                    </aside>

                </section>
            </main>
        </div>
	</body>
</html>