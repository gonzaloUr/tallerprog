package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class CategoriaTest {

    @Test
    public void equalsTest() {
        Categoria c1 = new Categoria("test", Collections.emptySet(), Collections.emptySet());
        Categoria c2 = new Categoria("test", Collections.emptySet(), Collections.emptySet());
        
        assertEquals(c1, c2);
    }
}
