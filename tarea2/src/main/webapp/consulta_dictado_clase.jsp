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
                    <img src="img/clase/${nombre}" alt=" " class="consulta_clase mb-3">
                    <p class="fs-6"> <b>Fecha y hora de inicio:</b>  ${inicio}</p>
                    <p class="fs-6"><b>Cantidad minima de participantes:</b> ${cantMin}</p>
                    <p class="fs-6"><b>Cantidad maxima de participantes:</b> ${cantMax}</p>
                    <p><a href=${url}>Pagina web de ${nombre}</a></p>
                    <c:choose>
                        <c:when test="${esAceptada eq true}">
                            <p><a href="consulta_actividad?nombre=${acti}"> Ver Información Actividad Deportiva </a> </p>
                        </c:when>
                        <c:when test="${esAceptada eq false}">
                            <p class="fs-6"><b>Actividad deportiva finalizada</b></p>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${es_profesor eq false}">
                            <c:choose>
                                <c:when test="${esAceptada eq true}">
                                    <p><a href="confirmar_registro_clase?actividad=${acti}&clase=${nombre}"> Registrarme a la clase </a>  </p>
                                </c:when> 
                            </c:choose>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${es_profesor_que_dicta eq true}">
                            <c:choose>
                                <c:when test="${cantPremios ne 0}">
                                    <c:choose>
                                        <c:when test="${esAceptada eq true}">
                                            <p><a href="realizar_sorteo?clase=${nombre}"> Realizar sorteo </a></p>
                                        </c:when> 
                                    </c:choose>    
                                </c:when>
                            </c:choose>
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
