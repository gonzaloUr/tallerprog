package com.entrenamosuy.core.data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class DataClase {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private LocalDateTime inicio;

        private int cantMin, cantMax;

        private URL accesoURL;

        private DescActividad actividad;

        private int cantPremios;

        private Set<DescProfesor> profesores = Collections.emptySet();

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setInicio(LocalDateTime inicio) {
            this.inicio = inicio;
            return this;
        }

        public Builder setCantMin(int cantMin) {
            this.cantMin = cantMin;
            return this;
        }

        public Builder setCantMax(int cantMax) {
            this.cantMax = cantMax;
            return this;
        }

        public Builder setAccesoURL(URL accesoURL) {
            this.accesoURL = accesoURL;
            return this;
        }

        public Builder setActividad(DescActividad actividad) {
            this.actividad = actividad;
            return this;
        }

        public Builder setCantPremios(int cantPremios) {
            this.cantPremios = cantPremios;
            return this;
        }

        public Builder setProfesores(Set<DescProfesor> profesores) {
            this.profesores = profesores;
            return this;
        }

        public DataClase build() {
            return new DataClase(nombre, inicio, cantMin, cantMax, accesoURL, actividad, cantPremios, profesores);
        }
    }

    private final String nombre;

    private final LocalDateTime inicio;

    private final int cantMin, cantMax;

    private final URL accesoURL;

    private final DescActividad actividad;

    private final int cantPremios;

    private final Set<DescProfesor> profesores;

    protected DataClase(String nombre, LocalDateTime inicio, int cantMin, int cantMax, URL accesoURL,
            DescActividad actividad, int cantPremios, Set<DescProfesor> profesores) {

        Objects.requireNonNull(nombre, "nombre es null en constructor DataClase");
        Objects.requireNonNull(inicio, "inicio es null en constructor DataClase");
        Objects.requireNonNull(accesoURL, "accesoURL es null en constructor DataClase");
        Objects.requireNonNull(actividad, "actividad es null en constructor DataClase");
        Objects.requireNonNull(profesores, "profesores es null en constructor DataClase");

        this.nombre = nombre;
        this.inicio = inicio;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.accesoURL = accesoURL;
        this.actividad = actividad;
        this.cantPremios = cantPremios;
        this.profesores = profesores;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public int getCantMin() {
        return cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public URL getAccesoURL() {
        return accesoURL;
    }

    public DescActividad getActividad() {
        return actividad;
    }

    public int getCantPremios(){
        return cantPremios;
    }

    public Set<DescProfesor> getProfesores() {
        return profesores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, inicio, cantMin, cantMax, accesoURL, actividad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataClase other = (DataClase) obj;
        return Objects.equals(nombre, other.nombre) && Objects.equals(inicio, other.inicio)
                && Float.floatToIntBits(cantMin) == Float.floatToIntBits(other.cantMin)
                && Float.floatToIntBits(cantMax) == Float.floatToIntBits(other.cantMax)
                && Objects.equals(accesoURL, other.accesoURL) && Objects.equals(actividad, other.actividad)
                && Objects.equals(profesores, other.profesores);
    }
}
