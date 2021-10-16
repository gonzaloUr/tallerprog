package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProfesorTest {

    @Test
    public void equalsTest() {
        DataProfesor dataProfesor1 = DataProfesor.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setDescripcion("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setInstitucion("test")
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        DataProfesor dataProfesor2 = DataProfesor.builder()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setDescripcion("test")
                .setCorreo(Email.of("test", "mail.com"))
                .setInstitucion("test")
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .build();

        assertEquals(dataProfesor1, dataProfesor2);
        assertEquals(dataProfesor1.hashCode(), dataProfesor2.hashCode());
    }
}
