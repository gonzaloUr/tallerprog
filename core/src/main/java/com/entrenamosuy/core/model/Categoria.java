package com.entrenamosuy.core.model;

import java.util.Objects;
import java.util.Set;

public class Categoria {

    private String nombre;

    private Set<Actividad> actividades;

    private Set<Cuponera> cuponeras;

    public Categoria(String nombre, Set<Actividad> actividades, Set<Cuponera> cuponeras) {
        Objects.requireNonNull(nombre, "nombre es null en constructor Categoria");
        Objects.requireNonNull(actividades, "actividades es null en constructor Categoria");
        Objects.requireNonNull(cuponeras, "cuponeras es null en constructor Categoria");

        this.nombre = nombre;
        this.actividades = actividades;
        this.cuponeras = cuponeras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Set<Cuponera> getCuponeras() {
        return cuponeras;
    }

    public void setCuponeras(Set<Cuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public void agregarActividad(Actividad a){
        actividades.add(a);
    }
    public void agregarCuponera(Cuponera c){
        cuponeras.add(c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        return Objects.equals(nombre, other.nombre);
    }
}
