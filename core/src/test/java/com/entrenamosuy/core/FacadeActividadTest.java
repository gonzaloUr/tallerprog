package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;

import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

public class FacadeActividadTest {

    @Test
    public void crearActividad() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        facades.getFacadeActividad().crearCategoria("cat1");
        Set<String> categorias = new HashSet<>();
        categorias.add("cat1");

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("test2")
                    .setDescripcion("test2")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();
        });

        // No se puede crear actividades con nombres repetidos.
        assertThrows(ActividadRepetidaException.class, () -> {
            facades.getFacadeActividad().crearActividad()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(2))
                    .setCosto(15f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();
        });

        // La actividad esta asociada a una institucion valida.
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            facades.getFacadeActividad().crearActividad()
                    .setNombre("test3")
                    .setDescripcion("test3")
                    .setInstitucion("institucion")
                    .setDuracion(Duration.ofMinutes(45))
                    .setCosto(200f)
                    .setRegistro(LocalDate.of(2000, 1, 1))
                    .setCategorias(categorias)
                    .invoke();
        });
    }

    @Test
    public void getDataActividad() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();
        });

        DataActividad ret = facades.getFacadeActividad().getDataActividad("a1");
        assertEquals("a1", ret.getNombre());
        assertEquals("a1", ret.getDescripcion());
        assertEquals(Duration.ofHours(1), ret.getDuracion());
        assertEquals(10f, ret.getCosto());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getRegistro());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getRegistro());

        Set<String> categorias = new HashSet<>();
        categorias.add("cat1");

        assertEquals(categorias, ret.getCategorias());
    }
}
