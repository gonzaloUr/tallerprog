package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.net.URL;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorCuponeraTest {

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
    void crearCuponera() throws CuponeraRepetidaException {
        Fabrica F = new Fabrica();
        IControladorCuponera ctrlC = F.crearControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
        });
        assertThrows(CuponeraRepetidaException.class, () -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
        });
    }

    @Test
    void cuponerasUsables() throws ActividadNoEncontradaException, SocioNoEncontradoException { 
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlC.cuponerasUsables("test", "Lucho");
        });
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlC.cuponerasUsables("te", "Lucho");
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlC.cuponerasUsables("test", "Lu");
        });
    }

    @Test
    void actividadesAgregables() throws CuponeraNoEncontradaException, InstitucionNoEncontradaException {
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlC.actividadesAgregables("cuponera1", "test");
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.actividadesAgregables("cup", "test");
        });
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrlC.actividadesAgregables("cuponera1", "te");
        });
    }

    @Test
    void agregarACuponera() throws ActividadNoEncontradaException, CuponeraNoEncontradaException { //agregarACuponera(String cuponera, String actividad, int cant)
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlC.agregarACuponera("cuponera1", "test", 5);
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.agregarACuponera("cupo", "test", 5);
        });
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlC.agregarACuponera("cuponera1", "te", 5);
        });
    }

    @Test
    void obtenerDescCuponeras() {
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlC.obtenerDescCuponeras();
        });
    }

    @Test
    void consultarCuponera() throws CuponeraNoEncontradaException { //consultarCuponera(String nombre)
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlC.consultarCuponera("cuponera1");
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.consultarCuponera("cupo");
        });
    }

    @Test
    void manejadortest() {
        Manejador man = Manejador.getInstance();
        Map<String, Actividad> act = man.getActividades();
        Map<String, Clase> cla = man.getClases();
        Map<String, Cuponera> cupo = man.getCuponeras();
        Map<String, Institucion> ins = man.getInstituciones();
        Map<String, Profesor> proE = man.getProfesores();
        Map<Email, Profesor> proM = man.getProfesoresMail();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            man.setActividades(act);

            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            man.setClases(cla);

            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            man.setCuponeras(cupo);

            man.setInstituciones(ins);

            man.setProfesores(proE);
            man.setProfesoresMail(proM);
        });


    }
}
