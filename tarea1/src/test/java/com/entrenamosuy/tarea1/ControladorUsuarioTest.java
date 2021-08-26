package com.entrenamosuy.tarea1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import com.entrenamosuy.tarea1.data.DataSocio;
import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.tarea1.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.tarea1.logic.Fabrica;
import com.entrenamosuy.tarea1.logic.IControladorUsuario;

import org.junit.jupiter.api.Test;

public class ControladorUsuarioTest {
    
    @Test
    void testCrearSocioOK() {
        try {
            IControladorUsuario ctrlU = Fabrica.creaControladorUsuario();
            Email e = new Email("lucho", "@mail.com");
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", e, LocalDate.of(2007, 03, 28));
            DataSocio ds = (DataSocio) ctrlU.consultarSocio("Lucho");
            assertEquals(ds.getApellido(), "Almenares");
            assertEquals(ds.getNombre(), "Luciano");
            assertEquals(ds.getCorreo(), e);
            assertEquals(ds.getNacimiento(), LocalDate.of(2007, 03, 28));
        } catch (UsuarioRepetidoException e) {
            fail(e.getMessage());
			e.printStackTrace();
        } catch (UsuarioNoEncontradoException e) {
            fail(e.getMessage());
			e.printStackTrace();
        }
    }
}
