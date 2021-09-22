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
	        <jsp:include page="/WEB-INF/templates/header.jsp"/>
	        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bit.ly/3lxoBvZ" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>Emi71</h4>
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
                      Emiliano Lucas
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-5">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-7 text-secondary">
                      emi71@gmail.com
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-5">
                      <h6 class="mb-0">Fecha de nacimiento</h6>
                    </div>
                    <div class="col-sm-7 text-secondary">
                      31/12/1971
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
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>guille</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    </div>
                                    <div class="space" style="height:60px"></div>
               <div class="list-group">
                                    <div class="list-group-item d-flex align-items-center active">Seguidores
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>guille</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>eugue</strong></div>
                                            <div class="text-muted fs-13px">Socio</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>denis</strong></div>
                                            <div class="text-muted fs-13px">Profesor</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    <div class="list-group-item d-flex align-items-center">
                                        <div class="flex-fill pl-3 pr-3">
                                            <div><strong>Nelson</strong></div>
                                            <div class="text-muted fs-13px">Profesor</div>
                                        </div>
                                        <a href="#" class="btn btn-outline-primary">Ver Perfil</a>
                                    </div>
                                    </div>
              
              </div>
              <div class="col-md-1 mb-3">
	              <aside id="clase_cuponera">
	              <div class="card mb-3">
	                <div class="card-body">
	              <div class="list-group" style="list-style-type:none">
	              	<a class="list-group-item active">Clases</a>
	              	 <hr>
	              	<a href="consulta_clase" class="list-group-item list-group-item-action">Voleibol</a>
	              	<a href="consulta_clase" class="list-group-item list-group-item-action">Aerobico adulto mayor</a>
	              	<a href="consulta_clase" class="list-group-item list-group-item-action">Musculos para boxeo</a>
	              	<a href="consulta_clase" class="list-group-item list-group-item-action">200 M</a>
	              	<a href="consulta_clase" class="list-group-item list-group-item-action">Basquet I</a>
	              </div>
	              </div>
	              </div>
	
	              <div class="card mb-3">
	                <div class="card-body">
	              <div class="list-group" style="list-style-type:none">
	              <a class="list-group-item active">Cuponeras:</a>
	              	 <hr>
	              	 <a href="consulta_cuponera" class="list-group-item list-group-item-action">Pelota</a>
	              	              </div>
	              </div>
	              </div>
	              </aside>
              </div>
			
	</body>
</html>