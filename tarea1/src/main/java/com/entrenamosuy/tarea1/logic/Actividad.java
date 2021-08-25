package com.entrenamosuy.tarea1.logic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Actividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDateTime fechaRegistro;

    private float costo;

    public Actividad(String nombre, String descripcion, Duration duracion, LocalDateTime fechaRegistro, float costo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaRegistro = fechaRegistro;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(costo, descripcion, duracion, fechaRegistro, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actividad other = (Actividad) obj;
        return costo == other.costo && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(duracion, other.duracion) && Objects.equals(fechaRegistro, other.fechaRegistro)
                && Objects.equals(nombre, other.nombre);
    }
}
