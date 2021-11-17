<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/sidebar.css">
        <link rel="stylesheet" href="styles/common.css">
    </head>
    <body class="d-flex flex-column">
        <jsp:include page="/templates/header.jsp"/>
        <div class="d-flex flex-row">
            <jsp:include page="/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <section class="d-flex flex-column">
                    <h1 class="fs-1 fw-bold p-3">${categorianombre}</h1>
                </section>

                <aside id="clase_cuponera">
                    <nav class="flex flex-column p-3 bg-light">
                        <div class="list-group pb-3">
                            <label class="list-group-item active">Actividades Ofrecidas</label>
                            <c:forEach items="${catactividades}" var="actividad" >
                                <form action="consulta_actividad">
                                    <input class="list-group-item list-group-item-action" type="submit" name="nombre" value="${actividad}">
                                </form>
                            </c:forEach>
                        </div>
                    </nav>
                </aside>
            </main>
        </div>
    </body>
</html>
