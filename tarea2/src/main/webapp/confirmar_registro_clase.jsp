<%@page import="java.util.Set"%>
<%@page import="com.entrenamosuy.core.data.DataCuponera"%>

<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">

    <form class="d-flex flex-column form-signup" method="post">
      <h1 class="h3 mb-3 fw-normal">Confirmar registro a clase</h1>
      <label for="actividad_Depor">Si desea registrarse con una cuponera, seleccionela:</label>
      
      <select name="cuponera" id="cuponera" multiple>
      <%
      Set<String> cupos = (Set<String>) request.getAttribute("cuponeras");
      for (String cupo: cupos){
      %>
    
        <option value="<%= cupo%>"><%= cupo%></option>
      
      <% } %>

      </select>
      <p></p>
      
      <input class="w-100 btn btn-primary" type="submit" value="Confirmar registro">
    </form>

	</body>
</html>
