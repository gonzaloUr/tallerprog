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
    </head>
    <body class="d-flex flex-column">
        <jsp:include page="/templates/header.jsp"/>
        <div class="d-flex flex-row">
            <jsp:include page="/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <c:choose>
                <c:when test="${usuario == null}"> </c:when>
                <c:when test="${es_profesor eq true}">
                <section class="d-flex flex-column mt-3">
                    <div class="d-flex flex-column mt-3" style='float:left; margin-left:200px; margin-right:100px; width:100%'>
                        <div class="list-group" style="list-style-type:none">
                            <hr>
                            <a href="alta_actividad" class="btn btn-outline-primary">Dar de alta una actividad deportiva</a>
                            <hr>
                            <a href="alta_dictado_clase" class="btn btn-outline-primary">Dar de alta una clase</a>
                            <hr>
                        </div>
                    </div>
                </section>
                </c:when>
                <c:when test="${es_profesor eq false}">

                <section class="d-flex flex-column">
                    <div class="d-flex flex-column mt-3" style='float:left; margin-left:200px; margin-right:100px; width:100%'>
                        <div class="list-group" style="list-style-type:none">
                            <hr>
                            <a href="registrarse_a_clase_1" class="btn btn-outline-primary">Registrearse a una clase</a>
                            <hr>
                        </div>
                    </div>
                </section>
                </c:when>
                </c:choose>
            </main>
        </div>
    </body>
</html>
