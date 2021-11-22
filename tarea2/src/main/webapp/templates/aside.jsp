<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.util.stream.Collectors" %>
<%@page import="com.entrenamosuy.web.publicar.GetCategorias"%>
<%@page import="com.entrenamosuy.web.publicar.GetInstituciones"%>
<%@page import="com.entrenamosuy.web.publicar.Publicador"%>
<%@page import="com.entrenamosuy.web.publicar.PublicadorService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Publicador port = Webservice.getPort();

    Set<String> instituciones = port.getInstituciones()
        .stream()
        .collect(Collectors.toSet());
    Set<String> categorias = port.getCategorias()
        .stream()
        .collect(Collectors.toSet());

    request.setAttribute("instituciones", instituciones);

    request.setAttribute("categorias", categorias);
%>
<aside id="aside">
    <nav class="flex flex-column p-3 bg-light">
        <div class="list-group pb-3">
            <label class="list-group-item active">Instituciones</label>
            <c:forEach items="${instituciones}" var="institucion" >
            <form action="consulta_institucion">
                <input class="list-group-item list-group-item-action" type="submit" name="institucion" value="${institucion}">
            </form>
            </c:forEach>
        </div>
        <div class="list-group">
            <label class="list-group-item active">Categorías</label>
            <c:forEach items="${categorias}" var="categoria" >
            <form action="consulta_categoria">
                <input class="list-group-item list-group-item-action" type="submit" name="categoria" value="${categoria}">
            </form>
            </c:forEach>
        </div>
    </nav>
</aside>
