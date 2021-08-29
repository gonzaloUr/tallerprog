package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.tarea1.util.Pair;


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
        final int prime = 31;
        int result = 1;
        //result = prime * result + ((actividadesOfrecidas == null) ? 0 : actividadesOfrecidas.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Institucion))
            return false;
        Institucion other = (Institucion) obj;
        if (actividadesOfrecidas == null) {
            if (other.actividadesOfrecidas != null)
                return false;
        } else if (!actividadesOfrecidas.equals(other.actividadesOfrecidas))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    public Set<Pair<String, String>> actividadesAgregables(Cuponera cup){
        Set<Pair<String, String>> ret = new HashSet<>();
        for (Actividad act : actividadesOfrecidas){
            if (!cup.tieneActividad(act)){
                ret.add(new Pair<>(act.getNombre(), act.getDescripcion()));
            }
        }
        return ret;
    }


}
