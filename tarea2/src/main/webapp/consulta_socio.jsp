<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.entrenamosuy.web.MiniUsuario"%>
<%@page import="com.entrenamosuy.web.publicar.BeanClase"%>
<%@page import="com.entrenamosuy.web.publicar.BeanCuponera"%>
<%@page import="com.entrenamosuy.web.publicar.BeanLocalDate"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
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
    <body>

        <%
        String nick = (String) request.getAttribute("nickname");
        String nombre = (String) request.getAttribute("nombre");
        String mail = (String) request.getAttribute("mail");
        BeanLocalDate nacimiento = (BeanLocalDate) request.getAttribute("nacimiento");
        List<MiniUsuario> seguidos = (List<MiniUsuario>) request.getAttribute("seguidos");
        List<MiniUsuario> seguidores = (List<MiniUsuario>) request.getAttribute("seguidores");
        Set<BeanClase> clases = (Set<BeanClase>) request.getAttribute("clases");
        Set<BeanCuponera> cuponeras = (Set<BeanCuponera>) request.getAttribute("cuponeras");
        int esSeguidor = (int) request.getAttribute("esSeguidor");
        %>
        <jsp:include page="templates/header.jsp"/>
        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="img/usuario/<%=nick%>" alt=" " class="avatar-img-big">
                            <div class="mt-3">
                                <h4><%= nick%></h4>
                                <p class="text-secondary mb-1">Socio</p>
                                <c:choose>
                                <c:when test="${esSeguidor eq 0}">
                                <a href="iniciar_sesion" class="btn btn-primary">Seguir</a>
                                </c:when>
                                <c:when test="${esSeguidor eq 1}">
                                <a href="dejar_seguir_usuario?nickname=<%=nick%>" class="btn btn-primary">Dejar de seguir</a>
                                </c:when>
                                <c:when test="${esSeguidor eq 2}">
                                <a href="seguir_usuario?nickname=<%=nick%>" class="btn btn-primary">Seguir</a>
                                </c:when>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Nombre completo</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                <%= nombre%>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                <%= mail%>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Fecha de nacimiento</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                <%= nacimiento.getDayOfMonth()%>/<%= nacimiento.getMonth()%>/<%= nacimiento.getYear()%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="space" style="height:60px"></div>
                <div class="list-group">
                    <div class="list-group-item d-flex align-items-center active">Siguiendo
                    </div>
                    <%
                    String h;
                    for (MiniUsuario s: seguidos){
                    %>
                    <div class="list-group-item d-flex align-items-center">
                        <div class="flex-fill pl-3 pr-3">
                            <div><strong><%= s.getNombre()%></strong></div>
                            <% if (s.getEsSocio()){
                            h = "socio"; %>
                            <div class="text-muted fs-13px">Socio</div>
                            <%} else {
                            h = "profesor";%>
                            <div class="text-muted fs-13px">Profesor</div>
                            <% } %>
                        </div>
                        <a href="consulta_<%=h%>?nickname=<%= s.getNombre()%>" class="btn btn-outline-primary">Ver Perfil</a>
                    </div>
                    <% } %>
                </div>
                <div class="space" style="height:30px"></div>
                <div class="list-group">
                    <div class="list-group-item d-flex align-items-center active">Seguidores
                    </div>
                    <%
                    for (MiniUsuario a: seguidores){
                    %>
                    <div class="list-group-item d-flex align-items-center">
                        <div class="flex-fill pl-3 pr-3">
                            <div><strong><%= a.getNombre()%></strong></div>
                            <% if (a.getEsSocio()){
                            h = "socio";%>
                            <div class="text-muted fs-13px">Socio</div>
                            <%} else {
                            h = "profesor";%>
                            <div class="text-muted fs-13px">Profesor</div>
                            <% } %>
                        </div>
                        <a href="consulta_<%=h%>?nickname=<%= a.getNombre()%>" class="btn btn-outline-primary">Ver Perfil</a>
                    </div>
                    <% } %>
                </div>
            </div>
            <div class="col-md-1 mb-3">
                <aside id="clase_cuponera">
                    <div class="space" style="height:60px"></div>
                    <div class="card mb-3" style="width:300px">
                        <div class="card-body">
                            <div class="list-group" style="list-style-type:none">
                                <a class="list-group-item active">Clases acudidas</a>
                                <hr>
                                <%
                                Set<BeanClase> cls = (Set<BeanClase>) request.getAttribute("clases");
                                for (BeanClase c: cls){
                                %>
                                <a href="consulta_dictado_clase?clase=<%= c.getNombre()%>" class="list-group-item list-group-item-action"><%= c.getNombre()%></a>
                                <% } %>
                            </div>
                        </div>
                    </div>

                    <div class="card mb-3" style="width:300px">
                        <div class="card-body">
                            <div class="list-group" style="list-style-type:none">
                                <a class="list-group-item active">Cuponeras compradas</a>
                                <hr>
                                <%
                                Set<BeanCuponera> cups = (Set<BeanCuponera>) request.getAttribute("cuponeras");
                                for (BeanCuponera cup: cups){
                                %>
                                <a href="consulta_cuponera?nombre=<%= cup.getNombre()%>" class="list-group-item list-group-item-action"><%= cup.getNombre()%></a>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </body>
</html>
