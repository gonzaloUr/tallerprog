package com.entrenamosuy.core.model;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class IntegraTest {

    @Test
    public void constructor() {
        Actividad actividad = mock(Actividad.class);
        Cuponera cuponera = mock(Cuponera.class);
        Integra integra = new Integra(0, actividad, cuponera);

        assertThat(integra, hasProperty("actividad", sameInstance(actividad)));
        assertThat(integra, hasProperty("cuponera", sameInstance(cuponera)));
        assertThat(integra, hasProperty("cantClases", equalTo(0)));
    }

    @Test
    public void setters() {
        Actividad a1 = mock(Actividad.class);
        Cuponera c1 = mock(Cuponera.class);

        Integra integra = new Integra(0, a1, c1);

        Actividad a2 = mock(Actividad.class);
        Cuponera c2 = mock(Cuponera.class);

        integra.setActividad(a2);
        integra.setCuponera(c2);
        integra.setCantClases(10);

        assertThat(integra, hasProperty("actividad", sameInstance(a2)));
        assertThat(integra, hasProperty("cuponera", sameInstance(c2)));
        assertThat(integra, hasProperty("cantClases", equalTo(10)));
    }
}
