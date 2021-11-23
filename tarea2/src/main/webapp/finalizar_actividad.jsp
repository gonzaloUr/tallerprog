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
        <div class="d-flex flex-row" style="text-align: center;">
            <jsp:include page="/templates/aside.jsp"/>
            <div class="col-md-6 mb-3">
                <p>  </p>
                <h1 class="h3 mb-3 fw-normal">Finalizar actividad deportiva</h1>
                <c:forEach items="${actividadesAceptadas}" var="actividad">
                    <h4> ${actividad.nombre}</h4>
                    <p> ${actividad.descripcion}</p>
                    <p> Costo: ${actividad.costo}</p>
                    <p>Duración: ${actividad.duracion}</p>
                    <a href="terminar_actividad?finalizar=${actividad.nombre}" class="btn btn-primary">Finalizar</a>

                    <p>  </p>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-6 mb-3">
            <c:if test="${failed eq true}">
                <c:if test="${reason == 'no_finalizable'}">
                    <span class="text-danger mb-3">Error: Esa actividad aun tiene clases vigentes.</span>
                    <a href="finalizar_actividad" class="btn btn-primary">Volver atras</a>
                </c:if>
            </c:if>
        </div>
    </body>
</html>