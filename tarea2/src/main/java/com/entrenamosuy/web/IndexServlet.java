package com.entrenamosuy.web;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeClase;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeInstitucion;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.model.ActividadEstado;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (getServletContext().getAttribute("cargado") == null) {
            AbstractFacadeUsuario facadeUsuario = Facades.getFacades().getFacadeUsuario();
            AbstractFacadeActividad facadeActividad = Facades.getFacades().getFacadeActividad();
            AbstractFacadeCuponera facadeCuponera = Facades.getFacades().getFacadeCuponera();
            AbstractFacadeClase facadeClase = Facades.getFacades().getFacadeClase();
            AbstractFacadeInstitucion facadeInstitucion = Facades.getFacades().getFacadeInstitucion();

            ServletContext ctx = request.getServletContext();

            try {
                facadeUsuario.crearSocio()
                    .setNickname("Emi71")
                    .setNombre("Emiliano")
                    .setApellido("Lucas")
                    .setCorreo(Email.of("emi71", "gmail.com"))
                    .setNacimiento(LocalDate.of(1971, 12, 31))
                    .setPassword("asdfg456")
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3lxoBvZ")))
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("caro")
                    .setNombre("Carolina")
                    .setApellido("Omega")
                    .setCorreo(Email.of("caro", "gmail.com"))
                    .setNacimiento(LocalDate.of(1983, 11, 15))
                    .setPassword("123rtgfdv")
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3AfcJER")))
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("euge")
                    .setNombre("Eugenia")
                    .setApellido("Williams")
                    .setCorreo(Email.of("e.will", "gmail.com"))
                    .setNacimiento(LocalDate.of(1990, 4, 15))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3Afz59x")))
                    .setPassword("poiuy086")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("guille")
                    .setNombre("Guillermo")
                    .setApellido("Hector")
                    .setCorreo(Email.of("ghector", "gmail.com"))
                    .setNacimiento(LocalDate.of(1959, 5, 15))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3ElkVG2")))
                    .setPassword("GTO468")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("sergiop")
                    .setNombre("Sergio")
                    .setApellido("Perez")
                    .setCorreo(Email.of("sergi", "gmail.uy"))
                    .setNacimiento(LocalDate.of(1950, 1, 28))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3hDWgTD")))
                    .setPassword("HGF135")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("andy")
                    .setNombre("Andres")
                    .setApellido("Roman")
                    .setCorreo(Email.of("chino", "gmail.uy"))
                    .setNacimiento(LocalDate.of(1976, 3, 17))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3Ai4jMW")))
                    .setPassword("lkj65D")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("tonyp")
                    .setNombre("Antonio")
                    .setApellido("Paz")
                    .setCorreo(Email.of("eltony", "gmail.uy"))
                    .setNacimiento(LocalDate.of(1955, 2, 14))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3zglsWf")))
                    .setPassword("jhvf395")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("m1k4")
                    .setNombre("Micaela")
                    .setApellido("Lopez")
                    .setCorreo(Email.of("mika", "gmail.ar"))
                    .setNacimiento(LocalDate.of(1987, 2, 23))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/2YRWDTQ")))
                    .setPassword("ijngr024")
                    .invoke();

                facadeUsuario.crearSocio()
                    .setNickname("charly")
                    .setNombre("Carlos")
                    .setApellido("Boston")
                    .setCorreo(Email.of("emi71", "gmail.uy"))
                    .setNacimiento(LocalDate.of(1937, 3, 8))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3zetdMl")))
                    .setPassword("987mnbgh")
                    .invoke();

                facadeInstitucion.crearInstitucion()
                    .setNombre("Instituto Natural")
                    .setDescripcion("Clases de gimnasia aerobica, spinning y yoga.")
                    .setUrl(new URL("https://www.inatural.com"))
                    .invoke();

                facadeInstitucion.crearInstitucion()
                    .setNombre("Fuerza Bruta")
                    .setDescripcion("Gimnasio especializado en el desarrollo de la musculatura.")
                    .setUrl(new URL("https://www.musculos.com/"))
                    .invoke();

                facadeInstitucion.crearInstitucion()
                    .setNombre("Telon")
                    .setDescripcion("Actividades deportivas para todas la edades.")
                    .setUrl(new URL("https://telon.com.uy"))
                    .invoke();

                facadeInstitucion.crearInstitucion()
                    .setNombre("Olympic")
                    .setDescripcion("Gimnasia y aparatos.")
                    .setUrl(new URL("https://www.olympic21.com/"))
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("viktor")
                    .setNombre("Victor")
                    .setApellido("Perez")
                    .setCorreo(Email.of("vperez", "fuerza.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3zetdMl")))
                    .setNacimiento(LocalDate.of(1977, 1, 1))
                    .setInstitucion("Fuerza Bruta")
                    .setDescripcion("Victor es un apasionado de los musculos. " +
                            "Sus clases son organizadas en funcion de distintos aparatos y pesas con " +
                            "el objetivo de desarrollar los musculos.")
                    .setBiografia("Victor nacio en Moscow en 1977." +
                            " En el año 2005 emigro a Uruguay luego de quedar encantado con el pais en un viaje turistico.")
                    .setSitioWeb(new URL("https://www.vikgym.com"))
                    .setPassword("lkj34df")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("denis")
                    .setNombre("Denis")
                    .setApellido("Miguel")
                    .setCorreo(Email.of("den80", "fuerza.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3lKq8Px")))
                    .setNacimiento(LocalDate.of(1977, 1, 1))
                    .setNacimiento(LocalDate.of(1980, 6, 14))
                    .setInstitucion("Telon")
                    .setDescripcion("A Denis le interesan los deportes con pelota, principalmente el voleibol y el hanball.")
                    .setBiografia("Denis fue un jugador de voleibol profesional.")
                    .setSitioWeb(new URL("https://www.depecho.com"))
                    .setPassword("poke579")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("clazar")
                    .setNombre("Carlos")
                    .setApellido("Lazaro")
                    .setCorreo(Email.of("claz4r0", "hotmail.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/2VJvT6S")))
                    .setNacimiento(LocalDate.of(1953, 6, 22))
                    .setInstitucion("Instituto Natural")
                    .setDescripcion("Carlos es un profesor muy divertido, cuyas clases de aerobica estan cargadas de energia.")
                    .setBiografia("El interes por la actividad fisica llevo a Carlos a dejar su trabajo" +
                            " en un estudio contable y abrir su propio gimnasio.")
                    .setSitioWeb(new URL("https://www.enforma.com"))
                    .setPassword("mkji648")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("TheBoss")
                    .setNombre("Bruno")
                    .setApellido("Sosa")
                    .setCorreo(Email.of("bruceTheBoss", "gmail.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3kdT9TV")))
                    .setNacimiento(LocalDate.of(1949, 9, 23))
                    .setInstitucion("Fuerza Bruta")
                    .setDescripcion("Bruno es un ex-boxeador que busca entrenar futuros campeones.")
                    .setBiografia("Bruno, mejor conocido como Bruce en el ring, compitio como boxeador entre los años 60s y 70s.")
                    .setSitioWeb(new URL("https://www.bruce.net"))
                    .setPassword("fcku0123")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("Nelson")
                    .setNombre("Luis")
                    .setApellido("Nelson")
                    .setCorreo(Email.of("nelson", "hotmail.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3lxsDo7")))
                    .setNacimiento(LocalDate.of(1998, 1, 1))
                    .setInstitucion("Telon")
                    .setDescripcion("Profesor de natacion, especializado en braza y mariposa.")
                    .setBiografia(null)
                    .setSitioWeb(null)
                    .setPassword("vbmn4r")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("lale")
                    .setNombre("Laura")
                    .setApellido("Leyes")
                    .setCorreo(Email.of("la_le", "outlook.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3EmlY8F")))
                    .setNacimiento(LocalDate.of(1987, 2, 14))
                    .setInstitucion("Telon")
                    .setDescripcion("Luego de una exitosa carrera como jugadora de futbol profesional. Laura" +
                            " dedica sus clases a enseñar tacticas dee futbol.")
                    .setBiografia("Jugadora profesional de futbol desde 2010 a 2020.")
                    .setSitioWeb(new URL("https://www.laley.com"))
                    .setPassword("ncnl123")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("prisc")
                    .setNombre("Priscila")
                    .setApellido("Pappo")
                    .setCorreo(Email.of("pripa", "gmail.com"))
                    .setNacimiento(LocalDate.of(1981, 8, 13))
                    .setInstitucion("Olympic")
                    .setDescripcion("Priscila tiene un gran interespor los deportes olimpicos.")
                    .setBiografia(null)
                    .setSitioWeb(new URL("https://www.pi314.net"))
                    .setPassword("mny101")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("dagost")
                    .setNombre("Diana")
                    .setApellido("Agostini")
                    .setCorreo(Email.of("d_1940_ago", "gmail.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/3hB3zvo")))
                    .setNacimiento(LocalDate.of(1940, 3, 5))
                    .setInstitucion("Olympic")
                    .setDescripcion("Profesora dedicada y exigente. No acepta un no puedo como respuesta.")
                    .setBiografia(null)
                    .setSitioWeb(new URL("https://www.dygym.com"))
                    .setPassword("1o1vbm")
                    .invoke();

                facadeUsuario.crearProfesor()
                    .setNickname("aldo")
                    .setNombre("Aldo")
                    .setApellido("Vivaldi")
                    .setCorreo(Email.of("aldo", "outlook.com"))
                    .setImagen(new File(ctx.getRealPath("/img/usuarios/2VLnzUj")))
                    .setNacimiento(LocalDate.of(1952, 7, 17))
                    .setInstitucion("Telon")
                    .setDescripcion("Dada su gran estatura, aldo siempre jugo al basquetbol. Ahora se dedica a enseñarlo.")
                    .setBiografia(null)
                    .setSitioWeb(new URL("https://www.sportsaldo.net"))
                    .setPassword("ultraton01")
                    .invoke();

                Set<String> k1 = new HashSet<>();
                k1.add("Deportes");
                Set<String> k2 = new HashSet<>();
                k2.add("Fitness");
                Set<String> k3 = new HashSet<>();
                k3.add("Gimnasia");
                Set<String> k4 = new HashSet<>();
                k4.add("Gimnasia");
                k4.add("Al aire libre");

                Set<String> k5 = new HashSet<>();
                k5.add("Deportes");
                k5.add("Al aire libre");

                facadeActividad.crearCategoria("Al aire libre");
                facadeActividad.crearCategoria("Deportes");
                facadeActividad.crearCategoria("Fitness");
                facadeActividad.crearCategoria("Gimnasia");

                facadeActividad.crearActividad()
                    .setInstitucion("Fuerza Bruta")
                    .setNombre("Aparatos y pesas")
                    .setDescripcion("Clases de aparatos, pesas y calistenia.")
                    .setDuracion(Duration.ofMinutes(90))
                    .setCosto(550)
                    .setRegistro(LocalDate.of(2021, 3, 31))
                    .setCategorias(k2)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/2XpKBkr")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Telon")
                    .setNombre("Voleibol")
                    .setDescripcion("Voleibol en todas sus formas.")
                    .setDuracion(Duration.ofMinutes(120))
                    .setCosto(750)
                    .setRegistro(LocalDate.of(2021, 4, 20))
                    .setCategorias(k1)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3vqbAbS")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Instituto Natural")
                    .setNombre("Aerobica")
                    .setDescripcion("Para cuidar el aparato cardiovascular.")
                    .setDuracion(Duration.ofMinutes(110))
                    .setCosto(800)
                    .setRegistro(LocalDate.of(2021, 5, 30))
                    .setCategorias(k4)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3ANzEXq")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Fuerza Bruta")
                    .setNombre("Kickboxing")
                    .setDescripcion("En busca del nuevo campeón de boxeo.")
                    .setDuracion(Duration.ofMinutes(100))
                    .setCosto(980)
                    .setRegistro(LocalDate.of(2021, 6, 7))
                    .setCategorias(k1)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3jfuKfN")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Telon")
                    .setNombre("Atletismo")
                    .setDescripcion("100m, 200m, postas y carreras con obstaculos.")
                    .setDuracion(Duration.ofMinutes(150))
                    .setCosto(500)
                    .setRegistro(LocalDate.of(2021, 7, 8))
                    .setCategorias(k1)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3n9Tw2l")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Telon")
                    .setNombre("Basquetbol")
                    .setDescripcion("Basquetbol para todos.")
                    .setDuracion(Duration.ofMinutes(80))
                    .setCosto(450)
                    .setRegistro(LocalDate.of(2021, 7, 31))
                    .setCategorias(k1)
                    .setEstado(ActividadEstado.ACEPTADA)
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Fuerza Bruta")
                    .setNombre("Aparatos II")
                    .setDescripcion("Clases de aparatos avanzadas.")
                    .setDuracion(Duration.ofMinutes(60))
                    .setCosto(1500)
                    .setRegistro(LocalDate.of(2021, 8, 15))
                    .setCategorias(k2)
                    .setEstado(ActividadEstado.RECHAZADA)
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Instituto Natural")
                    .setNombre("Pilates")
                    .setDescripcion("El Método Pilates combina diferentes capacidades físicas.")
                    .setDuracion(Duration.ofMinutes(45))
                    .setCosto(600)
                    .setRegistro(LocalDate.of(2021, 8, 30))
                    .setCategorias(k3)
                    .setEstado(ActividadEstado.INGRESADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3DWa6sW")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Telon")
                    .setNombre("Voleibol II")
                    .setDescripcion("Voleibol avanzado.")
                    .setDuracion(Duration.ofMinutes(120))
                    .setCosto(1000)
                    .setRegistro(LocalDate.of(2021, 9, 1))
                    .setCategorias(k5)
                    .setEstado(ActividadEstado.RECHAZADA)
                    .setImagen(new File(ctx.getRealPath("/img/actividades/3lTd3Ex")))
                    .invoke();

                facadeActividad.crearActividad()
                    .setInstitucion("Telon")
                    .setNombre("Basquetbol II")
                    .setDescripcion("Basquetbol avanzado.")
                    .setDuracion(Duration.ofMinutes(80))
                    .setCosto(600)
                    .setRegistro(LocalDate.of(2021, 9, 7))
                    .setCategorias(k3)
                    .setEstado(ActividadEstado.INGRESADA)
                    .invoke();

                facadeUsuario.seguirUsuario("guille", "Emi71");
                facadeUsuario.seguirUsuario("euge", "caro");
                facadeUsuario.seguirUsuario("guille", "caro");
                facadeUsuario.seguirUsuario("Emi71", "euge");
                facadeUsuario.seguirUsuario("caro", "euge");
                facadeUsuario.seguirUsuario("m1k4", "euge");
                facadeUsuario.seguirUsuario("Emi71", "guille");
                facadeUsuario.seguirUsuario("caro", "guille");
                facadeUsuario.seguirUsuario("euge", "guille");
                facadeUsuario.seguirUsuario("TheBoss", "guille");
                facadeUsuario.seguirUsuario("euge", "sergiop");
                facadeUsuario.seguirUsuario("andy", "sergiop");
                facadeUsuario.seguirUsuario("clazar", "sergiop");
                facadeUsuario.seguirUsuario("caro", "andy");
                facadeUsuario.seguirUsuario("tonyp", "andy");
                facadeUsuario.seguirUsuario("clazar", "andy");
                facadeUsuario.seguirUsuario("caro", "tonyp");
                facadeUsuario.seguirUsuario("m1k4", "tonyp");
                facadeUsuario.seguirUsuario("charly", "tonyp");
                facadeUsuario.seguirUsuario("sergiop", "m1k4");
                facadeUsuario.seguirUsuario("tonyp", "m1k4");
                facadeUsuario.seguirUsuario("tonyp", "charly");
                facadeUsuario.seguirUsuario("Nelson", "charly");
                facadeUsuario.seguirUsuario("tonyp", "viktor");
                facadeUsuario.seguirUsuario("m1k4", "viktor");
                facadeUsuario.seguirUsuario("clazar", "viktor");
                facadeUsuario.seguirUsuario("lale", "viktor");
                facadeUsuario.seguirUsuario("prisc", "viktor");
                facadeUsuario.seguirUsuario("Emi71", "denis");
                facadeUsuario.seguirUsuario("caro", "denis");
                facadeUsuario.seguirUsuario("euge", "denis");
                facadeUsuario.seguirUsuario("guille", "denis");
                facadeUsuario.seguirUsuario("sergiop", "denis");
                facadeUsuario.seguirUsuario("andy", "denis");
                facadeUsuario.seguirUsuario("tonyp", "denis");
                facadeUsuario.seguirUsuario("m1k4", "denis");
                facadeUsuario.seguirUsuario("charly", "denis");
                facadeUsuario.seguirUsuario("caro", "clazar");
                facadeUsuario.seguirUsuario("euge", "clazar");
                facadeUsuario.seguirUsuario("guille", "clazar");
                facadeUsuario.seguirUsuario("TheBoss", "clazar");
                facadeUsuario.seguirUsuario("guille", "TheBoss");
                facadeUsuario.seguirUsuario("andy", "TheBoss");
                facadeUsuario.seguirUsuario("m1k4", "TheBoss");
                facadeUsuario.seguirUsuario("Emi71", "Nelson");
                facadeUsuario.seguirUsuario("andy", "Nelson");
                facadeUsuario.seguirUsuario("tonyp", "Nelson");
                facadeUsuario.seguirUsuario("lale", "Nelson");
                facadeUsuario.seguirUsuario("prisc", "Nelson");
                facadeUsuario.seguirUsuario("dagost", "Nelson");
                facadeUsuario.seguirUsuario("charly", "lale");
                facadeUsuario.seguirUsuario("Nelson", "lale");
                facadeUsuario.seguirUsuario("charly", "prisc");
                facadeUsuario.seguirUsuario("Nelson", "prisc");
                facadeUsuario.seguirUsuario("tonyp", "dagost");
                facadeUsuario.seguirUsuario("charly", "dagost");
                facadeUsuario.seguirUsuario("andy", "aldo");
                facadeUsuario.seguirUsuario("tonyp", "aldo");
                facadeUsuario.seguirUsuario("charly", "aldo");
                facadeUsuario.seguirUsuario("lale", "aldo");
                facadeUsuario.seguirUsuario("prisc", "aldo");
                facadeUsuario.seguirUsuario("dagost", "aldo");

                Set<String> p1 = new HashSet<>();
                p1.add("viktor");

                facadeClase.crearClase()
                    .setNombreActividad("Aparatos y pesas")
                    .setNombre("Calistenia")
                    .setInicio(LocalDateTime.of(2021, 4, 15, 15, 30))
                    .setNicknameProfesores(p1)
                    .setCantMin(1)
                    .setCantMax(5)
                    .setAcceso(new URL("https://www.musculos.com/Calistenia"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3pj6mxJ")))
                    .setFechaRegistro(LocalDate.of(2021, 3, 31))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Aparatos y pesas")
                    .setNombre("Peso libre")
                    .setInicio(LocalDateTime.of(2021, 5, 1, 17, 00))
                    .setNicknameProfesores(p1)
                    .setCantMin(1)
                    .setCantMax(5)
                    .setAcceso(new URL("https://www.musculos.com/pesolibre"))
                    .setFechaRegistro(LocalDate.of(2021, 3, 31))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Aparatos y pesas")
                    .setNombre("Aparatos")
                    .setInicio(LocalDateTime.of(2021, 6, 1, 18, 00))
                    .setNicknameProfesores(p1)
                    .setCantMin(1)
                    .setCantMax(7)
                    .setAcceso(new URL("https://www.musculos.com/aparatos"))
                    .setFechaRegistro(LocalDate.of(2021, 3, 31))
                    .invoke();

                Set<String> p2 = new HashSet<>();
                p2.add("denis");
                facadeClase.crearClase()
                    .setNombreActividad("Voleibol")
                    .setNombre("Voleibol")
                    .setInicio(LocalDateTime.of(2021, 6, 10, 19, 00))
                    .setNicknameProfesores(p2)
                    .setCantMin(10)
                    .setCantMax(21)
                    .setAcceso(new URL("https://telon.com.uy/voley"))
                    .setFechaRegistro(LocalDate.of(2021, 4, 20))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3lTd3Ex")))
                    .invoke();

                Set<String> p3 = new HashSet<>();
                p3.add("Nelson");

                facadeClase.crearClase()
                    .setNombreActividad("Voleibol")
                    .setNombre("Braza")
                    .setInicio(LocalDateTime.of(2021, 7, 10, 20, 00))
                    .setNicknameProfesores(p3)
                    .setCantMin(2)
                    .setCantMax(6)
                    .setAcceso(new URL("https://telon.com.uy/natacionB"))
                    .setFechaRegistro(LocalDate.of(2021, 4, 20))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3lTe1AF")))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Voleibol")
                    .setNombre("Mariposa")
                    .setInicio(LocalDateTime.of(2021, 8, 10, 17, 45))
                    .setNicknameProfesores(p3)
                    .setCantMin(2)
                    .setCantMax(6)
                    .setAcceso(new URL("https://telon.com.uy/natacionM"))
                    .setFechaRegistro(LocalDate.of(2021, 4, 20))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3jeSUam")))
                    .invoke();

                Set<String> p4 = new HashSet<>();
                p4.add("clazar");

                facadeClase.crearClase()
                    .setNombreActividad("Aerobica")
                    .setNombre("Aerobica niños")
                    .setInicio(LocalDateTime.of(2021, 8, 15, 16, 30))
                    .setNicknameProfesores(p4)
                    .setCantMin(5)
                    .setCantMax(10)
                    .setAcceso(new URL("https://www.inatural.com/aeroni"))
                    .setFechaRegistro(LocalDate.of(2021, 5, 30))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Aerobica")
                    .setNombre("Aerobica adulto mayor")
                    .setInicio(LocalDateTime.of(2021, 8, 31, 19, 30))
                    .setNicknameProfesores(p4)
                    .setCantMin(5)
                    .setCantMax(12)
                    .setAcceso(new URL("https://www.inatural.com/aeroam"))
                    .setFechaRegistro(LocalDate.of(2021, 5, 30))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Aerobica")
                    .setNombre("Aerobica")
                    .setInicio(LocalDateTime.of(2021, 9, 30, 20, 00))
                    .setNicknameProfesores(p4)
                    .setCantMin(5)
                    .setCantMax(20)
                    .setAcceso(new URL("https://www.inatural.com/aerogral"))
                    .setFechaRegistro(LocalDate.of(2021, 5, 30))
                    .invoke();

                Set<String> p5 = new HashSet<>();
                p5.add("clazar");

                facadeClase.crearClase()
                    .setNombreActividad("Kickboxing")
                    .setNombre("Boxeo I")
                    .setInicio(LocalDateTime.of(2021, 9, 1, 19, 30))
                    .setNicknameProfesores(p5)
                    .setCantMin(1)
                    .setCantMax(4)
                    .setAcceso(new URL("https://www.musculos.com/boxeo1"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3aPbRM9")))
                    .setFechaRegistro(LocalDate.of(2021, 6, 7))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Kickboxing")
                    .setNombre("Boxeo II")
                    .setInicio(LocalDateTime.of(2021, 9, 30, 17, 00))
                    .setNicknameProfesores(p5)
                    .setCantMin(2)
                    .setCantMax(2)
                    .setAcceso(new URL("https://www.musculos.com/boxeo2"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3n9UOKJ")))
                    .setFechaRegistro(LocalDate.of(2021, 6, 7))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Kickboxing")
                    .setNombre("Musculos para boxeo")
                    .setInicio(LocalDateTime.of(2021, 10, 15, 20, 00))
                    .setNicknameProfesores(p1)
                    .setCantMin(1)
                    .setCantMax(5)
                    .setAcceso(new URL("https://www.musculos.com/muscbox"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3n9UOKJ")))
                    .setFechaRegistro(LocalDate.of(2021, 6, 7))
                    .invoke();

                Set<String> p6 = new HashSet<>();
                p6.add("lale");

                facadeClase.crearClase()
                    .setNombreActividad("Atletismo")
                    .setNombre("100 M")
                    .setInicio(LocalDateTime.of(2021, 9, 25, 19, 00))
                    .setNicknameProfesores(p6)
                    .setCantMin(3)
                    .setCantMax(10)
                    .setAcceso(new URL("https://telon.com.uy/100m"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3aRuy1Y")))
                    .setFechaRegistro(LocalDate.of(2021, 7, 8))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Atletismo")
                    .setNombre("200 M")
                    .setInicio(LocalDateTime.of(2021, 10, 25, 18, 30))
                    .setNicknameProfesores(p6)
                    .setCantMin(3)
                    .setCantMax(10)
                    .setAcceso(new URL("https://telon.com.uy/200m"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3aRuy1Y")))
                    .setFechaRegistro(LocalDate.of(2021, 7, 8))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Atletismo")
                    .setNombre("Posta")
                    .setInicio(LocalDateTime.of(2021, 11, 25, 17, 45))
                    .setNicknameProfesores(p6)
                    .setCantMin(8)
                    .setCantMax(16)
                    .setAcceso(new URL("https://telon.com.uy/posta"))
                    .setImagen(new File(ctx.getRealPath("/img/clases/3DTD3S")))
                    .setFechaRegistro(LocalDate.of(2021, 7, 8))
                    .invoke();

                Set<String> p7 = new HashSet<>();
                p7.add("aldo");

                facadeClase.crearClase()
                    .setNombreActividad("Basquetbol")
                    .setNombre("Basquet I")
                    .setInicio(LocalDateTime.of(2021, 9, 1, 21, 00))
                    .setNicknameProfesores(p7)
                    .setCantMin(10)
                    .setCantMax(15)
                    .setAcceso(new URL("https://telon.com.uy/bball1"))
                    .setFechaRegistro(LocalDate.of(2021, 7, 31))
                    .invoke();

                facadeClase.crearClase()
                    .setNombreActividad("Basquetbol")
                    .setNombre("Basquet II")
                    .setInicio(LocalDateTime.of(2021, 9, 10, 21, 00))
                    .setNicknameProfesores(p7)
                    .setCantMin(10)
                    .setCantMax(15)
                    .setAcceso(new URL("https://telon.com.uy/bball2"))
                    .setFechaRegistro(LocalDate.of(2021, 7, 31))
                    .invoke();

                facadeActividad.registarseSinCuponera("caro", "Calistenia", LocalDate.of(2021, 4, 9));
                facadeActividad.registarseSinCuponera("sergiop", "Calistenia", LocalDate.of(2021, 4, 10));
                facadeActividad.registarseSinCuponera("andy", "Calistenia", LocalDate.of(2021, 4, 12));
                facadeActividad.registarseSinCuponera("andy", "Peso libre", LocalDate.of(2021, 4, 15));
                facadeActividad.registarseSinCuponera("tonyp", "Peso libre", LocalDate.of(2021, 4, 20));
                facadeActividad.registarseSinCuponera("caro", "Peso libre", LocalDate.of(2021, 4, 25));
                facadeActividad.registarseSinCuponera("m1k4", "Peso libre", LocalDate.of(2021, 4, 28));
                facadeActividad.registarseSinCuponera("charly", "Aparatos", LocalDate.of(2021, 4, 16));
                facadeActividad.registarseSinCuponera("caro", "Aparatos", LocalDate.of(2021, 5, 15));
                facadeActividad.registarseSinCuponera("m1k4", "Aparatos", LocalDate.of(2021, 5, 20));
                facadeActividad.registarseSinCuponera("Emi71", "Voleibol", LocalDate.of(2021, 5, 5));
                facadeActividad.registarseSinCuponera("euge", "Voleibol", LocalDate.of(2021, 5, 10));
                facadeActividad.registarseSinCuponera("sergiop", "Voleibol", LocalDate.of(2021, 5, 15));
                facadeActividad.registarseSinCuponera("tonyp", "Voleibol", LocalDate.of(2021, 5, 20));
                facadeActividad.registarseSinCuponera("guille", "Braza", LocalDate.of(2021, 6, 8));
                facadeActividad.registarseSinCuponera("euge", "Braza", LocalDate.of(2021, 6, 13));
                facadeActividad.registarseSinCuponera("m1k4", "Braza", LocalDate.of(2021, 6, 25));
                facadeActividad.registarseSinCuponera("charly", "Mariposa", LocalDate.of(2021, 7, 5));
                facadeActividad.registarseSinCuponera("sergiop", "Mariposa", LocalDate.of(2021, 7, 11));
                facadeActividad.registarseSinCuponera("andy", "Mariposa", LocalDate.of(2021, 7, 18));
                facadeActividad.registarseSinCuponera("m1k4", "Aerobica niños", LocalDate.of(2021, 7, 19));
                facadeActividad.registarseSinCuponera("Emi71", "Aerobica adulto mayor", LocalDate.of(2021, 8, 17));
                facadeActividad.registarseSinCuponera("guille", "Aerobica adulto mayor", LocalDate.of(2021, 8, 20));
                facadeActividad.registarseSinCuponera("andy", "Aerobica adulto mayor", LocalDate.of(2021, 8, 23));
                facadeActividad.registarseSinCuponera("caro", "Aerobica", LocalDate.of(2021, 8, 15));
                facadeActividad.registarseSinCuponera("euge", "Aerobica", LocalDate.of(2021, 8, 26));
                facadeActividad.registarseSinCuponera("andy", "Boxeo I", LocalDate.of(2021, 7, 19));
                facadeActividad.registarseSinCuponera("tonyp", "Boxeo I", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("m1k4", "Boxeo I", LocalDate.of(2021, 8, 24));
                facadeActividad.registarseSinCuponera("sergiop", "Boxeo II", LocalDate.of(2021, 8, 1));
                facadeActividad.registarseSinCuponera("guille", "Boxeo II", LocalDate.of(2021, 8, 30));
                facadeActividad.registarseSinCuponera("Emi71", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("caro", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("euge", "Musculos para boxeo", LocalDate.of(2021, 9, 1));
                facadeActividad.registarseSinCuponera("sergiop", "Musculos para boxeo", LocalDate.of(2021, 9, 5));
                facadeActividad.registarseSinCuponera("guille", "100 M", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("charly", "100 M", LocalDate.of(2021, 9, 3));
                facadeActividad.registarseSinCuponera("Emi71", "200 M", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("charly", "200 M", LocalDate.of(2021, 9, 6));
                facadeActividad.registarseSinCuponera("caro", "Posta", LocalDate.of(2021, 9, 1));
                facadeActividad.registarseSinCuponera("sergiop", "Basquet I", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("Emi71", "Basquet I", LocalDate.of(2021, 8, 20));
                facadeActividad.registarseSinCuponera("tonyp", "Basquet I", LocalDate.of(2021, 8, 31));
                facadeActividad.registarseSinCuponera("andy", "Basquet II", LocalDate.of(2021, 8, 16));
                facadeActividad.registarseSinCuponera("tonyp", "Basquet II", LocalDate.of(2021, 8, 20));
                facadeActividad.registarseSinCuponera("caro", "Basquet II", LocalDate.of(2021, 9, 2));

                facadeCuponera.crearCuponera()
                    .setNombre("Pelota")
                    .setDescripcion("Deportes con pelota.")
                    .setInicio(LocalDate.of(2021, 5, 1))
                    .setFin(LocalDate.of(2021, 7, 31))
                    .setDescuento(20)
                    .setFechaRegistro(LocalDate.of(2021, 4, 30))
                    .setImagen(new File(ctx.getRealPath("/img/cuponeras/3lUCYvu")))
                    .invoke();

                facadeCuponera.crearCuponera()
                    .setNombre("Gimnasia")
                    .setDescripcion("Aerobica y aparatos.")
                    .setInicio(LocalDate.of(2021, 8, 1))
                    .setFin(LocalDate.of(2021, 9, 30))
                    .setDescuento(30)
                    .setFechaRegistro(LocalDate.of(2021, 7, 15))
                    .setImagen(new File(ctx.getRealPath("/img/cuponeras/3aO80yO")))
                    .invoke();

                facadeCuponera.crearCuponera()
                    .setNombre("Musculos")
                    .setDescripcion("Pesas.")
                    .setInicio(LocalDate.of(2021, 8, 15))
                    .setFin(LocalDate.of(2021, 11, 15))
                    .setDescuento(10)
                    .setFechaRegistro(LocalDate.of(2021, 8, 1))
                    .setImagen(new File(ctx.getRealPath("/img/cuponeras/3pj6mxJ")))
                    .invoke();

                facadeCuponera.agregarACuponera("Pelota", "Voleibol", 7);
                facadeCuponera.agregarACuponera("Pelota", "Basquetbol", 18);
                facadeCuponera.agregarACuponera("Gimnasia", "Aerobica", 2);
                facadeCuponera.agregarACuponera("Gimnasia", "Aparatos y pesas", 8);
                facadeCuponera.agregarACuponera("Musculos", "Kickboxing", 11);
                facadeCuponera.agregarACuponera("Musculos", "Aparatos y pesas", 12);

                facadeCuponera.comprarCuponera("guille", "Pelota");
                facadeCuponera.comprarCuponera("m1k4", "Gimnasia");
                facadeCuponera.comprarCuponera("caro", "Gimnasia");
                facadeCuponera.comprarCuponera("sergiop", "Musculos");
                facadeCuponera.comprarCuponera("andy", "Musculos");
                facadeCuponera.comprarCuponera("Emi71", "Pelota");
            } catch (Exception e) {
                e.printStackTrace(response.getWriter());
                return;
            }
            getServletContext().setAttribute("cargado", true);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
