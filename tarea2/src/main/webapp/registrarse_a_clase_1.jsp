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
        <form class="d-flex flex-column form-signup" action="registrarse_a_clase_2">
            <h2 class="h2 mb-3 fw-normal">Registrarse a clase</h2>
            <p class="mb-3 fw-normal">Seleccione una institución o una categoría</p>

            <nav class="flex flex-column p-3 bg-light">
                <div class="list-group pb-3">
                    <label class="list-group-item active">Instituciones Deportivas</label>
                    <c:forEach items="${instituciones}" var="inst" >
                    <input class="list-group-item list-group-item-action" type="submit" name="institucion" value="${inst}">
                    </c:forEach>
                </div>
            </nav>

            <nav class="flex flex-column p-3 bg-light">
                <div class="list-group pb-3">
                    <label class="list-group-item active">Categorías </label>
                    <c:forEach items="${categorias}" var="cat" >
                    <input class="list-group-item list-group-item-action" type="submit" name="categoria" value="${cat}">
                    </c:forEach>
                </div>
            </nav>

        </form>

    </body>
</html>
