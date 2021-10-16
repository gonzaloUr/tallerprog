package com.entrenamosuy.core.data;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCuponeraTest {

    @Test
    public void equalsTest() {
        DataCuponera dataCuponera1 = new DataCuponera("test", "test", Collections.emptySet(), Collections.emptySet());
        DataCuponera dataCuponera2 = new DataCuponera("test", "test", Collections.emptySet(), Collections.emptySet());

        assertEquals(dataCuponera1, dataCuponera2);
        assertEquals(dataCuponera1.hashCode(), dataCuponera2.hashCode());
    }
}
