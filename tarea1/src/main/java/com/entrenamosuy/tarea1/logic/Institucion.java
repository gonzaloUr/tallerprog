package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Institucion {
    
    private String nombre;

    private String descripcion;

    private URL url;
    
    private Set<Actividad> actividadesOfrecidas;

    public Institucion(String nombre, String descripcion, URL url, Set<Actividad> actividadesOfrecidas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    public Institucion(String nombre, String descripcion, URL url) {
        this(nombre, descripcion, url, Collections.emptySet());
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

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Set<Actividad> getActividadesOfrecidas() {
        return actividadesOfrecidas;
    }

    public void setActividadesOfrecidas(Set<Actividad> actividadesOfrecidas) {
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actividadesOfrecidas, descripcion, nombre, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Institucion other = (Institucion) obj;
        return Objects.equals(actividadesOfrecidas, other.actividadesOfrecidas)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre)
                && Objects.equals(url, other.url);
    }
}
