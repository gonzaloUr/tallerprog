package com.entrenamosuy.core.model;

import java.util.Objects;

public class Puntaje {

    private final Socio socio;

    private final Clase clase;

    private final int puntaje;

    public Puntaje(Socio socio, Clase clase, int puntaje) {
        Objects.requireNonNull(socio, "socio es null en constructor Puntaje");
        Objects.requireNonNull(clase, "clase es null en constructor Puntaje");

        this.socio = socio;
        this.clase = clase;
        this.puntaje = puntaje;
    }

    public Socio getSocio() {
        return socio;
    }

    public Clase getClase() {
        return clase;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
