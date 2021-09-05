package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.*;
import com.entrenamosuy.core.model.*;
import com.entrenamosuy.core.util.Pair;

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
        Manejador m = Manejador.getInstance();
        ControladorActividadClase ctrl = new ControladorActividadClase();

        assertDoesNotThrow(() -> {
            ctrl.crearInstitucion("test", "test", new URL("https://test"));

            ctrl.crearActividad()
                    .setInstitucion("test")
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10.0f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .invoke();

            ctrl.crearActividad()
                    .setInstitucion("test")
                    .setNombre("test2")
                    .setDescripcion("test2")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10.0f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .invoke();
        });

        assertDoesNotThrow(() -> {
            DataActividad da = ctrl.consultarActividad("test");
            assertEquals(da.getClases().isEmpty(), da.getClases().isEmpty());
            assertEquals(da.getCosto(), 10.0f);
            assertEquals(da.getCuponeras().isEmpty(), da.getCuponeras().isEmpty());
            assertEquals(da.getDescripcion(), "test");
            assertEquals(da.getDuracion(), Duration.ofHours(1));
            assertEquals(da.getNombre(), "test");
            assertEquals(da.getRegistro(), LocalDate.of(2021, 9, 10));
        });

        assertDoesNotThrow(() -> {
            Actividad a1 = m.getActividades().get("test");
            Actividad a2 = m.getActividades().get("test2");
            Integra i1 = new Integra(2, a1);
            Integra i2 = new Integra(2, a2);
            assertEquals(i1, i1);
            assertNotEquals(i1, i2);

            assertNotEquals(i1.getCantClases(), 5);
            i1.setCantClases(5);
            assertEquals(i1.getCantClases(), 5);

            assertNotEquals(i1.getActividad(), a2);
            i1.setActividad(a2);
            assertEquals(i1.getActividad(), a2);
        });

        // No se puede crear actividades con nombres repetidos.
        assertThrows(ActividadRepetidaException.class, () -> {
            ctrl.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("desc").setDuracion(Duration.ofHours(2)).setCosto(15.5f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
        });

        // La actividad esta asociada a una institucion valida.
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrl.crearActividad().setInstitucion("mi institucion").setNombre("actividad").setDescripcion("desc").setDuracion(Duration.ofMinutes(45)).setCosto(200f).setRegistro(LocalDate.of(2000, 1, 1)).invoke();
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
            ctrlUsuario.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).invoke();
            ctrlActividadClase.crearInstitucion("test", "test", new URL("https://test"));
            ctrlActividadClase.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlActividadClase.crearActividad().setInstitucion("test").setNombre("test2").setDescripcion("test2").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();

            ctrlUsuario.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            ctrlUsuario.crearProfesor().setNickname("profe2").setNombre("Profe 2").setApellido("apellido").setCorreo(Email.of("profe2", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();

            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");

            ctrlActividadClase.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 0, 0)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlActividadClase.crearClase().setNombreActividad("test2").setNombre("test2").setInicio(LocalDateTime.of(2000, 10, 10, 0, 0)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlActividadClase.registarseSinCuponera("Lucho", "test", LocalDate.of(2000, 10, 10));
        });

        assertThrows(ClaseInconsistenteException.class, () -> {
            ctrlActividadClase.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 0, 0)).setNicknameProfesores(new HashSet<>()).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2001, 10, 10)).invoke();
        });

        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlActividadClase.crearClase().setNombreActividad("actividad").setNombre("mi clase").setInicio(LocalDateTime.of(2000, 10, 10, 0, 0)).setNicknameProfesores(new HashSet<>()).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2001, 10, 10)).invoke();
        });

        assertThrows(ProfesorNoEncontradoException.class, () -> {
            Set<String> profesores = new HashSet<>();
            profesores.add("profe3");

            ctrlActividadClase.crearClase().setNombreActividad("test").setNombre("mi clase").setInicio(LocalDateTime.of(2000, 10, 10, 0, 0)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
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
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
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
            ctrlA.crearActividad().setInstitucion("testI").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
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
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            ctrlU.crearProfesor().setNickname("profe2").setNombre("Profe 2").setApellido("apellido").setCorreo(Email.of("profe2", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
        });

        assertDoesNotThrow(() -> { // OK
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
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
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            ctrlU.crearProfesor().setNickname("profe2").setNombre("Profe 2").setApellido("apellido").setCorreo(Email.of("profe2", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlA.consultarClase("test");
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.consultarClase("t");
        });
    }

    ;

    @Test
    void consultarClase() throws ClaseNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            ctrlU.crearProfesor().setNickname("profe2").setNombre("Profe 2").setApellido("apellido").setCorreo(Email.of("profe2", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            profesores.add("profe2");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlA.consultarClase("test");
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.consultarClase("t");
        });
    }

    ;

    @Test
    void registraseConCuponera() throws CuponeraNoEncontradaException, SocioNoEncontradoException, ClaseNoEncontradaException {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).invoke();
            ctrlC.crearCuponera().setNombre("cuponera1").setDescripcion("Todo lindo").setInicio(LocalDate.of(2000, 10, 10)).setFin(LocalDate.of(2000, 10, 10)).setDescuento(15).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlA.registraseConCuponera("Lucho", "test", "cupo", LocalDate.of(2000, 10, 10));
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlA.registraseConCuponera("Lu", "test", "cupo", LocalDate.of(2000, 10, 10));
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.registraseConCuponera("Lu", "te", "cupo", LocalDate.of(2000, 10, 10));
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
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).invoke();
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlA.registarseSinCuponera("L", "test", LocalDate.of(2000, 10, 10));
        });
        assertThrows(ClaseNoEncontradaException.class, () -> {
            ctrlA.registarseSinCuponera("Lucho", "t", LocalDate.of(2000, 10, 10));
        });
        assertDoesNotThrow(() -> {
            ctrlA.registarseSinCuponera("Lucho", "test", LocalDate.of(2000, 10, 10));
        });
    }

    @Test
    void cuponerasUsables() {
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        ControladorCuponera ctrlC = new ControladorCuponera();

        Manejador manejador = Manejador.getInstance();

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2000, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2000, 10, 10)).invoke();
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2000, 10, 10)).invoke();

            ctrlC.crearCuponera().setNombre("test").setDescripcion("test").setInicio(LocalDate.of(2000, 10, 10)).setFin(LocalDate.of(2001, 10, 10)).setDescuento(20).setFechaRegistro(LocalDate.of(1999, 10, 10)).invoke();
            ctrlC.agregarACuponera("test", "test", 2);

            Socio socio = manejador.getSocios().get("Lucho");
            Cuponera cup = manejador.getCuponeras().get("test");

            Compra compra = new Compra(LocalDate.of(2000, 10, 10), socio, cup);
            socio.getCompras().add(compra);
        });

        assertDoesNotThrow(() -> {
            Set<Pair<String, String>> ret = ctrlC.cuponerasUsables("test", "Lucho");
            assertEquals(1, ret.size());
            assertEquals(true, ret.contains(new Pair<>("test", "test")));
        });
    }
}
