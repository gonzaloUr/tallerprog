package com.entrenamosuy.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.*;

import com.entrenamosuy.core.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.core.model.Institucion;

import org.junit.jupiter.api.Test;

public class FacadeInstitucionTest {

    @Test
    public void crearInstitucion() {
        AbstractRegistry registry = mock(AbstractRegistry.class);
        Map<String, Institucion> instituciones = new HashMap<>();

        when(registry.getInstituciones()).thenReturn(instituciones);

        AbstractFacadeInstitucion facadeInstitucion = new FacadeInstitucion();
        facadeInstitucion.setRegistry(registry);

        assertDoesNotThrow(() -> facadeInstitucion.crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke());

        assertThat(instituciones, hasKey("test"));

        assertThrows(InstitucionRepetidaException.class, () -> facadeInstitucion.crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke());
    }

    @Test
    public void getInstituciones() {
        AbstractRegistry registry = mock(AbstractRegistry.class);
        Map<String, Institucion> instituciones = new HashMap<>();

        when(registry.getInstituciones()).thenReturn(instituciones);

        AbstractFacadeInstitucion facadeInstitucion = new FacadeInstitucion();
        facadeInstitucion.setRegistry(registry);

        assertDoesNotThrow(() -> {
            facadeInstitucion.crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke();

            Set<String> ret = facadeInstitucion.getInstituciones();
            assertThat(ret, hasItem("test"));
        });
    }
}
