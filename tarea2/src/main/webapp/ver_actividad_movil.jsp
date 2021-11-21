<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Entrenamos.uy</title>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        

    </head>
    <body class="d-flex flex-column text-center justify-content-center py-12">
        <jsp:include page="/templates/top_mobil.jsp"/>
        
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
              Instituciones
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                <c:forEach items="${instituciones}" var="institucion">
                    <li><a class="dropdown-item" href="consulta_institucion?=${institucion}">${institucion}</a></li>
                </c:forEach>
            </ul>
        </div>


        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
              Categorías
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                <c:forEach items="${categorias}" var="categoria">
                    <li><a class="dropdown-item" href="consulta_categoria?=${categoria}">${categoria}</a></li>
                </c:forEach>
            </ul>
        </div>


    </body>
    <script src="styles/mio.js"></script>
</html>