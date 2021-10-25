<%@page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    </head>
	<body class="container">
        <div class="col-12 p-5">
            <form class="d-flex flex-column" method="post" action="alta_dictado_clase" enctype="multipart/form-data">
                <h1 class="h3 mb-3 fw-normal">Alta de clase</h1>
                <select class="form-control mb-3" name="actividad">
                    <c:forEach var="i" begin="0" end="${actividades.size() - 1}">
                        <c:choose>
                            <c:when test="${i eq 0}">
                                <option selected value="${actividades.get(i)}">${actividades.get(i)}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${actividades.get(i)}">${actividades.get(i)}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <input class="form-control mb-3" placeholder="nombre" name="nombre">
                <input class="form-control mb-3" placeholder="inicio" name="inicio" type="datetime-local" value="2021-10-27T11:00">
                <input class="form-control mb-3" placeholder="cantidad mininima" name="cant_min" type="number" min="0">
                <input class="form-control mb-3" placeholder="cantidad maxima" name="cant_max" type="number" min="0">
                <input class="form-control mb-3" placeholder="url de acesso" name="acceso" type="url">
                <input class="form-control mb-3" placeholder="fecha de registro" name="fecha_registro" type="date" value=<%=LocalDate.now()%>>
                <input class="form-control mb-3" accept="image/*" name="img" type="file">
                <input class="btn btn-primary w-100" type="submit" value="Crear">
            </form>
            <c:if test="${error ne null}">
            <span class="text-danger mb-3">${error}</span>
            </c:if>
        </div>
	</body>
</html>
