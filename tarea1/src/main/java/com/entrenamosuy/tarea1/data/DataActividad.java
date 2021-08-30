package com.entrenamosuy.tarea1.data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class DataActividad {

    private final String nombre;

    private final String descripcion;

    private final Duration duracion;

    private final LocalDate registro;

    private final float costo;

    private final Set<DataClase> clases;

    private final Set<DataCuponera> cuponeras;

    public DataActividad(String nombre, String descripcion, Duration duracion, LocalDate registro, float costo,
                         Set<DataClase> clases, Set<DataCuponera> cuponeras) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.registro = registro;
        this.costo = costo;
        this.clases = clases;
        this.cuponeras = cuponeras;
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

    public Set<DataClase> getClases() {
        return clases;
    }

    public Set<DataCuponera> getCuponeras() {
        return cuponeras;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clases, costo, cuponeras, descripcion, duracion, nombre, registro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataActividad other = (DataActividad) obj;
        return clases.equals(other.clases) && costo == other.costo
                && cuponeras.equals(other.cuponeras) && descripcion.equals(other.descripcion)
                && duracion.equals(other.duracion) && nombre.equals(other.nombre)
                && registro.equals(other.registro);
    }
}