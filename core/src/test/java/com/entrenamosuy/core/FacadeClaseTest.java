package com.entrenamosuy.core;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacadeClaseTest {

    @Test
    public void crearClase() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("i1")
                    .setDescripcion("i1")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a1")
                    .setInstitucion("i1")
                    .setDescripcion("a1")
                    .setCosto(10f)
                    .setDuracion(Duration.ofHours(1))
                    .setRegistro(LocalDate.of(2000, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("p1")
                    .setNombre("p1")
                    .setApellido("p1")
                    .setDescripcion("p1")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNacimiento(LocalDate.of(2000, 1, 1))
                    .setPassword("pass")
                    .setInstitucion("i1")
                    .invoke();

            Set<String> profesoresNickname = new HashSet<>();
            profesoresNickname.add("p1");

            facades.getFacadeClase().crearClase()
                    .setNombre("c1")
                    .setNombreActividad("a1")
                    .setNicknameProfesores(profesoresNickname)
                    .setFechaRegistro(LocalDate.of(2000, 1, 1))
                    .setCantMin(1)
                    .setCantMax(10)
                    .setAcceso(new URL("https://test"))
                    .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                    .invoke();
        });

        assertTrue(facades.getRegistry().getClases().containsKey("c1"));

        assertThrows(ClaseInconsistenteException.class, () -> {
            facades.getFacadeClase().crearClase()
                    .setNombre("c1")
                    .setNombreActividad("a1")
                    .setNicknameProfesores(Collections.emptySet())
                    .setFechaRegistro(LocalDate.of(2000, 1, 1))
                    .setCantMin(1)
                    .setCantMax(10)
                    .setAcceso(new URL("https://test"))
                    .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                    .invoke();
        });

        assertThrows(ActividadNoEncontradaException.class, () -> {
            facades.getFacadeClase().crearClase()
                    .setNombre("c2")
                    .setNombreActividad("a2")
                    .setNicknameProfesores(Collections.emptySet())
                    .setFechaRegistro(LocalDate.of(2000, 1, 1))
                    .setCantMin(1)
                    .setCantMax(10)
                    .setAcceso(new URL("https://test"))
                    .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                    .invoke();
        });

        assertThrows(ProfesorNoEncontradoException.class, () -> {
            Set<String> profesoresNickname = new HashSet<>();
            profesoresNickname.add("p3");

            facades.getFacadeClase().crearClase()
                    .setNombre("c2")
                    .setNombreActividad("a1")
                    .setNicknameProfesores(profesoresNickname)
                    .setFechaRegistro(LocalDate.of(2000, 1, 1))
                    .setCantMin(1)
                    .setCantMax(10)
                    .setAcceso(new URL("https://test"))
                    .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                    .invoke();
        });
    }
}