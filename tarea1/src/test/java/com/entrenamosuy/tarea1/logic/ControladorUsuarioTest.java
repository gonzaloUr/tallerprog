package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;

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
    void crearSocio() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();

        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "@mail.com"), LocalDate.of(2007, 03, 28));
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            ctrlU.crearSocio("Lucho", "luciano", "Almenares", Email.of("luciano", "@mail.com"), LocalDate.of(1000, 03, 28));
        });
    }

    @Test
    void consultarSocio() {
        Fabrica F = new Fabrica();
        IControladorUsuario ctrlU = F.creaControladorUsuario();
        Email e = Email.of("lucho", "@mail.com");

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
}
