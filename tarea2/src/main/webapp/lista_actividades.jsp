<%@page import="java.util.Set"%>
<%@page import="com.entrenamosuy.core.data.DataActividad"%>
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
            <div class="space" style="height:60px"></div>
		<div class="d-flex justify-content-center">
			<div class=col-3></div>
			<div class=col-6>
                
			      <div class="list-group">
                              <div class="list-group-item d-flex align-items-center active"><h4><strong>Actividades</strong></h4>
                              </div>
                              <%
                                    Set<DataActividad> acts = (Set<DataActividad>) request.getAttribute("actividades");
                                    for (DataActividad act: acts){
                              %>
                              
				      <div class="list-group-item d-flex align-items-center">
                        <img src="img/actividad/<%=act.getNombre()%>" alt=" " class="lista_actividad" />
                                    <h4 class="m-5"><strong><%= act.getNombre()%></strong></h4>
                                          <div class="flex-fill pl-5 pr-3">
                                  	      <div class="text-muted fs-13px"><%= act.getDescripcion()%></div>
                                          </div>
                                    <a href="consulta_actividad?nombre=<%= act.getNombre()%>" class="btn btn-outline-primary">Ver Mas Informacion</a>
				      </div>
                              <% } %>			
			      </div>
                  </div>
			<div class=col-3></div>
		</div>
	</body>
</html>