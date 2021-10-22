package com.entrenamosuy.core.model;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.entrenamosuy.core.data.DataInstitucion;

public class Institucion {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private URL url;

        private Set<Actividad> actividadesOfrecidas = new HashSet<>();

        private File imagen;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setUrl(URL url) {
            this.url = url;
            return this;
        }

        public Builder setActividadesOfrecidas(Set<Actividad> actividadesOfrecidas) {
            this.actividadesOfrecidas = actividadesOfrecidas;
            return this;
        }

        public Builder setImagen(File imagen) {
            this.imagen = imagen;
            return this;
        }

        public Institucion build() {
            return new Institucion(nombre, descripcion, url, actividadesOfrecidas, imagen);
        }
    }

    private String nombre;

    private String descripcion;

    private URL url;

    private Set<Actividad> actividadesOfrecidas;

    private File imagen;

    protected Institucion(String nombre, String descripcion, URL url,
            Set<Actividad> actividadesOfrecidas, File imagen) {

        Objects.requireNonNull(nombre, "nombre es null en constructor Institucion");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor Institucion");
        Objects.requireNonNull(url, "url es null en constructor Institucion");
        Objects.requireNonNull(actividadesOfrecidas, "actividadesOfrecidas es null en constructor Institucion");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividadesOfrecidas = actividadesOfrecidas;
        this.imagen = imagen;
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

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
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

    public DataInstitucion getDataInstitucion() {
        return DataInstitucion.builder()
            .setNombre(nombre)
            .setDescripcion(descripcion)
            .setUrl(url)
            .setActividadesOfrecidas(actividadesOfrecidas
                    .stream()
                    .map(Actividad::getDataActividad)
                    .collect(Collectors.toSet()))
            .build();
    }

    public Set<String> actividadesAgregables(Cuponera cup) {
        Set<String> ret = new HashSet<>();

        for (Actividad act : actividadesOfrecidas) {
            if (!cup.tieneActividad(act)&&act.getEstado()==ActividadEstado.ACEPTADA) {
                ret.add(act.getNombre());
            }
        }

        return ret;
    }
}
