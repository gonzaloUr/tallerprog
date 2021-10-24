<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.net.URL" %>
<%@ page import="com.entrenamosuy.web.Facades" %>
<%@ page import="com.entrenamosuy.core.AbstractFacadeInstitucion" %>
<%@ page import="com.entrenamosuy.core.AbstractFacadeActividad" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    AbstractFacadeInstitucion facadeInstitucion = Facades.getFacades().getFacadeInstitucion();
    Set<String> instituciones = facadeInstitucion.getInstituciones();
    request.setAttribute("instituciones", instituciones);

    AbstractFacadeActividad facadeActividad = Facades.getFacades().getFacadeActividad();
    Set<String> categorias = facadeActividad.getCategorias();
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
