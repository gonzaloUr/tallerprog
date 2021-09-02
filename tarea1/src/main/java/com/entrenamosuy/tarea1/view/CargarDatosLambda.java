package com.entrenamosuy.tarea1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.logic.IControladorActividadClase;
import com.entrenamosuy.tarea1.logic.IControladorCuponera;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;

public class CargarDatosLambda implements ActionListener {

    public interface Callback {

        void finished();
    }

    private final IControladorUsuario CU;

    private final IControladorActividadClase CAC;

    private final IControladorCuponera CC;

    private final Callback callback;

    public CargarDatosLambda(IControladorUsuario controladorUsuario,
                             IControladorActividadClase controladorActividadClase, IControladorCuponera controladorCuponera,
                             Callback callback) {
        this.CU = controladorUsuario;
        this.CAC = controladorActividadClase;
        this.CC = controladorCuponera;
        this.callback = callback;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            CU.crearSocio("Emi71", "Emiliano", "Lucas", Email.of("emi71", "gmail.com"), LocalDate.of(1971, 12, 31));
            CU.crearSocio("caro", "Carolina", "Omega", Email.of("caro", "gmail.com"), LocalDate.of(1983, 11, 15));
            CU.crearSocio("euge", "Eugenia", "Williams", Email.of("e.will", "gmail.com"), LocalDate.of(1990, 4, 15));
            CU.crearSocio("guille", "Guillermo", "Hector", Email.of("ghector", "gmail.com"), LocalDate.of(1959, 5, 15));
            CU.crearSocio("sergiop", "Sergio", "Perez", Email.of("sergi", "gmail.uy"), LocalDate.of(1950, 1, 28));
            CU.crearSocio("andy", "Andres", "Roman", Email.of("chino", "gmail.uy"), LocalDate.of(1976, 3, 17));
            CU.crearSocio("tonyp", "Antonio", "Paz", Email.of("eltony", "gmail.uy"), LocalDate.of(1955, 2, 14));
            CU.crearSocio("m1k4", "Micaela", "Lopez", Email.of("mika", "gmail.ar"), LocalDate.of(1987, 2, 23));
            CU.crearSocio("charly", "Carlos", "Boston", Email.of("emi71", "gmail.uy"), LocalDate.of(1937, 3, 8));

            CAC.crearInstitucion("Instituto Natural", "Clases de gimnasia aerobica, spinning y yoga.", new URL("https://www.inatural.com"));
            CAC.crearInstitucion("Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.", new URL("https://www.musculos.com/"));
            CAC.crearInstitucion("Telon", "Actividades deportivas para todas la edades.", new URL("https://telon.com.uy"));
            CAC.crearInstitucion("Olympic", "Gimnasia y aparatos.", new URL("https://www.olympic21.com/"));

            CU.crearProfesor("viktor", "Victor", "Perez", Email.of("vperez", "fuerza.com"), LocalDate.of(1977, 1, 1), "Fuerza Bruta", "Victor es un apasionado de los musculos. Sus clases son organizadas en funcion de distintos aparatos y pesas con el objetivo de desarrollar los musculos.", "Victor nacio en Moscow en 1977. En el año 2005 emigro a Uruguay luego de quedar encantado con el pais en un viaje turistico.", new URL("https://www.vikgym.com"));
            CU.crearProfesor("denis", "Denis", "Miguel", Email.of("den80", "fuerza.com"), LocalDate.of(1980, 6, 14), "Telon", "A Denis le interesan los deportes con pelota, principalmente el voleibol y el hanball.", "Denis fue un jugador de voleibol profesional.", new URL("https://www.depecho.com"));
            CU.crearProfesor("clazar", "Carlos", "Lazaro", Email.of("claz4r0", "hotmail.com"), LocalDate.of(1953, 6, 22), "Instituto Natural", "Carlos es un profesor muy divertido, cuyas clases de aerobica estan cargadas de energia.", "El interes por la actividad fisica llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.", new URL("https://www.enforma.com"));
            CU.crearProfesor("TheBoss", "Bruno", "Sosa", Email.of("bruceTheBoss", "gmail.com"), LocalDate.of(1949, 9, 23), "Fuerza Bruta", "Bruno es un ex-boxeador que busca entrenar futuros campeones.", "Bruno, mejor conocido como Bruce en el ring, compitio como boxeador entre los años 60s y 70s.", new URL("https://www.bruce.net"));
            CU.crearProfesor("Nelson", "Luis", "Nelson", Email.of("nelson", "hotmail.com"), LocalDate.of(1998, 1, 1), "Telon", "Profesor de natacion, especializado en braza y mariposa.", null, null);
            CU.crearProfesor("lale", "Laura", "Leyes", Email.of("la_le", "outlook.com"), LocalDate.of(1987, 2, 14), "Telon", "Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a enseñar tacticas dee futbol.", "Jugadora profesional de futbol desde 2010 a 2020.", new URL("https://www.laley.com"));
            CU.crearProfesor("prisc", "Priscila", "Pappo", Email.of("pripa", "gmail.com"), LocalDate.of(1981, 8, 13), "Olympic", "Priscila tiene un gran interespor los deportes olimpicos.", null, new URL("https://www.pi314.net"));
            CU.crearProfesor("dagost", "Diana", "Agostini", Email.of("d_1940_ago", "gmail.com"), LocalDate.of(1940, 3, 5), "Olympic", "Profesora dedicada y exigente. No acepta un no puedo como respuesta.", null, new URL("https://www.dygym.com"));
            CU.crearProfesor("aldo", "Aldo", "Vivaldi", Email.of("aldo", "outlook.com"), LocalDate.of(1952, 7, 17), "Telon", "Dada su gran estatura, aldo siempre jugo al basquetbol. Ahora se dedica a enseñarlo.", null, new URL("https://www.sportsaldo.net"));

            CAC.crearActividad("Fuerza Bruta", "Aparatos y pesas", "Clases de aparatos, pesas y calistenia.", Duration.ofMinutes(90), 550, LocalDate.of(2021, 3, 31));
            CAC.crearActividad("Telon", "Voleibol", "Voleibol en todas sus formas.", Duration.ofMinutes(120), 750, LocalDate.of(2021, 4, 20));
            CAC.crearActividad("Instituto Natural", "Aerobica", "Para cuidar el aparato cardiovascular.", Duration.ofMinutes(110), 800, LocalDate.of(2021, 5, 30));
            CAC.crearActividad("Fuerza Bruta", "Kickboxing", "En busca del nuevo campeon de boxeo.", Duration.ofMinutes(100), 980, LocalDate.of(2021, 6, 7));
            CAC.crearActividad("Telon", "Atletismo", "100m, 200m, postas y carreras con obstaculos.", Duration.ofMinutes(150), 500, LocalDate.of(2021, 7, 8));
            CAC.crearActividad("Telon", "Basquetbol", "Espectaculo conmemorando los 30 años de Violeta", Duration.ofMinutes(80), 450, LocalDate.of(2021, 7, 31));

            Set<String> p1 = new HashSet<>();
            p1.add("viktor");
            CAC.crearClase("Aparatos y pesas", "Calistenia", LocalDateTime.of(2021, 4, 15, 15, 30), p1, 1, 5, new URL("https://www.musculos.com/Calistenia"), LocalDate.of(2021, 3, 31));
            CAC.crearClase("Aparatos y pesas", "Peso libre", LocalDateTime.of(2021, 5, 1, 17, 00), p1, 1, 5, new URL("https://www.musculos.com/pesolibre"), LocalDate.of(2021, 3, 31));
            CAC.crearClase("Aparatos y pesas", "Aparatos", LocalDateTime.of(2021, 6, 1, 18, 00), p1, 1, 7, new URL("https://www.musculos.com/aparatos"), LocalDate.of(2021, 3, 31));  //Fallan por la fecha

            Set<String> p2 = new HashSet<>();
            p2.add("denis");
            CAC.crearClase("Voleibol", "Voleibol", LocalDateTime.of(2021, 6, 10, 19, 00), p2, 10, 21, new URL("https://telon.com.uy/voley"), LocalDate.of(2021, 4, 20));

            Set<String> p3 = new HashSet<>();
            p3.add("Nelson");
            CAC.crearClase("Voleibol", "Braza", LocalDateTime.of(2021, 7, 10, 20, 00), p3, 2, 6, new URL("https://telon.com.uy/natacionB"), LocalDate.of(2021, 4, 20));
            CAC.crearClase("Voleibol", "Mariposa", LocalDateTime.of(2021, 8, 10, 17, 45), p3, 2, 6, new URL("https://telon.com.uy/natacionM"), LocalDate.of(2021, 4, 20));

            Set<String> p4 = new HashSet<>();
            p4.add("clazar");
            CAC.crearClase("Aerobica", "Aerobica niños", LocalDateTime.of(2021, 8, 15, 16, 30), p4, 5, 10, new URL("https://www.inatural.com/aeroni"), LocalDate.of(2021, 5, 30));
            CAC.crearClase("Aerobica", "Aerobica adulto 5or", LocalDateTime.of(2021, 8, 31, 19, 30), p4, 5, 12, new URL("https://www.inatural.com/aeroam"), LocalDate.of(2021, 5, 30));
            CAC.crearClase("Aerobica", "Aerobica", LocalDateTime.of(2021, 9, 30, 20, 00), p4, 5, 20, new URL("https://www.inatural.com/aerogral"), LocalDate.of(2021, 5, 30));

            Set<String> p5 = new HashSet<>();
            p5.add("clazar");
            CAC.crearClase("Kickboxing", "Boxeo I", LocalDateTime.of(2021, 9, 1, 19, 30), p5, 1, 4, new URL("https://www.musculos.com/boxeo1"), LocalDate.of(2021, 6, 7));
            CAC.crearClase("Kickboxing", "Boxeo II", LocalDateTime.of(2021, 9, 30, 17, 00), p5, 2, 2, new URL("https://www.musculos.com/boxeo2"), LocalDate.of(2021, 6, 7));


            CAC.crearClase("Kickboxing", "Musculos para boxeo", LocalDateTime.of(2021, 10, 15, 20, 00), p1, 1, 5, new URL("https://www.musculos.com/muscbox"), LocalDate.of(2021, 6, 7));

            Set<String> p6 = new HashSet<>();
            p6.add("lale");
            CAC.crearClase("Atletismo", "100 M", LocalDateTime.of(2021, 9, 25, 19, 00), p6, 3, 10, new URL("https://telon.com.uy/100m"), LocalDate.of(2021, 7, 8));
            CAC.crearClase("Atletismo", "200 M", LocalDateTime.of(2021, 10, 25, 18, 30), p6, 3, 10, new URL("https://telon.com.uy/200m"), LocalDate.of(2021, 7, 8));
            CAC.crearClase("Atletismo", "Posta", LocalDateTime.of(2021, 11, 25, 17, 45), p6, 8, 16, new URL("https://telon.com.uy/posta"), LocalDate.of(2021, 7, 8));

            Set<String> p7 = new HashSet<>();
            p7.add("aldo");
            CAC.crearClase("Basquetbol", "Basquet I", LocalDateTime.of(2021, 9, 1, 21, 00), p7, 10, 15, new URL("https://telon.com.uy/bball1"), LocalDate.of(2021, 7, 31));
            CAC.crearClase("Basquetbol", "Basquet II", LocalDateTime.of(2021, 9, 10, 21, 00), p7, 10, 15, new URL("https://telon.com.uy/bball2"), LocalDate.of(2021, 7, 31));

            /* IMPORTANTE Quedó sin la r el nombre... mejor cambiarlo aca que en todo el codigo*/
            CAC.registarseSinCuponera("caro", "Calistenia", LocalDate.of(2021, 4, 9));
            CAC.registarseSinCuponera("sergiop", "Calistenia", LocalDate.of(2021, 4, 10));
            CAC.registarseSinCuponera("andy", "Calistenia", LocalDate.of(2021, 4, 12));
            CAC.registarseSinCuponera("andy", "Peso libre", LocalDate.of(2021, 4, 15));
            CAC.registarseSinCuponera("tonyp", "Peso libre", LocalDate.of(2021, 4, 20));
            CAC.registarseSinCuponera("caro", "Peso libre", LocalDate.of(2021, 4, 25));
            CAC.registarseSinCuponera("m1k4", "Peso libre", LocalDate.of(2021, 4, 28));
            CAC.registarseSinCuponera("charly", "Aparatos", LocalDate.of(2021, 4, 16));
            CAC.registarseSinCuponera("caro", "Aparatos", LocalDate.of(2021, 5, 15));
            CAC.registarseSinCuponera("m1k4", "Aparatos", LocalDate.of(2021, 5, 20));
            CAC.registarseSinCuponera("Emi71", "Voleibol", LocalDate.of(2021, 5, 5));
            CAC.registarseSinCuponera("euge", "Voleibol", LocalDate.of(2021, 5, 10));
            CAC.registarseSinCuponera("sergiop", "Voleibol", LocalDate.of(2021, 5, 15));
            CAC.registarseSinCuponera("tonyp", "Voleibol", LocalDate.of(2021, 5, 20));
            CAC.registarseSinCuponera("guille", "Braza", LocalDate.of(2021, 6, 8));
            CAC.registarseSinCuponera("euge", "Braza", LocalDate.of(2021, 6, 13));
            CAC.registarseSinCuponera("m1k4", "Braza", LocalDate.of(2021, 6, 25));
            CAC.registarseSinCuponera("charly", "Mariposa", LocalDate.of(2021, 7, 5));
            CAC.registarseSinCuponera("sergiop", "Mariposa", LocalDate.of(2021, 7, 11));
            CAC.registarseSinCuponera("andy", "Mariposa", LocalDate.of(2021, 7, 18));
            CAC.registarseSinCuponera("m1k4", "Aerobica niños", LocalDate.of(2021, 7, 19));
            CAC.registarseSinCuponera("Emi71", "Aerobica adulto 5or", LocalDate.of(2021, 8, 17));
            CAC.registarseSinCuponera("guille", "Aerobica adulto 5or", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("andy", "Aerobica adulto 5or", LocalDate.of(2021, 8, 23));
            CAC.registarseSinCuponera("caro", "Aerobica", LocalDate.of(2021, 8, 15));
            CAC.registarseSinCuponera("euge", "Aerobica", LocalDate.of(2021, 8, 26));
            CAC.registarseSinCuponera("andy", "Boxeo I", LocalDate.of(2021, 7, 19));
            CAC.registarseSinCuponera("tonyp", "Boxeo I", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("m1k4", "Boxeo I", LocalDate.of(2021, 8, 24));
            CAC.registarseSinCuponera("sergiop", "Boxeo II", LocalDate.of(2021, 8, 1));
            CAC.registarseSinCuponera("guille", "Boxeo II", LocalDate.of(2021, 8, 30));
            CAC.registarseSinCuponera("Emi71", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("caro", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("euge", "Musculos para boxeo", LocalDate.of(2021, 9, 1));
            CAC.registarseSinCuponera("sergiop", "Musculos para boxeo", LocalDate.of(2021, 9, 5));
            CAC.registarseSinCuponera("guille", "100 M", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("charly", "100 M", LocalDate.of(2021, 9, 3));
            CAC.registarseSinCuponera("Emi71", "200 M", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("charly", "200 M", LocalDate.of(2021, 9, 6));
            CAC.registarseSinCuponera("caro", "Posta", LocalDate.of(2021, 9, 1));
            CAC.registarseSinCuponera("sergiop", "Basquet I", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("Emi71", "Basquet I", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("tonyp", "Basquet I", LocalDate.of(2021, 8, 31));
            CAC.registarseSinCuponera("andy", "Basquet II", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("tonyp", "Basquet II", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("caro", "Basquet II", LocalDate.of(2021, 9, 2));

            CC.crearCuponera("Pelota", "Deportes con pelota.", LocalDate.of(2021, 5, 1), LocalDate.of(2021, 7, 31), 20, LocalDate.of(2021, 4, 30));
            CC.crearCuponera("Gimnasia", "Aerobica y aparatos.", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 9, 30), 30, LocalDate.of(2021, 7, 15));
            CC.crearCuponera("Musculos", "Pesas.", LocalDate.of(2021, 8, 15), LocalDate.of(2021, 11, 15), 10, LocalDate.of(2021, 8, 1));

            CC.agregarACuponera("Pelota", "Voleibol", 7);
            CC.agregarACuponera("Pelota", "Basquetbol", 18);
            CC.agregarACuponera("Gimnasia", "Aerobica", 2);
            CC.agregarACuponera("Gimnasia", "Aparatos y pesas", 8);
            CC.agregarACuponera("Musculos", "Kickboxing", 11);
            CC.agregarACuponera("Musculos", "Aparatos y pesas", 12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        callback.finished();
    }
}