package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInstitucionTest {

    @Test
    public void equalsTest() throws MalformedURLException {
        DataInstitucion dataInstitucion1 = DataInstitucion.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .build();

        DataInstitucion dataInstitucion2 = DataInstitucion.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .build();

        assertEquals(dataInstitucion1, dataInstitucion2);
        assertEquals(dataInstitucion1.hashCode(), dataInstitucion2.hashCode());
    }
}
