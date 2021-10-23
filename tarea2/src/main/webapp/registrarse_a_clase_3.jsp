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
        <form class="d-flex flex-column form-signup" action="consulta_dictado_clase">
            <h2 class="h2 mb-3 fw-normal">Registrarse a clase</h2>
            <p class="mb-3 fw-normal">Seleccione una clase</p>

            <nav class="flex flex-column p-3 bg-light">
              <div class="list-group pb-3">
                  <label class="list-group-item active">Clases </label>
                  <c:forEach items="${clases}" var="clase" >
                      <input class="list-group-item list-group-item-action" type="submit" name="clase" value="${clase}">
                  </c:forEach>
              </div>
            </nav>   
        </form>
        
	</body>
</html>