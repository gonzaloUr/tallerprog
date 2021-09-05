package com.entrenamosuy.core.model;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Institucion {

    private String nombre;

    private String descripcion;

    private URL url;

    private Set<Actividad> actividadesOfrecidas;

    public Institucion(String nombre, String descripcion, URL url, Set<Actividad> actividadesOfrecidas) {
        Objects.requireNonNull(nombre, "nombre es null en constructor Institucion");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor Institucion");
        Objects.requireNonNull(url, "url es null en constructor Institucion");
        Objects.requireNonNull(actividadesOfrecidas, "actividadesOfrecidas es null en constructor Institucion");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    public Institucion(String nombre, String descripcion, URL url) {
        this(nombre, descripcion, url, new HashSet<>());
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
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Institucion other = (Institucion) obj;
        return Objects.equals(nombre, other.nombre);
    }

    public Set<String> actividadesAgregables(Cuponera cup) {
        Set<String> ret = new HashSet<>();

        for (Actividad act : actividadesOfrecidas) {
            if (!cup.tieneActividad(act)) {
                ret.add(act.getNombre());
            }
        }

        return ret;
    }
}
