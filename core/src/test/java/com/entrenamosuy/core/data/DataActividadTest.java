package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataActividadTest {

    @Test
    public void equalsTest() {
        DataActividad d1 = DataActividad.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(1999, 1, 1))
                .build();

        DataActividad d2 = DataActividad.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
