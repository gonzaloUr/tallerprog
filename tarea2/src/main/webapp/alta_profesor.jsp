<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    </head>
	<body class="container">
        <div class="col-12 p-5">
            <form class="d-flex flex-column" method="post" action="alta_profesor" enctype="multipart/form-data">
                <h1 class="h3 mb-3 fw-normal">Alta de profesor</h1>
                <input class="form-control mb-3" placeholder="nickname" name="nick">
                <input class="form-control mb-3" placeholder="nombre" name="nombre">
                <input class="form-control mb-3" placeholder="apellido" name="apellido">
                <input class="form-control mb-3" placeholder="email" name="email" type="email">
                <input class="form-control mb-3" name="nacimiento" type="date">
                <select class="form-control mb-3" name="institucion">
                    <c:if test="${not empty instituciones}">
                        <c:forEach var="i" begin="0" end="${instituciones.size() - 1}">
                            <c:choose>
                                <c:when test="${i eq 0}">
                                    <option selected value="${instituciones.get(i)}">${instituciones.get(i)}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${instituciones.get(i)}">${instituciones.get(i)}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:if>
                </select>
                <input class="form-control mb-3" placeholder="descripción" name="desc">
                <input class="form-control mb-3" placeholder="biografia" name="bio">
                <input class="form-control mb-3" placeholder="sitio web" name="sitio_web" type="url">
                <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password">
                <input class="form-control mb-3" placeholder="confirmar contraseña" name="pass_confirm" type="password">
                <input class="form-control mb-3" accept="image/*" name="img" type="file">
                <input class="btn btn-primary w-100" type="submit" value="Registrarse">
            </form>
        </div>
	</body>
</html>
