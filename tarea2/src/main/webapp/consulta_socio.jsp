<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/sidebar.css">
	</head>
	<body>

          <% 
          String nick = request.getAttribute("nickname");
          String nombre = request.getAttribute("nombre");
          String mail = request.getAttribute("mail");
          LocalDate nacimiento = request.getAttribute("nacimiento");
          Set<String> seguidos = request.getAttribute("seguidos");
          Set<String> seguidores = request.getAttribute("seguidores");
          Set<DataClase> clases = request.getAttribute("clases");
          Set<DataCuponera> cuponeras = request.getAttribute("cuponeras");
          %>
	        <jsp:include page="/WEB-INF/templates/header.jsp"/>
	        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bit.ly/3lxoBvZ" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4><%= nick%></h4>
                      <p class="text-secondary mb-1">Socio</p>
                      <button class="btn btn-primary">Seguir</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-5">
                      <h6 class="mb-0">Nombre completo</h6>
                    </div>
                    <div class="col-sm-7 text-secondary">
                      <%= nombre%>
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-5">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-7 text-secondary">
                      <%= mail%>
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-5">
                      <h6 class="mb-0">Fecha de nacimiento</h6>
                    </div>
                    <div class="col-sm-7 text-secondary">
                      <%= nacimiento.getDayOfMonth()%>/<%= nacimiento.getMonthValue()%>/<%= nacimiento.getYear()%>
                    </div>
                  </div>
                 </div>
              </div>
              </div>
              <div class="col-md-4 mb-3">
              <div class="space" style="height:60px"></div>
               <div class="list-group">
                                    <div class="list-group-item d-flex align-items-center active">Siguiendo
                                    </div>
                                    <% 
                                    Set<String> sig = (Set<String>) request.getAttribute("seguidos");
                                    for (String s: sig){
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>guille</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    </div>
                                    <div class="space" style="height:30px"></div>
               <div class="list-group">
                                    <div class="list-group-item d-flex align-items-center active">Seguidores
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>guille</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="consulta_socio" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>eugue</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="consulta_socio" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>denis</strong></div>
                                            <div class="text-muted fs-13px">Profesor</div>
                                        </div>
                                        <a href="consulta_profesor" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>Nelson</strong></div>
                                            <div class="text-muted fs-13px">Profesor</div>
                                        </div>
                                        <a href="consulta_profesor" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    </div>
              
              </div>
              <div class="col-md-1 mb-3">
	              <aside id="clase_cuponera">
	              <div class="space" style="height:60px"></div>
	              <div class="card mb-3" style="width:300px">
	                <div class="card-body">
	              <div class="list-group" style="list-style-type:none">
	              	<a class="list-group-item active">Clases</a>
	              	 <hr>
                   <% 
                      Set<DataClase> cls = (Set<DataClase>) request.getAttribute("clases");
                      for (String c: cls){
                    %>
	              	<a href="consulta_dictado_clase?nombre=<%= c.getNombre()%>" class="list-group-item list-group-item-action"><%= c.get.Nombre()%></a>
                   <% } %>
	              </div>
	              </div>
	              </div>
	
	              <div class="card mb-3" style="width:300px">
	                <div class="card-body">
	              <div class="list-group" style="list-style-type:none">
	              <a class="list-group-item active">Cuponeras</a>
	              	 <hr>
                   <% 
                      Set<DataCuponera> cls = (Set<DataCuponera>) request.getAttribute("cuponeras");
                      for (String cup: cups){
                    %>
	              	 <a href="consulta_cuponera?nombre=<%= cup.getNombre()%>" class="list-group-item list-group-item-action"><%= cup.getNombre()%></a>
                   <% } %>
	              </div>
	              </div>
	              </div>
	              </aside>
              </div>
              </div>
			
	</body>
</html>