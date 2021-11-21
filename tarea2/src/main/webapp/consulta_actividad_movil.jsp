<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    </head>
    <body class="d-flex flex-column">
        <jsp:include page="/templates/top_mobil.jsp"/>
        
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Instituciones
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach items="${instituciones}" var="institucion" >
                    <a class="dropdown-item" href="consulta_institucion?=${institucion}">Action</a>
                </c:forEach>
            </div>
        </div>

        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Categorías
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <c:forEach items="${categorias}" var="categoria" >
                    <a class="dropdown-item" href="consulta_categoria?categoria={categoria}">Action</a>
                </c:forEach>
            </div>
        </div>


        <div class="d-flex flex-row">
            <div class="col-md-6 mb-3">
                        <img src="img/actividad/${nombre}" alt=" " class="w-50">
                        <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
            </div>
        </div>

        <nav class="flex flex-column p-3 bg-light">
            <div class="list-group pb-3">
                <c:forEach items="${actividadesOfrecidas}" var="actividad" >
                <form action="consulta_actividad">
                    <input class="list-group-item list-group-item-action" type="submit" name="nombre" value="${actividad}">
                </form>
                </c:forEach>
            </div>
        </nav>
    </body>
    <script src="styles/mio.js"></script>
</html>