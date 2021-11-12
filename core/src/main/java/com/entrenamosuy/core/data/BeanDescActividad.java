package com.entrenamosuy.core.data;

import java.time.Duration;
import java.time.LocalDate;

public class BeanDescActividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDate registro;

    private float costo;

    public BeanDescActividad() {}

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Duration getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public LocalDate getRegistro() {
        return this.registro;
    }

    public void setRegistro(LocalDate registro) {
        this.registro = registro;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void from(DescActividad x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setDuracion(x.getDuracion());
        setRegistro(x.getRegistro());
        setCosto(x.getCosto());
    }
}
