package com.entrenamosuy.tarea1.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class DescActividad {
    
    private final String nombre;

    private final String descripcion;

    private final Duration duracion;

    private final LocalDateTime registro;

    private final int costo;

    public DescActividad(String nombre, String descripcion, Duration duracion, LocalDateTime registro, int costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.registro = registro;
        this.costo = costo;
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

    public LocalDateTime getRegistro() {
        return registro;
    }

    public int getCosto() {
        return costo;
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
        DescActividad other = (DescActividad) obj;
        return costo == other.costo && descripcion.equals(other.descripcion)
                && duracion.equals(other.duracion) && nombre.equals(other.nombre)
                && registro.equals(other.registro);
    }
}
