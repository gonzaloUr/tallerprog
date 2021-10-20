<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/alta_usuario.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <form class="d-flex flex-column form-signup" action="index.html">
            <h1 class="h3 mb-3 fw-normal">Alta de dictado de clase</h1>
            <label for="categorias">Elija una actividad deportiva de Telon:</label>
            <select name="actividades_depor" id="actividades_depor" multiple>
                <option value="Voleibol">Voleibol</option>
                <option value="Atletismo">Atletismo</option>
                <option value="Basquetbol">Basquetbol</option>
            </select> 
            <p> </p>
            <input class="form-control mb-3" placeholder="Nombre" name="nombre">
            <input class="form-control mb-3" placeholder="Fecha inicio" name="Fecha_inicio">
            <input class="form-control mb-3" placeholder="Hora inicio" name="Hora_inicio">
            <input class="form-control mb-3" placeholder="Socios mínimos" name="Socios_minimos">
            <input class="form-control mb-3" placeholder="Socios máximos" name="Socios_maximos">
            <input class="form-control mb-3" placeholder="URL de pagina web" name="URL">
            <input class="w-100 btn btn-primary" type="submit" value="Dar de alta">
        </form>
	</body>
</html>