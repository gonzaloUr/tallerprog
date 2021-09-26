package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class IntegraTest {

    @Test
    public void equalsTest() {
        Actividad a1 = mock(Actividad.class);
        Cuponera c1 = mock(Cuponera.class);
        
        Integra i1 = new Integra(1, a1, c1);
        Integra i2 = new Integra(1, a1, c1);
        
        assertEquals(i1, i2);
    }
}
