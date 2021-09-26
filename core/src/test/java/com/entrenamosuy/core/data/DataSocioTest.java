package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSocioTest {

    @Test
    public void equalsTest() {
        DataSocio d1 = DataSocio.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        DataSocio d2 = DataSocio.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
