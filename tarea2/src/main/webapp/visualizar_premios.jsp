<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.entrenamosuy.web.publicar.BeanDescActividad"%>
<%@page import="com.entrenamosuy.web.publicar.BeanClase"%>
<%@page import="com.entrenamosuy.web.publicar.BeanLocalDate"%>
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
<jsp:include page="templates/header.jsp"/>
<div class="d-flex justify-content-center">
    <div class=col-3></div>
    <div class=col-6>
        <div class="space" style="height:60px"></div>
        <div class= "card">
            <div class= "card-body">
                <h5 class="list-group-item d-flex align-items-center active">Premios de ${usuario.nombre} ${usuario.apellido}:</h5>
                <div class="space" style="height:40px"></div>
                <div class="list-group">
                    <%
                    List<BeanClase> clases = (List<BeanClase>) request.getAttribute("clasesGanadasOrdenadas");
                    for (BeanClase c : clases){ %>
                    <div class="list-group-item d-flex align-items-center">  
                        <div class="flex-fill pl-5 pr-3">
                            <h class="m-3"><strong>Premio de clase: <%=c.getNombre()%> </strong></h>
                            <h class="m-3"><strong>Actividad deportiva: <%=c.getActividad().getNombre()%> </strong></h>
                            <h class="m-3"><strong> Fecha del Sorteo: <%=c.getFechaSorteo().getDayOfMonth()%>/<%=c.getFechaSorteo().getMonth()%>/<%=c.getFechaSorteo().getYear()%></strong></h> 
                        </div>  
                    </div>
                    <%}%>
                </div> 
                <div class="space" style="height:10px"></div> 
            </div> 
        </div> 
    </div> 
    <div class=col-3></div>             
</body>
</html>        