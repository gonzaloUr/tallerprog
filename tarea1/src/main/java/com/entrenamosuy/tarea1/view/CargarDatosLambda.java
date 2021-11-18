package com.entrenamosuy.tarea1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeClase;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeInstitucion;
import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.model.ActividadEstado;
import com.entrenamosuy.core.util.FacadeContainer;

public class CargarDatosLambda implements ActionListener {

    private final AbstractFacadeActividad facadeActividad;
    private final AbstractFacadeClase facadeClase;
    private final AbstractFacadeCuponera facadeCuponera;
    private final AbstractFacadeInstitucion facadeInstitucion;
    private final AbstractFacadeUsuario facadeUsuario;
    private final Callback callback;

    public CargarDatosLambda(FacadeContainer facades, Callback callback) {
        this.facadeActividad = facades.getFacadeActividad();
        this.facadeClase = facades.getFacadeClase();
        this.facadeCuponera = facades.getFacadeCuponera();
        this.facadeInstitucion = facades.getFacadeInstitucion();
        this.facadeUsuario = facades.getFacadeUsuario();
        this.callback = callback;
    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    private static File resourceToFile(String path) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        File tmp = null;

        try {
            tmp = File.createTempFile("img_", null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream os = null;

        try {
            os = new FileOutputStream(tmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            pipe(is, os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmp;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {

            facadeUsuario.crearSocio()
                .setNickname("Emi71")
                .setNombre("Emiliano")
                .setApellido("Lucas")
                .setCorreo(Email.of("emi71", "gmail.com"))
                .setNacimiento(LocalDate.of(1971, 12, 31))
                .setPassword("asdfg456")
                .setImagen(resourceToFile("img/usuarios/3lxoBvZ"))
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("caro")
                .setNombre("Carolina")
                .setApellido("Omega")
                .setCorreo(Email.of("caro", "gmail.com"))
                .setNacimiento(LocalDate.of(1983, 11, 15))
                .setPassword("123rtgfdv")
                .setImagen(resourceToFile("img/usuarios/3AfcJER"))
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("euge")
                .setNombre("Eugenia")
                .setApellido("Williams")
                .setCorreo(Email.of("e.will", "gmail.com"))
                .setNacimiento(LocalDate.of(1990, 4, 15))
                .setImagen(resourceToFile("img/usuarios/3Afz59x"))
                .setPassword("poiuy086")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("guille")
                .setNombre("Guillermo")
                .setApellido("Hector")
                .setCorreo(Email.of("ghector", "gmail.com"))
                .setNacimiento(LocalDate.of(1959, 5, 15))
                .setImagen(resourceToFile("img/usuarios/2XkrKH9"))
                .setPassword("GTO468")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("sergiop")
                .setNombre("Sergio")
                .setApellido("Perez")
                .setCorreo(Email.of("sergi", "gmail.com.uy"))
                .setNacimiento(LocalDate.of(1950, 1, 28))
                .setImagen(resourceToFile("img/usuarios/3ElkVG2"))
                .setPassword("HGF135")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("andy")
                .setNombre("Andres")
                .setApellido("Roman")
                .setCorreo(Email.of("chino", "gmail.org.uy"))
                .setNacimiento(LocalDate.of(1976, 3, 17))
                .setImagen(resourceToFile("img/usuarios/3hDWgTD"))
                .setPassword("lkj65D")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("tonyp")
                .setNombre("Antonio")
                .setApellido("Paz")
                .setCorreo(Email.of("eltony", "gmail.org.uy"))
                .setNacimiento(LocalDate.of(1955, 2, 14))
                .setImagen(resourceToFile("img/usuarios/3Ai4jMW"))
                .setPassword("jhvf395")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("m1k4")
                .setNombre("Micaela")
                .setApellido("Lopez")
                .setCorreo(Email.of("mika", "gmail.com.ar"))
                .setNacimiento(LocalDate.of(1987, 2, 23))
                .setImagen(resourceToFile("img/usuarios/3zglsWf"))
                .setPassword("ijngr024")
                .invoke();

            facadeUsuario.crearSocio()
                .setNickname("charly")
                .setNombre("Carlos")
                .setApellido("Boston")
                .setCorreo(Email.of("charly", "gmail.com.uy"))
                .setNacimiento(LocalDate.of(1937, 3, 8))
                .setImagen(resourceToFile("img/usuarios/2YRWDTQ"))
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
                .setImagen(resourceToFile("img/usuarios/3zetdMl"))
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
                .setImagen(resourceToFile("img/usuarios/3lKq8Px"))
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
                .setImagen(resourceToFile("img/usuarios/2VJvT6S"))
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
                .setImagen(resourceToFile("img/usuarios/3kdT9TV"))
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
                .setImagen(resourceToFile("img/usuarios/3lxsDo7"))
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
                .setImagen(resourceToFile("img/usuarios/3EmlY8F"))
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
                .setImagen(resourceToFile("img/usuarios/3hB3zvo"))
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
                .setImagen(resourceToFile("img/usuarios/2VLnzUj"))
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
                .setImagen(resourceToFile("img/actividades/2XpKBkr"))
                .setCreador("viktor")
                .invoke();

            facadeActividad.crearActividad()
                .setInstitucion("Telon")
                .setNombre("Voleibol")
                .setDescripcion("Voleibol en todas sus formas.")
                .setDuracion(Duration.ofMinutes(120))
                .setCosto(750)
                .setRegistro(LocalDate.of(2021, 4, 20))
                .setCategorias(k1)
                .setEstado(ActividadEstado.FINALIZADA)
                .setImagen(resourceToFile("img/actividades/3vqbAbS"))
                .setCreador("denis")
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
                .setImagen(resourceToFile("img/actividades/3ANzEXq"))
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
                .setImagen(resourceToFile("img/actividades/3jfuKfN"))
                .setCreador("TheBoss")
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
                .setImagen(resourceToFile("img/actividades/3n9Tw2l"))
                .setCreador("denis")
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
                .setCreador("Nelson")
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
                .setImagen(resourceToFile("img/actividades/3DWa6sW"))
                .setCreador("clazar")
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
                .setImagen(resourceToFile("img/actividades/3lTd3Ex"))
                .setCreador("denis")
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
                .setCreador("denis")
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
                .setImagen(resourceToFile("img/clases/3pj6mxJ"))
                .setFechaRegistro(LocalDate.of(2021, 3, 31))
                .setCantPremios(0) 
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
                .setCantPremios(0)
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
                .setCantPremios(3)
                .setPremio("Rueda de Abdominales")
                .setFechaSorteo(LocalDate.of(2021,6,2))
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
                .setImagen(resourceToFile("img/clases/3lTd3Ex"))
                .setCantPremios(0)
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
                .setImagen(resourceToFile("img/clases/3lTe1AF"))
                .setCantPremios(0)
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
                .setImagen(resourceToFile("img/clases/3jeSUam"))
                .setCantPremios(2)
                .setPremio("lentes natacion")
                .setFechaSorteo(LocalDate.of(2021, 8, 11))
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
                .setCantPremios(3)
                .setPremio("caramañola infantil")
                .setFechaSorteo(LocalDate.of(2021, 8, 16))
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
                .setCantPremios(0)
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
                .setCantPremios(2)
                .setPremio("caramañola")
                .setFechaSorteo(LocalDate.of(2021,10,1))
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
                .setImagen(resourceToFile("img/clases/3aPbRM9"))
                .setFechaRegistro(LocalDate.of(2021, 6, 7))
                .setCantPremios(0)
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Kickboxing")
                .setNombre("Boxeo II")
                .setInicio(LocalDateTime.of(2021, 9, 30, 17, 00))
                .setNicknameProfesores(p5)
                .setCantMin(2)
                .setCantMax(2)
                .setAcceso(new URL("https://www.musculos.com/boxeo2"))
                .setImagen(resourceToFile("img/clases/3n9UOKJ"))
                .setFechaRegistro(LocalDate.of(2021, 6, 7))
                .setCantPremios(2)
                .setPremio("guantillas")
                .setFechaSorteo(LocalDate.of(2021,10,1))
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Kickboxing")
                .setNombre("Musculos para boxeo")
                .setInicio(LocalDateTime.of(2021, 10, 15, 20, 00))
                .setNicknameProfesores(p1)
                .setCantMin(1)
                .setCantMax(5)
                .setAcceso(new URL("https://www.musculos.com/muscbox"))
                .setImagen(resourceToFile("img/clases/3n9UOKJ"))
                .setFechaRegistro(LocalDate.of(2021, 6, 7))
                .setCantPremios(0)
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
                .setImagen(resourceToFile("img/clases/3aRuy1Y"))
                .setFechaRegistro(LocalDate.of(2021, 7, 8))
                .setCantPremios(0)
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Atletismo")
                .setNombre("200 M")
                .setInicio(LocalDateTime.of(2021, 11, 5, 18, 30))
                .setNicknameProfesores(p6)
                .setCantMin(3)
                .setCantMax(10)
                .setAcceso(new URL("https://telon.com.uy/200m"))
                .setImagen(resourceToFile("img/clases/3aRuy1Y"))
                .setFechaRegistro(LocalDate.of(2021, 7, 8))
                .setCantPremios(0)
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Atletismo")
                .setNombre("Posta")
                .setInicio(LocalDateTime.of(2021, 11, 29, 17, 45))
                .setNicknameProfesores(p6)
                .setCantMin(8)
                .setCantMax(16)
                .setAcceso(new URL("https://telon.com.uy/posta"))
                .setImagen(resourceToFile("img/clases/3DTDm3S"))
                .setFechaRegistro(LocalDate.of(2021, 7, 8))
                .setCantPremios(0)
                .invoke();

            Set<String> p7 = new HashSet<>();
            p7.add("aldo");

            facadeClase.crearClase()
                .setNombreActividad("Basquetbol")
                .setNombre("Basquet I")
                .setInicio(LocalDateTime.of(2021, 11, 3, 21, 00))
                .setNicknameProfesores(p7)
                .setCantMin(10)
                .setCantMax(15)
                .setAcceso(new URL("https://telon.com.uy/bball1"))
                .setFechaRegistro(LocalDate.of(2021, 7, 31))
                .setCantPremios(0)
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Basquetbol")
                .setNombre("Basquet II")
                .setInicio(LocalDateTime.of(2021, 11, 27, 21, 00))
                .setNicknameProfesores(p7)
                .setCantMin(10)
                .setCantMax(10)
                .setAcceso(new URL("https://telon.com.uy/bball2"))
                .setFechaRegistro(LocalDate.of(2021, 7, 31))
                .setCantPremios(5)
                .setPremio("juego de muñequeras")
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Aparatos y pesas")
                .setNombre("Aparatos II")
                .setInicio(LocalDateTime.of(2021, 11, 30, 20, 00))
                .setNicknameProfesores(p1)
                .setCantMin(1)
                .setCantMax(5)
                .setAcceso(new URL("https://www.musculos.com/aparatos"))
                .setFechaRegistro(LocalDate.of(2021, 11, 15))
                .setCantPremios(2)
                .setPremio("pesa rusa 5K")
                .invoke();

            facadeClase.crearClase()
                .setNombreActividad("Kickboxing")
                .setNombre("Boxeo III")
                .setInicio(LocalDateTime.of(2021, 12, 1, 19, 00))
                .setNicknameProfesores(p5)
                .setCantMin(2)
                .setCantMax(6)
                .setAcceso(new URL("https://www.musculos.com/boxeo2"))
                .setImagen(resourceToFile("img/clases/3n9UOKJ"))
                .setFechaRegistro(LocalDate.of(2021, 11, 10))
                .setCantPremios(2)
                .setPremio("guantillas")
                .invoke();

            facadeActividad.registrarseSinCuponera("caro", "Calistenia", LocalDate.of(2021, 4, 9));
            facadeActividad.registrarseSinCuponera("sergiop", "Calistenia", LocalDate.of(2021, 4, 10));
            facadeActividad.registrarseSinCuponera("andy", "Calistenia", LocalDate.of(2021, 4, 12));
            facadeActividad.registrarseSinCuponera("andy", "Peso libre", LocalDate.of(2021, 4, 15));
            facadeActividad.registrarseSinCuponera("tonyp", "Peso libre", LocalDate.of(2021, 4, 20));
            facadeActividad.registrarseSinCuponera("caro", "Peso libre", LocalDate.of(2021, 4, 25));
            facadeActividad.registrarseSinCuponera("m1k4", "Peso libre", LocalDate.of(2021, 4, 28));
            facadeActividad.registrarseSinCuponera("charly", "Aparatos", LocalDate.of(2021, 4, 16));
            facadeActividad.registrarseSinCuponera("caro", "Aparatos", LocalDate.of(2021, 5, 15));
            facadeActividad.registrarseSinCuponera("m1k4", "Aparatos", LocalDate.of(2021, 5, 20));
            facadeActividad.registrarseSinCuponera("Emi71", "Voleibol", LocalDate.of(2021, 5, 5));
            facadeActividad.registrarseSinCuponera("euge", "Voleibol", LocalDate.of(2021, 5, 10));
            facadeActividad.registrarseSinCuponera("sergiop", "Voleibol", LocalDate.of(2021, 5, 15));
            facadeActividad.registrarseSinCuponera("tonyp", "Voleibol", LocalDate.of(2021, 5, 20));
            facadeActividad.registrarseSinCuponera("guille", "Braza", LocalDate.of(2021, 6, 8));
            facadeActividad.registrarseSinCuponera("euge", "Braza", LocalDate.of(2021, 6, 13));
            facadeActividad.registrarseSinCuponera("m1k4", "Braza", LocalDate.of(2021, 6, 25));
            facadeActividad.registrarseSinCuponera("charly", "Mariposa", LocalDate.of(2021, 7, 5));
            facadeActividad.registrarseSinCuponera("sergiop", "Mariposa", LocalDate.of(2021, 7, 11));
            facadeActividad.registrarseSinCuponera("andy", "Mariposa", LocalDate.of(2021, 7, 18));
            //facadeActividad.registrarseSinCuponera("m1k4", "Aerobica niños", LocalDate.of(2021, 7, 19));
            facadeActividad.registrarseSinCuponera("Emi71", "Aerobica adulto mayor", LocalDate.of(2021, 8, 17));
            facadeActividad.registrarseSinCuponera("guille", "Aerobica adulto mayor", LocalDate.of(2021, 8, 20));
            facadeActividad.registrarseSinCuponera("andy", "Aerobica adulto mayor", LocalDate.of(2021, 8, 23));
            //facadeActividad.registrarseSinCuponera("caro", "Aerobica", LocalDate.of(2021, 8, 15));
            facadeActividad.registrarseSinCuponera("euge", "Aerobica", LocalDate.of(2021, 8, 26));
            //facadeActividad.registrarseSinCuponera("andy", "Boxeo I", LocalDate.of(2021, 7, 19));
            facadeActividad.registrarseSinCuponera("tonyp", "Boxeo I", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("m1k4", "Boxeo I", LocalDate.of(2021, 8, 24));
            //facadeActividad.registrarseSinCuponera("sergiop", "Boxeo II", LocalDate.of(2021, 8, 1));
            facadeActividad.registrarseSinCuponera("guille", "Boxeo II", LocalDate.of(2021, 8, 30));
            facadeActividad.registrarseSinCuponera("Emi71", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("caro", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("euge", "Musculos para boxeo", LocalDate.of(2021, 9, 1));
            facadeActividad.registrarseSinCuponera("sergiop", "Musculos para boxeo", LocalDate.of(2021, 9, 5));
            facadeActividad.registrarseSinCuponera("guille", "100 M", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("charly", "100 M", LocalDate.of(2021, 9, 3));
            facadeActividad.registrarseSinCuponera("Emi71", "200 M", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("charly", "200 M", LocalDate.of(2021, 9, 6));
            //facadeActividad.registrarseSinCuponera("caro", "Posta", LocalDate.of(2021, 9, 1));
            facadeActividad.registrarseSinCuponera("sergiop", "Basquet I", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("Emi71", "Basquet I", LocalDate.of(2021, 8, 20));
            facadeActividad.registrarseSinCuponera("tonyp", "Basquet I", LocalDate.of(2021, 8, 31));
            facadeActividad.registrarseSinCuponera("andy", "Basquet II", LocalDate.of(2021, 8, 16));
            facadeActividad.registrarseSinCuponera("tonyp", "Basquet II", LocalDate.of(2021, 8, 20));
            facadeActividad.registrarseSinCuponera("caro", "Basquet II", LocalDate.of(2021, 9, 2));

            facadeCuponera.crearCuponera()
                .setNombre("Pelota")
                .setDescripcion("Deportes con pelota.")
                .setInicio(LocalDate.of(2021, 5, 1))
                .setFin(LocalDate.of(2021, 7, 31))
                .setDescuento(20)
                .setFechaRegistro(LocalDate.of(2021, 4, 30))
                .setImagen(resourceToFile("img/cuponeras/3lUCYvu"))
                .invoke();

            facadeCuponera.crearCuponera()
                .setNombre("Gimnasia")
                .setDescripcion("Aerobica y aparatos.")
                .setInicio(LocalDate.of(2021, 8, 1))
                .setFin(LocalDate.of(2021, 9, 30))
                .setDescuento(30)
                .setFechaRegistro(LocalDate.of(2021, 7, 15))
                .setImagen(resourceToFile("img/cuponeras/3aO80yO"))
                .invoke();

            facadeCuponera.crearCuponera()
                .setNombre("Musculos")
                .setDescripcion("Pesas.")
                .setInicio(LocalDate.of(2021, 8, 15))
                .setFin(LocalDate.of(2021, 12, 15))
                .setDescuento(10)
                .setFechaRegistro(LocalDate.of(2021, 7, 18))
                .setImagen(resourceToFile("img/cuponeras/3pj6mxJ"))
                .invoke();

            facadeCuponera.crearCuponera()
                .setNombre("Pista")
                .setDescripcion("Entrenamiento de Atletismo")
                .setInicio(LocalDate.of(2021, 10, 1))
                .setFin(LocalDate.of(2021, 12, 31))
                .setDescuento(15)
                .setFechaRegistro(LocalDate.of(2021, 9, 1))
                .setImagen(resourceToFile("img/cuponeras/3c76d8L")) //agregar file
                .invoke();


            facadeCuponera.agregarACuponera("Pelota", "Voleibol", 7);
            facadeCuponera.agregarACuponera("Pelota", "Basquetbol", 18);
            facadeCuponera.agregarACuponera("Gimnasia", "Aerobica", 2);
            facadeCuponera.agregarACuponera("Gimnasia", "Aparatos y pesas", 8);
            facadeCuponera.agregarACuponera("Musculos", "Kickboxing", 11);
            facadeCuponera.agregarACuponera("Musculos", "Aparatos y pesas", 12);
            facadeCuponera.agregarACuponera("Pista", "Atletismo", 20);

            facadeCuponera.comprarCuponera("guille", "Pelota");
            facadeCuponera.comprarCuponera("m1k4", "Gimnasia");
            facadeCuponera.comprarCuponera("caro", "Gimnasia");
            facadeCuponera.comprarCuponera("sergiop", "Musculos");
            facadeCuponera.comprarCuponera("andy", "Musculos");
            facadeCuponera.comprarCuponera("Emi71", "Pelota");
            facadeCuponera.comprarCuponera("caro", "Pista");

            facadeActividad.registrarseConCuponera("m1k4", "Aerobica niños", "Gimnasia", LocalDate.of(2021, 7, 19));
            facadeActividad.registrarseConCuponera("caro", "Aerobica", "Gimnasia", LocalDate.of(2021, 8, 15));
            facadeActividad.registrarseConCuponera("andy", "Boxeo I", "Musculos", LocalDate.of(2021, 7, 19));
            facadeActividad.registrarseConCuponera("sergiop", "Boxeo II", "Musculos", LocalDate.of(2021, 8, 1));
            facadeActividad.registrarseConCuponera("caro", "Posta", "Pista", LocalDate.of(2021, 9, 1));

        } catch (Exception e) {
            e.printStackTrace();
        }

        callback.finished();
    }

    public interface Callback {

        void finished();
    }
}
