package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.Email;

public class Profesor extends Usuario {

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private Set<Institucion> instituciones;

    private Set<Clase> clasesDictadas;

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String descripcion, String biografia, URL sitioWeb, Set<Institucion> instituciones, Set<Clase> clasesDictadas) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.instituciones = instituciones;
        this.clasesDictadas = clasesDictadas;
    }

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String descripcion, String biografia, URL sitioWeb) {
        this(nickname, nombre, apellido, correo, nacimiento, descripcion, biografia, sitioWeb, Collections.emptySet(), Collections.emptySet());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(URL sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Set<Institucion> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Set<Institucion> instituciones) {
        this.instituciones = instituciones;
    }

    public Set<Clase> getClasesDictadas() {
        return clasesDictadas;
    }

    public void setClasesDictadas(Set<Clase> clasesDictadas) {
        this.clasesDictadas = clasesDictadas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(biografia, clasesDictadas, descripcion, instituciones, sitioWeb);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profesor other = (Profesor) obj;
        return Objects.equals(biografia, other.biografia) && Objects.equals(clasesDictadas, other.clasesDictadas)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(instituciones, other.instituciones)
                && Objects.equals(sitioWeb, other.sitioWeb);
    }
}
