package com.entrenamosuy.core.data;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class DataActividadTest {

    @Test
    void constructor() {
        @SuppressWarnings("unchecked") Set<DataClase> clases = (Set<DataClase>) mock(Set.class);
        @SuppressWarnings("unchecked") Set<DataCuponera> cuponeras = (Set<DataCuponera>) mock(Set.class);

        DataActividad.Builder builder = DataActividad.builder();
        assertNotNull(builder);

        assertDoesNotThrow(() -> {
            DataActividad ret = builder.setNombre("test")
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2000, 8, 20))
                    .setDuracion(Duration.ofMinutes(60))
                    .setDescripcion("test")
                    .setClases(clases)
                    .setCuponeras(cuponeras)
                    .build();
            assertNotNull(ret);

            assertEquals(ret.getNombre(), "test");
            assertEquals(ret.getCosto(), 10f);
            assertEquals(ret.getRegistro(), LocalDate.of(2000, 8, 20));
            assertEquals(ret.getDuracion(), Duration.ofMinutes(60));
            assertEquals(ret.getDescripcion(), "test");
            assertEquals(ret.getClases(), clases);
            assertEquals(ret.getCuponeras(), cuponeras);
        });
    }
}