<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <form class="d-flex flex-column form-signup" action="consulta_dictado_clase.html">
            <h1 class="h3 mb-3 fw-normal">Registrarse a clase</h1>
            <label for="institucion">Elija institucion deportiva :</label>
            <select name="institucion" id="institucion" multiple>
              <option value="Telon">Telón</option>
            </select> 
            <p></p>
            <label for="actividad_Depor">Elija la actividad deportiva :</label>
            <select name="actividad_Depor" id="actividad_Depor" multiple>
              <option value="Voleibol">Voleibol</option>
              <option value="Atletismo">Atletismo</option>
              <option value="Basquetbol">Basquetbol</option>
            </select>
            <p></p> 
            <label for="clases">Elija la clase :</label>
            <select name="clase" id="clase" multiple>
              <option value="Voleibol">Voleibol</option>
              <option value="Braza">Braza</option>
              <option value="Mariposa">Mariposa</option>
            </select>
            <p></p> 
            <input class="w-100 btn btn-primary" type="submit" value="Ver clase seleccionada">
        </form>
	</body>
</html>