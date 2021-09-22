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
            <div class="col-md-5 mb-3">
              <div class="card">
                <div class="card-body">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bit.ly/3lKq8Px" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>denis</h4>
                      <p class="text-secondary mb-1">Profesor</p>
                      <button class="btn btn-primary">Seguir</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Nombre completo</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Denis Miguel
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      den80@fuerza.com
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Fecha de nacimiento</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      14/06/1980
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Institucion</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Telon
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Descripcion</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      A Denis le interesan los deportes con pelota,
principalmente el voleibol y el handball
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Biografia</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Denis fue un jugador de voleibol
profesional.
                    </div>
                  </div>
                  <hr>
                    <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Sitio web</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
						www.denis.com
                    </div>
                  </div>
                 </div>
              </div>
              </div>
              <div class="col-md-4 mb-3">
              <aside id="clase_cuponera">
	              <div class="card mb-3">
		              <div class="card-body">
			              <div class="list-group" style="list-style-type:none">
			              	<a class="list-group-item active">Clases</a>
			              	 <hr>
			              	<a href="consulta_clase" class="list-group-item list-group-item-action">Voleibol</a>
			              </div>
		              </div>
	              </div>

	              <div class="card mb-3">
	                <div class="card-body">
		              <div class="list-group" style="list-style-type:none">
			              <a class="list-group-item active">Actividades:</a>
			              <hr>
			              <a href="consulta_actividad_deportiva" class="list-group-item list-group-item-action">Voleibol</a>
			              <a href="consulta_actividad_deportiva" class="list-group-item list-group-item-action">Atletismo</a>
		              </div>
	              	</div>
	              </div>
              </aside>
              </div>
              </div>
			
	</body>
</html>