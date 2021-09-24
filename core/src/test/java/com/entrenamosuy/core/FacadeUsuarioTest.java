package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.time.LocalDate;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

public class FacadeUsuarioTest {

    @Test
    public void crearSocio() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test2")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test")
                .setPassword("pass")
                .setCorreo(Email.of("test2", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });
    }

    @Test
    public void crearProfesor() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test2", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test2")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });
    }
}
