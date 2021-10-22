<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/templates/header.jsp"/>
        <main class="container">
            <c:forEach items="${socios}" var="socio">
                <div class="list-group-item d-flex align-items-center">
                    <img src="https://bit.ly/3lxoBvZ" alt="" height="50px" class="rounded-sm ml-n2" />
                    <div class="flex-fill pl-5 pr-3">
                        <h class="m-3"><strong>${socio.nombre}</strong></h>
                    </div>
                    <a href="consulta_socio" class="btn btn-outline-primary">Ver Perfil</a>
                </div>
            </c:forEach>
            <c:forEach items="${profes}" var="profe">
                <div class="list-group-item d-flex align-items-center">
                    <img src="https://bit.ly/2VLnzUj" alt="" height="50px" class="rounded-sm ml-n2" />
                    <h class="m-3"><strong>${profe.nombre}</strong></h>
                    <div class="flex-fill pl-5 pr-3">
                        <a href="consulta_institucion" class="text-muted fs-13px">${profe.institucion}</a>
                    </div>
                    <a href="consulta_profesor" class="btn btn-outline-primary">Ver Perfil</a>
                </div>
            </c:forEach>
        </main>
    </body>
</html>
