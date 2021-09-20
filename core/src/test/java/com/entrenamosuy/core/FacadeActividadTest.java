package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Institucion;

import org.junit.jupiter.api.Test;

public class FacadeActividadTest {

    @Test
    public void crearActividad() {
        AbstractRegistry registry = mock(AbstractRegistry.class);
        Map<String, Institucion> instituciones = new HashMap<>();
        Map<String, Actividad> actividades = new HashMap<>();

        when(registry.getInstituciones()).thenReturn(instituciones);
        when(registry.getActividades()).thenReturn(actividades);

        Institucion i1 = mock(Institucion.class);
        instituciones.put("test", i1);

        AbstractFacadeActividad facadeActividad = new FacadeActividad();
        facadeActividad.setRegistry(registry);

        assertDoesNotThrow(() -> {
            facadeActividad.crearActividad()
                .setNombre("test")
                .setDescripcion("test")
                .setInstitucion("test")
                .setDuracion(Duration.ofHours(1))
                .setCosto(10f)
                .setRegistro(LocalDate.of(2021, 9, 10))
                .invoke();

            facadeActividad.crearActividad()
                .setNombre("test2")
                .setDescripcion("test2")
                .setInstitucion("test")
                .setDuracion(Duration.ofHours(1))
                .setCosto(10f)
                .setRegistro(LocalDate.of(2021, 9, 10))
                .invoke();
        });

        // No se puede crear actividades con nombres repetidos.
        assertThrows(ActividadRepetidaException.class, () -> {
            facadeActividad.crearActividad()
                .setNombre("test")
                .setDescripcion("test")
                .setInstitucion("test")
                .setDuracion(Duration.ofHours(2))
                .setCosto(15f)
                .setRegistro(LocalDate.of(2021, 9, 10))
                .invoke();
        });

        // La actividad esta asociada a una institucion valida.
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            facadeActividad.crearActividad()
                .setNombre("test3")
                .setDescripcion("test3")
                .setInstitucion("institucion")
                .setDuracion(Duration.ofMinutes(45))
                .setCosto(200f)
                .setRegistro(LocalDate.of(2000, 1, 1))
                .invoke();
        });
    }
}
