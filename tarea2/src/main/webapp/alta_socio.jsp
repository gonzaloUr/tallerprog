<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <form class="d-flex flex-column form-signup" method="post" action="alta_socio" enctype="multipart/form-data">
            <h1 class="h3 mb-3 fw-normal">Alta de socio</h1>
            <input class="form-control mb-3" placeholder="nickname" name="nick">
            <input class="form-control mb-3" placeholder="nombre" name="nombre">
            <input class="form-control mb-3" placeholder="apellido" name="apellido">
            <input class="form-control mb-3" placeholder="email" name="email" type="email">
            <input class="form-control mb-3" name="nacimiento" type="date">
            <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password">
            <input class="form-control mb-3" placeholder="confirmar contraseña" name="pass_confirm" type="password">
            <input class="form-control mb-3" accept="image/*" name="img" type="file">
            <input class="btn btn-primary w-100" type="submit" value="Registrarse">
            <c:if test="${failed eq true}">
                <span class="text-danger mb-3">${reason}</span>
            </c:if>
        </form>
	</body>
</html>
