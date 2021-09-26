package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataClaseTest {

    @Test
    public void equalsTest() throws MalformedURLException {
        DataClase d1 = DataClase.builder()
                .setNombre("test")
                .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
                .setAccesoURL(new URL("https://test"))
                .setCantMin(1)
                .setCantMax(5)
                .setActividad(new DescActividad(
                        "test",
                        "test",
                        Duration.ofHours(1),
                        LocalDate.of(1999, 1, 1),
                        10f))
                .build();

        DataClase d2 = DataClase.builder()
                .setNombre("test")
                .setInicio(LocalDateTime.of(1999, 1, 1, 1, 1))
                .setAccesoURL(new URL("https://test"))
                .setCantMin(1)
                .setCantMax(5)
                .setActividad(new DescActividad(
                        "test",
                        "test",
                        Duration.ofHours(1),
                        LocalDate.of(1999, 1, 1),
                        10f))
                .build();

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
