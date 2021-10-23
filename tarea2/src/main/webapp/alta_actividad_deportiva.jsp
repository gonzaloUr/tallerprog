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
            <h1 class="h3 mb-3 fw-normal">Alta de actividad deportiva</h1>
            <input class="form-control mb-3" placeholder="Nombre" name="nombre">
            <input class="form-control mb-3" placeholder="Descripcion" name="descripcion">
            <input class="form-control mb-3" placeholder="Duracion" name="duracion">
            <input class="form-control mb-3" placeholder="Costo" name="costo">
            <label for="categorias">Elija categorias (para multiples ctrl+click) :</label>
            <select name="categorias" id="categortias" multiple>
              <option value="Al_aire_libre">Al aire libre</option>
              <option value="Deportes">Deportes</option>
              <option value="Fitness">Fitness</option>
              <option value="Gimnasia">Gimnasia</option>
            </select>
            <p> </p>
            <input class="w-100 btn btn-primary" type="submit" value="Dar de alta">
        </form>
	</body>
</html>
