<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/sidebar.css">
        <link rel="stylesheet" href="styles/common.css">
    </head>
    <body class="d-flex flex-column">
        <jsp:include page="/templates/header.jsp"/>
        <div class="d-flex flex-row">
            <jsp:include page="/templates/aside.jsp"/>
            <div class="col-md-6 mb-3">
                        <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
                        <img src="img/actividad/${nombre}" alt=" " class="w-50">
                        <p class="fs-6 mt-3">${descripcion}</p>
                        <p class="fs-6 mt-3">Duracion: ${duracion} minutos</p>
                        <% int f = (int) request.getAttribute("tipoFav");
                            if(f == 0){ %>
                                <a href="/tarea2/marcar_fav?nombre=${nombre}" class="btn btn-primary"> Favorita
                                </a>
                            <% } 
                            else if(f == 1){ %>
                                <a href="/tarea2/desmarcar_fav?nombre=${nombre}" class="btn btn-primary"> Desmarcar como Favorita
                                    <span class="glyphicon glyphicon-star"></span> 
                                </a>
                            <% } %>
                        <p class="fs-4 fw-bold p-3">Categorias: </p>
                        <ul>
                            <nav class="flex flex-column p-3 ">
                                <div class="list-group pb-3">
                                    <c:forEach items="${categoriasAsociadas}" var="cat" >
                                        <form action="consulta_categoria">
                                            <input class="list-group-item list-group-item-action" type="submit" name="categoria" value="${cat}">
                                        </form>
                                    </c:forEach>
                                </div>
                            </nav>
                        </ul>
            </div>

                    <aside id="clase_cuponera">
                        <nav class="flex flex-column p-3 bg-light">
                            <div class="list-group pb-3">
                                <label class="list-group-item active">Clases Ofrecidas</label>
                                <c:forEach items="${clasesOfrecidas}" var="clase" >
                                    <form action="consulta_dictado_clase">
                                        <input class="list-group-item list-group-item-action" type="submit" name="clase" value="${clase}">
                                    </form>
                                </c:forEach>
                            </div>
                        </nav>
                        <nav class="flex flex-column p-3 bg-light">
                            <div class="list-group pb-3">
                                <label class="list-group-item active">Cuponeras Asociadas</label>
                                <c:forEach items="${cuponerasAsociadas}" var="cuponera" >
                                    <span class="list-group-item list-group-item-action">${cuponera}</span>
                                </c:forEach>
                            </div>
                        </nav>
                    </aside>
                </section>
            </main>
        </div>
    </body>
</html>
