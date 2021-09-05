package com.entrenamosuy.core.model;

import com.entrenamosuy.core.Manejador;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelTestUtils {

    public static void assertModelo() {
        Manejador manejador = Manejador.getInstance();

        Map<String, Actividad> actividades = manejador.getActividades();
        Map<String, Clase> clases = manejador.getClases();
        Map<String, Cuponera> cuponeras = manejador.getCuponeras();
        Map<String, Institucion> instituciones = manejador.getInstituciones();
        Map<String, Profesor> profesores = manejador.getProfesores();
        Map<String, Socio> socios = manejador.getSocios();

        // Link dicta entre Profesor <-> Clase.

        for (Profesor p : profesores.values())
            for (Clase c : p.getClasesDictadas())
                assertTrue(c.getProfesores().contains(p), c.getNombre() + " pertenece a " + p.getNickname() +
                        ".clasesDictadas pero " + p.getNickname() + "no pertenece a " + c.getNombre() + ".profesores");

        for (Clase c : clases.values())
            for (Profesor p : c.getProfesores())
                assertTrue(p.getClasesDictadas().contains(c), p.getNickname() + " pertenece a " + c.getNombre() +
                        ".profesores pero " + c.getNombre() + " no pertenece a " + p.getNickname() + ".clasesDictadas");

        // Link compone entre Clase <-> Actividad.

        for (Clase c : clases.values())
            assertTrue(c.getActividad().getClases().contains(c), c.getNombre() +
                    ".actividad.getClases() no contiene a " + c.getNombre());

        for (Actividad a : actividades.values())
            for (Clase c : a.getClases())
                assertSame(c.getActividad(), a, c.getNombre() + " pertenece a " + a.getNombre() +
                        ".clases pero " + c.getNombre() + ".actividad no es el mismo que " + a.getNombre());
    }
}
