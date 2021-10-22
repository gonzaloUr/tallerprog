<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.net.URL" %>
<%@ page import="com.entrenamosuy.web.Facades" %>
<%@ page import="com.entrenamosuy.core.data.DataInstitucion" %>
<%@ page import="com.entrenamosuy.core.data.DescProfesor" %>
<%@ page import="com.entrenamosuy.core.data.DataActividad" %>
<%@ page import="com.entrenamosuy.core.data.DataClase" %>
<%@ page import="com.entrenamosuy.core.data.DataCuponera" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        
        <link rel="stylesheet" href="styles/sidebar.css">
    </head>
	<body class="d-flex flex-column">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <%
            String claseNombre = request.getParameter("clase");
            DataClase clase = Facades
                .getFacades()
                .getFacadeClase()
                .getDataClase(claseNombre);
            String nombre = clase.getNombre();
            LocalDateTime inicio = clase.getInicio();
            int cantMin = clase.getCantMin();
            int cantMax = clase.getCantMax();
            URL url = clase.getAccesoURL();
            String acti= clase.getActividad().getNombre();
            Set<String> profesorNom = clase.getProfesores()
                .stream()
                .map(DescProfesor::getNombre)
                .collect(Collectors.toSet());
            Set<String> profesorApe = clase.getProfesores()
                .stream()
                .map(DescProfesor::getApellido)
                .collect(Collectors.toSet());

            String apellido = profesorApe.iterator().next();    
                
            request.setAttribute("nombre", nombre);
            request.setAttribute("inicio", inicio);
            request.setAttribute("cantMin", cantMin);
            request.setAttribute("cantMax", cantMax);
            request.setAttribute("url", url);
            request.setAttribute("acti", acti);
            request.setAttribute("profesorNom", profesorNom);
            request.setAttribute("profesorApe", profesorApe);
            request.setAttribute("apellido", apellido);
        %>
        <div class="d-flex flex-row">
            <jsp:include page="/WEB-INF/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <section class="d-flex flex-column">
                    <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
                    <p class="fs-6"> <b>Fecha y hora de inicio:</b>  ${inicio}</p>
                    <p class="fs-6"><b>Cantidad minima de participantes:</b> ${cantMin}</p>
                    <p class="fs-6"><b>Cantidad maxima de participantes:</b> ${cantMax}</p>
                    <p><a href=${url}>Pagina web de ${nombre}</a></p>                   
                    <p><a href="consulta_actividad_deportiva?actividad=${acti}"> Ver Información Actividad Deportiva </a>  </p>
                    <p><a href="confirmar_registro_clase?actividad=${acti}&clase=${clase}"> Registrarme a la clase </a>  </p> 
                    <c:forEach items="${profesorNom}" var="profesorNom" >
                        <p><b>Profesor: </b>${profesorNom} ${apellido}</p>
                    </c:forEach>


                </section>
            </main>
        </div>
	</body>
</html>