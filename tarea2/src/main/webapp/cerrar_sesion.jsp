<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/cerrar_sesion.css">
        <meta http-equiv="refresh" content="3; URL=<c:url value="/index_visitante.html"/>">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <c:choose>
            <c:when test="${usuario eq null}">
                <span>usuario no logeado!</span>
            </c:when>
            <c:otherwise>
                <c:set var="usuario" value="null" scope="session"/>
                <span>Cerrando sesion para ${usuario.nombre} ${usuario.apellido}</span>
                <a class="btn btn-primary" href="<c:url value="/index_profe.html"/index_visitante.html>">Pagina principal</a>
            </c:otherwise>
        </c:choose>
	</body>
</html>
