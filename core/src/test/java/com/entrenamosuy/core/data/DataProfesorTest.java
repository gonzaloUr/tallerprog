package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProfesorTest {

    @Test
    public void equalsTest() {
        DataProfesor d1 = DataProfesor.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setDescripcion("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setInstitucion("test")
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        DataProfesor d2 = DataProfesor.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setDescripcion("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setInstitucion("test")
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
