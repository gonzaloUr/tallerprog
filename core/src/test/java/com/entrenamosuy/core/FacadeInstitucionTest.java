package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.util.Set;

import com.entrenamosuy.core.exceptions.InstitucionRepetidaException;

import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

public class FacadeInstitucionTest {

    @Test
    public void crearInstitucion() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke());

        assertTrue(facades.getRegistry().getInstituciones().containsKey("test"));

        assertThrows(InstitucionRepetidaException.class, () -> facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke());
    }

    @Test
    public void getInstituciones() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke();

            Set<String> ret = facades.getFacadeInstitucion().getInstituciones();
            assertTrue(ret.contains("test"));
        });
    }
}
