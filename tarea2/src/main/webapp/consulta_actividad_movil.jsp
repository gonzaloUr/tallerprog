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
<body class="flex-column text-center justify-content-center py-12">
    <jsp:include page="/templates/top_mobil.jsp"/>

                <p class="fs-4 fw-bold p-3">${nombre} </p>

                <div class="list-group pb-3" style="display: block;">
                    <img src="img/actividad/${nombre}" alt=" " class="w-50">
                    <p class="fs-6 mt-3">${descripcion}</p>
                    <p class="fs-6 mt-3">Duracion: ${duracion} minutos</p>
                </div>

                <p class="fs-4 fw-bold p-3">Categorias: </p>
                <ul>
                    <nav class="flex flex-column p-3 ">
                        <div class="list-group pb-3">
                            <c:forEach items="${categoriasAsociadas}" var="cat" >
                                <form action="consulta_actividad_cat_movil">
                                    <input class="list-group-item list-group-item-action" type="submit" name="categoria" value="${cat}">
                                </form>
                            </c:forEach>
                        </div>
                    </nav>
                </ul>

                <p class="fs-4 fw-bold p-3">Clases Ofrecidas: </p>
                <ul>
                    <nav class="flex flex-column p-3 ">
                        <div class="list-group pb-3">
                            <c:forEach items="${clasesOfrecidas}" var="clase" >
                                <form action="consulta_dictado_clase_movil">
                                    <input class="list-group-item list-group-item-action" type="submit" name="clase" value="${clase}">
                                </form>
                            </c:forEach>
                        </div>
                    </nav>
                </ul>

                <p class="fs-4 fw-bold p-3">Cuponeras Asociadas: </p>
                <ul>
                    <nav class="flex flex-column p-3 ">
                        <div class="list-group pb-3">
                            <c:forEach items="${cuponerasAsociadas}" var="cuponera" >
                            <span class="list-group-item list-group-item-action">${cuponera}</span>
                        </c:forEach>
                        </div>
                    </nav>
                </ul>


    </body>
    <script src="styles/mio.js"></script>
</html>