package com.entrenamosuy.core;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.isA;

import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.everyItem;

import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.ActividadEstado;
import com.entrenamosuy.core.model.Integra;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Compra;
import com.entrenamosuy.core.model.Cuponera;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Registro;
import com.entrenamosuy.core.model.Socio;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {

    public static Matcher<Actividad> actividadAceptada() {
        return new TypeSafeMatcher<Actividad>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Actividad no aceptada");
            }

            @Override
            protected boolean matchesSafely(Actividad item) {
                return item.getEstado() == ActividadEstado.ACEPTADA;
            }
        };
    }

    public static Matcher<Cuponera> cuponeraActividadAceptada() {
        return allOf(isA(Cuponera.class), hasProperty("integras", everyItem(hasProperty("actividad", actividadAceptada()))));
    }

    public static Matcher<Clase> claseActividadAceptada() {
        return allOf(isA(Cuponera.class), hasProperty("actividad", actividadAceptada()));
    }

    public static Matcher<Registro> cuponeraComprada() {
        return new TypeSafeMatcher<Registro>() {

            private Cuponera cuponeraNoComprada;

            private Socio socio;

            private Clase clase;

            @Override
            public void describeTo(Description description) {
                description.appendText("El socio " +
                        socio.getNombre() +
                        " esta registrado con la cuponera " +
                        cuponeraNoComprada.getNombre() +
                        " a la clase " +
                        clase.getNombre() +
                        " pero no es dueño de dicha cuponera");
            }

            @Override
            protected boolean matchesSafely(Registro item) {
                if (item.getCuponera() == null)
                    return true;

                Cuponera cuponera = item.getCuponera();
                Socio socio = item.getSocio();

                Set<Cuponera> cuponerasCompradas = socio.getCompras().stream()
                    .map(Compra::getCuponera)
                    .collect(Collectors.toSet());

                if (cuponerasCompradas.contains(cuponera))
                    return true;

                cuponeraNoComprada = cuponera;
                this.socio = socio;
                clase = item.getClaseAsociada();

                return false;
            }
        };
    }

    public static Matcher<Registro> claseEnCuponera() {
        return new TypeSafeMatcher<Registro>() {

            private Cuponera cuponera;

            private Clase clase;

            private Socio socio;

            @Override
            public void describeTo(Description description) {
                description.appendText("El socio " + socio.getNombre() + " esta registrado la clase " + clase.getNombre() +
                        " con la cuponera " + cuponera.getNombre() + " pero esta no tiene ninguna actividad con la clase");
            }

            @Override
            protected boolean matchesSafely(Registro item) {
                if (item.getCuponera() == null)
                    return true;

                Cuponera cuponera = item.getCuponera();
                Clase clase = item.getClaseAsociada();

                Set<Clase> clasesEnCuponera = cuponera.getIntegras().stream()
                    .map(Integra::getActividad)
                    .map(Actividad::getClases)
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());

                if (clasesEnCuponera.contains(clase))
                    return true;

                this.cuponera = cuponera;
                this.clase = clase;
                socio = item.getSocio();

                return false;
            }
        };
    }

    public static Matcher<Profesor> clasesEnInstitucion() {
        return new TypeSafeMatcher<Profesor>() {

            private Institucion institucion;

            private Profesor profesor;

            private Clase clase;

            @Override
            public void describeTo(Description description) {
                description.appendText("El profesor " + profesor.getNombre() +
                        " dicta la clase " + clase.getNombre() +
                        " pero esta no pertenece a la institucion " + institucion.getNombre() +
                        " del profesor");
            }

            @Override
            protected boolean matchesSafely(Profesor item) {
                if (item.getClasesDictadas().isEmpty())
                    return true;

                Institucion institucion = item.getInstitucion();
                Set<Clase> clasesEnInstitucion = institucion.getActividadesOfrecidas().stream()
                    .map(Actividad::getClases)
                    .flatMap(Set::stream)
                    .collect(Collectors.toSet());

                for (Clase c : item.getClasesDictadas())
                    if (!clasesEnInstitucion.contains(c)) {
                        profesor = item;
                        this.institucion = institucion;
                        clase = c;

                        return false;
                    }

                return true;
            }
        };
    }
}
