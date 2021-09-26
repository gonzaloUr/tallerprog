package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

public class InstitucionTest {
    @Test
    public void equalsTest() throws MalformedURLException {

        Institucion r1 = Institucion.builder()
            .setNombre("i")
            .setDescripcion("")
            .setUrl(new URL("https://test"))
            .build();
        Institucion r2 = Institucion.builder()
            .setNombre("i")
            .setDescripcion("")
            .setUrl(new URL("https://test"))
            .build();
            
        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }
}