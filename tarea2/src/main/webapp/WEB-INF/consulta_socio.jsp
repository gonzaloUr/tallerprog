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
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>Emi71</h4>
                      <p class="text-secondary mb-1">Socio</p>
                      <button class="btn btn-primary">Seguir</button>
                    </div>
                  </div>
                </div>
              </div>
             </div>
	        <div class="col-md-8">
              <div class="card mb-3">
                <div class="card-body">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Nombre completo</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Emiliano Lucas
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      emi71@gmail.com
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Fecha de nacimiento</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      31/12/1971
                    </div>
                  </div>
                 </div>
              </div>
              </div>
              </div>
              <div class="space" style="height:100px"></div>
              <div class="row gutters-sm">
               <div class="col-md-4 mb-3 offset-md-1">
              <h5><strong>Clases:</strong></h5>
              <div class="space" style="height:20px"></div>
              <div class="card mb-3">
                <div class="card-body">
              <div class="list-group" style="list-style-type:none">
              	<a href="consulta_clase" class="list-gropu-item list-gropu-item-action">Voleibol</a>
              	 <hr>
              	<a href="consulta_clase" class="list-gropu-item list-gropu-item-action">Aerobico adulto mayor</a>
              	 <hr>
              	<a href="consulta_clase" class="list-gropu-item list-gropu-item-action">Musculos para boxeo</a>
              	 <hr>
              	<a href="consulta_clase" class="list-gropu-item list-gropu-item-action">200 M</a>
              	 <hr>
              	<a href="consulta_clase" class="list-gropu-item list-gropu-item-action">Basquet I</a>
              </div>
              </div>
              </div>
              </div>
              <div class="col-md-4 mb-3 offset-md-1">
              <h5><strong>Cuponeras:</strong></h5>
              <div class="space" style="height:20px"></div>
              <div class="card mb-3">
                <div class="card-body">
              <div class="list-group" style="list-style-type:none">
              	              </div>
              </div>
              </div>
              </div>
			  </div>
	</body>
</html>