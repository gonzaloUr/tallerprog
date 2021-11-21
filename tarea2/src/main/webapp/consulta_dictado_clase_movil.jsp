<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Entrenamos.uy</title>
    <script src="bootstrap/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    <link rel="stylesheet" href="styles/common.css">
</head>



<body class="flex-column text-center justify-content-center py-12">
    <jsp:include page="/templates/top_mobil.jsp"/>

    <p class="fs-4 fw-bold p-3">${nombre} </p>

    <div class="list-group pb-3" style="display: block;">
        <img src="img/clase/${nombre}" alt=" " class="w-50">
        <p class="fs-6"> <b>Fecha y hora de inicio:</b>  ${inicio}</p>
        <p class="fs-6"><b>Cantidad minima de participantes:</b> ${cantMin}</p>
        <p class="fs-6"><b>Cantidad maxima de participantes:</b> ${cantMax}</p>
        <p><a href=${url}>Pagina web de ${nombre}</a></p>
        <p><a href="consulta_actividad_movil?nombre=${acti}"> Ver Información Actividad Deportiva </a>  </p>
    </div>
</body>
    <script src="styles/mio.js"></script>
</html>