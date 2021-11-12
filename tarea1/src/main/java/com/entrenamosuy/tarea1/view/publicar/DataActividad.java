package com.entrenamosuy.tarea1.view.publicar;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
//import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.crypto.Data;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataActividad {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private Duration duracion;

        private LocalDate registro;

        private float costo;

        private ArrayList<DataClase> clases = new ArrayList<>();

        private ArrayList<DataCuponera> cuponeras = new ArrayList<>();

        private ArrayList<String> categorias = new ArrayList<>();

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setDuracion(Duration duracion) {
            this.duracion = duracion;
            return this;
        }

        public Builder setRegistro(LocalDate registro) {
            this.registro = registro;
            return this;
        }

        public Builder setCosto(float costo) {
            this.costo = costo;
            return this;
        }

        public Builder setClases(ArrayList<DataClase> clases) {
            this.clases = clases;
            return this;
        }

        public Builder setCuponeras(ArrayList<DataCuponera> cuponeras) {
            this.cuponeras = cuponeras;
            return this;
        }

        public Builder setCategorias(ArrayList<String> categorias) {
            this.categorias = categorias;
            return this;
        }

        public DataActividad build() {
            return new DataActividad(nombre, descripcion, duracion, registro, costo,
                    clases, cuponeras, categorias);
        }
    }

    private final String nombre;

    private final String descripcion;

    private final Duration duracion;

    private final LocalDate registro;

    private final float costo;

    private final ArrayList<DataClase> clases;

    private final ArrayList<DataCuponera> cuponeras;

    private final ArrayList<String> categorias;

    //public DataActividad(){}

    protected DataActividad(String nombre, String descripcion, Duration duracion,
            LocalDate registro, float costo, ArrayList<DataClase> clases,
            ArrayList<DataCuponera> cuponeras, ArrayList<String> categorias) {

        Objects.requireNonNull(nombre, "nombre es null en constructor DataActividad");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DataActividad");
        Objects.requireNonNull(duracion, "duracion es null en constructor DataActividad");
        Objects.requireNonNull(registro, "registro es null en constructor DataActividad");
        Objects.requireNonNull(clases, "clases es null en constructor DataActividad");
        Objects.requireNonNull(cuponeras, "cuponeras es null en constructor DataActividad");
        Objects.requireNonNull(categorias, "categorias es null en constructor DataActividad");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.registro = registro;
        this.costo = costo;
        this.clases = clases;
        this.cuponeras = cuponeras;
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public LocalDate getRegistro() {
        return registro;
    }

    public float getCosto() {
        return costo;
    }

    public ArrayList<DataClase> getClases() {
        return clases;
    }

    public ArrayList<DataCuponera> getCuponeras() {
        return cuponeras;
    }

    public ArrayList<String> getCategorias(){
        return categorias;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costo, descripcion, duracion, nombre, registro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataActividad other = (DataActividad) obj;
        return Objects.equals(clases, other.clases)
                && Objects.equals(cuponeras, other.cuponeras)
                && Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo)
                && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(duracion, other.duracion)
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(registro, other.registro);
    }
}
