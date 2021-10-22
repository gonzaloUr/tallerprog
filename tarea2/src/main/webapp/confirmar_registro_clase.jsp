<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <form class="d-flex flex-column form-signup" action="index_socio.html">
            <h1 class="h3 mb-3 fw-normal">Finalizar registrarse a clase</h1>
            <label for="institucion">Metodo de pago:</label>
            <select name="tiene_cuponera" id="tiene_cuponera" multiple>
              <option value="con_cupo">Con cuponera</option>
              <option value="sin_cupo">Sin cuponera</option>
            </select>
            <p></p>
            <label for="actividad_Depor">Elija cuponera:</label>
            <select name="cuponera" id="cuponera" multiple>
              <option value="Pelota">Pelota</option>
            </select>
            <p></p>
            <input class="w-100 btn btn-primary" type="submit" value="Confirmar registro">
        </form>
	</body>
</html>
