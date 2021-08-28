package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;

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
        Email e = Email.of("lucho", "mail.com");

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", e, LocalDate.of(2007, 03, 28));
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
    void crearProfesorBien() throws MalformedURLException {  
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        URL u = new URL("http", "www.google", 5, "file");
        Institucion inst = null;
        assertDoesNotThrow(() -> {  
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), inst, "descripcion", "ola", u);
        });

        assertThrows(UsuarioRepetidoException.class, () -> { //2 profs con mismo mail y mismo nick 
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), inst, "descripcion", "ola", u);
        });

        assertThrows(UsuarioRepetidoException.class, () -> { //2 profs con mismo mail y distinto nick
            ctrlU.crearProfesor("Hola", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), inst, "descripcion", "ola", u);
        });
    }

    @Test
    void consultarProfesor() throws MalformedURLException {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        Email e = Email.of("facu", "mail.com");
        Institucion inst = null;//Explota por esto.. Hay que implementar
        URL u = new URL("http", "www.google", 5, "file");

        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), inst, "descripcion", "ola", u);
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
        Institucion inst = null;//Explota por esto.. Hay que implementar
        URL u = new URL("http", "www.google", 5, "file");
        assertDoesNotThrow(() -> {
            ctrlU.crearProfesor("Facu", "Facundo", "Techera", Email.of("facu", "mail.com"), LocalDate.of(2007, 03, 28), inst, "descripcion", "ola", u);
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Facu", "Facundito", "Techera", LocalDate.of(2007, 03, 28));
        });

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
        });
        assertDoesNotThrow(() -> {
            ctrlU.modificarDatosUsuario("Lucho", "Lucianito", "Almenares", LocalDate.of(2007, 03, 28));
        });

        assertThrows(UsuarioNoEncontradoException.class, () -> {
            ctrlU.modificarDatosUsuario("Luchito", "Lucianito", "Almenares", LocalDate.of(2007, 03, 28));
        });
    }

}
