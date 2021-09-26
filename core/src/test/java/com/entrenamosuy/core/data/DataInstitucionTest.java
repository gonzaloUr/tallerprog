package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInstitucionTest {

    @Test
    public void equalsTest() throws MalformedURLException {
        DataInstitucion d1 = DataInstitucion.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .build();

        DataInstitucion d2 = DataInstitucion.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .build();

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
