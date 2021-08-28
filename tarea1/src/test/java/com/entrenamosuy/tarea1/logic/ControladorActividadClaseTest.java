package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorActividadClaseTest {
    
    @BeforeEach
    void resetarManejador() {
        Manejador manejador = Manejador.getInstance();

        manejador.getActividades().clear();
        manejador.getClases().clear();
        manejador.getCuponeras().clear();
        manejador.getInstituciones().clear();
        manejador.getProfesores().clear();
        manejador.getProfesoresMail().clear();
        manejador.getSocios().clear();
        manejador.getSociosMail().clear();
    }

    @Test
    void crearActividad() {
        ControladorActividadClase ctrl = new ControladorActividadClase();

        assertDoesNotThrow(() -> {
            ctrl.crearInstitucion("test", "test", new URL("https://test"));
            ctrl.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
        });

        // No se puede crear actividades con nombres repetidos.
        assertThrows(ActividadRepetidaException.class, () -> {
            ctrl.crearActividad("test", "test", "desc", Duration.ofHours(2), 15.5f, LocalDate.of(2021, 9, 10));
        });

        // La actividad esta asociada a una institucion valida.
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrl.crearActividad("mi institucion", "actividad", "desc", Duration.ofMinutes(45), 200f, LocalDate.of(2000, 1, 1));
        });
    }

    @Test
    void crearInstitucion() {
        ControladorActividadClase ctrl = new ControladorActividadClase();
        
        assertDoesNotThrow(() -> {
            ctrl.crearInstitucion("test", "test", new URL("http://test"));
        });

        // No puede haber instituciones con nombre repetido
        assertThrows(InstitucionRepetidaException.class, () -> {
            ctrl.crearInstitucion("test", "desc", new URL("https://mypage"));
        });
    }

    @Test
    void crearClase() {
        ControladorActividadClase ctrlActividadClase = new ControladorActividadClase();
        ControladorUsuario ctrlUsuario = new ControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlActividadClase.crearInstitucion("test", "test", new URL("https://test"));
            ctrlActividadClase.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));

            ctrlUsuario.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            ctrlUsuario.crearProfesor("profe2", "Profe 2", "apellido", Email.of("profe2", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);

            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");

            ctrlActividadClase.crearClase("test", "test", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
        });

        assertThrows(ClaseRepetidaException.class, () -> {
            ctrlActividadClase.crearClase("test", "test", LocalDateTime.of(2000, 10, 10, 0, 0), new HashSet<>(), 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
        });

        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlActividadClase.crearClase("actividad", "mi clase", LocalDateTime.of(2000, 10, 10, 0, 0), new HashSet<>(), 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
        });

        assertThrows(ProfesorNoEncontradoException.class, () -> {
            Set<String> profesores = new HashSet<>();
            profesores.add("profe3");

            ctrlActividadClase.crearClase("test", "mi clase", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
        });
    }
}
