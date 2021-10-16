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
        DataClase dataClase1 = DataClase.builder()
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

        DataClase dataClase2 = DataClase.builder()
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

        assertEquals(dataClase1, dataClase2);
        assertEquals(dataClase1.hashCode(), dataClase2.hashCode());
    }
}
