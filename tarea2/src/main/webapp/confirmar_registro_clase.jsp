<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Set"%>
<%@page import="com.entrenamosuy.core.data.DataCuponera"%>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
    <c:choose>
      <c:when test="${reg_exito eq false}">
        <div class="form-login">
          <h1 class="h3 mb-3 fw-normal">Ya está registrado a esta clase</h1>
          <span class="mb-3">Presione para volver al inicio</span>
          <a class="btn btn-primary" href="/tarea2">Pagina principal</a>
        </div>
      </c:when>
      <c:otherwise>
        <form class="d-flex flex-column form-signup" method="post">
          <h1 class="h3 mb-3 fw-normal">Confirmar registro a clase</h1>
          <label for="actividad_Depor">Si desea registrarse con una cuponera, seleccionela:</label>
          
          <select name="cuponera" id="cuponera" multiple>
          <%
          Set<String> cupos = (Set<String>) request.getAttribute("cuponeras");
          for (String cupo: cupos){
          %>
            <option value="<%= cupo%>"><%= cupo%></option>
          <% } %>
          </select>
          <p></p>
          
          <input class="w-100 btn btn-primary" type="submit" value="Confirmar registro">
        </form>
      </c:otherwise>
    </c:choose>  
	</body>
</html>
