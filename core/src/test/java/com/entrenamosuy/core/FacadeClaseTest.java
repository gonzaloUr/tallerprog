package com.entrenamosuy.core;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Profesor;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FacadeClaseTest {

    @Test
    public void crearClase() {
        AbstractRegistry registry = mock(AbstractRegistry.class);
        Map<String, Institucion> instituciones = new HashMap<>();
        Map<String, Actividad> actividades = new HashMap<>();
        Map<String, Profesor> profesores = new HashMap<>();
        Map<Email, Profesor> profesoresMail = new HashMap<>();
        Map<String, Clase> clases = new HashMap<>();

        when(registry.getInstituciones()).thenReturn(instituciones);
        when(registry.getActividades()).thenReturn(actividades);
        when(registry.getProfesores()).thenReturn(profesores);
        when(registry.getProfesoresMail()).thenReturn(profesoresMail);
        when(registry.getClases()).thenReturn(clases);

        AbstractFacadeUsuario facadeUsuario = new FacadeUsuario();
        AbstractFacadeInstitucion facadeInstitucion = new FacadeInstitucion();
        AbstractFacadeActividad facadeActividad = new FacadeActividad();
        AbstractFacadeClase facadeClase = new FacadeClase();

        facadeUsuario.setRegistry(registry);
        facadeInstitucion.setRegistry(registry);
        facadeActividad.setRegistry(registry);
        facadeClase.setRegistry(registry);

        assertDoesNotThrow(() -> {
            facadeInstitucion.crearInstitucion()
                    .setNombre("i1")
                    .setDescripcion("i1")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facadeActividad.crearActividad()
                    .setNombre("a1")
                    .setInstitucion("i1")
                    .setDescripcion("a1")
                    .setCosto(10f)
                    .setDuracion(Duration.ofHours(1))
                    .setRegistro(LocalDate.of(2000, 1, 1))
                    .invoke();

            facadeUsuario.crearProfesor()
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

            facadeClase.crearClase()
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

        assertThat(clases, hasKey("c1"));


        assertThrows(ClaseInconsistenteException.class, () -> {
            facadeClase.crearClase()
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
            facadeClase.crearClase()
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

            facadeClase.crearClase()
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