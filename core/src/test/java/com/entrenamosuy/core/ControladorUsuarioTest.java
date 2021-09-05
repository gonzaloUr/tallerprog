package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.*;

import com.entrenamosuy.core.model.Socio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorUsuarioTest {

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
    void crearSocioBien() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlU.crearSocio().setNickname("Hola").setNombre("luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });
    }

    @Test
    void consultarSocio() {
        Fabrica F = new Fabrica();
        Manejador m = Manejador.getInstance();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        Email e = Email.of("lucho", "mail.com");
        Email e2 = Email.of("lucho2", "mail.com");
        assertDoesNotThrow(() -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(e).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
            ctrlU.crearSocio().setNickname("Lucho2").setNombre("Luciano").setApellido("Almenares").setCorreo(e2).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();

            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe1").setNombre("Profe 1").setApellido("apellido").setCorreo(Email.of("profe1", "mail.com")).setNacimiento(LocalDate.of(2021, 9, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test").setInicio(LocalDateTime.of(2021, 10, 10, 12, 12)).setNicknameProfesores(profesores).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(2021, 10, 10)).invoke();
            ctrlA.registarseSinCuponera("Lucho", "test", LocalDate.of(2021, 10, 10));

        });

        assertDoesNotThrow(() -> {
            DataSocio ds = ctrlU.consultarSocio("Lucho");
            assertEquals(ds.getApellido(), "Almenares");
            assertEquals(ds.getNombre(), "Luciano");
            assertEquals(ds.getCorreo(), e);
            assertEquals(ds.getNacimiento(), LocalDate.of(2007, 03, 28));
        });

        assertThrows(ClaseInconsistenteException.class, () -> {
            ctrlA.crearActividad().setInstitucion("test").setNombre("test21").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
            ctrlU.crearProfesor().setNickname("profe21").setNombre("Profe 21").setApellido("apellido").setCorreo(Email.of("profe21", "mail.com")).setNacimiento(LocalDate.of(2021, 9, 10)).setInstitucion("test").setDescripcion("desc").setBiografia(null).setLink(null).invoke();
            Set<String> profesores21 = new HashSet<>();
            profesores21.add("profe21");
            ctrlA.crearClase().setNombreActividad("test").setNombre("test21").setInicio(LocalDateTime.of(2005, 10, 10, 12, 12)).setNicknameProfesores(profesores21).setCantMin(2).setCantMax(10).setAcceso(new URL("https://test")).setFechaRegistro(LocalDate.of(1995, 10, 10)).invoke();
            ctrlA.registarseSinCuponera("Lucho", "test21", LocalDate.of(1995, 10, 10));
        });

        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlU.consultarSocio("lucho");
        });

        assertDoesNotThrow(() -> {
            Socio s = m.getSocios().get("Lucho2");
            assertNotEquals(s.getNickname(), "UWU");
            s.setNickname("UWU");
            assertEquals(s.getNickname(), "UWU");

            assertEquals(s.getCompras().isEmpty(), true);

            assertNotEquals(s.getCorreo(), Email.of("lililili", "mail.com"));
            s.setCorreo(Email.of("lililili", "mail.com"));
            assertEquals(s.getCorreo(), Email.of("lililili", "mail.com"));
        });
    }

    @Test
    void crearProfesor() throws MalformedURLException {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor().setNickname("Facu").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion("test").setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> { //2 profs con mismo mail y mismo nick 
            ctrlU.crearProfesor().setNickname("Facu").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion("test").setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });

        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrlU.crearProfesor().setNickname("Hola").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion(null).setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });
        assertDoesNotThrow(() -> {
            DataProfesor dp = ctrlU.consultarProfesor("Facu");
            assertEquals(dp.getApellido(), "Techera");
            assertEquals(dp.getNombre(), "Facundo");
            assertEquals(dp.getCorreo(), Email.of("facu", "mail.com"));
            assertEquals(dp.getNacimiento(), LocalDate.of(2007, 03, 28));
            assertEquals(dp.getDescripcion(), "descripcion");
            assertEquals(dp.getBiografia(), "ola");
            assertEquals(dp.getSitioWeb(), u);
            assertEquals(dp.getInstitucion(), "test");
        });
    }

    @Test
    void consultarProfesor() throws MalformedURLException {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        Email e = Email.of("facu", "mail.com");
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor().setNickname("Facu").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion("test").setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });

        assertDoesNotThrow(() -> {
            DataProfesor dp = ctrlU.consultarProfesor("Facu");
            assertEquals(dp.getApellido(), "Techera");
            assertEquals(dp.getNombre(), "Facundo");
            assertEquals(dp.getCorreo(), e);
            assertEquals(dp.getNacimiento(), LocalDate.of(2007, 03, 28));
//            assertEquals(dp.getInstitucionNombre(), inst.getNombre());
            assertEquals(dp.getDescripcion(), "descripcion");
            assertEquals(dp.getBiografia(), "ola");
            assertEquals(dp.getSitioWeb(), u);
        });

        assertThrows(ProfesorNoEncontradoException.class, () -> {
            ctrlU.consultarProfesor("facu");
        });
    }

    @Test
    void modificarDatosUsuario() throws MalformedURLException {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor().setNickname("Facu").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion("test").setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosProfesor().setNickname("Facu").setNombre("Techera").setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosSocio("Lucho", "lucianito", "almenares", LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosSocio("Lucho", null, "almenares", LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosSocio("Lucho", "lucianito", null, LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosSocio("Lucho", "lucianito", "almenares", null);
        });

        assertThrows(UsuarioNoEncontradoException.class, () -> {
            ctrlU.modificarDatosSocio("Luchito", "Lucianito", "Almenares", LocalDate.of(2007, 03, 28));
        });
    }

    @Test
    void obtenerDescSocios() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
        });
        assertDoesNotThrow(() -> {
            ctrlU.obtenerDescSocios();
        });

    }

    @Test
    void obtenerDescProfesores() throws MalformedURLException {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad().setInstitucion("test").setNombre("test").setDescripcion("test").setDuracion(Duration.ofHours(1)).setCosto(10.0f).setRegistro(LocalDate.of(2021, 9, 10)).invoke();
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor().setNickname("Facu").setNombre("Facundo").setApellido("Techera").setCorreo(Email.of("facu", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).setInstitucion("test").setDescripcion("descripcion").setBiografia("ola").setLink(u).invoke();
        });
        assertDoesNotThrow(() -> {
            ctrlU.obtenerDescProfesores();
        });
    }

    @Test
    void otros() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlU.crearSocio().setNickname("Lucho").setNombre("Luciano").setApellido("Almenares").setCorreo(Email.of("lucho", "mail.com")).setNacimiento(LocalDate.of(2007, 03, 28)).invoke();
            ctrlU.crearSocio().setNickname("Lucho2").setNombre("Luciano2").setApellido("Almenares2").setCorreo(Email.of("lucho2", "mail.com")).setNacimiento(LocalDate.of(2001, 11, 28)).invoke();
            Manejador m = Manejador.getInstance();
            Socio u1 = m.getSocios().get("Lucho");
            Socio u2 = m.getSocios().get("Lucho2");
            u1.equals(u2);
            u1.equals(u1);
        });
    }
}
