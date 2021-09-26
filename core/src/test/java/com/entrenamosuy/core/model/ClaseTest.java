package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class ClaseTest {

    @Test
    public void equalsTest() throws MalformedURLException {
        Actividad actividad = mock(Actividad.class);

        Clase c1 = Clase.builder()
            .setActividad(actividad)
            .setAcceso(new URL("https://test"))
            .setCantMin(1)
            .setCantMax(5)
            .setFechaRegistro(LocalDate.of(1999, 1, 1))
            .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
            .setNombre("c1")
            .build();

        Clase c2 = Clase.builder()
            .setActividad(actividad)
            .setAcceso(new URL("https://test"))
            .setCantMin(1)
            .setCantMax(5)
            .setFechaRegistro(LocalDate.of(1999, 1, 1))
            .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
            .setNombre("c1")
            .build();
        
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
