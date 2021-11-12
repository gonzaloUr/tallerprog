package com.entrenamosuy.core.data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

public class BeanActividad {

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDate registro;

    private float costo;

    private Set<DataClase> clases;

    private Set<DataCuponera> cuponeras;

    private Set<String> categorias;

    public BeanActividad() {}

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

    public Set<DataClase> getClases() {
        return this.clases;
    }

    public void setClases(Set<DataClase> clases) {
        this.clases = clases;
    }

    public Set<DataCuponera> getCuponeras() {
        return this.cuponeras;
    }

    public void setCuponeras(Set<DataCuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public Set<String> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Set<String> categorias) {
        this.categorias = categorias;
    }

    public void from(DataActividad x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setDuracion(x.getDuracion());
        setRegistro(x.getRegistro());
        setCosto(x.getCosto());
        setClases(x.getClases());
        setCuponeras(x.getCuponeras());
        setCategorias(x.getCategorias());
    }
}
