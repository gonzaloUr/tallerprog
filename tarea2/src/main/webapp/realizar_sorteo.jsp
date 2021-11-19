<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.entrenamosuy.web.publicar.BeanSocio"%>
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
int estadoS = (int) request.getAttribute("estadoSorteo");
String clase = (String) request.getAttribute("clase");

if(estadoS == 2){
%>
<div class = "d-flex flex-column text-center justify-content-center py-12">
	<div class= "card">
		<div class= "card-body">
			<h4>Clase no dictada.</h4>
			<a href="consulta_clase?nombre=<%=clase%>" class="btn btn-primary">Volver</a>
		</div>
	</div>
</div>
<% } 
else if (estadoS == 1){
%>
<div class = "d-flex flex-column text-center justify-content-center py-12">
	<div class= "card">
		<div class= "card-body">
			<h4>Sorteo ya realizado.</h4>
			<div class="space" style="height:40px"></div>
			<div class="list-group">
            	<div class="list-group-item d-flex align-items-center active">Ganadores
                </div>
                <%
                List<BeanSocio> socios = (List<BeanSocio>) request.getAttribute("ganadores");
                for (BeanSocio s : socios){ %>
                <div class="list-group-item d-flex align-items-center">
                    <img src="img/usuario/<%=s.getNickname()%> %>" alt=" " class="avatar-img" />
                    <div class="flex-fill pl-5 pr-3">
                    	<h class="m-3"><strong><%=s.getNickname()%></strong></h>
                    </div>
                    <a href="consulta_socio?nickname=<%=s.getNickname()%>" class="btn btn-outline-primary">Ver Perfil</a>
                </div>
                <%}%>
            </div>
            <a href="consulta_clase?nombre=<%=clase%>" class="btn btn-primary">Volver</a>
		</div>
	</div>
</div>
<%}
else {%>
<div class = "d-flex flex-column text-center justify-content-center py-12">
	<div class= "card">
		<div class= "card-body">
			<h4>Sorteo no realizado.</h4>
			<div class="space" style="height:40px"></div>
			<div class="list-group">
            	<div class="list-group-item d-flex align-items-center active">Socios registrados
                </div>
                <%
                List<BeanSocio> socios = (List<BeanSocio>) request.getAttribute("registrados");
                for (BeanSocio s : socios){ %>
                <div class="list-group-item d-flex align-items-center">
                    <img src="img/usuario/<%=s.getNickname()%> %>" alt=" " class="avatar-img" />
                    <div class="flex-fill pl-5 pr-3">
                    	<h class="m-3"><strong><%=s.getNickname()%></strong></h>
                    </div>
                    <a href="consulta_socio?nickname=<%=s.getNickname()%>" class="btn btn-outline-primary">Ver Perfil</a>
                </div>
                <%}%>
            </div>
            <a href="consulta_dictado_clase?clase=<%=clase%>" class="btn btn-primary">Cancelar</a>
            <a href="confirmar_sorteo?clase=<%=clase%>" class="btn btn-primary">Realizar Sorteo</a>
		</div>
	</div>
</div>
<%}%>
</body>
</html>