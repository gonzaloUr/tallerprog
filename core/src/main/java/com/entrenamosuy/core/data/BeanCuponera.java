package com.entrenamosuy.core.data;

import java.util.Set;

public class BeanCuponera {

    private String nombre;

    private String descripcion;

    private Set<DescActividad> actividades;

    private Set<String> categorias;

    public BeanCuponera() {}

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

    public Set<DescActividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(Set<DescActividad> actividades) {
        this.actividades = actividades;
    }

    public Set<String> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(Set<String> categorias) {
        this.categorias = categorias;
    }

    public void from(DataCuponera x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setActividades(x.getActividades());
        setCategorias(x.getCategorias());
    }
}
