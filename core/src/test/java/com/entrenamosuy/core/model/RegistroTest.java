package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class RegistroTest {

    @Test
    public void equalsTest() {
        Socio socio = mock(Socio.class);
        Cuponera cuponera = mock(Cuponera.class);
        Clase clase = mock(Clase.class);

        Registro r1 = Registro.builder()
            .setSocio(socio)
            .setCuponera(cuponera)
            .setClaseAsociada(clase)
            .setFecha(LocalDate.of(1999, 1, 1))
            .build();

        Registro r2 = Registro.builder()
            .setSocio(socio)
            .setCuponera(cuponera)
            .setClaseAsociada(clase)
            .setFecha(LocalDate.of(1999, 1, 1))
            .build();
        
        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }
}
