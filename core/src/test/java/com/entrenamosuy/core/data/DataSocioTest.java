package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSocioTest {

    @Test
    public void equalsTest() {
        DataSocio dataSocio1 = DataSocio.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        DataSocio dataSocio2 = DataSocio.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(dataSocio1, dataSocio2);
        assertEquals(dataSocio1.hashCode(), dataSocio2.hashCode());
    }
}
