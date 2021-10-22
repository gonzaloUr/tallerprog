<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-4">
                <div class="d-flex p-2 align-items-center h-100">
                    <h3>Entrenamos.uy</h3>
                </div>
            </div>
            <div class="col-8">
                <div class="d-flex p-2 justify-content-end align-items-center">
                    <form class="m-0" action="search" method="post">
                        <input class="form-control" type="search" placeholder="buscar" name="keyword">
                    </form>
                    <c:choose>
                        <c:when test="${usuario == null}">
                            <a class="btn btn-outline-light ms-3" href="iniciar_sesion">Iniciar sesión</a>
                            <a class="btn btn-outline-light ms-3" href="alta_usuario">Registrarse</a>
                        </c:when>
                        <c:otherwise>
                            <span class="ms-3">${usuario.nombre} ${usuario.apellido}</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</header>
