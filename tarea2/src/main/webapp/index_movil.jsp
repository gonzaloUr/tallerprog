<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/iniciar_sesion_mobil.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <c:choose>
            <c:when test="${usuario != null}">
                <c:choose>
                    <c:when test="${es_profesor eq false}">
                        <jsp:include page="/templates/top_mobil.jsp"/>
                        <span class="ms-3">Bienvenido ${usuario.nombre} ${usuario.apellido}</span>
                    </c:when>
                    <c:otherwise>
                        <form class="d-flex flex-column form-login" method="post">
                            <h1 class="h3 mb-3 fw-normal">Inicio de sesión</h1>
                                <% 
                                String nickCookieAtr = "";
                                String passCookieAtr = "";
                                Cookie [] oreos = request.getCookies();
                                if (oreos != null){
                                    for (Cookie ck : oreos){
                                        if (ck.getName().equals("nickCookie"))
                                            nickCookieAtr = ck.getValue();
                                        else if (ck.getName().equals("passCookie"))
                                            passCookieAtr = ck.getValue();
                                    }
                                } %> 
                            <input class="form-control mb-3" placeholder="nickname" name="nick" value="<%=nickCookieAtr%>">
                            <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password" value="<%=passCookieAtr%>">
                            
                            <span>Recordar</span> 
                            <input type="checkbox" name="cookie_login" value="1">
                            
                            <c:if test="${attempted_login}">
                                <c:if test="${reason == 'nickname'}">
                                    <span class="text-danger mb-3">Nickname o contraseña invalida</span>
                                </c:if>
                                <c:if test="${reason == 'password'}">
                                    <span class="text-danger mb-3"> Nickname o contraseña invalida</span>
                                </c:if>
                            </c:if>
                            <input class="w-100 btn btn-primary" type="submit" value="Iniciar sesión">
                        </form>
                    </c:otherwise>
                </c:choose> 
            </c:when>
            <c:otherwise>
                <form class="d-flex flex-column form-login" method="post">
                    <h1 class="h3 mb-3 fw-normal">Inicio de sesión</h1>
                        <% 
                        String nickCookieAtr = "";
                        String passCookieAtr = "";
                        Cookie [] oreos = request.getCookies();
                        if (oreos != null){
                            for (Cookie ck : oreos){
                                if (ck.getName().equals("nickCookie"))
                                    nickCookieAtr = ck.getValue();
                                else if (ck.getName().equals("passCookie"))
                                    passCookieAtr = ck.getValue();
                            }
                        } %> 
                    <input class="form-control mb-3" placeholder="nickname" name="nick" value="<%=nickCookieAtr%>">
                    <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password" value="<%=passCookieAtr%>">
                    
                    <span>Recordar</span> 
                    <input type="checkbox" name="cookie_login" value="1">
                    
                    <c:if test="${attempted_login}">
                        <c:if test="${reason == 'nickname'}">
                            <span class="text-danger mb-3">Nickname o contraseña invalida</span>
                        </c:if>
                        <c:if test="${reason == 'password'}">
                            <span class="text-danger mb-3"> Nickname o contraseña invalida</span>
                        </c:if>
                    </c:if>
                    <input class="w-100 btn btn-primary" type="submit" value="Iniciar sesión">
                </form>
            </c:otherwise>
        </c:choose>
	</body>
    <script src="styles/mio.js"></script>
</html>

