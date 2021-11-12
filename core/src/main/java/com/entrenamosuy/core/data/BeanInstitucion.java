package com.entrenamosuy.core.data;

import java.net.URL;
import java.util.Set;

public class BeanInstitucion {

    private String nombre;

    private String descripcion;

    private URL url;

    private Set<DataActividad> actividadesOfrecidas;

    public BeanInstitucion() {}

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

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Set<DataActividad> getActividadesOfrecidas() {
        return this.actividadesOfrecidas;
    }

    public void setActividadesOfrecidas(Set<DataActividad> actividadesOfrecidas) {
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    public void from(DataInstitucion x) {
        setNombre(x.getNombre());
        setDescripcion(x.getDescripcion());
        setUrl(x.getUrl());
        setActividadesOfrecidas(x.getActividadesOfrecidas());
    }
}
