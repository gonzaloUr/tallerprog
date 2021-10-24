<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<body class="d-flex flex-column">
        <jsp:include page="/templates/header.jsp"/>
        <div class="d-flex flex-row">
            <jsp:include page="/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <section class="d-flex flex-column">
                    <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
                    <p class="fs-6"> <b>Fecha y hora de inicio:</b>  ${inicio}</p>
                    <p class="fs-6"><b>Cantidad minima de participantes:</b> ${cantMin}</p>
                    <p class="fs-6"><b>Cantidad maxima de participantes:</b> ${cantMax}</p>
                    <p><a href=${url}>Pagina web de ${nombre}</a></p>
                    <p><a href="consulta_actividad?nombre=${acti}"> Ver Información Actividad Deportiva </a>  </p>
                    <c:choose>
                        <c:when test="${es_socio eq true}">
                            <p><a href="confirmar_registro_clase?actividad=${acti}&clase=${nombre}"> Registrarme a la clase </a>  </p>
                        </c:when>
                    </c:choose>
                    <c:forEach items="${profesorNom}" var="profesorNom" >
                        <p><b>Profesor: </b>${profesorNom} ${apellido}</p>
                    </c:forEach>

                </section>
            </main>
        </div>
	</body>
</html>
