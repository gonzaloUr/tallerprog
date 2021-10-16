package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class IntegraTest {

    @Test
    public void equalsTest() {
        Actividad actividad1 = mock(Actividad.class);
        Cuponera cuponera1 = mock(Cuponera.class);
        
        Integra integra1 = new Integra(1, actividad1, cuponera1);
        Integra integra2 = new Integra(1, actividad1, cuponera1);
        
        assertEquals(integra1, integra2);
    }
}
