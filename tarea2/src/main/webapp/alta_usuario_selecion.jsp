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
        <form class="d-flex flex-column form-signup" method="get">
            <h1 class="h3 mb-3 fw-normal">Selecione tipo de usuario</h1>
            <select class="form-select mb-3" name="tipo">
                <option value="socio" selected>Socio</option>
                <option value="profesor">Profesor</option>
            </select>
            <input class="w-100 btn btn-primary" type="submit" value="Siguiente">
        </form>
	</body>
</html>
