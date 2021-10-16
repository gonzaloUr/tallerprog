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

        Clase clase1 = Clase.builder()
            .setActividad(actividad)
            .setAcceso(new URL("https://test"))
            .setCantMin(1)
            .setCantMax(5)
            .setFechaRegistro(LocalDate.of(1999, 1, 1))
            .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
            .setNombre("c1")
            .build();

        Clase clase2 = Clase.builder()
            .setActividad(actividad)
            .setAcceso(new URL("https://test"))
            .setCantMin(1)
            .setCantMax(5)
            .setFechaRegistro(LocalDate.of(1999, 1, 1))
            .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
            .setNombre("c1")
            .build();
        
        assertEquals(clase1, clase2);
        assertEquals(clase1.hashCode(), clase2.hashCode());
    }
}
