<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="d-flex flex-row justify-content-between bg-dark text-white p-3">
    
    <h3>Entrenamos.uy</h3>
    <div class="d-flex flex-column">
    	<a class="btn btn-outline-light mx-3" href="lista_usuarios.html">Usuarios</a>
    </div>
    <div class="d-flex flex-column">
    	<a class="btn btn-outline-light mx-3" href="lista_instituciones.html">Instituciones</a>
    </div>
    <div class="d-flex flex-column">
    	<a class="btn btn-outline-light mx-3" href="lista_actividades.html">Actividades</a>
    </div>
    <form class="col-4 mx-3" action="search" method="post">
        <input class="form-control" type="search" placeholder="buscar" name="keyword">
    </form>
    <c:choose>
        <c:when test="${usuario == null}">
            <a class="btn btn-outline-light mx-3" href="iniciar_sesion">Iniciar sesión</a>
            <a class="btn btn-outline-light mx-3" href="alta_usuario">Registrarse</a>
        </c:when>
        <c:otherwise>
            <span>${usuario.nombre} ${usuario.apellido}</span>
        </c:otherwise>
    </c:choose>
</header>
