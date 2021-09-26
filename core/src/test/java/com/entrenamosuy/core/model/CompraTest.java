package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CompraTest {

    @Test
    public void equalsTest() {
        Socio socio = mock(Socio.class);
        Cuponera cuponera = mock(Cuponera.class);
        
        Compra c1 = new Compra(LocalDate.of(1999, 1, 1), socio, cuponera);
        Compra c2 = new Compra(LocalDate.of(1999, 1, 1), socio, cuponera);
        
        assertEquals(c1, c2);
    }
}
