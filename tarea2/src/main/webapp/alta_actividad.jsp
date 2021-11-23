<%@page import="java.util.Set"%>
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
        <form class="d-flex flex-column form-signup" method="post" action="alta_actividad" enctype="multipart/form-data">
            <h1 class="h3 mb-3 fw-normal">Alta de actividad deportiva</h1>
            <input class="form-control mb-3" placeholder="Nombre" name="nombre_alta_act">
            <input class="form-control mb-3" placeholder="Descripcion" name="descripcion_alta_act">
            <input class="form-control mb-3" placeholder="Duracion (en minutos)" name="duracion_alta_act" type="number" min="0">
            <input class="form-control mb-3" placeholder="Costo (en $U)" name="costo_alta_act" type="number" min="0">
            <input class="form-control mb-3" accept="image/*" name="img" type="file">
            <label for="categorias">Elija categorias (para multiples Ctrl+click) :</label>
            <select name="select_categorias" multiple>
                <c:forEach items="${categorias}" var="categoria">
                    <option value="${categoria}"> ${categoria} </option>
                </c:forEach>
            </select>
            <input class="w-100 btn btn-primary mt-3" type="submit" value="Dar de alta">
        </form>
        <c:if test="${error ne null}">
            <span class="text-danger mb-3">${error}</span>
        </c:if>
    </body>
</html>
