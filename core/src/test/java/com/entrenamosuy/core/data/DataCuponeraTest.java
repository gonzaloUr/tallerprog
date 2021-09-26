package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCuponeraTest {

    @Test
    public void equalsTest() {
        DataCuponera d1 = new DataCuponera("test", "test", Collections.emptySet(), Collections.emptySet());
        DataCuponera d2 = new DataCuponera("test", "test", Collections.emptySet(), Collections.emptySet());

        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}
