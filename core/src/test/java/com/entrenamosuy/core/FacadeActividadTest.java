package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
                    .setCategoriasString(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("test2")
                    .setDescripcion("test2")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategoriasString(categorias)
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
                    .setCategoriasString(categorias)
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
                    .setCategoriasString(categorias)
                    .invoke();
        });
    }
}
