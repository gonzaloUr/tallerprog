package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;

public class InstitucionTest {
    @Test
    public void equalsTest() throws MalformedURLException {

        Institucion institucion1 = Institucion.builder()
            .setNombre("i")
            .setDescripcion("")
            .setUrl(new URL("https://test"))
            .build();
        Institucion institucion2 = Institucion.builder()
            .setNombre("i")
            .setDescripcion("")
            .setUrl(new URL("https://test"))
            .build();
            
        assertEquals(institucion1, institucion2);
        assertEquals(institucion1.hashCode(), institucion2.hashCode());
    }
}