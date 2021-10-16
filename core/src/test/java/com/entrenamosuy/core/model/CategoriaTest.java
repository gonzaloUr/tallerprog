package com.entrenamosuy.core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;

public class CategoriaTest {

    @Test
    public void equalsTest() {
        Categoria categoria1 = new Categoria("test", Collections.emptySet(), Collections.emptySet());
        Categoria categoria2 = new Categoria("test", Collections.emptySet(), Collections.emptySet());
        
        assertEquals(categoria1, categoria2);
    }
}
