package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;

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
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlU.crearSocio("Lucho", "luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(1000, 03, 28));
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlU.crearSocio("Hola", "luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(1000, 03, 28));
        });
    }

    @Test
    void consultarSocio() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        Email e = Email.of("lucho", "mail.com");
        Email e2 = Email.of("lucho2", "mail.com");
        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", e, LocalDate.of(2007, 03, 28));
            ctrlU.crearSocio("Lucho2", "Luciano", "Almenares", e2, LocalDate.of(2007, 03, 28));

            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2005, 10, 10, 12,12), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            ctrlA.registarseSinCuponera("Lucho", "test", LocalDate.of(1995, 10, 10));

        });

        assertDoesNotThrow(() -> {
            DataSocio ds = ctrlU.consultarSocio("Lucho");
            assertEquals(ds.getApellido(), "Almenares");
            assertEquals(ds.getNombre(), "Luciano");
            assertEquals(ds.getCorreo(), e);
            assertEquals(ds.getNacimiento(), LocalDate.of(2007, 03, 28));
        });

        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlU.consultarSocio("lucho");
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
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
        });

        assertDoesNotThrow(() -> {  
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), "test", "descripcion", "ola", u);
        });

        assertThrows(UsuarioRepetidoException.class, () -> { //2 profs con mismo mail y mismo nick 
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), "test", "descripcion", "ola", u);
        });

        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrlU.crearProfesor("Hola", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), null, "descripcion", "ola", u);
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
            assertEquals(dp.getInstitucionNombre(), "test");
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
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), "test", "descripcion", "ola", u);
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
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), "test", "descripcion", "ola", u);
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Facu", "Facundito", "Techera", LocalDate.of(2007, 03, 28));
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Lucho", "lucianito", "almenares", LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Lucho", null, "almenares", LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Lucho", "lucianito", null, LocalDate.of(2007, 03, 29));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Lucho", "lucianito", "almenares", null);
        });

        assertThrows(UsuarioNoEncontradoException.class, () -> {
            ctrlU.modificarDatosUsuario("Luchito", "Lucianito", "Almenares", LocalDate.of(2007, 03, 28));
        });
    }

    @Test
    void obtenerDescSocios() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
        });
        assertDoesNotThrow(() -> {
            ctrlU.obtenerDescSocios();
        });

    }

    @Test
    void obtenerDescProfesores() throws MalformedURLException{
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), "test", "descripcion", "ola", u);
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
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
            ctrlU.crearSocio("Lucho2", "Luciano2", "Almenares2", Email.of("lucho2", "mail.com"), LocalDate.of(2001, 11, 28));
            Manejador m = Manejador.getInstance();
            Socio u1 = m.getSocios().get("Lucho");
            Socio u2 = m.getSocios().get("Lucho2");
            u1.equals(u2);
            u1.equals(u1);
        });
    }
}
