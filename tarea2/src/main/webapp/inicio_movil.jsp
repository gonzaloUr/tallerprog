<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <jsp:include page="/templates/top_mobil.jsp"/>
        <c:choose>
            <c:when test="${usuario == null}">
                <a class="btn btn-outline-light ms-3" href="index_movil">Debe iniciar sesión</a>
            </c:when>
            <c:otherwise>
                <span class="ms-3">${usuario.nombre} ${usuario.apellido}</span>
                <a href="consulta_socio?nickname=${usuario.nickname}">
                </a>
            </c:otherwise>
        </c:choose>
        
	</body>
    <script src="styles/mio.js"></script>
</html>