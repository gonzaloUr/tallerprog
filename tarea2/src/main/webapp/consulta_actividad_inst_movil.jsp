<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Entrenamos.uy</title>
    <script src="bootstrap/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    

</head>
<body class="d-flex flex-column text-center justify-content-center py-12">
    <jsp:include page="/templates/top_mobil.jsp"/>
        
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
              Instituciones
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                <c:forEach items="${instituciones}" var="institucion">
                    <li><a class="dropdown-item" href="consulta_institucion?institucion=${institucion}">${institucion}</a></li>
                </c:forEach>
            </ul>
        </div>


        <nav class="flex flex-column p-3 bg-light">
            <div class="list-group pb-3">
                <c:forEach items="${actividades}" var="actividad" >
                <form action="consulta_actividad">
                    <img src="img/actividad/${actividad.nombre}" alt=" " class="w-50">
                    <input class="list-group-item list-group-item-action" type="submit" name="nombre" value="${actividad.nombre}">
                </form>
                </c:forEach>
            </div>
        </nav>


    </body>
    <script src="styles/mio.js"></script>
</html>