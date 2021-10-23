<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>

	<body class="d-flex flex-column text-center justify-content-center py-12">
        <form class="d-flex flex-column form-signup" action="registrarse_a_clase_3">
            <h2 class="h2 mb-3 fw-normal">Registrarse a clase</h2>
            <p class="mb-3 fw-normal">Seleccione una actividad deportiva</p>

            <nav class="flex flex-column p-3 bg-light">
              <div class="list-group pb-3">
                  <label class="list-group-item active">Actividades Deportivas</label>
                  <c:forEach items="${actividades}" var="act" >
                      <input class="list-group-item list-group-item-action" type="submit" name="actividad" value="${act}">
                  </c:forEach>
              </div>
            </nav>   
        </form>
        
	</body>
</html>