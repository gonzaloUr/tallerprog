<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:if test="${successful_login eq true}">
            <meta http-equiv="refresh" content="0.1; URL=<c:url value="/inicio_movil"/>">
        </c:if>
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <jsp:include page="/templates/top_mobil.jsp"/>
        <c:choose>
            <c:when test="${successful_login eq true}">
                
            </c:when>
            <c:otherwise>
                <form class="d-flex flex-column form-login" method="post">
                    <h1 class="h3 mb-3 fw-normal">Inicio de sesión</h1>
                    <input class="form-control mb-3" placeholder="nickname" name="nick">
                    <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password">
                    <c:if test="${attempted_login}">
                        <c:if test="${reason == 'nickname'}">
                            <span class="text-danger mb-3">Nickname o contraseña invalido</span>
                        </c:if>
                        <c:if test="${reason == 'password'}">
                            <span class="text-danger mb-3">Nickname o contraseña invalido</span>
                        </c:if>
                    </c:if>
                    <input class="w-100 btn btn-primary" type="submit" value="Iniciar sesión">
                </form>
            </c:otherwise>
        </c:choose>
	</body>
    <script src="styles/mio.js"></script>
</html>