package com.entrenamosuy.tarea1.logic;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.tarea1.data.DataProfesor;
import com.entrenamosuy.tarea1.data.Email;

public class Profesor extends Usuario {

    private String descripcion;

    private String biografia;

    private URL sitioWeb;

    private Institucion institucion;

    private Set<Clase> clasesDictadas;

    public Profesor(String nickname, String nombre, String apellido, Email correo, LocalDateTime nacimiento,
            String descripcion, String biografia, URL sitioWeb, Institucion institucion) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.institucion = institucion;
        this.clasesDictadas = Collections.emptySet();
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
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
        result = prime * result + Objects.hash(biografia, clasesDictadas, descripcion, institucion, sitioWeb);
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
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(institucion, other.institucion)
                && Objects.equals(sitioWeb, other.sitioWeb);
    }


    public DataProfesor getDataProfesor() {
        return null;
    }
}
