package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataActividadTest {

    @Test
    public void equalsTest() {
        DataActividad dataActividad1 = DataActividad.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(1999, 1, 1))
                .build();

        DataActividad dataActividad2 = DataActividad.builder()
                .setNombre("test")
                .setDescripcion("test")
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(dataActividad1, dataActividad2);
        assertEquals(dataActividad1.hashCode(), dataActividad2.hashCode());
    }
}
