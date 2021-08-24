package com.entrenamosuy.tarea1.data;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class DataProfesor extends DataUsuario {

    private final String descripcion;

    private final String biografia;

    private final URL sitioWeb;

    private final Set<DataActividad> actividades;

    public DataProfesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            Set<DataActividad> actividades, String descripcion, String biografia, URL sitioWeb) {
        super(nickname, nombre, apellido, correo, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.actividades = actividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    public Set<DataActividad> getActividades() {
        return actividades;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(actividades, biografia, descripcion, sitioWeb);
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
        DataProfesor other = (DataProfesor) obj;
        return Objects.equals(actividades, other.actividades) && Objects.equals(biografia, other.biografia)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(sitioWeb, other.sitioWeb);
    }
}
