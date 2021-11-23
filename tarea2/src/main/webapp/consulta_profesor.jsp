<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.entrenamosuy.web.MiniUsuario"%>
<%@page import="com.entrenamosuy.web.publicar.BeanClase"%>
<%@page import="com.entrenamosuy.web.publicar.BeanActividad"%>
<%@page import="com.entrenamosuy.web.publicar.BeanLocalDate"%>
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
        List<MiniUsuario> seguidos = (List<MiniUsuario>) request.getAttribute("seguidos");
        List<MiniUsuario> seguidores = (List<MiniUsuario>) request.getAttribute("seguidores");
        Set<BeanClase> clases = (Set<BeanClase>) request.getAttribute("clases");
        Set<BeanActividad> actividades = (Set<BeanActividad>) request.getAttribute("actividades");
        Set<BeanActividad> actividadesNoAceptadas = (Set<BeanActividad>) request.getAttribute("actividadesNoAceptadas");
        Set<BeanActividad> actividadesRechazadas = (Set<BeanActividad>) request.getAttribute("actividadesRechazadas"); 
        Set<BeanActividad> actividadesIngresadas = (Set<BeanActividad>) request.getAttribute("actividadesIngresadas");   
        Set<BeanActividad> actividadesFinalizada = (Set<BeanActividad>) request.getAttribute("actividadesFinalizada");             
        int esSeguidor = (int) request.getAttribute("esSeguidor");
        %>
        <jsp:include page="templates/header.jsp"/>
        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="img/usuario/${nickname}" alt=" " class="avatar-img-big">
                            <div class="mt-3">
                                <h4>${nickname}</h4>
                                <p class="text-secondary mb-1">Profesor</p>
                                <c:choose>
                                <c:when test="${esSeguidor eq 0}">
                                <a href="iniciar_sesion" class="btn btn-primary">Seguir</a>
                                </c:when>
                                <c:when test="${esSeguidor eq 1}">
                                <a href="dejar_seguir_usuario?nickname=${nickname}" class="btn btn-primary">Dejar de seguir</a>
                                </c:when>
                                <c:when test="${esSeguidor eq 2}">
                                <a href="seguir_usuario?nickname=${nickname}" class="btn btn-primary">Seguir</a>
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
                                Socio
                                Ver Perfil
                                
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${nombre}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${mail}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Fecha de nacimiento</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${nacimiento.dayOfMonth}/${nacimiento.month}/${nacimiento.year}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Institucion</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${institucion}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Descripcion</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${descripcion}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-5">
                                <h6 class="mb-0">Biografia</h6>
                            </div>
                            <div class="col-sm-7 text-secondary">
                                ${biografia}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="space" style="height:60px"></div>
                <div class="list-group">
                    <div class="list-group-item d-flex align-items-center active">Siguiendo</div>
                    <%
                    String h;
                    for (MiniUsuario a: seguidos){
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
                <aside>
                    <div class="space" style="height:60px"></div>
                    <div class="card mb-3" style="width:300px">
                        <div class="card-body">
                            <div class="list-group" style="list-style-type:none">
                                <a class="list-group-item active">Actividades creadas</a>
                                <hr>
                                <%
                                Set<BeanActividad> acts = (Set<BeanActividad>) actividades;
                                for (BeanActividad a: acts){
                                %>
                                <a href="consulta_actividad?nombre=<%= a.getNombre()%>" class="list-group-item list-group-item-action"><%= a.getNombre()%></a>
                                <% } %>
                                <%
                                boolean esDicta = (boolean) request.getAttribute("esDicta");
                                if ((request.getAttribute("actividadesIngresadas") != null) && (esDicta)){
                                    Set<BeanActividad> actsIng = (Set<BeanActividad>) request.getAttribute("actividadesIngresadas");
                                    for (BeanActividad ac: actsIng){
                                %>
                                <div class="list-group-item d-flex align-items-center">
                                    <div class="flex-fill pl-3 pr-3">
                                        <div><%= ac.getNombre()%></div>
                                        <div class="text-muted fs-13px">Ingresada</div>
                                    </div>
                                </div>
                                <% }
                                } %>
                                
                                <%
                                if ((request.getAttribute("actividadesNoAceptadas") != null) && (esDicta)){
                                Set<BeanActividad> actsR = (Set<BeanActividad>) request.getAttribute("actividadesRechazadas");
                                for (BeanActividad ac: actsR){
                                %>
                                <div class="list-group-item d-flex align-items-center">
                                    <div class="flex-fill pl-3 pr-3">
                                        <div><%= ac.getNombre()%></div>
                                        <div class="text-muted fs-13px">Rechazada</div>
                                    </div>
                                </div>
                                <% }
                                } %>

                                <%
                                if ((request.getAttribute("actividadesFinalizadas") != null) && (esDicta)){
                                Set<BeanActividad> actsFin = (Set<BeanActividad>) request.getAttribute("actividadesFinalizadas");
                                for (BeanActividad ac: actsFin){
                                %>
                                <div class="list-group-item d-flex align-items-center">
                                    <div class="flex-fill pl-3 pr-3">
                                        <div><%= ac.getNombre()%></div>
                                        <div class="text-muted fs-13px">Finalizada</div>
                                    </div>
                                </div>
                                <% }
                                } %>
                            </div>
                        </div>
                    </div>

                    <div class="card mb-3" style="width:300px">
                        <div class="card-body">
                            <div class="list-group" style="list-style-type:none">
                                <a class="list-group-item active">Clases dictadas</a>
                                <hr>
                                <%
                                Set<BeanClase> cls = (Set<BeanClase>) request.getAttribute("clases");
                                for (BeanClase cl: cls){
                                %>
                                <a href="consulta_dictado_clase?clase=<%= cl.getNombre()%>" class="list-group-item list-group-item-action"><%= cl.getNombre()%></a>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </body>
</html>
