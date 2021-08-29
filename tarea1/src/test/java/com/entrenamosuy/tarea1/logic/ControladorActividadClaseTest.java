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
import com.entrenamosuy.tarea1.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.ClaseRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;

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
            ctrlUsuario.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
            ctrlActividadClase.crearInstitucion("test", "test", new URL("https://test"));
            ctrlActividadClase.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlActividadClase.crearActividad("test", "test2", "test2", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));

            ctrlUsuario.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            ctrlUsuario.crearProfesor("profe2", "Profe 2", "apellido", Email.of("profe2", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);

            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");

            ctrlActividadClase.crearClase("test", "test", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlActividadClase.crearClase("test2", "test2", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlActividadClase.registarseSinCuponera("Lucho", "test", LocalDate.of(1995, 10, 10));
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

    @Test
    void obtenerDescInstituciones() {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
        });
        assertDoesNotThrow(() -> {
            ctrlA.obtenerDescInstituciones();
        });
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test1", "test1", new URL("https://test1"));
            ctrlA.crearInstitucion("test2", "test2", new URL("https://test2"));
            ctrlA.obtenerDescInstituciones();
        });
    }

    @Test
    void obtenerDescActividades() throws InstitucionNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertThrows(InstitucionNoEncontradaException.class, () -> { //Instituto no encontrado
            ctrlA.obtenerDescActividades("");    
        });
        assertDoesNotThrow(() -> { 
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
        });
        assertDoesNotThrow(() -> { //Todo bien
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlA.obtenerDescActividades("test");
        });
    }


    @Test
    void consultarActividad() throws ActividadNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlA.consultarActividad("t");
        });

        assertDoesNotThrow(() -> { //Todo bien
            ctrlA.crearInstitucion("testI", "testIn", new URL("https://test"));
            ctrlA.crearActividad("testI", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlA.consultarActividad("test");
        });
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlA.consultarActividad("t");
        });
    }

    @Test
    void obtenerDescClases() throws ActividadNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            ctrlU.crearProfesor("profe2", "Profe 2", "apellido", Email.of("profe2", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
        });

        assertDoesNotThrow(() -> { // OK
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlA.obtenerDescClases("test");
        });

        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlA.obtenerDescClases("t");
        });
    }

    @Test
    void obtenerDataClase() throws ClaseNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            ctrlU.crearProfesor("profe2", "Profe 2", "apellido", Email.of("profe2", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlA.consultarClase("test");
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.consultarClase("t");
        });
    };

    @Test
    void consultarClase() throws ClaseNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            ctrlU.crearProfesor("profe2", "Profe 2", "apellido", Email.of("profe2", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlA.consultarClase("test");
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.consultarClase("t");
        });
    };

    @Test
    void registraseConCuponera() throws CuponeraNoEncontradaException, SocioNoEncontradoException, ClaseNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlA.registraseConCuponera("Lucho", "test", "cupo", LocalDate.of(2021, 03, 2));
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlA.registraseConCuponera("Lu", "test", "cupo", LocalDate.of(2021, 03, 2));
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.registraseConCuponera("Lu", "te", "cupo", LocalDate.of(2021, 03, 2));
        });

        assertDoesNotThrow(() -> {
            ctrlA.registraseConCuponera("Lucho", "test", "cuponera1", LocalDate.of(2021, 03, 2));  
        });
    }

    @Test
    void registarseSinCuponera() throws ClaseNoEncontradaException, SocioNoEncontradoException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlA.registarseSinCuponera("L", "test", LocalDate.of(2021, 03, 2));
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.registarseSinCuponera("Lucho", "t", LocalDate.of(2021, 03, 2));
        });
        assertDoesNotThrow(() -> {
            ctrlA.registarseSinCuponera("Lucho", "test", LocalDate.of(2021, 03, 2));  
        });
    }
}
